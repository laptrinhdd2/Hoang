package com.nt.xuanhoang.exe1_hoangtran;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeUtils.setTheme(this);
        setContentView(R.layout.activity_main);

        Button btnBlue = (Button) findViewById(R.id.btnBlue);
        Button btnPink = (Button) findViewById(R.id.btnPink);

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemeUtils.changeTheme(MainActivity.this, 0);
            }
        });

        btnPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemeUtils.changeTheme(MainActivity.this, 1);
            }
        });

        TextView txtClickLogin = (TextView) findViewById(R.id.txtClickLogin);
        txtClickLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialog();
            }
        });

        final EditText edtName = (EditText) findViewById(R.id.edtName);
        final EditText edtPass = (EditText) findViewById(R.id.edtPass);
        final Button btnLLL = (Button) findViewById(R.id.btnLLL);


        btnLLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = edtName.getText().toString().trim();
                String strPassword = edtPass.getText().toString().trim();
                if(strUsername.equals("hoang") && strPassword.equals("1234")){
                    Toast.makeText(MainActivity.this, "Login successfully!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //ham login dialog
    private void loginDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCanceledOnTouchOutside(false);

        final EditText edtUsername = (EditText) dialog.findViewById(R.id.edtUsername);
        final EditText edtPassword = (EditText) dialog.findViewById(R.id.edtPassword);
        final Button btnLogin = (Button) dialog.findViewById(R.id.btnLogin);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = edtUsername.getText().toString().trim();
                String strPassword = edtPassword.getText().toString().trim();
                if(strUsername.equals("xuanhoang") && strPassword.equals("1234")){
                    Toast.makeText(MainActivity.this, "Login successfully!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
