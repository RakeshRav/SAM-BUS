package bus.monkeybusiness.com.sambus.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;

import bus.monkeybusiness.com.sambus.R;
import bus.monkeybusiness.com.sambus.adapter.EventsListStudentsAdapter;
import bus.monkeybusiness.com.sambus.model.addRemarksObject.Remarks;
import bus.monkeybusiness.com.sambus.model.addRemarksObject.RemarksRequestObject;
import bus.monkeybusiness.com.sambus.model.addRemarksResponseData.AddRemarksResponseData;
import bus.monkeybusiness.com.sambus.model.studentDetailsResponse.StudentsDetailsResponseData;
import bus.monkeybusiness.com.sambus.model.studentRemarksData.Remark;
import bus.monkeybusiness.com.sambus.model.studentRemarksData.StudentsRemarksResponse;
import bus.monkeybusiness.com.sambus.retrofit.RestClient;
import bus.monkeybusiness.com.sambus.utility.Constants;
import bus.monkeybusiness.com.sambus.utility.FontClass;
import bus.monkeybusiness.com.sambus.utility.ISO8601;
import bus.monkeybusiness.com.sambus.utility.Log;
import bus.monkeybusiness.com.sambus.utility.NonScrollListView;
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
 * Created by rakesh on 4/2/16.
 */
public class StudentDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    //    private static final String[] STORAGE_PERMS = {
//            Manifest.permission.READ_EXTERNAL_STORAGE
//    };
//    private static final int INITIAL_REQUEST = 1337;
//    private static final int STORAGE_REQUEST = INITIAL_REQUEST + 3;
    final String TAG = "StudentDetailsActivity";
    LinearLayout linearLayoutMainStudent;
    RelativeLayout relativeLayoutMenu;

    TextView textViewName;
    TextView textViewClass;
    TextView textViewEmailStudent;
    TextView textViewContactStudent;
    TextView textViewFname;
    TextView textViewMname;
    TextView textViewDOB;
    TextView textViewAddress;
    TextView textViewCity;
    TextView textViewState;
    TextView textViewDOJ;
    TextView textViewRollNoStudent;
    com.rey.material.widget.Button buttonRemarksStudent;
    TextView textViewPersonalTitle;
    TextView textViewFNameTitle;
    TextView textViewMNameTitle;
    TextView textViewNumberTitle;
    TextView textViewEmailTitle;
    TextView textViewDOBTitle;
    TextView textViewAddressTitle;
    TextView textViewCityTitle;
    TextView textViewStateTitle;
    TextView textViewAcademicTitle;
    TextView textViewRollNoTitle;
    TextView textViewClassTitle;
    TextView textViewDOJTitle;
    TextView textViewRemarksTitle;

    ImageView imageViewEditNumber;
    RelativeLayout relativeLayoutEditPic;

    NonScrollListView listViewEventsStudents;

    //    TextView textViewRemarks;
//    Button buttonRemarksStudent;
//    ProgressBar progressBarStudent;
    ImageView imageViewProfilePicStudent;
    Dialog dialog;

    //    NonScrollListView listViewRemarks;
    int studentId;
        StudentsDetailsResponseData studentsDetailsResponseData;
    Dialog subjectDialog;
    EditText editTextRemarks;
    Button buttonSend;
    LinearLayout linearLayoutRemarks;
    LinearLayout linearLayoutAttendances;
//    TextDrawable drawableAbsent;
//    TextDrawable drawablePresent;

    Dialog mobileNumberDialog;
    private TextView textViewCamera;
    private TextView textViewGallery;
    private TextView textViewTitle;
    //    private ImageChooserManager imageChooserManagerGallery;
//    private ImageChooserManager imageChooserManagerCamera;
    private Uri inputUri;
    private Uri outputUri;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        new ASSL(this, (ViewGroup) findViewById(R.id.root), 1134, 720,
                false);

