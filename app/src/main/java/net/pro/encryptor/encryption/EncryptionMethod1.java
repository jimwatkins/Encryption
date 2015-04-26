package net.pro.encryptor.encryption;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class EncryptionMethod1 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption_method1);
    }


    public void textToBinary (View v) {
        TextView input = (TextView) this.findViewById(R.id.txtInput);
        String s = input.getText().toString();
        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            binary.append(' ');
        }
        System.out.println("'" + s + "' to binary: " + binary);

        TextView BinaryText = (TextView) this.findViewById(R.id.txtBinary);
        BinaryText.setText(binary);

    }


    public void algorithm1(View view) {
        // String binaryIn = "01100001"; //a
        String binaryIn = "";

        TextView BinaryText = (TextView) this.findViewById(R.id.txtBinary);
        binaryIn = BinaryText.getText().toString();

        StringBuilder binaryOut = new StringBuilder();
        for (char bit : binaryIn.toCharArray()) {
            System.out.println(bit);
            if (bit == ' ') {
                binaryOut.append(' ');
                continue;
            }
            String d = String.valueOf(bit);
            int b = (Integer.valueOf(d) + 15)*2;


            System.out.println("After Modification" + b);

            binaryOut.append(b);

        }

        TextView encryptedBinary = (TextView) this.findViewById(R.id.txtEncryptedBinary);
        encryptedBinary.setText(binaryOut.toString());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_encryption_method1, menu);
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
