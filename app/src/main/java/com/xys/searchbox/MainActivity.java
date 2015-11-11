package com.xys.searchbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText searchbox = (EditText) findViewById(R.id.et_searchbox);
        final ImageView cancelImg = (ImageView) findViewById(R.id.iv_clean);

        searchbox.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() == 0) {
                    cancelImg.setVisibility(View.GONE);
                } else {
                    cancelImg.setVisibility(View.VISIBLE);
                    if (s.toString().trim().length() == 0) { // 全是空格
                        searchbox.setTextKeepState("");
                    }
                }
            }
        });

        cancelImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchbox.setTextKeepState("");
            }
        });
    }
}