//        Utils.classFlag = 0;
//
//        toggleLayouts(linearlayoutDashboard, textViewDashboard);

        initialization();
        setFont();

        Intent intent = getIntent();
        studentId = intent.getIntExtra(Constants.STUDENT_ID, 0);

    }

    private void setFont() {

        textViewName.setTypeface(FontClass.proximaRegular(this));
        textViewClass.setTypeface(FontClass.proximaRegular(this));
        textViewEmailStudent.setTypeface(FontClass.proximaRegular(this));
        textViewContactStudent.setTypeface(FontClass.proximaRegular(this));
        textViewFname.setTypeface(FontClass.proximaRegular(this));
        textViewMname.setTypeface(FontClass.proximaRegular(this));
        textViewDOB.setTypeface(FontClass.proximaRegular(this));
        textViewAddress.setTypeface(FontClass.proximaRegular(this));
        textViewCity.setTypeface(FontClass.proximaRegular(this));
        textViewState.setTypeface(FontClass.proximaRegular(this));
        textViewDOJ.setTypeface(FontClass.proximaRegular(this));
        textViewRollNoStudent.setTypeface(FontClass.proximaRegular(this));
        buttonRemarksStudent.setTypeface(FontClass.proximaRegular(this));
        textViewPersonalTitle.setTypeface(FontClass.proximaBold(this));
        textViewFNameTitle.setTypeface(FontClass.proximaRegular(this));
        textViewMNameTitle.setTypeface(FontClass.proximaRegular(this));
        textViewNumberTitle.setTypeface(FontClass.proximaRegular(this));
        textViewEmailTitle.setTypeface(FontClass.proximaRegular(this));
        textViewDOBTitle.setTypeface(FontClass.proximaRegular(this));
        textViewAddressTitle.setTypeface(FontClass.proximaRegular(this));
        textViewCityTitle.setTypeface(FontClass.proximaRegular(this));
        textViewStateTitle.setTypeface(FontClass.proximaRegular(this));
        textViewAcademicTitle.setTypeface(FontClass.proximaBold(this));
        textViewRollNoTitle.setTypeface(FontClass.proximaRegular(this));
        textViewClassTitle.setTypeface(FontClass.proximaRegular(this));
        textViewDOJTitle.setTypeface(FontClass.proximaRegular(this));
        textViewRemarksTitle.setTypeface(FontClass.proximaBold(this));
    }

    public void initialization() {
        linearLayoutMainStudent = (LinearLayout) findViewById(R.id.linearLayoutMainStudent);

        relativeLayoutMenu = (RelativeLayout) findViewById(R.id.relativeLayoutMenu);
        relativeLayoutEditPic = (RelativeLayout) findViewById(R.id.relativeLayoutEditPic);
        relativeLayoutEditPic.setVisibility(View.GONE);

        linearLayoutRemarks = (LinearLayout) findViewById(R.id.linearLayoutRemarks);
        linearLayoutAttendances = (LinearLayout) findViewById(R.id.linearLayoutAttendances);

//        textViewActionTitle = (TextView) findViewById(R.id.textViewActionTitle);
        textViewName = (TextView) findViewById(R.id.textViewNameStudent);
        textViewClass = (TextView) findViewById(R.id.textViewClassStudent);
//        textViewContact = (TextView) findViewById(R.id.textViewContactStudent);
        textViewEmailStudent = (TextView) findViewById(R.id.textViewEmailStudent);
        textViewRollNoStudent = (TextView) findViewById(R.id.textViewRollNoStudent);

        textViewFname = (TextView) findViewById(R.id.textViewFname);
        textViewMname = (TextView) findViewById(R.id.textViewMname);
        textViewDOB = (TextView) findViewById(R.id.textViewDOB);
        textViewAddress = (TextView) findViewById(R.id.textViewAddress);
        textViewCity = (TextView) findViewById(R.id.textViewCity);
        textViewState = (TextView) findViewById(R.id.textViewState);
        textViewDOJ = (TextView) findViewById(R.id.textViewDOJ);

        textViewPersonalTitle = (TextView) findViewById(R.id.textViewPersonalTitle);
        textViewFNameTitle = (TextView) findViewById(R.id.textViewFNameTitle);
        textViewMNameTitle = (TextView) findViewById(R.id.textViewMNameTitle);
        textViewNumberTitle = (TextView) findViewById(R.id.textViewNumberTitle);
        textViewEmailTitle = (TextView) findViewById(R.id.textViewEmailTitle);
        textViewDOBTitle = (TextView) findViewById(R.id.textViewDOBTitle);
        textViewAddressTitle = (TextView) findViewById(R.id.textViewAddressTitle);
        textViewCityTitle = (TextView) findViewById(R.id.textViewCityTitle);
        textViewStateTitle = (TextView) findViewById(R.id.textViewStateTitle);
        textViewAcademicTitle = (TextView) findViewById(R.id.textViewAcademicTitle);
        textViewRollNoTitle = (TextView) findViewById(R.id.textViewRollNoTitle);
        textViewClassTitle = (TextView) findViewById(R.id.textViewClassTitle);
        textViewDOJTitle = (TextView) findViewById(R.id.textViewDOJTitle);
        textViewRemarksTitle = (TextView) findViewById(R.id.textViewRemarksTitle);

        imageViewEditNumber = (ImageView) findViewById(R.id.imageViewEditNumber);

//        textViewRemarks = (TextView) findViewById(R.id.textViewRemarks);

//        buttonRemarksStudent = (Button) findViewById(R.id.buttonRemarksStudent);

//        progressBarStudent = (ProgressBar) findViewById(R.id.progressBarStudent);

        textViewContactStudent = (TextView) findViewById(R.id.textViewParentConatctStudent);

        imageViewProfilePicStudent = (ImageView) findViewById(R.id.imageViewProfilePicStudent);
        listViewEventsStudents = (NonScrollListView) findViewById(R.id.listViewEventsStudents);

        buttonRemarksStudent = (com.rey.material.widget.Button) findViewById(R.id.buttonRemarksStudent);

//        listViewRemarks = (NonScrollListView) findViewById(R.id.listViewRemarks);

//        textViewActionTitle.setText("Student Profile");

        linearLayoutMainStudent.setVisibility(View.GONE);


//        imageChooserManagerCamera = new ImageChooserManager(this, ChooserType.REQUEST_CAPTURE_PICTURE);
//        imageChooserManagerCamera.setImageChooserListener(this);
//
//        imageChooserManagerGallery = new ImageChooserManager(this, ChooserType.REQUEST_PICK_PICTURE);
//        imageChooserManagerGallery.setImageChooserListener(this);

        relativeLayoutMenu.setOnClickListener(this);
//        textViewActionTitle.setOnClickListener(this);
//        buttonRemarksStudent.setOnClickListener(this);
        relativeLayoutEditPic.setOnClickListener(this);
        buttonRemarksStudent.setOnClickListener(this);
        imageViewEditNumber.setOnClickListener(this);
        imageViewEditNumber.setVisibility(View.GONE);

//        drawableAbsent = TextDrawable.builder()
//                .beginConfig()
//                .withBorder(4) /* thickness in px */
//                .endConfig()
//                .buildRound("A", getResources().getColor(R.color.absent_button));
//
//        drawablePresent = TextDrawable.builder()
//                .beginConfig()
//                .withBorder(4) /* thickness in px */
//                .endConfig()
//                .buildRound("P", getResources().getColor(R.color.normal_present_button));
    }


