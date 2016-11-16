package herbert.com.pp.ppinstore;

/**
 * Created by hlima on 11/15/2016.
 */

public class Payment {

    private Integer Id;
    private String timestamp;
    private Integer Amount;
    private String Status;
    private String Trx;

    public Integer getId() {
        return Id;
    }


    public void setId(Integer id) {
        Id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return this.getTimestamp() + " - " + this.getAmount() + " U$ (" + this.getStatus() + ")";
    }

    public String getTrx() {
        return Trx;
    }

    public void setTrx(String trx) {
        Trx = trx;
    }
}
