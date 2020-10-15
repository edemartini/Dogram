package com.edemartini.dogram;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.edemartini.dogram.adapter.PageAdapter;
import com.edemartini.dogram.fragment.MascotasFragment;
import com.edemartini.dogram.fragment.PerfilMascotaFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //static ArrayList<Mascota> mascotas;
    //private RecyclerView listaMascotas;
    //public MascotaAdaptador adaptador;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        //Validación
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mRanking:
                Intent i1 = new Intent(this, MascotasRankeadas.class);
                startActivity(i1);
                break;
            case R.id.mContacto:
                Intent i2 = new Intent(this, Contacto.class);
                startActivity(i2);
                break;
            case R.id.mAcercaDe:
                Intent i3 = new Intent(this, Desarrollador.class);
                startActivity(i3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new MascotasFragment());
        fragments.add(new PerfilMascotaFragment());

        return fragments;
    }

        public void setUpViewPager () {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.icon_cucha);
        tabLayout.getTabAt(1).setIcon((R.drawable.icon_perro));

    }

}