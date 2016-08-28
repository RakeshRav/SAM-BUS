package bus.monkeybusiness.com.sambus.utility.dialogBox;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.WindowManager;
import android.widget.TextView;

import bus.monkeybusiness.com.sambus.R;


public class CommonDialog {


    Activity activity;


    /**
     * @param act
     */
    public CommonDialog(Activity act) {
        activity = act;
    }

    /**
     * @param activity
     * @return
     */
    public static CommonDialog With(Activity activity) {
        return new CommonDialog(activity);
    }

    /**
     * @param message
     */
    public void Show(String message) {
        try {

            final Dialog dialog = new Dialog(activity,
                    R.style.Theme_AppCompat_Translucent);
            dialog.setContentView(R.layout.dialog_custom_msg);
            WindowManager.LayoutParams layoutParams = dialog.getWindow()
                    .getAttributes();
            layoutParams.dimAmount = 0.6f;
            dialog.getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);

            TextView textMessage = (TextView) dialog
                    .findViewById(R.id.textViewMessage);
            textMessage.setMovementMethod(new ScrollingMovementMethod());
            textMessage.setText(message);
            Handler mHandler = new Handler();
            mHandler.postDelayed(new Runnable() {
                public void run() {
                    try {
                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }, 2000);

            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}