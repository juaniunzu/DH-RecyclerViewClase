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
    //tiene un escuchador que se pasara como parametro en el constructor.
    // al momento de crear el adapter (instanciarlo),
    // la clase que se pase como parametro será quien escuche,
    // por lo tanto tendra que implementar la interfaz para ser parámetro válido
    private PersonajesAdapterListener listener;

    public PersonajesAdapter(List<Personaje> listaDePersonajes, PersonajesAdapterListener listener) {
        this.listaDePersonajes = listaDePersonajes;
        this.listener = listener;
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

        //tomo el personaje que se muestra en una variable local
        Personaje personajeAMostrar = this.listaDePersonajes.get(position);

        //casteo el parametro holder para que sea tipo PersonajeViewHolder,
        //lo que le dara el metodo cargarPersonaje()
        PersonajeViewHolder elHolder = (PersonajeViewHolder) holder;

        //cargo el personaje de la variable local en la celda
        elHolder.cargarPersonaje(personajeAMostrar);

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

            //seteo el onClickListener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //le pedimos al adapter la posicion donde se esta haciendo click
                    Integer adapterPosition = getAdapterPosition();

                    //consigo el personaje segun la posicion del click sacada arriba
                    Personaje personaje = listaDePersonajes.get(adapterPosition);

                    //corro el metodo hicieronClick que es parte del parametro (this.)listener,
                    //le paso como parametro el personaje tomado aca arriba. Este metodo
                    //hara distintas cosas segun en qué actividad se encuentre la celda clickeada.
                    //nos damos cuenta de esto porque al momento de instanciar el adapter en una
                    //actividad, le tendremos que pasar dicha actividad como parametro de escuchador (listener)

                    listener.hicieronClick(personaje);

                }
            });
        }

        //aca se enlaza cada personaje con cada celda
        public void cargarPersonaje(Personaje unPersonaje){

            imageViewPersonaje.setImageResource(unPersonaje.getImagen());
            textViewPersonajeNombre.setText(unPersonaje.getNombre());
            textViewPersonajeSerieOrigen.setText(unPersonaje.getOrigenSerie());

        }


    }

    // esta interface es la que dice que cuando una clase la implementa se
    // transforma en una "escuchadora" de lo que el click en la celda quiere decir.
    // cada clase que la implemente tendra que reescribir el metodo hicieronClick()
    // e indicará qué es lo que tiene que hacer cuando eso pasa
    public interface PersonajesAdapterListener{
        public void hicieronClick(Personaje unPersonaje);
    }


}
