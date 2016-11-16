package herbert.com.pp.ppinstore.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import herbert.com.pp.ppinstore.Payment;

/**
 * Created by hlima on 11/15/2016.
 */

public class StoreDAO extends SQLiteOpenHelper {


    public StoreDAO(Context context) {
        super(context, "Strore", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String sql = "CREATE TABLE PAYMENTS (id INTEGER PRIMARY KEY, amount INTEGER NOT NULL, paymentstatus TEXT, Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP, trx TEXT);";
       db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS PAYMENTS";
        db.execSQL(sql);
        this.onCreate(db);
    }

    public void Insert(Payment pay) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("amount", pay.getAmount());
        values.put("paymentstatus", pay.getStatus());
        values.put("trx", pay.getTrx());

        db.insert("PAYMENTS", null, values);
    }

    public List<Payment> ListPayMents() {
        String sql = "SELECT * FROM PAYMENTS";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Payment> payments = new ArrayList<Payment>();

        while (c.moveToNext()) {

            Payment pay = new Payment();
            pay.setId(c.getInt(c.getColumnIndex("id")));
            pay.setAmount(c.getInt(c.getColumnIndex("amount")));
            pay.setStatus(c.getString(c.getColumnIndex("paymentstatus")));
            pay.setTimestamp(c.getString(c.getColumnIndex("Timestamp")));
            pay.setTrx(c.getString(c.getColumnIndex("trx")));
            payments.add(pay);
        }

        c.close();

        return payments;
    }
}
