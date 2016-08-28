package bus.monkeybusiness.com.sambus.retrofit;

import android.app.Activity;
import android.content.Intent;

import com.google.gson.Gson;

import bus.monkeybusiness.com.sambus.utility.preferences.Prefs;
import bus.monkeybusiness.com.sambus.utility.preferences.PrefsKeys;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by rakesh on 26/6/16.
 */
public class CommonApiCalls {

    private static final String TAG = "CommonApiCalls";
    Activity context;
    boolean isCheck;


    public CommonApiCalls(Activity context)
    {
        this.context = context;
    }


    public void checkLoginServerCall() {

        String xCookies = Prefs.with(context).getString(PrefsKeys.X_COOKIES,"");
        String aCookies = Prefs.with(context).getString(PrefsKeys.A_COOKIES,"");

//        RestClient.getApiServicePojo(xCookies,aCookies).apiCallCheckLogin(new Callback<CheckLoginResponse>() {
//            @Override
//            public void success(CheckLoginResponse checkLoginResponse, Response response) {
//                Log.d(TAG,"Response : "+new Gson().toJson(checkLoginResponse));
//
//                if (checkLoginResponse.getResponseMetadata().getSuccess().equalsIgnoreCase("yes"))
//                {
//                    isCheck = true;
//                }
//                else
//                {
//                    Intent intent = new Intent(context,LoginActivity.class);
//                    context.startActivity(intent);
//                    context.finish();
//                }
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                Log.d(TAG,"Response-err : "+error.toString());
//            }
//        });
    }
}
