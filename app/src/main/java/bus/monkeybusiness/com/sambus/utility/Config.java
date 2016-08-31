package bus.monkeybusiness.com.sambus.utility;

public class Config {

    static String BASE_URL = "";

    public static AppMode appMode = AppMode.LIVE;

    public static String getBaseURL() {
        init(appMode);
        return BASE_URL;
    }

    /**
     * Initialize all the variable in this method
     *
     * @param appMode
     */
    public static void init(AppMode appMode) {

        switch (appMode) {

            case TEST:

                BASE_URL = "http://samapidev.bytedreams.in";

                break;

            case LIVE:

                BASE_URL = "http://samapi.bytedreams.in";

                break;
        }

    }

    public enum AppMode {
        TEST, LIVE
    }
}