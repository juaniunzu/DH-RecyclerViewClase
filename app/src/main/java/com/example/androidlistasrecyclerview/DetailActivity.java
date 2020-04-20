package com.example.androidlistasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    public static final String NOMBRE_PERSONAJE = "nombrePersonaje";
    public static final String IMAGEN_PERSONAJE = "imagenPersonaje";

    private TextView detailActivityTextViewPersonaje;
    private ImageView detailActivityImageViewPersonaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailActivityTextViewPersonaje = findViewById(R.id.detailActivityTextViewPersonaje);
        detailActivityImageViewPersonaje = findViewById(R.id.detailActivityImageViewPersonaje);

        //recibo el intent
        Intent desdeMainADetail = getIntent();

        //le saco el bundle
        Bundle bundle = desdeMainADetail.getExtras();

        //le saco los datos al bundle y los guardo en variables locales
        String nombrePersonaje = bundle.getString(DetailActivity.NOMBRE_PERSONAJE);
        Integer imagenPersonaje = bundle.getInt(DetailActivity.IMAGEN_PERSONAJE);

        detailActivityTextViewPersonaje.setText(nombrePersonaje);
        detailActivityImageViewPersonaje.setImageResource(imagenPersonaje);


    }
}
