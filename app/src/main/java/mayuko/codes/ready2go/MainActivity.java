package mayuko.codes.ready2go;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mayuko.codes.ready2go.Adapter.Adapter;
import mayuko.codes.ready2go.Constants.Constants;
import mayuko.codes.ready2go.Data.AppData;
import mayuko.codes.ready2go.Database.RoomDB;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;
    RoomDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.recyclerview);

        addAddTitles();
        addAllImages();
        persistAppData();
        database = RoomDB.getInstance(this);
        System.out.println("--------------------------> " +database.mainDao().getAllSelected(false).get(0).getItemname());

        adapter = new Adapter(this, titles,images, MainActivity.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private static final int TIME_INTERVAL = 2000;

    private long mBackPressed;

    @Override
    public void onBackPressed() {
        if(mBackPressed+TIME_INTERVAL>System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        }else{
            Toast.makeText(this, "Tap back button in order to exit", Toast.LENGTH_SHORT).show();
        }
        mBackPressed = System.currentTimeMillis();
    }

    private void persistAppData(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();

        database = RoomDB.getInstance(this);
        AppData appData = new AppData(database);
        int last = prefs.getInt(AppData.LAST_VERSION, 0);
        if (!prefs.getBoolean(Constants.FIRST_TIME_CAMEL_CASE, false)){
            appData.persistAllData();
            editor.putBoolean(Constants.FIRST_TIME_CAMEL_CASE, true);
            editor.commit();
        } else if (last < AppData.NEW_VERSION) {
            database.mainDao().deleteAllSystemItems(Constants.SYSTEM_SMALL);
            appData.persistAllData();

        }
    }

    private void addAddTitles(){
        titles = new ArrayList<>();
        titles.add(Constants.BASIC_NEEDS_CAMEL_CASE);
        titles.add(Constants.CLOTHING_CAMEL_CASE);
        titles.add(Constants.PERSONAL_CARE_CAMEL_CASE);
        titles.add(Constants.BABY_NEEDS_CAMEL_CASE);
        titles.add(Constants.HEALTH_CAMEL_CASE);
        titles.add(Constants.TECHNOLOGY_CAMEL_CASE);
        titles.add(Constants.FOOD_CAMEL_CASE);
        titles.add(Constants.BEACH_SUPPLIES_CAMEL_CASE);
        titles.add(Constants.CAR_SUPPLIES_CAMEL_CASE);
        titles.add(Constants.NEEDS_CAMEL_CASE);
        titles.add(Constants.MY_LIST_CAMEL_CASE);
        titles.add(Constants.MY_SELECTIONS_CAMEL_CASE);
    }
    private void addAllImages(){
        images = new ArrayList<>();
        images.add(R.drawable.technicalsupport);
        images.add(R.drawable.clothes);
        images.add(R.drawable.personalcare);
        images.add(R.drawable.babyproducts);
        images.add(R.drawable.healthcare);
        images.add(R.drawable.technology);
        images.add(R.drawable.food);
        images.add(R.drawable.beach);
        images.add(R.drawable.car);
        images.add(R.drawable.needs);
        images.add(R.drawable.mylist);
        images.add(R.drawable.choices);

    }
}