package es.studium.filmingapp.ui.Series;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.studium.filmingapp.MainActivity;
import es.studium.filmingapp.R;
import es.studium.filmingapp.ui.Series.SeriesAdapter;
import es.studium.filmingapp.ui.Series.SeriesDetalles;
import es.studium.filmingapp.ui.Series.SeriesImagenDetalles;
import es.studium.filmingapp.ui.Series.SeriesInterface;
import es.studium.filmingapp.ui.Series.SeriesViewModel;

public class SeriesFragment extends Fragment
{
    private SeriesInterface seriesInterface;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private java.util.List<Series> datos;
    View rootView;

    private SeriesViewModel seriesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_series, container, false);
        datos = new ArrayList<>();
        datos.add(new Series(R.drawable.breaking, "Breaking Bad","Vince Gilligan", "Bryan Cranston, Aaron Paul, Anna Gunn", "Hundido por una monótona e insulsa relación con su mujer e incapaz de poner a prueba su brillantez trabajando como profesor de instituto, Walter da un giro radical a su forma de vida cuando descubre que tiene un cáncer terminal.","5",R.drawable.cuatroestrellas ));
        datos.add(new Series(R.drawable.juegotronos, "Juego de Tronos","D.B. Weiss, David Benioff", "Peter Dinklage, Kit Harington, Emilia Clarke","La serie nos sitúa en Invernalia, uno de los siete reinos del continente de Poniente. Tras un largo verano, Lord Eddard 'Ned' Stark (Sean Ben, 'El señor de los anillo', 'Troya', 'Equilibrium'), señor de Invernalia, es llamado a ocupar el cargo de Mano del Rey","8", R.drawable.cincoestrellas ));
        datos.add(new Series(R.drawable.peaky, "Peaky Blinders","Steven Knight", "Cillian Murphy, Helen McCrory, Paul Anderson","Es un drama de BBC que narra la historia de la familia gitana Shelby y su banda de gángsters, un grupo de personas características por sus boinas con cuchillas y dueñas de los asuntos ilegales, que dominan las apuestas clandestinas y se rigen mediante extorsiones.","5", R.drawable.cuatroestrellas ));
        datos.add(new Series(R.drawable.chernobyl, "Chernobyl","Craig Mazin", "Jared Harris, Stellan Skarsgård, Paul Ritter","El 26 de abril de 1986, una de las peores catástrofes humanas se cierne sobre la faz de la tierra.","1", R.drawable.tresestrellas ));
        datos.add(new Series(R.drawable.vickingos, "Vickingos","Michael Hirst", "Alex Høgh Andersen, Marco Ilsø, Gustaf Skarsgård","Este nuevo drama histórico de History Channel está centrado en Ragnar Lothbrok, figura mítica que aseguraba que era el descendiente de Odín, el dios principal de la mitología nórdica.\n","6", R.drawable.cuatroestrellas ));
        datos.add(new Series(R.drawable.stranger, "Stranger Things","Matt Duffer, Ross Duffer", " Millie Bobby Brown, Winona Ryder, Finn Wolfhard","La historia narra la súbita desaparición de un niño en esta ciudad durante la década de los 80, hecho que destapa los extraños sucesos que tienen lugar en la zona, producto de una serie de experimentos que realiza el gobierno. Además, en la ciudad aparecen fuerzas sobrenaturales inquietantes y una niña muy perturbadora.","4", R.drawable.cincoestrellas ));

        // Obtenemos el Recycler
        recycler = (RecyclerView) rootView.findViewById(R.id.myRecyclerViewSeries);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        //Crear un nuevo adaptador
        adapter = new SeriesAdapter(datos, seriesInterface);
        recycler.setAdapter(adapter);

        setupRecyclerView();
        return rootView;
    }
    private void setupRecyclerView()
    {
        RecyclerView recyclerView = recycler.findViewById(R.id.myRecyclerViewSeries);
        recyclerView.setAdapter(new SeriesAdapter(datos, new SeriesInterface()
        {
            @Override
            public void onClick(View v, int position) {
                if(v.getId()==(R.id.img_serie)){
                    Intent seriesImagenDetalles = new Intent(rootView.getContext(), SeriesImagenDetalles.class);
                    seriesImagenDetalles.putExtra("serieImagenDetalle", datos.get(position).getImagen());
                    startActivity(seriesImagenDetalles);
                }
                else{
                    Intent seriesDetalles = new Intent(rootView.getContext(), SeriesDetalles.class);
                    seriesDetalles.putExtra("imgSerieDetalle", datos.get(position).getImagen());
                    seriesDetalles.putExtra("txtTituloSerieDetalle", datos.get(position).getTitulo());
                    seriesDetalles.putExtra("director_detalle_serie", datos.get(position).getDirector());
                    seriesDetalles.putExtra("reparto_detalle_serie", datos.get(position).getReparto());

                    seriesDetalles.putExtra("sinopsi_detalle_serie", datos.get(position).getSinopsi());
                    seriesDetalles.putExtra("temporadas_detalle_serie", datos.get(position).getTemporadas());
                    seriesDetalles.putExtra("imgSerieClasificacion", datos.get(position).getClasificacion());

                    startActivity(seriesDetalles);
                }
            }
        }));
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
    }
}