//    ExecutorService executorService = Executors.newFixedThreadPool(5);

    private void setUIData(StudentsDetailsResponseData studentsDetailsResponseData) {

//        progressBarStudent.setVisibility(View.GONE);
        linearLayoutMainStudent.setVisibility(View.VISIBLE);

        this.studentsDetailsResponseData = studentsDetailsResponseData;

        if (studentsDetailsResponseData.getData().getStudent() != null) {
            textViewName.setText(studentsDetailsResponseData.getData().getStudent().getStudentName());
            textViewClass.setText(studentsDetailsResponseData.getData().getStudent().getBatch().getClassAlias());
//            textViewContact.setText("Address : " + studentsDetailsResponseData.getData().getStudent().getAddress());
            textViewEmailStudent.setText(studentsDetailsResponseData.getData().getStudent().getParent().getContactEmail());
            textViewRollNoStudent.setText("" + studentsDetailsResponseData.getData().getStudent().getRollno());
            textViewContactStudent.setText("" + studentsDetailsResponseData.getData().getStudent().getParent().getContactPhone());

            textViewFname.setText(studentsDetailsResponseData.getData().getStudent().getFatherName());
            textViewMname.setText(studentsDetailsResponseData.getData().getStudent().getMotherName());
            textViewDOB.setText(studentsDetailsResponseData.getData().getStudent().getDob());
            textViewAddress.setText(studentsDetailsResponseData.getData().getStudent().getAddress());
            textViewCity.setText(studentsDetailsResponseData.getData().getStudent().getCity());
            textViewState.setText(studentsDetailsResponseData.getData().getStudent().getState());
            textViewDOJ.setText(studentsDetailsResponseData.getData().getStudent().getDateOfJoining());

            if (studentsDetailsResponseData.getData().getStudent().getPicture() != null) {
                Log.d(TAG, "Image_photo : " + studentsDetailsResponseData.getData().getStudent().getPicture().getUrl());
//                Picasso.with(this).invalidate(studentsDetailsResponseData.getData().getStudent().getPicture().getUrl());
                Picasso.with(this).load(studentsDetailsResponseData.getData().getStudent().getPicture().getUrl()).fit().into(imageViewProfilePicStudent);
//                imageViewProfilePicStudent.setImageBitmap(getDecodedPhotos(studentsDetailsResponseData.getData().getStudent().getPicture().getUrl()));4
//                executorService.submit(new imageDownload(studentsDetailsResponseData.getData().getStudent().getPicture().getUrl()));
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.relativeLayoutMenu:
                break;
            case R.id.imageViewEditNumber:
//                showNumberDialog(studentId);
                break;
            case R.id.buttonRemarksStudent:
                if (studentsDetailsResponseData != null) {
                    showRemarksDialog(studentsDetailsResponseData.getData().getStudent().getId());
                }
                Log.d(TAG, "button pressed");
                break;
            case R.id.relativeLayoutEditPic:

//                int currentApiLevel = Build.VERSION.SDK_INT;
//
//                if (currentApiLevel > Build.VERSION_CODES.LOLLIPOP_MR1) {
//                    Log.d("splash", "version greater than 22");
//                    if (!Utils.allowPermissionForHigherVersions(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                        requestPermissions(STORAGE_PERMS, STORAGE_REQUEST);
//                    } else {
//                        showProfilePicDialog();
//                    }
//                } else {
//                    showProfilePicDialog();
//                }
                break;

//            case R.id.textViewCamera:
//
//                Log.d("abc dialog", "camera");
//                dialog.dismiss();
//                try {
//                    imageChooserManagerCamera.choose();
//                } catch (ChooserException e) {
//                    e.printStackTrace();
//                }
//                break;
//
//            case R.id.textViewGallery:
//
//                Log.d("abc dialog", "gallery");
//                //            Log.d("abc choose","aa gya");
//                dialog.dismiss();
//                try {
//                    imageChooserManagerGallery.choose();
//                } catch (ChooserException e) {
//                    e.printStackTrace();
//                }
//                break;
        }
    }

    public void showRemarksDialog(final int id) {

        subjectDialog = new Dialog(this);
        subjectDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        subjectDialog.setContentView(R.layout.dialog_custom_msg_test);
        editTextRemarks = (EditText) subjectDialog.findViewById(R.id.editTextRemarks);

        buttonSend = (Button) subjectDialog.findViewById(R.id.buttonSend);
        buttonSend.setText("SEND");
        editTextRemarks.setHint("Enter Remarks");

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextRemarks.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(StudentDetailsActivity.this, "Please Enter Some remarks", Toast.LENGTH_SHORT).show();
                } else {
                    subjectDialog.dismiss();
                    sendRemarksServerCall(id);
                }
            }
        });

        subjectDialog.setCancelable(true);
        subjectDialog.setCanceledOnTouchOutside(true);
        subjectDialog.show();
    }

