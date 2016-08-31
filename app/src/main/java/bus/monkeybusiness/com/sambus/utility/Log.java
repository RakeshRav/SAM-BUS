package bus.monkeybusiness.com.sambus.utility;

public class Log {

    private static final boolean print = false;    //true for printing and false for not

    public Log() {
    }

    /**
     * @param tag
     * @param message
     */

    public static void i(String tag, String message) {
        if (print) {
            android.util.Log.i(tag, message);
        }
    }

    /**
     * @param tag
     * @param message
     */
    public static void d(String tag, String message) {
        if (print) {
            android.util.Log.d(tag, message);
        }
    }

    /**
     * @param tag
     * @param message
     */
    public static void e(String tag, String message) {
        if (print) {
            android.util.Log.e(tag, message);
        }
    }

    /**
     * @param tag
     * @param message
     */
    public static void v(String tag, String message) {
        if (print) {
            android.util.Log.v(tag, message);
        }
    }

    /**
     * @param tag
     * @param message
     */
    public static void w(String tag, String message) {
        if (print) {
            android.util.Log.w(tag, message);
        }
    }
}