package com.exam.faeezkmuhammed.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    Databasehelper sqldb=new Databasehelper(this);
    EditText firstname=(EditText)findViewById(R.id.fnme);
    EditText lname=(EditText)findViewById(R.id.lnme);
    EditText address=(EditText)findViewById(R.id.address);
    EditText mobile =(EditText)findViewById(R.id.phone);
    EditText email=(EditText)findViewById(R.id.email);
    EditText password=(EditText)findViewById(R.id.password);
    Button sign=(Button)findViewById(R.id.sgnup);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean inserted=sqldb.signup(email.getText().toString(),firstname.getText().toString(),lname.getText().toString(),address.getText().toString(),mobile.getText().toString(),password.getText().toString());
                if (inserted==true)
                    Toast.makeText(signup.this, "account created", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
