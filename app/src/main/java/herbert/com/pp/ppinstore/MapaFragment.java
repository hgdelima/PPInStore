package herbert.com.pp.ppinstore;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hlima on 11/15/2016.
 */

public class MapaFragment extends SupportMapFragment implements OnMapReadyCallback {



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng initialPosition = getAddressGPSPositions("Rua Capao Alto, 86, Vila Curuca, Sao Paulo");

        if (initialPosition != null) {
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(initialPosition, 17);
            googleMap.moveCamera(update);
        }

        for (Store store : listPayPalStore()) {

            store.setStoreLatLng(getAddressGPSPositions(store.getStoreAddress()));

            LatLng currentStorePosition = store.getStoreLatLng();

           if (currentStorePosition != null){
               MarkerOptions marker = new MarkerOptions();
               marker.position(currentStorePosition);
               marker.title(store.getStoreName());
               marker.snippet(store.getStoreAddress());
               googleMap.addMarker(marker);
           }
        }
    }

    private List<Store> listPayPalStore()
    {

        List<Store> stores = new ArrayList<Store>();

        Store store = new Store();
        store.setStoreName("Good News Restaurant");
        store.setStoreAddress("Rua Capao Alto, 86, Vila Curuca, Sao Paulo");
        stores.add(store);

        store = new Store();
        store.setStoreName("GPA Foods");
        store.setStoreAddress("Rua Palanque, Vila Curuca, Sao Paulo");
        stores.add(store);

        store = new Store();
        store.setStoreName("Buenos Aires");
        store.setStoreAddress("Rua Chacuru, Vila Curuca, Sao Paulo");
        stores.add(store);

        store = new Store();
        store.setStoreName("Marechal Lanches");
        store.setStoreAddress("Av Marechal Tito, 1055, Sao Paulo");
        stores.add(store);

        store = new Store();
        store.setStoreName("Brazilian's Bistro Fresh Food");
        store.setStoreAddress("Avenida Paulista, 1048, Bela Vista, Sao Paulo");
        stores.add(store);

        store = new Store();
        store.setStoreName("BBQ");
        store.setStoreAddress("Avenida Paulista, 3048, Bela Vista, Sao Paulo");
        stores.add(store);

        return stores;

    }

    private LatLng getAddressGPSPositions(String address)
    {
        Geocoder geocoder = new Geocoder(getContext());
        try {
            List<Address> results = geocoder.getFromLocationName(address, 1);
            if (!results.isEmpty()) {
                LatLng position = new LatLng(results.get(0).getLatitude(), results.get(0).getLongitude());
                return position;
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
