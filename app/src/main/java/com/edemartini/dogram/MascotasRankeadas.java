package com.edemartini.dogram;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edemartini.dogram.adapter.MascotaRankeadaAdaptador;
import com.edemartini.dogram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasRankeadas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaRankeadaAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_rankeadas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasRankeadas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        //inicializaListaMascotasRankeadas();
        inicializaListaMascotas();

        inicializaAdaptador();

    }

    public void inicializaAdaptador() {
        adaptador = new MascotaRankeadaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializaListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.travieso, "Travieso",20));
        mascotas.add(new Mascota(R.drawable.manchita, "Manchita",18));
        mascotas.add(new Mascota(R.drawable.simpatico, "Simpatico",12));
        mascotas.add(new Mascota(R.drawable.bonita, "Bonita", 10));
        mascotas.add(new Mascota(R.drawable.alegre, "Alegre",8));
    }


}

