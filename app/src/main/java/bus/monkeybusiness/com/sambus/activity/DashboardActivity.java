package bus.monkeybusiness.com.sambus.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import bus.monkeybusiness.com.sambus.R;
import bus.monkeybusiness.com.sambus.adapter.BusListAdapter;
import bus.monkeybusiness.com.sambus.model.busListResponse.BusListResponse;
import bus.monkeybusiness.com.sambus.model.checkLoginResponse.CheckLoginResponse;
import bus.monkeybusiness.com.sambus.retrofit.RestClient;
import bus.monkeybusiness.com.sambus.utility.Constants;
import bus.monkeybusiness.com.sambus.utility.FontClass;
import bus.monkeybusiness.com.sambus.utility.Log;
import bus.monkeybusiness.com.sambus.utility.dialogBox.LoadingBox;
import bus.monkeybusiness.com.sambus.utility.preferences.Prefs;
import bus.monkeybusiness.com.sambus.utility.preferences.PrefsKeys;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rmn.androidscreenlibrary.ASSL;

/**
 * Created by rakesh on 4/2/16.
 */
public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    final String TAG = "DashboardActivity";

    LinearLayout linearLayoutMainDash;
    //
    RelativeLayout relativeLayoutMenu;

//    TextView textViewActionTitle;

//    TextView textViewClass;
//    TextView textViewContact;
//    TextView textViewEmailStudent;

    ImageView imageViewProfilePic;
    TextView textViewName;
    TextView textViewGreetings;
    //    TextView textViewAttdText;
//    TextView textViewAttdTitle;
    TextView textViewEventsText;

//    Button buttonTakeAttd;

    //    ProgressBar progressBarDash;
    FrameLayout frameLayoutAttd;
//    RelativeLayout relativeLayoutAdd;

    RelativeLayout relativeLayoutNodataFound;

    ListView listViewEvents;
    ProgressBar progressBarEvents;
    private BusListAdapter busListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_new);

        new ASSL(this, (ViewGroup) findViewById(R.id.root), 1134, 720,
                false);
//        Utils.classFlag = 0;

//        toggleLayouts(linearlayoutDashboard, textViewDashboard);

        initialization();
        setFont();

        dashBoardServerCall();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getBusListServerCallDay();
            }
        }, 200);
    }

    public void initialization() {
        linearLayoutMainDash = (LinearLayout) findViewById(R.id.root);

        relativeLayoutMenu = (RelativeLayout) findViewById(R.id.relativeLayoutMenu);
        listViewEvents = (ListView) findViewById(R.id.listViewEvents);


//        textViewActionTitle = (TextView) findViewById(R.id.textViewActionTitle);
        textViewName = (TextView) findViewById(R.id.textViewName);
//        textViewClass = (TextView) findViewById(R.id.textViewClass);
//        textViewContact = (TextView) findViewById(R.id.textViewContact);
//        textViewEmailStudent = (TextView) findViewById(R.id.textViewEmailStudent);
        textViewGreetings = (TextView) findViewById(R.id.textViewGreetings);
//        textViewAttdText= (TextView) findViewById(R.id.textViewAttdText);
//        textViewAttdTitle= (TextView) findViewById(R.id.textViewAttdTitle);
        textViewEventsText = (TextView) findViewById(R.id.textViewEventsText);

//        relativeLayoutAdd = (RelativeLayout) findViewById(R.id.relativeLayoutAdd);

        imageViewProfilePic = (ImageView) findViewById(R.id.imageViewProfilePic);

        progressBarEvents = (ProgressBar) findViewById(R.id.progressBarEvents);

        relativeLayoutNodataFound = (RelativeLayout) findViewById(R.id.relativeLayoutNodataFound);

        progressBarEvents.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.add_button_purple), PorterDuff.Mode.MULTIPLY);

//        buttonTakeAttd = (Button) findViewById(R.id.buttonTakeAttd);
//        frameLayoutAttd = (FrameLayout) findViewById(R.id.frameLayoutAttd);


//        progressBarDash = (ProgressBar) findViewById(R.id.progressBarDash);

//        textViewActionTitle.setText("DashBoard");

        linearLayoutMainDash.setVisibility(View.GONE);

        busListAdapter = new BusListAdapter(this);
        listViewEvents.setAdapter(busListAdapter);

        relativeLayoutMenu.setOnClickListener(this);
