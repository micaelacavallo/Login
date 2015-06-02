package com.example.micaelacavallo.login;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText mUser;
    EditText mPass;
    Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareEditTexts();
        prepareButtonLogin();

    }

    private void prepareButtonLogin() {
        mLogin = (Button)findViewById(R.id.button_login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUser.getText().toString().equals("myTest+fake@account.com") && mPass.getText().toString().equals("password"))
                {
                    Intent intent = new Intent(MainActivity.this, SuccessActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void prepareEditTexts() {
        mUser = (EditText)findViewById(R.id.username);
        mPass = (EditText)findViewById(R.id.password);
        mUser.addTextChangedListener(mTextEditorWatcher);
        mPass.addTextChangedListener(mTextEditorWatcher);
    }

    private final TextWatcher mTextEditorWatcher = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
        }

        public void afterTextChanged(Editable s)
        {
            if (!mPass.getText().toString().isEmpty() && !mUser.getText().toString().isEmpty())
            {
                if (isEmailValid(mUser.getText().toString()))
                {
                    mLogin.setEnabled(true);
                }
                else
                {
                    mLogin.setEnabled(false);
                }
            }
            else
            {
                mLogin.setEnabled(false);
            }

        }
    };

    private boolean isEmailValid(CharSequence email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
