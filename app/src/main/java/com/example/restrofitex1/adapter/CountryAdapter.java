package com.example.restrofitex1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restrofitex1.MainActivity2;
import com.example.restrofitex1.R;
import com.example.restrofitex1.model.CountryModel;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private ArrayList<CountryModel> countriesArrayList;
    Context context;

    RecyclerView recyclerView;
    private CountryAdapter countryAdapter;

    public CountryAdapter(Context context,ArrayList<CountryModel> countriesArrayList) {
        this.context=context;
        this.countriesArrayList = countriesArrayList;
    }

    @NonNull
    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_item,parent,false);
        return new CountryViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.CountryViewHolder holder, int position) {

        holder.textView.setText(countriesArrayList.get(position).getName());
        holder.textView1.setText(countriesArrayList.get(position).getCode());
        holder.textView2.setText(countriesArrayList.get(position).getRegion());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Country" +position,Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(context , MainActivity2.class);
                intent.putExtra("name",countriesArrayList.get(position).getName());
                intent.putExtra("code",countriesArrayList.get(position).getCode());
                intent.putExtra("region",countriesArrayList.get(position).getRegion());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return countriesArrayList.size();
    }
    public class CountryViewHolder extends  RecyclerView.ViewHolder{

        TextView textView,textView1,textView2;
        CardView cardView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.countryName);
            textView1=itemView.findViewById(R.id.code);
            textView2=itemView.findViewById(R.id.region);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
