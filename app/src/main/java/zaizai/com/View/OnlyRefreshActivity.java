package zaizai.com.View;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ajguan.R;
import com.ajguan.library.EasyRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import zaizai.com.SimpleAdapter;

public class OnlyRefreshActivity extends AppCompatActivity {

    private EasyRefreshLayout easyRefreshLayout;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_only_refresh);
        initView();
        initListener();
        initData();
    }

    private void initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("EasyRefreshLayout index :" + i);
        }
        adapter.setNewData(list);
    }

    private void initListener() {
        easyRefreshLayout.autoRefresh();
        easyRefreshLayout.setRefreshListener(new EasyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefreshing() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        easyRefreshLayout.refreshComplete();
                        Toast.makeText(getApplicationContext(), "refresh success", Toast.LENGTH_SHORT).show();                    }
                },3000);

            }
        });
        easyRefreshLayout.setEnableLoadMore(false);
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
