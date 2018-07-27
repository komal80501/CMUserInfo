package com.example.cm.cmuserinfo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cm.cmuserinfo.R;
import com.example.cm.cmuserinfo.Services.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    Context ctx;
    List<Country> lstCountry;
    LayoutInflater inflater;

    public CountryAdapter(Context ctx, List<Country> lstCountry) {
        this.ctx = ctx;
        this.lstCountry = lstCountry;
        inflater= LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.country_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.countryName.setText(lstCountry.get(position).getCountryName());
        holder.alfa2code.setText(lstCountry.get(position).getAlpha2Code());
        holder.alfa3code.setText(lstCountry.get(position).getAlpha3Code());
    }

    @Override
    public int getItemCount() {
        return lstCountry.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView countryName,alfa2code,alfa3code;
        public ViewHolder(View itemView) {
            super(itemView);
            countryName=itemView.findViewById(R.id.countryName);
            alfa2code=itemView.findViewById(R.id.alfa2code);
            alfa3code=itemView.findViewById(R.id.alfa3code);

        }
    }
}
