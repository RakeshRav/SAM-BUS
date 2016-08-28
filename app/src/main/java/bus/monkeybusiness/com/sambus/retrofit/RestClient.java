package bus.monkeybusiness.com.sambus.retrofit;

import android.util.Base64;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import bus.monkeybusiness.com.sambus.utility.Config;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;


/**
 * Rest client
 */
public class RestClient {

    public static final String credentials = "";

    public static ApiService getApiService(final String xCookies, final String aCookies) {

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(Config.getBaseURL())
                .setConverter(new StringConverter())
                .setClient(new OkClient(new OkHttpClient()));

        builder.setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
                request.addHeader("Cookie", xCookies);
                request.addHeader("Cookie", aCookies);
            }
        });

        builder.setLogLevel(RestAdapter.LogLevel.FULL).setLog(new RestAdapter.Log() {
            public void log(String msg) {
//                if (cookieString.isEmpty()) {
                Log.i("retrofit======", msg);
//                }
            }
        });

        RestAdapter restAdapter = builder.build();

        return restAdapter.create(ApiService.class);
    }

    public static ApiService getApiServicePojo(final String xCookies, final String aCookies) {

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(Config.getBaseURL())
                .setClient(new OkClient(new OkHttpClient()));

        builder.setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
                request.addHeader("Cookie", xCookies);
                request.addHeader("Cookie", aCookies);
            }
        });

        builder.setLogLevel(RestAdapter.LogLevel.FULL).setLog(new RestAdapter.Log() {
            public void log(String msg) {
//                if (cookieString.isEmpty()) {
                Log.i("retrofit======", msg);
//                }
            }
        });

        RestAdapter restAdapter = builder.build();

        return restAdapter.create(ApiService.class);
    }

    public static ApiService getApiServiceWithUserIdPassword(final String cookieString) {

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(Config.getBaseURL())
                .setConverter(new StringConverter())
                .setClient(new OkClient(new OkHttpClient()));

        builder.setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                String string = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                request.addHeader("Accept", "application/json");
                if (Config.appMode != Config.AppMode.LIVE)
                    request.addHeader("Authorization", string);
                request.addHeader("Cookie", cookieString);

            }
        });

        builder.setLogLevel(RestAdapter.LogLevel.FULL).setLog(new RestAdapter.Log() {
            public void log(String msg) {
//                if (cookieString.isEmpty()) {
                Log.i("retrofit======", msg);
//                }
            }
        });

        RestAdapter adapter = builder.build();

        return adapter.create(ApiService.class);
    }

    public static ApiService getApiServicePojoWithUserIdPassword(final String cookieString) {


        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(Config.getBaseURL())
                .setClient(new OkClient(new OkHttpClient()));


        builder.setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                // create Base64 encodet string
                String string = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                request.addHeader("Accept", "application/json");
                if (Config.appMode != Config.AppMode.LIVE)
                    request.addHeader("Authorization", string);
                request.addHeader("Cookie", cookieString);
                Log.e("cookieString", "===" + cookieString);
            }
        });

        builder.setLogLevel(RestAdapter.LogLevel.HEADERS_AND_ARGS).setLog(new RestAdapter.Log() {
            public void log(String msg) {
                if (cookieString.isEmpty()) {
                    Log.i("retrofit======", msg);
                }


            }
        });


        RestAdapter adapter = builder.build();

        return adapter.create(ApiService.class);
    }

    public static ApiService getApiServiceForAddress() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://maps.google.com")
                .setClient(new OkClient(new OkHttpClient()))
                .build();

        return restAdapter.create(ApiService.class);
    }

}

