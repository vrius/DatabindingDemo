package android.discovery.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.discovery.mvvmdemo.databinding.MainUserBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private UserInfo mUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mUserInfo = new UserInfo("老王",18);
        binding.setUserInfo(mUserInfo);
        binding.setEvent(new Event());

        ininTimer();
    }

    private void ininTimer() {
        final Random random = new Random();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //Log.d(TAG,"=======改变内容=======");
                mUserInfo.setAge(random.nextInt(100));
            }
        },2000,2000);
    }


    public class Event{
        public void onEvent(View view) {
            Log.d(TAG,"Text="+((TextView)view).getText());
        }
    }
}
