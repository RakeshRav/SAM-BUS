package bus.monkeybusiness.com.sambus.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rey.material.widget.Button;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import bus.monkeybusiness.com.sambus.R;
import bus.monkeybusiness.com.sambus.adapter.StudentNameAdapter;
import bus.monkeybusiness.com.sambus.adapter.StudentSearchListAdapter;
import bus.monkeybusiness.com.sambus.model.addRemarksObject.Remarks;
import bus.monkeybusiness.com.sambus.model.addRemarksObject.RemarksRequestObject;
import bus.monkeybusiness.com.sambus.model.addRemarksResponseData.AddRemarksResponseData;
import bus.monkeybusiness.com.sambus.model.studentSearchdata.SearchStudentData;
import bus.monkeybusiness.com.sambus.model.studentSearchdata.Student;
import bus.monkeybusiness.com.sambus.retrofit.CommonApiCalls;
import bus.monkeybusiness.com.sambus.retrofit.RestClient;
import bus.monkeybusiness.com.sambus.utility.FontClass;
import bus.monkeybusiness.com.sambus.utility.ISO8601;
import bus.monkeybusiness.com.sambus.utility.Utils;
import bus.monkeybusiness.com.sambus.utility.dialogBox.LoadingBox;
import bus.monkeybusiness.com.sambus.utility.preferences.Prefs;
import bus.monkeybusiness.com.sambus.utility.preferences.PrefsKeys;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import rmn.androidscreenlibrary.ASSL;

/**
 * Created by rakesh on 2/2/16.
 */
public class RemarksActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "RemarksFragment";
    public ArrayList<Student> studentNameadapterList = new ArrayList<>();
    public List<Student> studentListObject;
    public List<HashMap<String, String>> studentsHashMap;
    RelativeLayout relativeLayoutMenu;

    TextView textViewActionTitle;
    AutoCompleteTextView recipientEditTextView;
    Button buttonSendRemarks;
    EditText editTextRemarks;
    //    ArrayAdapter adapter;

    StudentSearchListAdapter adapter;
    GridView gridviewStudentName;
    ArrayList<String> studentList;
    StudentNameAdapter studentNameAdapter;

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//
//        return rootView;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remarks_student);

        new ASSL(this, (ViewGroup) findViewById(R.id.root), 1134, 720,
                false);

        new CommonApiCalls(this).checkLoginServerCall();

        buttonSendRemarks = (Button) findViewById(R.id.buttonSendRemarks);
        relativeLayoutMenu = (RelativeLayout) findViewById(R.id.relativeLayoutMenu);
        textViewActionTitle = (TextView) findViewById(R.id.textViewActionTitle);

        editTextRemarks = (EditText) findViewById(R.id.editTextRemarks);

        relativeLayoutMenu.setOnClickListener(this);
        textViewActionTitle.setOnClickListener(this);
        buttonSendRemarks.setOnClickListener(this);

        textViewActionTitle.setText("Remarks");

        recipientEditTextView = (AutoCompleteTextView) findViewById(R.id.recipientEditTextView);

//        studentList = new ArrayList<>();
//
////        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, studentList);
//        studentListObject = new ArrayList<>();
//        adapter = new StudentSearchListAdapter(this,studentListObject);
//
////        adapter.setData(studentListObject);
//
//        recipientEditTextView.setAdapter(adapter);
        recipientEditTextView.setThreshold(1);

        gridviewStudentName = (GridView) findViewById(R.id.gridviewStudentName);

        studentNameAdapter = new StudentNameAdapter(this, new ArrayList<Student>());
        gridviewStudentName.setAdapter(studentNameAdapter);

        gridviewStudentName.setVisibility(View.VISIBLE);

        recipientEditTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "Position : " + position + " name : " + studentListObject.get(position).getId());

                recipientEditTextView.setText("");

                boolean isAvailable = false;

                for (Student student : studentNameAdapter.studentNames) {
                    if (student.getId() == studentListObject.get(position).getId()) {
                        isAvailable = true;
                    }
                }

                if (!isAvailable) {
                    studentNameadapterList.add(studentListObject.get(position));

                    studentNameAdapter = new StudentNameAdapter(RemarksActivity.this, studentNameadapterList);

                    gridviewStudentName.setAdapter(studentNameAdapter);
                    gridviewStudentName.smoothScrollToPosition(studentNameAdapter.getCount());

                }
            }
        });
