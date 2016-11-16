package herbert.com.pp.ppinstore;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by hlima on 11/15/2016.
 */

public class Store {
    private String StoreName;
    private String StoreAddress;
    private LatLng StoreLatLng;

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }


    public String getStoreAddress() {
        return StoreAddress;
    }

    public void setStoreAddress(String storeAddress) {
        StoreAddress = storeAddress;
    }

    public LatLng getStoreLatLng() {
        return StoreLatLng;
    }

    public void setStoreLatLng(LatLng storeLatLng) {
        StoreLatLng = storeLatLng;
    }
}
