package com.example.movie.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.movie.R;
import com.example.movie.constant.AboutUsConfig;
import com.example.movie.prefs.DataStoreManager;
import com.example.movie.utils.GlobalFuntion;
import com.example.movie.utils.StringUtil;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        initUi();
        Handler handler = new Handler();
        handler.postDelayed(this::goToActivity, 2000);
    }

    private void initUi() {
        TextView tvAboutUsTitle = findViewById(R.id.tv_about_us_title);
        TextView tvAboutUsSlogan = findViewById(R.id.tv_about_us_slogan);
        tvAboutUsTitle.setText(AboutUsConfig.ABOUT_US_TITLE);
        tvAboutUsSlogan.setText(AboutUsConfig.ABOUT_US_SLOGAN);
    }

    private void goToActivity() {
        if (DataStoreManager.getUser() != null && !StringUtil.isEmpty(DataStoreManager.getUser().getEmail())) {
            GlobalFuntion.startActivity(this, MainActivity.class);
        } else {
            GlobalFuntion.startActivity(this, SignInActivity.class);
        }
        finish();
    }
}
