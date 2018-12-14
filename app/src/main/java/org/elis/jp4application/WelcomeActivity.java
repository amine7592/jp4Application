package org.elis.jp4application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class WelcomeActivity extends AppCompatActivity {

    TextView welcomeTW, emailTv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_welcome);

        welcomeTW = findViewById(R.id.welcome_tv);
        emailTv = findViewById(R.id.email_tv);


        Intent intent = getIntent();

       /* if(intent != null){
            if(intent.getStringExtra(MainActivity.WELCOME) != null)
                emailTv.setText(intent.getStringExtra(MainActivity.WELCOME));

            else if(intent.getAction()!= null && intent.getAction() == Intent.ACTION_SENDTO)
                emailTv.setText(intent.getData());
        }

        emailTv.setText(mail);
        emailTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:" + mail);
                Intent sendMailIntent = new Intent(Intent.ACTION_SENDTO,uri);
                startActivity(sendMailIntent);
            }
        });*/


    }
}
