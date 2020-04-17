package com.example.androidlistasrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * necesito tanto el layout como la lista de datos
 */


public class PersonajesAdapter extends RecyclerView.Adapter {

    private List<Personaje> listaDePersonajes;

    public PersonajesAdapter(List<Personaje> listaDePersonajes) {
        this.listaDePersonajes = listaDePersonajes;
    }

    /**
     * crea la celda del layout
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //pasa el xml a algo de tipo View, o sea necesito INFLARLO (igual al fragment)
        //este metodo no retorna un View, sino ViewHolder: "mamushka",
        // representacion java de la celda (atributos: precio, titulo, imagen, background, etc)

        //necesito el inflador
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        //con el inflador, inflo el xml a View
        View viewCelda = layoutInflater.inflate(R.layout.celda_personaje, parent, false);

        //con esta view la paso a viewHolder
        PersonajeViewHolder viewHolder = new PersonajeViewHolder(viewCelda);
        return viewHolder;


    }

    /**
     * el que le da a la celda creada los valores correspondientes
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Personaje personajeAMostrar = this.listaDePersonajes.get(position);
        RecyclerView.ViewHolder elHolder = (PersonajeViewHolder) holder;
        ((PersonajeViewHolder) holder).cargarPersonaje(personajeAMostrar);

    }

    /**
     * retorna la cantidad de elementos en mi lista
     * @return
     */
    @Override
    public int getItemCount() {
        return this.listaDePersonajes.size();
    }

    //que es el viewHolder? es la representacion java de la celda. se crea la clase
    private class PersonajeViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewPersonaje;
        private TextView textViewPersonajeNombre;
        private TextView textViewPersonajeSerieOrigen;

        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);

            //aca van los findViewById
            imageViewPersonaje = itemView.findViewById(R.id.celdaPersonajeImageViewPersonaje);
            textViewPersonajeNombre = itemView.findViewById(R.id.celdaPersonajeTextViewPersonaje);
            textViewPersonajeSerieOrigen = itemView.findViewById(R.id.celdaPersonajeTextViewSerie);
        }

        //aca se enlaza cada personaje con cada celda
        public void cargarPersonaje(Personaje unPersonaje){

            imageViewPersonaje.setImageResource(unPersonaje.getImagen());
            textViewPersonajeNombre.setText(unPersonaje.getNombre());
            textViewPersonajeSerieOrigen.setText(unPersonaje.getOrigenSerie());

        }


    }


}
