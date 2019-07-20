package markmomo.com.moodtrackerfinal.Tools;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import markmomo.com.moodtrackerfinal.Controllers.HistoryActivity;

import static markmomo.com.moodtrackerfinal.Tools.Preferences.buildMoodsAndCommentsHistoryInPrefs;
import static markmomo.com.moodtrackerfinal.Tools.Preferences.getActivityStatusFromPrefs;
import static markmomo.com.moodtrackerfinal.Tools.Preferences.printDataFromPrefs;
import static markmomo.com.moodtrackerfinal.Tools.Preferences.resetCurrentDataInPrefs;
import static markmomo.com.moodtrackerfinal.Tools.Preferences.resizePrefs;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("onReceive: onReceive: onReceive: onReceive: onReceive: onReceive: onReceive: ");
        printDataFromPrefs(context);
        buildMoodsAndCommentsHistoryInPrefs(context);
        resetCurrentDataInPrefs (context);
        resizePrefs(context);

        intent = new Intent(context, HistoryActivity.class);
        if (getActivityStatusFromPrefs(context).equals("history")){
            context.startActivity(intent);
        }
        System.out.println("onReceive: onReceive: onReceive: onReceive: onReceive: onReceive: onReceive: ");
        printDataFromPrefs(context);
    }
}