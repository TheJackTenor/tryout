package com.example.dhihan.tryout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dhihan.tryout.R;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {
    private static String url = "kontak.json";

    private static final String tag_nama = "nama";
    private static final String tag_organisasi = "organisasi";
    private static final String tag_telepon = "telepon";
    private static final String tag_alamat = "alamat";

    JSONArray kontak = null;

    ArrayList<HashMap<String, String>> contactList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = new ArrayList<HashMap<String, String>>();

        ListView lv = getListView();

        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Mengambil data dari ListView yang dipilih
                String nama = ((TextView) view.findViewById(R.id.nama)).getText().toString();
                String organisasi = ((TextView) view.findViewById(R.id.organisasi)).getText().toString();
                String telepon = ((TextView) view.findViewById(R.id.telepon)).getText().toString();
                String alamat = ((TextView) view.findViewById(R.id.alamat)).getText().toString();

                // Memulai memanggil ke class KontakActivity dengan beberapa data
                Intent in = new Intent(getApplicationContext(),KontakActivity.class);
                in.putExtra(tag_nama, nama);
                in.putExtra(tag_organisasi, organisasi);
                in.putExtra(tag_telepon, telepon);
                in.putExtra(tag_alamat, alamat);
                startActivity(in);

            }
        });


    }

}

