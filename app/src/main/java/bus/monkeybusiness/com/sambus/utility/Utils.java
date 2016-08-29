package bus.monkeybusiness.com.sambus.utility;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AlertDialog;
import android.util.Patterns;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by rakesh on 15/12/15.
 */
public class Utils {

    public final static String REGEX_STR = "^[7-9]{1}[0-9]{9}$";
    public static int classFlag;


    public static String appVersion(Context context) {
        String version = "0";
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            version = String.valueOf(pInfo.versionCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return version;
    }

    public static ArrayList<String> getEmailIds(Context context) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
        Account[] accounts = AccountManager.get(context).getAccounts();
//        Log.e("email_res","==="+new Gson().toJson(accounts));
        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches() && !stringArrayList.contains(account.name)) {
                android.util.Log.e("account.name", "=======" + account.name);
                stringArrayList.add(account.name);
            }
        }
        return stringArrayList;
    }

    public static AlertDialog.Builder failureDialog(Context context, String title, String msg) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle(title);
        alert.setMessage(msg);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.show();

        return alert;
    }

    public static AlertDialog.Builder failureDialogCanOverride(Context context, String title, String msg) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle(title);
        alert.setMessage(msg);

        return alert;
    }

    public static String formatDateAndTime(String isoDate) {
        try {
            Calendar calendar = ISO8601.toCalendar(isoDate);
//            Log.d("calendar","calendar : "+new Gson().toJson(calendar));

            Date date = new Date();
            date.setYear(calendar.get(Calendar.YEAR) - 1900);
            date.setMonth(calendar.get(Calendar.MONTH));
            date.setDate(calendar.get(Calendar.DAY_OF_MONTH));
            date.setHours(calendar.get(Calendar.HOUR_OF_DAY));
            date.setMinutes(calendar.get(Calendar.MINUTE));

//            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm, EEE dd MMM yyyy");
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd,  yyyy  HH:mm");
//            Log.d("calendar","date : "+dateFormat.format(date));

            String dateAndTime = dateFormat.format(date);

            return dateAndTime;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String simpleDateFormatter(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(date);

        Log.d("utils", dateStr);

        return dateStr + "T00:00:00.000Z";
    }

    public static String getOnlyDateNotTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(date);

        Log.d("utils", dateStr);

        return dateStr;
    }

    public static boolean allowPermissionForHigherVersions(Context context, String permissionAccess) {
        return hasPermission(context, permissionAccess);
    }

    public static boolean hasPermission(Context context, String perm) {
        return (PackageManager.PERMISSION_GRANTED == context.checkSelfPermission(perm));
    }

}
