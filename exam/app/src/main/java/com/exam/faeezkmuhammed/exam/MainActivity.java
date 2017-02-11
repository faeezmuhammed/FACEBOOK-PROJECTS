package com.exam.faeezkmuhammed.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Databasehelper sqldb=new Databasehelper(this);

    EditText name =(EditText)findViewById(R.id.name);
    EditText password=(EditText)findViewById(R.id.password);
    Button login=(Button)findViewById(R.id.login);

    final Intent intent1 =new Intent(MainActivity.this,signup.class);
    Button signup=(Button)findViewById(R.id.signup);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String eid=name.getText().toString();
                final String pswd=password.getText().toString();
                String password=sqldb.check(eid);
                if(pswd.equals(password)) {

                    final Intent intent = new Intent(MainActivity.this,loggedin.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(MainActivity.this, "login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