//        textViewActionTitle.setOnClickListener(this);
//        buttonTakeAttd.setOnClickListener(this);
//        relativeLayoutAdd.setOnClickListener(this);
    }

    public void setFont() {
        textViewName.setTypeface(FontClass.proximaRegular(this));
        textViewGreetings.setTypeface(FontClass.proximaBold(this));
//        textViewAttdText.setTypeface(FontClass.proximaRegular(this));
//        textViewAttdTitle.setTypeface(FontClass.proximaRegular(this));
        textViewEventsText.setTypeface(FontClass.proximaRegular(this));
    }

    private void setUIData() {

        CheckLoginResponse checkLoginResponse = Prefs.with(this).getObject(PrefsKeys.CHECK_LOGIN_DATA, CheckLoginResponse.class);

//        progressBarDash.setVisibility(View.GONE);
        linearLayoutMainDash.setVisibility(View.VISIBLE);

        if (checkLoginResponse != null) {
            textViewName.setText("Hi!  " + checkLoginResponse.getData().getUserTypeDetails().getTeacherName());
//            textViewClass.setVisibility(View.GONE);
//            textViewContact.setText("Contact No : "+checkLoginResponse.getData().getUserTypeDetails().getContactInfo());
//            textViewEmailStudent.setText("Email : "+checkLoginResponse.getData().getUserInfo().getEmail());

            if (checkLoginResponse.getData().getUserTypeDetails().getPicture() != null) {

                Picasso.with(this).load(checkLoginResponse.getData().getUserTypeDetails().getPicture().getUrl()).into(imageViewProfilePic);
//                Picasso.with(this).load(checkLoginResponse.getData().getUserTypeDetails().getPicture().getUrl()).into(profile_image);
//                Picasso.with(this).load(checkLoginResponse.getData().getUserTypeDetails().getPicture().getUrl()).into(littleProfilePic);
            }
        }

    }

    public void setUiDataForListView(BusListResponse busListResponse) {

        progressBarEvents.setVisibility(View.GONE);
        if (busListResponse.getData().getBus() != null) {
            if (!busListResponse.getData().getBus().isEmpty()) {
                listViewEvents.setVisibility(View.VISIBLE);
                relativeLayoutNodataFound.setVisibility(View.GONE);
                busListAdapter.setData(busListResponse.getData().getBus());
            } else {
                listViewEvents.setVisibility(View.GONE);
                relativeLayoutNodataFound.setVisibility(View.VISIBLE);
            }
        } else {
            listViewEvents.setVisibility(View.GONE);
            relativeLayoutNodataFound.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.relativeLayoutMenu:
                break;
        }
    }

    private void dashBoardServerCall() {

        String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
        String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");

        LoadingBox.showLoadingDialog(this, "Loading Data...");

        RestClient.getApiServicePojo(xCookies, aCookies).apiCallCheckLogin(new Callback<CheckLoginResponse>() {
            @Override
            public void success(CheckLoginResponse checkLoginResponse, Response response) {
                Log.d(TAG, "Response : " + new Gson().toJson(checkLoginResponse));
//                Log.d(TAG,"Response : "+checkLoginResponse);

                if (LoadingBox.isDialogShowing()) {
                    LoadingBox.dismissLoadingDialog();
                }
                if (checkLoginResponse.getResponseMetadata().getSuccess().equalsIgnoreCase("yes")) {
                    Prefs.with(DashboardActivity.this).save(PrefsKeys.CHECK_LOGIN_DATA, checkLoginResponse);
                    setUIData();
                } else {
                    Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                    startActivity(intent);
                    Prefs.with(DashboardActivity.this).save(PrefsKeys.VERIFIED_USER, Constants.UNVERIFIED);
                    finish();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                if (LoadingBox.isDialogShowing()) {
                    LoadingBox.dismissLoadingDialog();
                }
                Log.d(TAG, "Response-err : " + error.toString());
            }
        });
    }

    public void getBusListServerCallDay() {

        String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
        String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");

        RestClient.getApiServicePojo(xCookies, aCookies).apiCallGetBusList(new Callback<BusListResponse>() {
            @Override
            public void success(BusListResponse busListResponse, Response response) {
                Log.d(TAG, "Response : " + new Gson().toJson(busListResponse));

                Prefs.with(DashboardActivity.this).save(PrefsKeys.BUS_LIST_RESPONSE, busListResponse);
                setUiDataForListView(busListResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "error : " + error.toString());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Utils.classFlag = 0;
    }
}
