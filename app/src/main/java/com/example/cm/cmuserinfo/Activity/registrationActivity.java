package com.example.cm.cmuserinfo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cm.cmuserinfo.DataUtility.DBHandler;
import com.example.cm.cmuserinfo.DataUtility.UserInfo;
import com.example.cm.cmuserinfo.MainActivity;
import com.example.cm.cmuserinfo.R;

public class registrationActivity extends AppCompatActivity {
    EditText userName,mobileNo,emailID;
    Button btnCancel,btnRegister;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
       userName=findViewById(R.id.registerUserName);
       mobileNo=findViewById(R.id.registerMobileNo);
       emailID=findViewById(R.id.regiterEmail);

       btnRegister=findViewById(R.id.btnRegister);
       btnCancel=findViewById(R.id.btnCancel);

       btnRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              saveUser();

           }
       });

       btnCancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(registrationActivity.this,MainActivity.class);
               startActivity(intent);
           }
       });
    }

    private  void saveUser(){
        DBHandler db=new DBHandler(this);
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName(userName.getText().toString());
        userInfo.setMobileNo(mobileNo.getText().toString());
        userInfo.setEmailID(emailID.getText().toString());
        long i=db.insertUser(userInfo);
        if (i==0)
        {
            Intent intent=new Intent(registrationActivity.this,MainActivity.class);
            startActivity(intent);
        }else{

        }
    }
}
