package com.example.androidlistasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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

        PersonajesAdapter personajesAdapter = new PersonajesAdapter(personajeList);

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
}
