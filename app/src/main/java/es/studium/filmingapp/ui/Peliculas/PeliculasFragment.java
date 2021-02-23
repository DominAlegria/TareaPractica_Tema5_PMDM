package es.studium.filmingapp.ui.Peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
import es.studium.filmingapp.ui.Peliculas.PeliculasViewModel;
import es.studium.filmingapp.ui.home.HomeFragment;

public class PeliculasFragment extends Fragment
{
    private PeliculasInterface peliculasInterface;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private java.util.List<Peliculas> datos;
    View rootView;

    private PeliculasViewModel peliculasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {


        rootView = inflater.inflate(R.layout.fragment_peliculas, container, false);
        datos = new ArrayList<>();
        datos.add(new Peliculas(R.drawable.adu, "Adú", "Salvador Calvo", "Álvaro Cervantes, Ana Wagener, Anna Castillo, Jesús Carroza, Luis Tosar, Miquel Fernández", " En un intento desesperado por alcanzar Europa y agazapados ante una pista de aterrizaje en Camerún, un niño de seis años y su hermana mayor esperan para colarse en las bodegas de un avión.",R.drawable.dosestrellas));
        datos.add(new Peliculas(R.drawable.apocalipsis, "Apocalypse Now", " Francis Ford Coppola", "Albert Hall, Frederic Forrest, Laurence Fishburne, Marlon Brando", " Con un reparto de lujo, cuenta la historia de un capitán del Ejército norteamericano (Martin Sheen) que es enviado en misión secreta por la peligrosa e hipnótica Camboya, con el fin de asesinar a un misterioso coronel renegado llamado Kurtz (Marlon Brando), que ha sucumbido a los horrores de la guerra y vive apartado en un poblado remoto.", R.drawable.cincoestrellas));
        datos.add(new Peliculas(R.drawable.bitelchus, "Bitelchús", "Bill Scott, Carol Sevilla", " Alec Baldwin, Catherine Ohara, Geena Davis, Jeffrey Jones, Michael Keaton, Winona Ryder", " Bitelchus (Michael Keaton) es una criatura de ultratumba repugnante y terrorífica, un fenómeno asustando y bromeando que se gira y se transforma en grotescas formas, traga insectos y no puede dejar a las mujeres (vivas o muertas) en paz.", R.drawable.tresestrellas));
        datos.add(new Peliculas(R.drawable.et, "E.T. El extraterrestre"," Steven Spielberg", " Dee Wallace, Drew Barrymore, Erika Eleniak, Henry Thomas, Peter Coyote, Robert Macnaughton", " Un pequeño ser de otro planeta se queda abandonado en la Tierra cuando su nave se marcha olvidándose de él. Tiene miedo. Está completamente solo, pero se hará amigo de un niño, que lo esconde en su casa.", R.drawable.cincoestrellas));
        datos.add(new Peliculas(R.drawable.gladiator, "Gladiator", "Ridley Scott", "Connie Nielsen, Derek Jacobi, Joaquin Phoenix, Oliver Reed, Russell Crowe", " En el año 180, el Imperio Romano domina todo el mundo conocido. Tras una gran victoria sobre los bárbaros del norte, el anciano emperador Marco Aurelio decide transferir el poder a Máximo, bravo general de sus ejércitos y hombre de inquebrantable lealtad al imperio. Pero su hijo Cómodo, que aspiraba al trono, no lo acepta y trata de asesinar a Máximo.", R.drawable.cincoestrellas));
        datos.add(new Peliculas(R.drawable.trescientos, "300", "Zack Snyder", "Gerard Butler, Lena Headey, David Wenham, Dominic West, Vincent Regan, Tom Wisdom, etc...", "El objetivo de Jerjes, emperador de Persia, era la conquista de Grecia, lo que desencadenó las Guerras Médicas. Dada la gravedad de la situación, el rey Leónidas de Esparta (Gerard Butler) y 300 espartanos se enfrentaron a un ejército persa que era inmensamente superior.", R.drawable.tresestrellas));

        // Obtenemos el Recycler
        recycler = (RecyclerView) rootView.findViewById(R.id.myRecyclerViewPeliculas);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        //Crear un nuevo adaptador
        adapter = new PeliculasAdapter(datos, peliculasInterface);
        recycler.setAdapter(adapter);

        setupRecyclerView();
        return rootView;
    }
    private void setupRecyclerView(){
        RecyclerView recyclerView = recycler.findViewById(R.id.myRecyclerViewPeliculas);
        recyclerView.setAdapter(new PeliculasAdapter(datos, new PeliculasInterface() {
            @Override
            public void onClick(View v, int position) {
                if(v.getId()==(R.id.imgPeli)){
                    Intent pelisImagenDetalles = new Intent(rootView.getContext(), PeliculasImagenDetalles.class);
                    pelisImagenDetalles.putExtra("peliculaImagenDetalle", datos.get(position).getImagen());
                    startActivity(pelisImagenDetalles);
                }
                else{
                    Intent pelisDetalles = new Intent(rootView.getContext(), PeliculasDetalles.class);
                    pelisDetalles.putExtra("imgPeliculaDetalle", datos.get(position).getImagen());
                    pelisDetalles.putExtra("txtTituloPeliculaDetalle", datos.get(position).getTitulo());
                    pelisDetalles.putExtra("director_detalle_pelicula", datos.get(position).getDirector());
                    pelisDetalles.putExtra("reparto_detalle_pelicula", datos.get(position).getReparto());
                    pelisDetalles.putExtra("sinopsi_detalle_pelicula", datos.get(position).getSinopsi());
                    pelisDetalles.putExtra("imgPeliculaClasificacion", datos.get(position).getClasificacion());
                    startActivity(pelisDetalles);
                }
            }
        }));
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
    }
}