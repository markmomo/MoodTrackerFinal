package markmomo.com.moodtrackerfinal.Controllers;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import markmomo.com.moodtrackerfinal.R;
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
}
