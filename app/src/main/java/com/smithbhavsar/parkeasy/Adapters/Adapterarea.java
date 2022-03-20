package com.smithbhavsar.parkeasy.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smithbhavsar.parkeasy.R;
import com.smithbhavsar.parkeasy.models.Areaname;

import java.util.List;

public class Adapterarea extends RecyclerView.Adapter<Adapterarea.Viewholder> {

    List<Areaname> area;
    Context context;

    public Adapterarea(List<Areaname> area, Context context) {
        this.area = area;
        this.context = context;
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_area, viewGroup, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int i) {
        final Areaname model = area.get(i);
        double lati = model.getLat();
        double longi = model.getLan();

        holder.areaname.setText(model.getTitle());
        holder.lat_val.setText(Double.toString(lati));
        holder.lang_val.setText(Double.toString(longi));


        if ((i + 1) % 2 == 0) {
            holder.constraintLayout.setBackgroundColor(Color.WHITE);
            holder.areaname.setTextColor(Color.BLACK);
            holder.lat_val.setTextColor(Color.BLACK);
            holder.lang_val.setTextColor(Color.BLACK);
            holder.lat.setTextColor(Color.BLACK);
            holder.lang.setTextColor(Color.BLACK);
        }
    }

    @Override
    public int getItemCount() {
        return area.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public TextView areaname, lat_val, lang_val, lat, lang;
        ConstraintLayout constraintLayout;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            constraintLayout = itemView.findViewById(R.id.color);
            areaname = itemView.findViewById(R.id.name);
            lat_val = itemView.findViewById(R.id.lat_val);
            lang_val = itemView.findViewById(R.id.lang_val);
            lat = itemView.findViewById(R.id.lat);
            lang = itemView.findViewById(R.id.lang);
        }
    }
}
