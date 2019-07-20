package markmomo.com.moodtrackerfinal.Controllers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Calendar;

import markmomo.com.moodtrackerfinal.R;
import markmomo.com.moodtrackerfinal.Tools.AlarmBroadcastReceiver;
import markmomo.com.moodtrackerfinal.Tools.MoodsFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private ImageButton mCommentIcon,mHistoryIcon;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCommentIcon = findViewById(R.id.act_main_comment_icon);
        mHistoryIcon = findViewById(R.id.act_main_history_icon);

        this.configureViewPager();
        this.startAlarm();
    }

    public void historyIconIsClicked (View view){

        Intent intent = new Intent(MainActivity.this,HistoryActivity.class);
        startActivity(intent);
    }

    private void configureViewPager(){

        mViewPager = findViewById(R.id.act_main_view_pager);
        MoodsFragmentPagerAdapter moodsAdapter = new MoodsFragmentPagerAdapter(getSupportFragmentManager(), getResources().getIntArray(R.array.viewPagerColors));
        mViewPager.setAdapter(moodsAdapter);
        mCommentIcon.setBackgroundColor(moodsAdapter.mainActivityIconsColors);
        mHistoryIcon.setBackgroundColor(moodsAdapter.mainActivityIconsColors);
    }

    private void startAlarm (){

        AlarmManager alarmMgr;
        PendingIntent alarmIntent;
        alarmMgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this, AlarmBroadcastReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
        Calendar cal = Calendar.getInstance();

        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, 8);
        cal.set(Calendar.MINUTE, 30);

//        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
//                1000 * 60 * 20, alarmIntent);

        alarmMgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_FIFTEEN_MINUTES/15,
                AlarmManager.INTERVAL_FIFTEEN_MINUTES/15, alarmIntent);
    }
}