//
        recipientEditTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(final CharSequence s, int start, int before, int count) {
                Log.d(TAG, "text : " + s);
                final String currentStr = s.toString();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (currentStr.equalsIgnoreCase(recipientEditTextView.getText().toString())) {
                            searchStudentServerCall(s + "");
                        }
                    }
                }, 1000);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        textViewActionTitle.setTypeface(FontClass.proximaRegular(this));
        recipientEditTextView.setTypeface(FontClass.proximaRegular(this));
        buttonSendRemarks.setTypeface(FontClass.proximaRegular(this));
        editTextRemarks.setTypeface(FontClass.proximaRegular(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.relativeLayoutMenu:
                finish();
                break;
            case R.id.buttonSendRemarks:
                sendRemarksServerCall();
                break;
        }
    }

    private void sendRemarksServerCall() {

        Log.d(TAG, "Array : " + new Gson().toJson(studentNameAdapter.studentNames));

        List<Student> students = studentNameAdapter.studentNames;

        RemarksRequestObject remarksRequestObject = new RemarksRequestObject();

        String remarksStr = editTextRemarks.getText().toString();

        if (remarksStr.equalsIgnoreCase("") || students.isEmpty()) {
            Utils.failureDialog(this, "Warning", "Please enter student name or remarks");
        } else {
            Remarks remarks = new Remarks();
            remarks.setDateOfRemark(ISO8601.fromCalendar(Calendar.getInstance()));
            remarks.setRemark(remarksStr);
            ArrayList<Integer> studentList = new ArrayList<>();

            for (Student student : students) {
                studentList.add(student.getId());
            }

            Log.d(TAG, "IDS : " + new Gson().toJson(studentList));

            remarks.setStudents(studentList);

            remarksRequestObject.setRemarks(remarks);

            String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
            String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");

            String jsonRemarks = new Gson().toJson(remarksRequestObject);

//            ProgressDialog progressDialog = ProgressDialog.show(this, "Please Wait", "Sending Remarks...", false);
            LoadingBox.showLoadingDialog(this, "Sending Remarks...");

            try {
                TypedInput typedInput = new TypedByteArray("application/json", jsonRemarks.getBytes("UTF-8"));
                RestClient.getApiServicePojo(xCookies, aCookies).apiCallSendRemarks(typedInput, new Callback<AddRemarksResponseData>() {
                    @Override
                    public void success(AddRemarksResponseData addRemarksResponseData, Response response) {
                        Log.d(TAG, "Response : " + new Gson().toJson(addRemarksResponseData));

                        if (LoadingBox.isDialogShowing()) {
                            LoadingBox.dismissLoadingDialog();
                        }
                        if (addRemarksResponseData.getResponseMetadata().getSuccess().equalsIgnoreCase("yes")) {
                            Utils.failureDialog(RemarksActivity.this, "Success", "You have successfully sent remarks");
                        } else {
                            Utils.failureDialog(RemarksActivity.this, "Failure", "Something went wrong, please try again.");
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        if (LoadingBox.isDialogShowing()) {
                            LoadingBox.dismissLoadingDialog();
                        }
                        Log.d(TAG, "error : " + error.toString());
                        Utils.failureDialog(RemarksActivity.this, "Failure", "Something went wrong, please try again.");
                    }
                });
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public void searchStudentServerCall(String studentName) {

        String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
        String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");

        RestClient.getApiServicePojo(xCookies, aCookies).apiCallSearchStudent(studentName, new Callback<SearchStudentData>() {
            @Override
            public void success(SearchStudentData searchStudentData, Response response) {
                Log.d(TAG, "response : " + new Gson().toJson(searchStudentData));


                if (searchStudentData.getResponseMetadata().getSuccess().equalsIgnoreCase("yes")) {
                    Log.d(TAG, "Student Name:" + new Gson().toJson(studentList));

                    studentsHashMap = new ArrayList<HashMap<String, String>>();
                    studentListObject = searchStudentData.getData().getStudents();

                    studentsHashMap.clear();
                    for (Student student : searchStudentData.getData().getStudents()) {
//                        studentList.add(student.getStudentName());
                        HashMap<String, String> hashMap = new HashMap<String, String>();
                        hashMap.put("name", student.getStudentName());
                        hashMap.put("class", student.getBatch().getClassAlias());
                        hashMap.put("roll", student.getRollno().toString());
                        studentsHashMap.add(hashMap);
                    }

                    Log.d(TAG, "Student Name:" + new Gson().toJson(studentList));
//                    adapter = new ArrayAdapter(RemarksFragment.this, android.R.layout.simple_list_item_1, studentList);
//                    adapter = new StudentSearchListAdapter(RemarksFragment.this,studentListObject);

                    String[] from = {"name", "class", "roll"};

                    int[] to = {R.id.textViewEventTitle, R.id.textViewEventDesc, R.id.textViewRollNo};
                    SimpleAdapter adapter = new SimpleAdapter(RemarksActivity.this, studentsHashMap, R.layout.item_search_event, from, to);
//                    ASSL.DoMagic(linearLayoutMain);

                    recipientEditTextView.setAdapter(adapter);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "error : " + error.toString());
            }
        });
    }
}
