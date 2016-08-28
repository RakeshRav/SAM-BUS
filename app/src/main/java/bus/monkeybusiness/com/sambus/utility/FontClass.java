package bus.monkeybusiness.com.sambus.utility;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by rakesh on 21/8/15.
 */
public class FontClass {

    private static Typeface proximaLight;
    private static Typeface proximaBold;
    private static Typeface proximaThin;
    private static Typeface proximaRegular;


    public static Typeface proximaLight(Context appContext) {


        if (proximaLight == null) {
            proximaLight = Typeface.createFromAsset(appContext.getAssets(),
                    "fonts/ProximaNova-Light.ttf");
        }
        return proximaLight;
    }

    public static Typeface proximaBold(Context appContext) {

        if (proximaBold == null) {
            proximaBold = Typeface.createFromAsset(appContext.getAssets(),
                    "fonts/ProximaNova-Bold.ttf");
        }
        return proximaBold;
    }

    public static Typeface proximaThin(Context appContext) {

        if (proximaThin == null) {
            proximaThin = Typeface.createFromAsset(appContext.getAssets(),
                    "fonts/ProximaNova-Thin.ttf");
        }
        return proximaThin;
    }


    public static Typeface proximaRegular(Context appContext) {

        if (proximaRegular == null) {
            proximaRegular = Typeface.createFromAsset(appContext.getAssets(),
                    "fonts/ProximaNova-Reg.ttf");
        }
        return proximaRegular;
    }

}
