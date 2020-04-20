package com.example.androidlistasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PersonajesAdapter.PersonajesAdapterListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //necesito el dato - hacemos una lista de objetos
        //necesito el xml q represente la celda (cada uno de los elementos)
        //necesito el recyclerview
        //necesito el adapter
        //juntar el recyclerView

        recyclerView = findViewById(R.id.mainActivityRecyclerView);


        List<Personaje> personajeList = obtenerPersonajes();

        //como parametro PersonajesAdapterListener se puede pasar esta misma clase porque implementa la interfaz
        //es decir, es "escuchadora" entonces sirve como parametro
        PersonajesAdapter personajesAdapter = new PersonajesAdapter(personajeList, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(personajesAdapter);




    }

    public List<Personaje> obtenerPersonajes(){
        List<Personaje> personajesList = new ArrayList<>();

        personajesList.add(new Personaje("homero", "Los simpsons", R.drawable.homero));
        personajesList.add(new Personaje("Cartman", "South Park", R.drawable.cartman));
        personajesList.add(new Personaje("homero", "Los simpsons", R.drawable.homero));
        personajesList.add(new Personaje("Cartman", "South Park", R.drawable.cartman));
        personajesList.add(new Personaje("homero", "Los simpsons", R.drawable.homero));
        personajesList.add(new Personaje("Cartman", "South Park", R.drawable.cartman));
        personajesList.add(new Personaje("homero", "Los simpsons", R.drawable.homero));
        personajesList.add(new Personaje("Cartman", "South Park", R.drawable.cartman));

        return personajesList;
    }

    //se sobreescribe este metodo que es quien dirá qué se hace cuando se hace click CUANDO LA CELDA ESTA EN EL MAIN
    //la responsabilidad de ir de una actividad a otra es de la propia actividad, no de la celda ni del adapter
    @Override
    public void hicieronClick(Personaje unPersonaje) {

        //creo intent
        Intent mainADetail = new Intent(this, DetailActivity.class);

        //creo bundle donde metere imagen y nombre del personaje parametro
        Bundle bundle = new Bundle();

        //le agrego los datos
        bundle.putString(DetailActivity.NOMBRE_PERSONAJE, unPersonaje.getNombre());
        bundle.putInt(DetailActivity.IMAGEN_PERSONAJE, unPersonaje.getImagen());

        //agrego el bundle al intent
        mainADetail.putExtras(bundle);

        //start
        startActivity(mainADetail);

    }
}
