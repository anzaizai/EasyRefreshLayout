package zaizai.com.View;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.ajguan.R;
import com.ajguan.library.EasyRefreshLayout;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.animation.SlideInBottomAnimation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import zaizai.com.MyAnimation;
import zaizai.com.SimpleAdapter;

public class RefreshLoadingActivity extends AppCompatActivity {

    private EasyRefreshLayout easyRefreshLayout;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_loading);
        initView();
        initListener();
        initData();
    }

    private void initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("EasyRefreshLayout index :" + i);
        }
        adapter.getData().addAll(list);
        adapter.notifyDataSetChanged();

    }

    private void initListener() {
        easyRefreshLayout.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {

                final List<String> list = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    list.add("this is  new load data >>>>" + new Date().toLocaleString());
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        easyRefreshLayout.closeLoadView();
                        int postion = adapter.getData().size();
                        adapter.getData().addAll(list);
                        adapter.notifyDataSetChanged();
                        recyclerView.scrollToPosition(postion);
                    }
                }, 500);

            }

            @Override
            public void onRefreshing() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String> list = new ArrayList<>();
                        for (int i = 0; i < 20; i++) {
                            list.add("this is refresh data >>>" + new Date().toLocaleString());
                        }
                        adapter.setNewData(list);
                        easyRefreshLayout.refreshComplete();
                        Toast.makeText(getApplicationContext(), "refresh success", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);

            }
        });
    }

    private void initView() {
        easyRefreshLayout = (EasyRefreshLayout) findViewById(R.id.easylayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new SimpleAdapter();
        recyclerView.setAdapter(adapter);
    }
}
