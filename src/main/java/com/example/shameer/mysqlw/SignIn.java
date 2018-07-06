package com.example.shameer.mysqlw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ResourceBundle;

public class SignIn extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText edtPhone,edtPassword,edtname;
    private Button btnSignin;
    //   private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPassword;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtPassword = (MaterialEditText)findViewById(R.id.edtpassword);
        //edtPhone = (MaterialEditText)findViewById(R.id.edtphone);
        edtname =(MaterialEditText)findViewById(R.id.edtname);
        btnSignin=(Button)findViewById(R.id.Btn_signin);

        //Firebase work





       btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtname.getText().toString();
                String password = edtPassword.getText().toString();
                String type = "login";
                BackgroundWorker backgroundWorker = new BackgroundWorker(SignIn.this);
                backgroundWorker.execute(type, username, password);

                //  Toast.makeText(SignIn.this,backgroundWorker.chk, Toast.LENGTH_LONG).show();


            }
        });
        // toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //btnSignUp = (Button) findViewById(R.id.btn_signup);

        //inputName.addTextChangedListener(new MyTextWatcher(inputName));
        //inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        //inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));


    }
}
