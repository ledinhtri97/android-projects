package com.droidoxy.easymoneyrewards;

/**
 * Created by yash on 10/11/2016.
 */
import android.os.Bundle;
import android.content.Intent;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {

    private PrefManager prefManager;

    @Override
    public void init(Bundle savedInstanceState) {

        // Checking for first time launch - before calling setContentView()
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHome();
            finish();
        }

        // Just set a title, description,image and background. AppIntro will do the rest
        addSlide(AppIntroFragment.newInstance(getResources().getString(R.string.slide_1_title),getResources().getString(R.string.slide_1_desc), R.drawable.ic_discount, getResources().getColor(R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance(getResources().getString(R.string.slide_2_title),getResources().getString(R.string.slide_2_desc), R.drawable.ic_movie, getResources().getColor(R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance(getResources().getString(R.string.slide_3_title),getResources().getString(R.string.slide_3_desc), R.drawable.ic_food, getResources().getColor(R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance(getResources().getString(R.string.slide_4_title),getResources().getString(R.string.slide_4_desc), R.drawable.ic_travel,getResources().getColor(R.color.colorPrimary)));

        // Hide Skip/Done button
        showSkipButton(true);
        showDoneButton(true);

    }

    void launchHome(){
        prefManager.setFirstTimeLaunch(false);
        Intent skip = new Intent(this, AppActivity.class);
        startActivity(skip);
    }

    @Override
    public void onSkipPressed() {
        launchHome();
    }

    @Override
    public void onDonePressed() {
        launchHome();
    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onSlideChanged() {

    }
}

