package com.example.cm.cmuserinfo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cm.cmuserinfo.DataUtility.DBHandler;
import com.example.cm.cmuserinfo.DataUtility.UserInfo;
import com.example.cm.cmuserinfo.MainActivity;
import com.example.cm.cmuserinfo.R;

public class profileAcitivity extends AppCompatActivity {
    TextView userName,mobileNo,emailID;
    Button btnShowList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_acitivity);

        userName=findViewById(R.id.profileName);
        mobileNo=findViewById(R.id.profileMobileNo);
        emailID=findViewById(R.id.profileEmail);
        btnShowList=findViewById(R.id.btnCountryList);

        int userID=getIntent().getIntExtra("userID",0);
        if (userID!=0)
        {
            DBHandler db=new DBHandler(this);
            UserInfo userInfo=new UserInfo();
            userInfo=db.getUserInfo(userID);
            userName.setText(userInfo.getUserName());
            mobileNo.setText(userInfo.getMobileNo());
            emailID.setText(userInfo.getEmailID());
        }

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(profileAcitivity.this,countrylistActivity.class);
                startActivity(intent);
            }
        });
    }
}
