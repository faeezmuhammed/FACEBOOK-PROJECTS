package com.example.faeezkmuhammed.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         final Sqlitehelp sqldb =new Sqlitehelp(this);

        final EditText editid =(EditText)findViewById(R.id.editText);
        final EditText editpswd =(EditText)findViewById(R.id.editText2);
        final Button btnlogin=(Button)findViewById(R.id.button);
        Button btncrearte=(Button)findViewById(R.id.button2);
        final String uid=editid.getText().toString();
        final String upswd=editpswd.getText().toString();
        final TextView tv=(TextView)findViewById(R.id.textView2);

        btncrearte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // final String uid=editid.getText().toString();
                //final String upswd=editpswd.getText().toString();
                boolean insert=sqldb.createaccount(editid.getText().toString(),editpswd.getText().toString());
                if (insert=true){
                    Toast.makeText(MainActivity.this, "data inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               final String uid=editid.getText().toString();
                final String upswd=editpswd.getText().toString();
                String password=sqldb.check(uid);
                if(upswd.equals(password)){
                    final Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                    Toast.makeText(MainActivity.this, "login successful", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "login faild", Toast.LENGTH_SHORT).show();
                    tv.setVisibility(view.VISIBLE);
                }


            }


        });
    }
}
