package com.basiclca.app.sharedpreferencesapplca;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnSaveData;
    private Button btnReadData;
    private Button btnRemoveBykey;
    private Button btnRemoveAll;
    public final String SHARED_PREFENRECES_NAME = "binhlca";
    public final String NAME = "name";
    public final String PHONE = "phone";
    public final String WEIGHT = "weight";
    public final String SINGLE = "single";

    private final String TAG = getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSaveData = (Button) findViewById(R.id.btn_save_data);
        btnReadData = (Button) findViewById(R.id.btn_read_data);
        btnRemoveBykey= (Button) findViewById(R.id.btn_remove_Bykey);
        btnRemoveAll= (Button) findViewById(R.id.btn_remove_all);
        btnRemoveBykey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeBykey(WEIGHT);
                readData();
            }
        });
        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeAll();
            }
        });
        btnReadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readData();
            }
        });
        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFENRECES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(NAME, "Le Cong An");
        editor.putInt(PHONE, 933429223);
        editor.putLong(WEIGHT, 60);
        editor.putBoolean(SINGLE, false);
        editor.apply();
        Toast.makeText(MainActivity.this, "saved Sucessfully", Toast.LENGTH_SHORT).show();
//                editor.commit();
    }
    public void readData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFENRECES_NAME, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(NAME, "Dao");
        int phone = sharedPreferences.getInt(PHONE, 0);
        boolean issingle= sharedPreferences.getBoolean(SINGLE, true);
        long weight = sharedPreferences.getLong(WEIGHT, 10);

        Log.d(TAG, "anroi2d: "
                + name +"\n"
                + phone + "\n"
                +issingle +"\n"
                + weight);
    }
    public void removeBykey(String key){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFENRECES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove(key);
        editor.apply();
    }
    public void removeAll(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFENRECES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();
    }

}
