package zaizai.com;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ajguan.R;
import com.ajguan.library.EasyRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SimpleAdapter simpleAdapter = new SimpleAdapter();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add("index:" + i);
        }
        recyclerView.setAdapter(simpleAdapter);
        simpleAdapter.setNewData(list);


        final EasyRefreshLayout refreshLayout = (EasyRefreshLayout) findViewById(R.id.esayRefreshLayout);
        if (refreshLayout != null) {
            // 刷新状态的回调
            refreshLayout.setRefreshListener(new EasyRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefreshing() {
                    // 延迟3秒后刷新成功
                    refreshLayout.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            refreshLayout.refreshComplete();
                        }
                    }, 3000);
                }
            });
        }

        refreshLayout.initLoadMore(new EasyRefreshLayout.LoadMoreEvent() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /*refreshLayout.loadMoreComplete(new EsayRefreshLayout.Event() {
                            @Override
                            public void complete() {
                            }
                        });*/
                        //refreshLayout.loadMoreFail();
                        refreshLayout.loadNothing();
                    }
                }, 2000);
            }
        });

    }
}
