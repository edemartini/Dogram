package com.edemartini.dogram.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edemartini.dogram.R;
import com.edemartini.dogram.adapter.MascotaAdaptador;
import com.edemartini.dogram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    public MascotaAdaptador adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        inicializaDatos();
        inicializaAdaptador();

        return v;
    }

    public void inicializaAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializaDatos() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.alegre, "Alegre"));
        mascotas.add(new Mascota(R.drawable.bonita, "Bonita"));
        mascotas.add(new Mascota(R.drawable.cazador, "Cazador"));
        mascotas.add(new Mascota(R.drawable.guardian, "Guardián"));
        mascotas.add(new Mascota(R.drawable.jugueton, "Juguetón"));
        mascotas.add(new Mascota(R.drawable.manchita, "Manchita"));
        mascotas.add(new Mascota(R.drawable.simpatico, "Simpatico"));
        mascotas.add(new Mascota(R.drawable.tranquila, "Tranquila"));
        mascotas.add(new Mascota(R.drawable.travieso, "Travieso"));
        mascotas.add(new Mascota(R.drawable.triston, "Tristón"));
    }

}