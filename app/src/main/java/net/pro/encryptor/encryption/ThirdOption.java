package net.pro.encryptor.encryption;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.security.GeneralSecurityException;


public class ThirdOption extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_option);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_third_option, menu);
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
    public void EncryptwAES(View v) {
        String key = "";
        String message = "";

        TextView input = (TextView) this.findViewById(R.id.txtOption3Input);
        message = input.getText().toString();

        TextView keyInput = (TextView) this.findViewById(R.id.txtCustomKeyInput);
        key = keyInput.getText().toString();


        String encryptedMsg = "";

        try {
            encryptedMsg = AESEncryptor.encrypt(key, message);
        } catch (GeneralSecurityException e) {
            //handle error
        }

        TextView BinaryText = (TextView) this.findViewById(R.id.txtCustomEncryptedOutput);
        BinaryText.setText(encryptedMsg);

    }

}
