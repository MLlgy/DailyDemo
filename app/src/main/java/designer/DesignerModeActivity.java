package designer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.androidwebviewdemo.mddemo.R;

import designer.WatchMode.WatchModeActivity;

public class DesignerModeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_mode);
        findViewById(R.id.tv_watcher_mode).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_watcher_mode:
                startActivity(new Intent(this, WatchModeActivity.class));
                break;
        }
    }
}
