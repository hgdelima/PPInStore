package herbert.com.pp.ppinstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.paypal.android.sdk.payments.PayPalService;

//Implementing click listener to our class
public class StoreIdActivity extends AppCompatActivity implements View.OnClickListener {

    //The views
    private Button buttonCode;
    private EditText editTextCode;

    //Paypal intent request code to track onActivityResult method
    public static final int PAYPAL_REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_id);

        buttonCode = (Button) findViewById(R.id.buttonCode);
        editTextCode = (EditText) findViewById(R.id.editTextCode);

        buttonCode.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }


    @Override
    public void onClick(View v) {
        Intent goToPayPal = new Intent(this, PayPalActivity.class);
        startActivity(goToPayPal);
    }
}


