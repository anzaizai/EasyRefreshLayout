package zaizai.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ajguan.R;

import zaizai.com.View.OnlyLoadingActivity;
import zaizai.com.View.OnlyRefreshActivity;
import zaizai.com.View.RefreshLoadingActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        findViewById(R.id.loading).setOnClickListener(this);
        findViewById(R.id.refresh).setOnClickListener(this);
        findViewById(R.id.refresh_loding).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.refresh:
                startActivity(new Intent(MainActivity.this, OnlyRefreshActivity.class));
                break;
            case R.id.loading:
                startActivity(new Intent(MainActivity.this, OnlyLoadingActivity.class));
                break;
            case R.id.refresh_loding:
                startActivity(new Intent(MainActivity.this, RefreshLoadingActivity.class));
                break;
        }

    }
}
