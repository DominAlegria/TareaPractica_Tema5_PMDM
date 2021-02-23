package es.studium.filmingapp.ui.Peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import es.studium.filmingapp.R;


public class PeliculasImagenDetalles extends AppCompatActivity implements View.OnClickListener
{



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_imagen_detalles);

        ImageView imgPeli = (ImageView) findViewById(R.id.peliculaImagenDetalle);
        imgPeli.setOnClickListener(this);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        if(bundle != null)
        {
            imgPeli.setImageResource(bundle.getInt("peliculaImagenDetalle"));
        }
    }
    public void onClick(View v)
    {
        
        if(v.getId() == R.id.peliculaImagenDetalle)
        {
            finish();
        }
    }
}