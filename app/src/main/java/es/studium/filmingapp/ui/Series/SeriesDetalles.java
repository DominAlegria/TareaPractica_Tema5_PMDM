package es.studium.filmingapp.ui.Series;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.studium.filmingapp.R;
import es.studium.filmingapp.ui.Series.Series;
import es.studium.filmingapp.ui.Series.SeriesFragment;
import es.studium.filmingapp.ui.Series.SeriesImagenDetalles;

public class SeriesDetalles extends AppCompatActivity
{
    private List<Series> datos;
    private SeriesImagenDetalles seriesImagenDetalles;
    private SeriesFragment seriesFragment;
    private ImageView imagenSeriesDetalle;
    private RecyclerView recycler;

    View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_detalles);

        ImageView imgSerie = (ImageView) findViewById(R.id.imgSerieDetalle);
        TextView tituloSerie = (TextView) findViewById(R.id.txtTituloSerieDetalle);
        TextView directorSerie = (TextView) findViewById(R.id.director_detalle_serie);
        TextView repartoSerie = (TextView) findViewById(R.id.reparto_detalle_serie);
        TextView sinopsiSerie = (TextView) findViewById(R.id.sinopsi_detalle_serie);
        TextView temporadasSerie = (TextView) findViewById(R.id.temporadas_detalle_serie);
        ImageView imgclasificacion = (ImageView) findViewById(R.id.imgSerieClasificacion);

        String director = getString(R.string.director);
        String reparto = getString(R.string.reparto);
        String sinopsis = getString(R.string.sinopsis);
        String temporadas = getString(R.string.temporadas);


        //imgSerie.setOnClickListener(this);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            tituloSerie.setText(bundle.getString("txtTituloSerieDetalle"));
            imgSerie.setImageResource(bundle.getInt("imgSerieDetalle"));
            directorSerie.setText(director + ": " + bundle.getString("director_detalle_serie"));
            repartoSerie.setText(reparto + ": " + bundle.getString("reparto_detalle_serie"));
            sinopsiSerie.setText(sinopsis + ": " + bundle.getString("sinopsi_detalle_serie"));
            temporadasSerie.setText(temporadas + ": " + bundle.getString("temporadas_detalle_serie"));
            imgclasificacion.setImageResource(bundle.getInt("imgSerieClasificacion"));
        }
    }


    public void onClick(View v, int position) {
        if (v.getId() == (R.id.img_serie)) {
            Intent seriesImagenDetalles = new Intent(rootView.getContext(), SeriesImagenDetalles.class);
            seriesImagenDetalles.putExtra("seriesImagenDetalle", datos.get(position).getImagen());
        }
    }
}