//    public void showNumberDialog(int id) {
//
//        mobileNumberDialog = new Dialog(this);
//        mobileNumberDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        mobileNumberDialog.setContentView(R.layout.dialog_custom_msg_number);
//        editTextRemarks = (EditText) mobileNumberDialog.findViewById(R.id.editTextRemarks);
//        editTextRemarks.setHint("Enter Number");
//
//        buttonSend = (Button) mobileNumberDialog.findViewById(R.id.buttonSend);
//        buttonSend.setText("SAVE");
//
//        buttonSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (editTextRemarks.getText().toString().equalsIgnoreCase("")) {
//                    Toast.makeText(StudentDetailsActivity.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
//                } else {
//                    mobileNumberDialog.dismiss();
//                    upDateStudentNumberServerCall(id, editTextRemarks.getText().toString());
//                }
//            }
//        });
//
//        mobileNumberDialog.setCancelable(true);
//        mobileNumberDialog.setCanceledOnTouchOutside(true);
//        mobileNumberDialog.show();
//    }

//    public void showProfilePicDialog() {
//        dialog = new Dialog(StudentDetailsActivity.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.custom_dialog);
//
////            dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        textViewCamera = (TextView) dialog.findViewById(R.id.textViewCamera);
//        textViewGallery = (TextView) dialog.findViewById(R.id.textViewGallery);
//        textViewTitle = (TextView) dialog.findViewById(R.id.txt_title);
//
//
//        textViewCamera.setOnClickListener(this);
//        textViewGallery.setOnClickListener(this);
//
//        dialog.show();
//
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && (requestCode == ChooserType.REQUEST_PICK_PICTURE)) {
//            imageChooserManagerGallery.submit(requestCode, data);
//            Log.d("ProfiileEdit", "imageChosenResultgallery");
//        } else if (resultCode == RESULT_OK && (requestCode == ChooserType.REQUEST_CAPTURE_PICTURE)) {
//            imageChooserManagerCamera.submit(requestCode, data);
//            Log.d("ProfiileEdit", "imageChosenResultcamera");
//        } else if (requestCode == Crop.REQUEST_CROP && resultCode == RESULT_OK) {
////            Log.i("abc", "success");
////            imageViewEditDetailFeMale.setImageURI(outputUri);
////            imageViewEditDetailMale.setImageURI(outputUri);
//            Log.d("ProfiileEdit", "CropResult");
//            if (outputUri != null) {
//                String filePath = outputUri.toString().substring(7);
//                File file = new File(filePath);
////                Picasso.with(this).invalidate(file);
////                Picasso.with(this).load(file).into(imageViewProfilePicStudent);
//
//                if (studentsDetailsResponseData.getData().getStudent().getPicture() != null) {
//                    sendPictureToUploadsWithId(studentsDetailsResponseData.getData().getStudent().getPicture().getId(), filePath);
//                } else {
//                    sendPictureToUploads(filePath);
//                }
//
////                    postUserImageOnServer(filePath);
////                getAddressGivenLatLongFrom(filePath);
//            }
//        }
    }

