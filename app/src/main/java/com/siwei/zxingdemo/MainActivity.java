package com.siwei.zxingdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText= (EditText) findViewById(R.id.scannerResult);
    }
    public void startScan(View view){
        startActivityForResult(ScanActivity.createIntent(this),0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0){
            if (data != null) {
                String result = data.getStringExtra(ScanActivity.RESULT_QRCODE_STRING);
                mEditText.setText(result);
            }
        }
    }
}
