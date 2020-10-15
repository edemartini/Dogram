package com.edemartini.dogram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edemartini.dogram.R;
import com.edemartini.dogram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.MascotaPerfilViewHolder> {

    ArrayList<Mascota> fotos;
    Activity activity;

    public MascotaPerfilAdaptador(ArrayList<Mascota> fotos, Activity activity) {
        this.fotos = fotos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaPerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_foto_mascota, parent, false);
        return new MascotaPerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaPerfilViewHolder mascotaViewHolder, int position) {
        final Mascota foto = fotos.get(position);
        mascotaViewHolder.imgFotoMascotaCV.setImageResource(foto.getFoto());
        //mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvRatingFotoMascotaCV.setText(Integer.toString(foto.getRate()));

    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }


    public static class MascotaPerfilViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imgFotoMascotaCV;
        private final TextView tvRatingFotoMascotaCV;


        public MascotaPerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoMascotaCV = (ImageView) itemView.findViewById(R.id.imgFotoMascotaCV);
            tvRatingFotoMascotaCV = (TextView) itemView.findViewById(R.id.tvRatingFotoMascotaCV);

        }
    }

}
