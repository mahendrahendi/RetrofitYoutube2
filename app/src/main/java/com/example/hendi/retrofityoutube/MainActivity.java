package com.example.hendi.retrofityoutube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ListView listView;
    RecyclerView recyclerView;
    WeatherAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //listView = findViewById(R.id.listView);
        adapter = new WeatherAdapter();
        adapter.notifyDataSetChanged();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);



        retro();

}

public void retro() {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

            .build();

    Api api = retrofit.create(Api.class);
    Call<MovieResults> call = api.getHeroes();
    final ArrayList<Hero> weatherItemses = new ArrayList<>();
    call.enqueue(new Callback<MovieResults>() {
        @Override
        public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {


            Log.d(TAG, "HASIL : "+response.body().getResults());
            Log.d(TAG, "STATUS HASIL: "+response.toString());

            List<Hero> heroList = response.body().getResults();
 



            String[] heroes = new String[heroList.size()];

            for (int i = 0; i < heroList.size(); i++) {
               heroes[i] = heroList.get(i).getTitle();
                Hero hero  = new Hero();
                hero.setTitle(heroList.get(i).getTitle());
                hero.setVote_average(heroList.get(i).getVote_average());
                hero.setOverview(heroList.get(i).getOverview());
                weatherItemses.add(hero);

            }
            Log.d(TAG, "STATUS HASIL22: "+weatherItemses);

            adapter.setData(weatherItemses);
           // listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));
        }

        @Override
        public void onFailure(Call<MovieResults> call, Throwable t) {
            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });
}
}
