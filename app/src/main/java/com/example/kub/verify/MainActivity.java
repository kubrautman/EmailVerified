package com.example.kub.verify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

public class MainActivity extends AppCompatActivity {
private static final int PER_LOGIN=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Start Login
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
                .setAllowNewEmailAccounts(true).build(),PER_LOGIN);




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==PER_LOGIN)
        {
            handleSignInResponce(resultCode,data);
            return;
        }
    }

    private void handleSignInResponce(int resultCode, Intent data) {
        if (resultCode == RESULT_OK
                ) {

            Intent intent=new Intent(MainActivity.this,Status.class);
            startActivity(intent);
            finish();
            return;
        }
        else
        {

            Toast.makeText(this,"Giriş başarısız",Toast.LENGTH_SHORT).show();
        }

    }
}
