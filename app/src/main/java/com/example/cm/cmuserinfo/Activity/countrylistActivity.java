package com.example.cm.cmuserinfo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.cm.cmuserinfo.Adapter.CountryAdapter;
import com.example.cm.cmuserinfo.R;
import com.example.cm.cmuserinfo.Services.Country;
import com.example.cm.cmuserinfo.Services.CountryDataService;
import com.example.cm.cmuserinfo.Services.CountryList;
import com.example.cm.cmuserinfo.Services.RestResponse;
import com.example.cm.cmuserinfo.Services.RetrofitInstance;
import com.example.cm.cmuserinfo.Services.Sample;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class countrylistActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrylist);



        CallApi();
    }
    private void CallApi()
    {
        CountryDataService service= RetrofitInstance.getRetrofitInstance().create(CountryDataService.class);

        Call<Sample> call=service.getCountryData();

        call.enqueue(new Callback<Sample>() {
            @Override
            public void onResponse(Call<Sample> call, Response<Sample> response) {
                showCountryFromApi(response.body());
            }

            @Override
            public void onFailure(Call<Sample> call, Throwable t) {
                Log.wtf("URL Called", call.request().url() + "");
                Log.wtf("Error Message", t.getMessage() + "");

                Toast.makeText(countrylistActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    private void showCountryFromApi(Sample sample)
    {
        if (sample.getRestResponse().getResult()!=null){
            recyclerView=findViewById(R.id.rvCoutry);
            adapter=new CountryAdapter(this,sample.getRestResponse().getResult());
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
             recyclerView.setAdapter(adapter);
        }
    }
}
