package bus.monkeybusiness.com.sambus.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rey.material.widget.CheckBox;
import com.rey.material.widget.FloatingActionButton;

import java.io.UnsupportedEncodingException;

import bus.monkeybusiness.com.sambus.R;
import bus.monkeybusiness.com.sambus.model.changeRole.ChangeRoleObject;
import bus.monkeybusiness.com.sambus.model.changeRoleRespnse.ChangeRoleResponse;
import bus.monkeybusiness.com.sambus.model.loginRequestObject.LoginRequestObject;
import bus.monkeybusiness.com.sambus.model.loginRequestObject.Session;
import bus.monkeybusiness.com.sambus.model.loginResponseData.LoginResponse;
import bus.monkeybusiness.com.sambus.model.loginResponseData.UserRole;
import bus.monkeybusiness.com.sambus.retrofit.RestClient;
import bus.monkeybusiness.com.sambus.utility.Constants;
import bus.monkeybusiness.com.sambus.utility.FontClass;
import bus.monkeybusiness.com.sambus.utility.dialogBox.CommonDialog;
import bus.monkeybusiness.com.sambus.utility.dialogBox.LoadingBox;
import bus.monkeybusiness.com.sambus.utility.preferences.Prefs;
import bus.monkeybusiness.com.sambus.utility.preferences.PrefsKeys;
import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import rmn.androidscreenlibrary.ASSL;

public class LoginActivity extends AppCompatActivity {


    final String TAG = "LoginActivity.java";
    @Bind(R.id.input_email)
    EditText inputEmail;
    @Bind(R.id.input_password)
    EditText inputPassword;
    @Bind(R.id.btn_login)
    FloatingActionButton loginButton;
    @Bind(R.id.textViewForgotPass)
    TextView textViewforgotpass;
    @Bind(R.id.textViewTitle)
    TextView textViewTitle;
    @Bind(R.id.textViewBrownCode)
    TextView textViewBrownCode;
//    @Bind(R.id.linearLayoutMain)
//    LinearLayout linearLayoutMain;

    CheckBox checkBoxRememberMe;


//    private void startAnimations() {
//        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
//        anim.reset();
//        LinearLayout l=(LinearLayout) findViewById(R.id.linearLayoutMain);
//        l.clearAnimation();
//        l.startAnimation(anim);
//
//        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
//        anim.reset();
//        ImageView iv = (ImageView) findViewById(R.id.logo);
//        iv.clearAnimation();
//        iv.startAnimation(anim);
//
//        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
//        anim.reset();
//        EditText iv1 = (EditText) findViewById(R.id.input_email);
//        iv1.clearAnimation();
//        iv1.startAnimation(anim);
//
//        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
//        anim.reset();
//        EditText iv2 = (EditText) findViewById(R.id.input_password);
//        iv2.clearAnimation();
//        iv2.startAnimation(anim);
//
//        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
//        anim.reset();
//        Button iv3 = (Button) findViewById(R.id.btn_login);
//        iv3.clearAnimation();
//        iv3.startAnimation(anim);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_login);

        new ASSL(this, (ViewGroup) findViewById(R.id.root), 1134, 720,
                false);
//        startAnimations();
        ButterKnife.bind(this);

        checkBoxRememberMe = (CheckBox) findViewById(R.id.checkBoxRememberMe);

        textViewforgotpass.setText(Html.fromHtml("<u>Forgot Password?</u>"));

        String verifiedUser = Prefs.with(this).getString(PrefsKeys.VERIFIED_USER, Constants.UNVERIFIED);

        if (verifiedUser.equalsIgnoreCase(Constants.VERIFIED)) {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        }

        setFonts();

//        linearLayoutMain.setBackgroundDrawable(drawable);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void setFonts() {

