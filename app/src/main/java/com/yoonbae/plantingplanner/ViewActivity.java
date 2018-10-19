package com.yoonbae.plantingplanner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ViewActivity extends AppCompatActivity {

    private TextView mName;
    private TextView mKind;
    private TextView mIntro;
    private TextView mAdoptionDate;
    private TextView mAlarmDate;
    private ImageView imageView;
    private Switch mAlarm;
    private TextView mAlarmPeriod;
    private TextView mAlarmTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the ActionBar here to configure the way it behaves.
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setIcon(R.drawable.baseline_keyboard_arrow_left_black_24);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);    // 커스터마이징 하기 위해 필요
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);      // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        actionBar.setHomeAsUpIndicator(R.drawable.baseline_keyboard_arrow_left_black_24);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String kind = intent.getStringExtra("kind");
        String intro = intent.getStringExtra("intro");
        String imageUrl = intent.getStringExtra("imageUrl");
        String adoptionDate = intent.getStringExtra("adoptionDate");
        String alarm = intent.getStringExtra("alarm");
        String alarmDate = intent.getStringExtra("alarmDate");
        String period = intent.getStringExtra("period");
        String alarmTime = intent.getStringExtra("alarmTime");

        mName = findViewById(R.id.name);
        mName.setText(name);
        mKind = findViewById(R.id.kind);
        mKind.setText(kind);
        mIntro = findViewById(R.id.intro);
        mIntro.setText(intro);
        mAdoptionDate = findViewById(R.id.adoptionDate);
        mAdoptionDate.setText(adoptionDate);
        mAlarmDate = findViewById(R.id.alarmDate);
        mAlarmDate.setText(alarmDate);
        mAlarmPeriod = findViewById(R.id.alarmPeriod);
        mAlarmPeriod.setText(period);
        mAlarmTime = findViewById(R.id.alarmTime);
        mAlarmTime.setText(alarmTime);
        imageView = findViewById(R.id.imageView);
        Glide.with(imageView).load(imageUrl).into(imageView);

        mAlarm = findViewById(R.id.alarm);
        mAlarm.setClickable(false);
        if("Y".equals(alarm)) {
            mAlarm.setChecked(true);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Intent intent = new Intent(ViewActivity.this, ListActivity.class);
                startActivity(intent);
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
