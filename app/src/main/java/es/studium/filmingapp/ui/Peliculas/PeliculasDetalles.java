package es.studium.filmingapp.ui.Peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.studium.filmingapp.R;
import es.studium.filmingapp.ui.Peliculas.PeliculasFragment;

public class PeliculasDetalles extends AppCompatActivity {
    private List<es.studium.filmingapp.ui.Peliculas.Peliculas> datos;
    private PeliculasImagenDetalles peliculasImagenDetalles;
    private PeliculasFragment peliculaFragment;
    private ImageView imagenPeliculaDetalle;
    private RecyclerView recycler;

    View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_detalles);

        ImageView imgPeli = (ImageView) findViewById(R.id.imgPeliculaDetalle);
        TextView tituloPeli = (TextView) findViewById(R.id.txtTituloPeliculaDetalle);
        TextView directorPeli = (TextView) findViewById(R.id.director_detalle_pelicula);
        TextView repartoPeli = (TextView) findViewById(R.id.reparto_detalle_pelicula);
        TextView sinopsiPeli = (TextView) findViewById(R.id.sinopsi_detalle_pelicula);
        ImageView imgClasificacion = (ImageView) findViewById(R.id.imgPeliculaClasificacion);

        String director = getString(R.string.director);
        String reparto = getString(R.string.reparto);
        String sinopsis = getString(R.string.sinopsis);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            tituloPeli.setText(bundle.getString("txtTituloPeliculaDetalle"));
            imgPeli.setImageResource(bundle.getInt("imgPeliculaDetalle"));
            directorPeli.setText(director + ": " + bundle.getString("director_detalle_pelicula"));
            repartoPeli.setText(reparto + ": " + bundle.getString("reparto_detalle_pelicula"));
            sinopsiPeli.setText(sinopsis + ": " + bundle.getString("sinopsi_detalle_pelicula"));
            imgClasificacion.setImageResource(bundle.getInt("imgPeliculaClasificacion"));

        }
    }


    public void onClick(View v, int position) {
        if (v.getId() == (R.id.imgPeli)) {
            Intent pelisImagenDetalles = new Intent(rootView.getContext(), PeliculasImagenDetalles.class);
            pelisImagenDetalles.putExtra("peliculaImagenDetalle", datos.get(position).getImagen());
        }
    }

}