        textViewTitle.setTypeface(FontClass.proximaRegular(this));
        inputEmail.setTypeface(FontClass.proximaRegular(this));
        inputPassword.setTypeface(FontClass.proximaRegular(this));
        checkBoxRememberMe.setTypeface(FontClass.proximaBold(this));
        textViewforgotpass.setTypeface(FontClass.proximaRegular(this));
        textViewBrownCode.setTypeface(FontClass.proximaLight(this));
    }

    public void login() {
//        Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
//        startActivity(i);
//        finish();

        LoadingBox.showLoadingDialog(this,"Verifying...");
        LoginRequestObject loginRequestObject = new LoginRequestObject();

        Session session = new Session();
        session.setUsername(inputEmail.getText().toString());

        boolean remember;

        if (checkBoxRememberMe.isChecked()) {
            remember = true;
        } else {
            remember = false;
        }

        session.setRemember(remember);
        loginRequestObject.setSession(session);
        loginRequestObject.setPassword(inputPassword.getText().toString());

//        String ssn = "{\"session\":{\"username\":\"bytedreams\"},\"password\":\"bytedreams\"}";
        Log.d(TAG, "JSON : " + new Gson().toJson(loginRequestObject));
        String jsonObject = new Gson().toJson(loginRequestObject);

        try {
            final TypedInput in = new TypedByteArray("application/json", jsonObject.getBytes("UTF-8"));
            String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
            String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");

            RestClient.getApiServicePojo(xCookies, aCookies).apiCallLogin(in, new Callback<LoginResponse>() {
                @Override
                public void success(LoginResponse loginResponse, Response response) {

//                    Log.d(TAG, "Response : " + loginResponse);
                    Log.d(TAG, "Response : " + new Gson().toJson(loginResponse));
                    if (LoadingBox.isDialogShowing())
                    {
                        LoadingBox.dismissLoadingDialog();
                    }
                    boolean isXcookies = true;
                    for (Header header : response.getHeaders()) {
                        if (header.getName().equalsIgnoreCase("set-cookie")) {
                            if (isXcookies) {
                                Prefs.with(getApplicationContext()).save(PrefsKeys.X_COOKIES, header.getValue().replaceAll("; path=/", ""));
                                Log.e("Cookies", "==" + header.getValue().replaceAll("; path=/", ""));
                                isXcookies = false;
                            } else {
                                Prefs.with(getApplicationContext()).save(PrefsKeys.A_COOKIES, header.getValue().replaceAll("; path=/; HttpOnly", ""));
                                Log.e("Cookies", "==" + header.getValue().replaceAll("; path=/; HttpOnly", ""));
                                break;
                            }
                        }
                    }

                    if (loginResponse != null) {
                        if (loginResponse.getResponseMetadata().getSuccess().equalsIgnoreCase("yes") && loginResponse.getData().getUserTypeDetails().contains("Teacher")) {
                            for (UserRole userRole : loginResponse.getData().getUserRoles())
                            {
                                if (userRole.getRoleName().equalsIgnoreCase("Bus")){
                                    changeRoleServerCall(userRole.getId());
                                }
                            }
                        }else if (loginResponse.getResponseMetadata().getSuccess().equalsIgnoreCase("yes") && loginResponse.getData().getUserTypeDetails().contains("Bus")){
                            Prefs.with(LoginActivity.this).save(PrefsKeys.VERIFIED_USER, Constants.VERIFIED);
                            Prefs.with(LoginActivity.this).save(PrefsKeys.LOGIN_RESPONSE_DATA, loginResponse);
                            Intent dashboardIntent = new Intent(LoginActivity.this,DashboardActivity.class);
                            startActivity(dashboardIntent);
                            finish();
                            Log.d(TAG,"success Bus Login");
                        }else
                        {
                            new CommonDialog(LoginActivity.this).Show(loginResponse.getResponseMetadata().getMessage());
                            Prefs.with(LoginActivity.this).save(PrefsKeys.VERIFIED_USER, Constants.UNVERIFIED);
                        }
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    if (LoadingBox.isDialogShowing())
                    {
                        LoadingBox.dismissLoadingDialog();
                    }
                    Log.d(TAG, "Error : " + error.toString());
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        // Log.d(TAG, "Login");

//        if (!validate()) {
//            onLoginFailed();
        return;
        //       }
    }

    private void changeRoleServerCall(int id) {

        LoadingBox.showLoadingDialog(this,"Verifying...");
        final ChangeRoleObject changeRoleObject = new ChangeRoleObject();
        bus.monkeybusiness.com.sambus.model.changeRole.Session session = new bus.monkeybusiness.com.sambus.model.changeRole.Session();
        session.setRoleId(id);

        changeRoleObject.setSession(session);

        Log.d(TAG, "JSON : " + new Gson().toJson(changeRoleObject));
        String jsonObject = new Gson().toJson(changeRoleObject);

        try {
            TypedInput input = new TypedByteArray("application/json",jsonObject.getBytes("UTF-8"));
            String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
            String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");

            RestClient.getApiServicePojo(xCookies,aCookies).apiCallChangeRole(input, new Callback<ChangeRoleResponse>() {
                @Override
                public void success(ChangeRoleResponse changeRoleResponse, Response response) {
                    bus.monkeybusiness.com.sambus.utility.Log.d(TAG,"Response : "+new Gson().toJson(changeRoleResponse));
                    if (LoadingBox.isDialogShowing()){
                        LoadingBox.dismissLoadingDialog();
                    }
                    if (changeRoleResponse.getResponseMetadata().getSuccess().equalsIgnoreCase("yes")){
                        Prefs.with(LoginActivity.this).save(PrefsKeys.VERIFIED_USER, Constants.VERIFIED);
                        Intent dashboardIntent = new Intent(LoginActivity.this,DashboardActivity.class);
                        startActivity(dashboardIntent);
                        finish();
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    bus.monkeybusiness.com.sambus.utility.Log.d(TAG,"error : "+error.toString());
                    if (LoadingBox.isDialogShowing()){
                        LoadingBox.dismissLoadingDialog();
                    }
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
