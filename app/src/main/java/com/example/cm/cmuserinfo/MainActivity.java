package com.example.cm.cmuserinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cm.cmuserinfo.Activity.profileAcitivity;
import com.example.cm.cmuserinfo.Activity.registrationActivity;
import com.example.cm.cmuserinfo.DataUtility.DBHandler;
import com.example.cm.cmuserinfo.DataUtility.UserInfo;

public class MainActivity extends AppCompatActivity {
    EditText userName,mobileNo;
    Button btnLogin,btnRegister;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName=findViewById(R.id.loginUserName);
        mobileNo=findViewById(R.id.loginMobileNo);

        btnLogin=findViewById(R.id.loginBtnLogin);
        btnRegister=findViewById(R.id.loginRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,registrationActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckUser();
            }
        });
    }

    private void CheckUser()
    {
        UserInfo userInfo=new UserInfo();
        DBHandler db=new DBHandler(this);
        userInfo=db.getIsUserExist(userName.getText().toString(),mobileNo.getText().toString());
        if (userInfo.getID()!=0)
        {
            Intent intent=new Intent(MainActivity.this,profileAcitivity.class);
            intent.putExtra("userID",userInfo.getID());
            startActivity(intent);
        }else {

        }
    }
}