//    @Override
//    public void onImageChosen(ChosenImage chosenImage) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                if (chosenImage != null) {
//
//                    Log.d("image", "extension : " + chosenImage.getExtension());
//
//                    String path = "file://" + chosenImage.getFilePathOriginal();
//                    inputUri = Uri.parse(path);
//
//                    String outPath = "file://" + chosenImage.getFilePathOriginal();
//                    outputUri = Uri.parse(outPath);
//
////                    Crop.of(inputUri, outputUri).asSquare().start(ProfileEditActivity.this)
//
//                    Crop.of(inputUri, outputUri).asSquare().start(StudentDetailsActivity.this);
////                    Crop.of(inputUri, outputUri).asSquare().start(ProfileEditActivity.this);
//
////                    try {
////                        imageChoose.setImageBitmap(decodeUri(Uri.parse(path)));
////                    } catch (FileNotFoundException e) {
////                        e.printStackTrace();
//                    String imagethumb = chosenImage.getFileThumbnail();
////                    }
//                    Log.d("abc original", "" + path);
//                    Log.d("abc thumb", imagethumb);
//
////
////                    Bitmap bitmap = BitmapFactory.decodeFile(path);
////                    imageChoose.setImageBitmap(bitmap);
////                    Bitmap bmp = BitmapFactory.decodeFile(path);
////                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
////                    bmp.compress(Bitmap.CompressFormat.JPEG, 70, bos);
////                    InputStream in = new ByteArrayInputStream(bos.toByteArray());
////
//                }
//            }
//        });
//    }

