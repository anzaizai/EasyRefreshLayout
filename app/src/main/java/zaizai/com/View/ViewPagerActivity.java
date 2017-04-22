package zaizai.com.View;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ajguan.R;
import com.ajguan.library.EasyRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import zaizai.com.EasyFragment;
import zaizai.com.SimpleAdapter;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> pagerList;
    private LayoutInflater inflater;
    private VPAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        inflater = getLayoutInflater();
        initView();
        initData();
    }

    private void initData() {
        pagerList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            pagerList.add(new EasyFragment());
        }
        vpAdapter.notifyDataSetChanged();


    }


    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.m_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.m_tbl);
        vpAdapter = new VPAdapter(getSupportFragmentManager());
        viewPager.setAdapter(vpAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    public class VPAdapter extends FragmentPagerAdapter {


        public VPAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "pager:" + position + 1;
        }

        @Override
        public Fragment getItem(int position) {
            return pagerList.get(position);
        }

        @Override
        public int getCount() {
            return pagerList == null ? 0 : pagerList.size();
        }

    }
}
