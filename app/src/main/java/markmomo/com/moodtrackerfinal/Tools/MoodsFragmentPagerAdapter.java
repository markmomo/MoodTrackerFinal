package markmomo.com.moodtrackerfinal.Tools;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MoodsFragmentPagerAdapter extends FragmentPagerAdapter {

    private int[] mColors;
    public int mainActivityIconsColors;

    public MoodsFragmentPagerAdapter(FragmentManager mgr, int[] colors) {

        super(mgr);
        this.mColors = colors;
    }

    @Override
    public int getCount() {

        return(5);
    }

    @Override
    public Fragment getItem(int position) {

        mainActivityIconsColors = position;
        return(MoodsFragment.newInstance(position, this.mColors[position]));
    }
}