//    @Override
//    public void onError(String s) {
//
//    }


    private void getStudentDetailsServerCall(int studentId) {

        LoadingBox.showLoadingDialog(this, "Loading Data...");
        String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
        String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");

        RestClient.getApiServicePojo(xCookies, aCookies).apiCallGetStudentDetails(String.valueOf(studentId), new Callback<StudentsDetailsResponseData>() {
            @Override
            public void success(StudentsDetailsResponseData studentsDetailsResponseData, Response response) {
                if (LoadingBox.isDialogShowing()) {
                    LoadingBox.dismissLoadingDialog();
                }
                Log.d(TAG, "Response : " + new Gson().toJson(studentsDetailsResponseData));
                Prefs.with(StudentDetailsActivity.this).save(PrefsKeys.STUDENT_DETAILS_RESPONSE_DATA, studentsDetailsResponseData);
                setUIData(studentsDetailsResponseData);
            }

            @Override
            public void failure(RetrofitError error) {
                if (LoadingBox.isDialogShowing()) {
                    LoadingBox.dismissLoadingDialog();
                }
                Log.d(TAG, "error : " + error.toString());
            }
        });
    }


    private void sendRemarksServerCall(int id) {

        RemarksRequestObject remarksRequestObject = new RemarksRequestObject();

        String remarksStr = editTextRemarks.getText().toString();

        Remarks remarks = new Remarks();
        remarks.setDateOfRemark(ISO8601.fromCalendar(Calendar.getInstance()));
        remarks.setRemark(remarksStr);
        ArrayList<Integer> studentList = new ArrayList<>();

        studentList.add(id);

        remarks.setStudents(studentList);

        remarksRequestObject.setRemarks(remarks);

        String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
        String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");

        String jsonRemarks = new Gson().toJson(remarksRequestObject);

        LoadingBox.showLoadingDialog(this, "Sending Remarks...");

        try {
            TypedInput typedInput = new TypedByteArray("application/json", jsonRemarks.getBytes("UTF-8"));
            RestClient.getApiServicePojo(xCookies, aCookies).apiCallSendRemarks(typedInput, new Callback<AddRemarksResponseData>() {
                @Override
                public void success(AddRemarksResponseData addRemarksResponseData, Response response) {
                    android.util.Log.d(TAG, "Response : " + new Gson().toJson(addRemarksResponseData));
                    if (LoadingBox.isDialogShowing()) {
                        LoadingBox.dismissLoadingDialog();
                    }

                    if (addRemarksResponseData.getResponseMetadata().getSuccess().equalsIgnoreCase("yes")) {
                        Utils.failureDialog(StudentDetailsActivity.this, "Success", "You have successfully sent remarks");
                        getStudentRemarks(studentId);
                    } else {
                        Utils.failureDialog(StudentDetailsActivity.this, "Failure", "Something went wrong, please try again.");
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    android.util.Log.d(TAG, "error : " + error.toString());
                    if (LoadingBox.isDialogShowing()) {
                        LoadingBox.dismissLoadingDialog();
                    }
                    Utils.failureDialog(StudentDetailsActivity.this, "Failure", "Something went wrong, please try again.");
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void getStudentRemarks(int studentId) {

        String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
        String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");

        RestClient.getApiServicePojo(xCookies, aCookies).apiCallFetchSingleStudentRemarks(String.valueOf(studentId), "1",
                new Callback<StudentsRemarksResponse>() {
                    @Override
                    public void success(StudentsRemarksResponse studentsRemarksResponse, Response response) {
                        Log.d(TAG, "Response : " + new Gson().toJson(studentsRemarksResponse));
                        setUiremarks(studentsRemarksResponse);
                    }


                    @Override
                    public void failure(RetrofitError error) {
                        Log.d(TAG, "error : " + error.toString());
                    }
                });
    }

    private void setUiremarks(StudentsRemarksResponse studentsRemarksResponse) {

//        if (studentsRemarksResponse.getData().getRemarks().isEmpty()) {
//            textViewRemarks.setVisibility(View.GONE);
//        } else {
//            textViewRemarks.setVisibility(View.VISIBLE);
//        }

        for (Remark remark : studentsRemarksResponse.getData().getRemarks()) {
            Log.d("adapter", "UIremark : " + new Gson().toJson(remark));
        }
//        RemarksListAdapter remarksListAdapter = new RemarksListAdapter(this, studentsRemarksResponse.getData().getRemarks());
//        listViewRemarks.setAdapter(remarksListAdapter);

        if (studentsRemarksResponse.getData().getRemarks() != null && !studentsRemarksResponse.getData().getRemarks().isEmpty()) {
            linearLayoutRemarks.setVisibility(View.VISIBLE);
            Log.d(TAG, "remarks Size : " + studentsRemarksResponse.getData().getRemarks().size());
            EventsListStudentsAdapter adapter = new EventsListStudentsAdapter(this, studentsRemarksResponse.getData().getRemarks());
            listViewEventsStudents.setAdapter(adapter);
        }
    }

//    private void sendPictureToUploads(String filePath) {
//        String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
//        String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");
//
//        PictureUploadObject pictureUploadObject = new PictureUploadObject();
//        Picture picture = new Picture();
//
//        picture.setExtention("jpeg");
//        picture.setContentType("image/jpeg");
//
//        String base64Str = bitmapToBase64(getBitmap(filePath));
//
//        base64Str = base64Str.replaceAll("\n", "");
//
////        String str  = base64Str;
//
//        picture.setFile("data:image/jpeg;base64,".concat(base64Str));
//
//        pictureUploadObject.setPicture(picture);
//
//        String jsonUpload = new Gson().toJson(pictureUploadObject);
//
//        if (jsonUpload.contains("\\u")) {
//            Log.d("matcher", "it contains special character");
//            jsonUpload = jsonUpload.replaceAll(Matcher.quoteReplacement("\\u"), "");
//        }
//
//        LoadingBox.showLoadingDialog(this, "Uploading Image...");
//
//        try {
//            TypedInput typedInput = new TypedByteArray("application/json", jsonUpload.getBytes("UTF-8"));
//            RestClient.getApiServicePojo(xCookies, aCookies).apiCallSendStudentPicture(typedInput, new Callback<ImageUploadResponse>() {
//                @Override
//                public void success(ImageUploadResponse imageUploadResponse, Response response) {
//                    Log.d(TAG, "Response : " + imageUploadResponse);
//                    if (LoadingBox.isDialogShowing()) {
//                        LoadingBox.dismissLoadingDialog();
//                    }
//                    if (imageUploadResponse.getResponseMetadata().getSuccess().equalsIgnoreCase("yes")) {
//                        sendPutStudentPicture(imageUploadResponse.getData().getImageUrl());
//                    } else {
//                        Utils.failureDialog(StudentDetailsActivity.this, "Image Upload failed", "Something went wrong, please try again");
//                    }
//                }
//
//                @Override
//                public void failure(RetrofitError error) {
//                    Log.d(TAG, "error : " + error.toString());
//                    if (LoadingBox.isDialogShowing()) {
//                        LoadingBox.dismissLoadingDialog();
//                    }
//                    Utils.failureDialog(StudentDetailsActivity.this, "Image Upload failed", "Something went wrong, please try again");
//                }
//            });
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void sendPictureToUploadsWithId(int id, String filePath) {
//        String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
//        String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");
//
//        PictureUploadObject pictureUploadObject = new PictureUploadObject();
//        Picture picture = new Picture();
//
//        picture.setExtention("jpeg");
//        picture.setContentType("image/jpeg");
//
//        String base64Str = bitmapToBase64(getBitmap(filePath));
//
//        base64Str = base64Str.replaceAll("\n", "");
//
////        String str  = base64Str;
//
//        picture.setFile("data:image/jpeg;base64,".concat(base64Str));
//
//        pictureUploadObject.setPicture(picture);
//
//        String jsonUpload = new Gson().toJson(pictureUploadObject);
//
//        if (jsonUpload.contains("\\u")) {
//            Log.d("matcher", "it contains special character");
//            jsonUpload = jsonUpload.replaceAll(Matcher.quoteReplacement("\\u"), "");
//        }
//
//        LoadingBox.showLoadingDialog(this, "Uploading Image...");
//
//        try {
//            TypedInput typedInput = new TypedByteArray("application/json", jsonUpload.getBytes("UTF-8"));
//            RestClient.getApiServicePojo(xCookies, aCookies).apiCallSendStudentPictureWithId(String.valueOf(id), typedInput, new Callback<ImageUploadResponse>() {
//                @Override
//                public void success(ImageUploadResponse imageUploadResponse, Response response) {
//                    Log.d(TAG, "Response : " + imageUploadResponse);
//                    if (LoadingBox.isDialogShowing()) {
//                        LoadingBox.dismissLoadingDialog();
//                    }
//                    if (imageUploadResponse.getResponseMetadata().getSuccess().equalsIgnoreCase("yes")) {
////                        Log.d(TAG,"Image_load"+imageUploadResponse.getData().getPicture().getUrl());
////                        Picasso.with(StudentDetailsActivity.this).load(imageUploadResponse.getData().getPicture().getUrl()).into(imageViewProfilePicStudent);
//                        getStudentDetailsServerCall(studentId);
//                    } else {
//                        Utils.failureDialog(StudentDetailsActivity.this, "Image Upload failed", "Something went wrong, please try again");
//                    }
//                }
//
//                @Override
//                public void failure(RetrofitError error) {
//                    Log.d(TAG, "error : " + error.toString());
//                    if (LoadingBox.isDialogShowing()) {
//                        LoadingBox.dismissLoadingDialog();
//                    }
//                    Utils.failureDialog(StudentDetailsActivity.this, "Image Upload failed", "Something went wrong, please try again");
//                }
//            });
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void sendPutStudentPicture(String imageUrl) {
//
//        ImageStudentPutObject imageStudentPutObject = new ImageStudentPutObject();
//
//        Student student = new Student();
//
//        student.setId(studentId);
//
//        com.monkeybusiness.jaaar.objectClasses.imagePutObject.Picture picture = new com.monkeybusiness.jaaar.objectClasses.imagePutObject.Picture();
//
//        picture.setUrl(imageUrl);
//
//        student.setPicture(picture);
//
//        imageStudentPutObject.setStudent(student);
//
//        String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
//        String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");
//        String jsonUpload = new Gson().toJson(imageStudentPutObject);
//
//        LoadingBox.showLoadingDialog(this, "Uploading Image...");
//        try {
//            TypedInput typedInput = new TypedByteArray("application/json", jsonUpload.getBytes("UTF-8"));
//            RestClient.getApiService(xCookies, aCookies).apiCallPutStudentPicture(String.valueOf(studentId), typedInput, new Callback<String>() {
//                @Override
//                public void success(String s, Response response) {
//                    Log.d(TAG, "Response : " + s);
//                    if (LoadingBox.isDialogShowing()) {
//                        LoadingBox.dismissLoadingDialog();
//                    }
//                    getStudentDetailsServerCall(studentId);
//                }
//
//                @Override
//                public void failure(RetrofitError error) {
//                    Log.d(TAG, "error : " + error.toString());
//                    if (LoadingBox.isDialogShowing()) {
//                        LoadingBox.dismissLoadingDialog();
//                    }
//                }
//            });
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    protected void onResume() {
        super.onResume();

        getStudentDetailsServerCall(studentId);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                getStudentRemarks(studentId);
//            }
//        }, 200);
    }

    public Bitmap getBitmap(String filePath) {
        Bitmap bm = BitmapFactory.decodeFile(filePath);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bm, 400, 400, false);
//        imageViewProfilePicStudent.setImageBitmap(scaledBitmap);
        return scaledBitmap;
    }

    //decodes image and scales it to reduce memory consumption
//    private Bitmap decodeFile(File f) {
//        try {
//            //decode image size
//            BitmapFactory.Options o = new BitmapFactory.Options();
//            o.inJustDecodeBounds = true;
//            BitmapFactory.decodeStream(new FileInputStream(f), null, o);
//
//            //Find the correct scale value. It should be the power of 2.
//            final int REQUIRED_SIZE = 400;
//            int width_tmp = o.outWidth, height_tmp = o.outHeight;
//            int scale = 1;
//            while (true) {
//                if (width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE)
//                    break;
//                width_tmp /= 2;
//                height_tmp /= 2;
//                scale *= 2;
//            }
//
//            //decode with inSampleSize
//            BitmapFactory.Options o2 = new BitmapFactory.Options();
//            o2.inSampleSize = scale;
//            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
//        } catch (FileNotFoundException e) {
//        }
//        return null;
//    }

    private String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

//        switch (requestCode) {
//            case STORAGE_REQUEST:
//                if (Utils.allowPermissionForHigherVersions(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                    showProfilePicDialog();
//                } else {
//
//                }
//
//                break;
//        }
    }

//    private void upDateStudentNumberServerCall(int id, String number) {
//
//        String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
//        String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");
//
//        StudentUpdateObject studentUpdateObject = new StudentUpdateObject();
//
//        com.monkeybusiness.jaaar.objectClasses.updateStudentNumber.Student student = new com.monkeybusiness.jaaar.objectClasses.updateStudentNumber.Student();
//
//        student.setId(id);
//
//        Parent parent = new Parent();
//        parent.setContactPhone(number);
//
//        student.setParent(parent);
//        studentUpdateObject.setStudent(student);
//
//        String jsonString = new Gson().toJson(studentUpdateObject);
//
//        LoadingBox.showLoadingDialog(this, "Saving Data...");
//        try {
//            TypedInput typedInput = new TypedByteArray("application/json", jsonString.getBytes("UTF-8"));
//            RestClient.getApiService(xCookies, aCookies).apiCallPutStudentNumber(String.valueOf(id), typedInput, new Callback<String>() {
//                @Override
//                public void success(String s, Response response) {
//                    if (LoadingBox.isDialogShowing()) {
//                        LoadingBox.dismissLoadingDialog();
//                    }
//                    textViewContactStudent.setText(number);
//                    Log.d(TAG, "Response : " + s);
//                }
//
//                @Override
//                public void failure(RetrofitError error) {
//                    if (LoadingBox.isDialogShowing()) {
//                        LoadingBox.dismissLoadingDialog();
//                    }
//                    Log.d(TAG, "error : " + error.toString());
//                }
//            });
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public class imageDownload implements Runnable {
//
//        String url;
//
//        imageDownload(String url) {
//            this.url = url;
//        }
//
//        private Bitmap getDecodedPhotos(String url) {
//
//            //from web
//            try {
//                android.util.Log.d("ImageLoader", "Loading from web");
//                Bitmap bitmap = null;
//                URL imageUrl = new URL(url.replaceAll(" ", "%20"));
//                HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
//                conn.setConnectTimeout(30000);
//                conn.setReadTimeout(30000);
//                conn.setInstanceFollowRedirects(true);
////            InputStream is = conn.getInputStream();
////            OutputStream os = new FileOutputStream();
////            os.close();
//                InputStream iStream = conn.getInputStream();
//
//                /** Creating a bitmap from the stream returned from the url */
//                bitmap = BitmapFactory.decodeStream(iStream);
//
//                return bitmap;
//            } catch (Throwable ex) {
//                ex.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        public void run() {
//
//            Bitmap bitmap = getDecodedPhotos(url);
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    imageViewProfilePicStudent.setImageBitmap(bitmap);
//                }
//            });
//        }
//    }
}




