package com.edemartini.dogram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edemartini.dogram.R;
import com.edemartini.dogram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaRankeadaAdaptador extends RecyclerView.Adapter<MascotaRankeadaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaRankeadaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvRatingCV.setText(Integer.toString(mascota.getRate()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imgFoto;
        private final TextView tvNombreCV;
        private final TextView tvRatingCV;
        private ImageButton btnLikeCV;
        private ImageButton btnRatesCV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFotoMascotaCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRatingCV = (TextView) itemView.findViewById(R.id.tvRatingFotoMascotaCV);
            btnLikeCV = (ImageButton) itemView.findViewById(R.id.btnLikeCV);
            btnRatesCV = (ImageButton) itemView.findViewById(R.id.imgIconoHuesoCV);
        }
    }


}
