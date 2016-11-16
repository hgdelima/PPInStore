package herbert.com.pp.ppinstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import herbert.com.pp.ppinstore.DAO.StoreDAO;

public class ConfirmationActivity extends AppCompatActivity implements View.OnClickListener {


    //The views
    private Button buttonHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        buttonHome = (Button) findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(this);

        //Getting Intent
        Intent intent = getIntent();


        try {
            JSONObject jsonDetails = new JSONObject(intent.getStringExtra("PaymentDetails"));

            //Displaying payment details
            showDetails(jsonDetails.getJSONObject("response"), intent.getStringExtra("PaymentAmount"));
        } catch (JSONException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void showDetails(JSONObject jsonDetails, String paymentAmount) throws JSONException {
        //Views
        TextView textViewId = (TextView) findViewById(R.id.paymentId);
        TextView textViewStatus= (TextView) findViewById(R.id.paymentStatus);
        TextView textViewAmount = (TextView) findViewById(R.id.paymentAmount);


        String state = jsonDetails.getString("state");
        //Showing the details from json object
        textViewId.setText(jsonDetails.getString("id"));
        textViewStatus.setText(state);
        textViewAmount.setText(paymentAmount+" USD");


        Payment pay = new Payment();
        pay.setAmount(new Integer(String.valueOf(paymentAmount)));
        pay.setStatus(state);

        StoreDAO dao = new StoreDAO(this);
        dao.Insert(pay);
        dao.close();

    }

    @Override
    public void onClick(View v) {
        Intent goToHome = new Intent(this, MainActivity.class);
        startActivity(goToHome);
    }
}