package bus.monkeybusiness.com.sambus.activity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rey.material.widget.Button;
import com.rey.material.widget.Spinner;
import com.squareup.okhttp.internal.Util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bus.monkeybusiness.com.sambus.R;
import bus.monkeybusiness.com.sambus.adapter.AnnouncementAdapter;
import bus.monkeybusiness.com.sambus.model.AddAnnouncementsData.AddAnnouncementObject;
import bus.monkeybusiness.com.sambus.model.AddAnnouncementsData.Announcements;
import bus.monkeybusiness.com.sambus.model.announcementResponse.AnnouncementsResponseData;
import bus.monkeybusiness.com.sambus.model.busListResponse.Bu;
import bus.monkeybusiness.com.sambus.model.busListResponse.BusListResponse;
import bus.monkeybusiness.com.sambus.model.busStudentList.BusStudentList;
import bus.monkeybusiness.com.sambus.retrofit.RestClient;
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

public class AnnouncementsActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextAnnouncements;
    Spinner busListSpinner;
    Button buttonPost;
    ListView listViewAnnouncements;
    LinearLayout linearLayoutList;

    RelativeLayout relativeLayoutMenu;
    TextView textViewActionTitle;
    ImageView imageViewToolbaar;

    ProgressBar progressBarAnnouncements;

    AnnouncementAdapter announcementAdapter;

    ArrayList<String> busList;
    BusListResponse busListResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        new ASSL(this, (ViewGroup) findViewById(R.id.root), 1134, 720,
                false);
        initializtion();
        getAnnouncementServerCall();
    }

    private void initializtion() {

        editTextAnnouncements = (EditText) findViewById(R.id.editTextAnnouncements);
        busListSpinner = (Spinner) findViewById(R.id.busListSpinner);
        buttonPost = (Button) findViewById(R.id.buttonPost);
        listViewAnnouncements  = (ListView) findViewById(R.id.listViewAnnouncements);
        progressBarAnnouncements = (ProgressBar) findViewById(R.id.progressBarAnnouncements);

        relativeLayoutMenu = (RelativeLayout) findViewById(R.id.relativeLayoutMenu);
        textViewActionTitle = (TextView) findViewById(R.id.textViewActionTitle);
        imageViewToolbaar =(ImageView) findViewById(R.id.imageViewToolbaar);

        textViewActionTitle.setText("Announcements");

        imageViewToolbaar.setBackgroundDrawable(getResources().getDrawable(R.drawable.cancel_event));

        linearLayoutList = (LinearLayout) findViewById(R.id.linearLayoutList);

        buttonPost.setOnClickListener(this);
        relativeLayoutMenu.setOnClickListener(this);
        progressBarAnnouncements.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.add_button_purple), PorterDuff.Mode.MULTIPLY);

        busList = new ArrayList<>();
        busListResponse = Prefs.with(this).getObject(PrefsKeys.BUS_LIST_RESPONSE, BusListResponse.class);

        if (busListResponse != null) {

            for (Bu bus : busListResponse.getData().getBus()) {
                busList.add(bus.getBusName());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_dropdown_item, busList);
            busListSpinner.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPost:
                sendPostAnnouncementServerCall();
                break;
            case R.id.relativeLayoutMenu:
                finish();
                break;
        }
    }

    private void sendPostAnnouncementServerCall() {

        String announcement = editTextAnnouncements.getText().toString();
        if (announcement.isEmpty()) {
            Utils.failureDialog(this, "Something went wrong", "Please enter some text.");
            return;
        }

        LoadingBox.showLoadingDialog(this,"Posting Announcements...");

        AddAnnouncementObject addAnnouncementObject = new AddAnnouncementObject();

        Announcements announcements = new Announcements();
        announcements.setAnnouncementTypeType("bus");
        announcements.setAnnouncementDetails(announcement);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(busListResponse.getData().getBus().get(busListSpinner.getSelectedItemPosition()).getId());
        announcements.setAnnouncementTypeId(ids);

        addAnnouncementObject.setAnnouncements(announcements);

        String jsonObject = new Gson().toJson(addAnnouncementObject);

        try {
            TypedInput in = new TypedByteArray("application/json", jsonObject.getBytes("UTF-8"));
            String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
            String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");
            RestClient.getApiService(xCookies,aCookies).apiCallPostAnnouncment(in, new Callback<String>() {
                @Override
                public void success(String s, Response response) {
                    Log.d("Announcement","Response : "+s);
                    if (LoadingBox.isDialogShowing())
                    {
                        LoadingBox.dismissLoadingDialog();
                    }
                    progressBarAnnouncements.setVisibility(View.VISIBLE);
                    linearLayoutList.setVisibility(View.INVISIBLE);
                    getAnnouncementServerCall();
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d("Announcement","error : "+error.toString());
                }
            });

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void getAnnouncementServerCall()
    {
        Date fromDate = new Date();
        fromDate.setDate(fromDate.getDate()-7);

        Date toDate = new Date();
        toDate.setDate(toDate.getDate()+7);

        String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
        String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");
        RestClient.getApiServicePojo(xCookies,aCookies).apiCallGetAnnouncements(
                Utils.simpleDateFormatter(fromDate),
                Utils.simpleDateFormatter(toDate),
                new Callback<AnnouncementsResponseData>() {
                    @Override
                    public void success(AnnouncementsResponseData announcementsResponseData, Response response) {
                        Log.d("Annuncements","Response: "+new Gson().toJson(announcementsResponseData));
                        setUiData(announcementsResponseData);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d("Annuncements","error: "+error.toString());
                    }
                });
    }

    private void setUiData(AnnouncementsResponseData announcementsResponseData) {
        if (!announcementsResponseData.getData().getAnnouncements().isEmpty())
        {
            progressBarAnnouncements.setVisibility(View.GONE);
            linearLayoutList.setVisibility(View.VISIBLE);
            announcementAdapter = new AnnouncementAdapter(this,announcementsResponseData.getData().getAnnouncements());
            listViewAnnouncements.setAdapter(announcementAdapter);
        }
    }
}
