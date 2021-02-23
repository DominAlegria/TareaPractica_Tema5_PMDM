package es.studium.filmingapp.ui.Peliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.studium.filmingapp.R;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasViewHolder>
{
    private List<Peliculas> datos;
    public final PeliculasInterface peliculasInterface;

    public PeliculasAdapter(List<Peliculas> datos, PeliculasInterface peliculasInterface)
    {
        this.datos = datos;
        this.peliculasInterface = peliculasInterface;
    }

    @NonNull
    @Override
    public PeliculasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_peliculas, parent, false);
        return new PeliculasViewHolder(row, peliculasInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculasViewHolder viewHolder, int position)
    {
        viewHolder.bindRow(datos.get(position));
    }

    @Override
    public int getItemCount()
    {
        return datos.size();
    }
}
