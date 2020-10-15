package com.edemartini.dogram.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edemartini.dogram.R;
import com.edemartini.dogram.adapter.MascotaPerfilAdaptador;
import com.edemartini.dogram.pojo.Mascota;

import java.util.ArrayList;

public class PerfilMascotaFragment extends Fragment {

    private ArrayList<Mascota> fotos;
    private RecyclerView rvFotosMascota;
    public MascotaPerfilAdaptador adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        rvFotosMascota = (RecyclerView) v.findViewById(R.id.rvFotosMascota);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvFotosMascota.setLayoutManager(glm);

        inicializaDatos();
        inicializaAdaptador();

        return v;
    }


    public void inicializaAdaptador(){
        adaptador = new MascotaPerfilAdaptador(fotos, getActivity());
        rvFotosMascota.setAdapter(adaptador);
    }

    public void inicializaDatos() {
        fotos = new ArrayList<Mascota>();
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 15));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 14));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 13));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 12));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 11));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 10));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 9));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 8));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 7));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 6));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 5));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 4));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 3));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 2));
        fotos.add(new Mascota(R.drawable.simpatico, "Simpatico", 1));
    }










}