package es.studium.filmingapp.ui.Peliculas;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

import es.studium.filmingapp.R;

class PeliculasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public ImageView imagen;
    public TextView titulo;
    private final es.studium.filmingapp.ui.Peliculas.PeliculasInterface listener;

    public PeliculasViewHolder(@NonNull View itemView, @NonNull es.studium.filmingapp.ui.Peliculas.PeliculasInterface listener)
    {
        super(itemView);
        imagen = (ImageView) itemView.findViewById(R.id.imgPeli);
        titulo = (TextView) itemView.findViewById(R.id.tituloPeli);
        imagen.setOnClickListener(this);
        titulo.setOnClickListener(this);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void bindRow(es.studium.filmingapp.ui.Peliculas.Peliculas peliculas)
    {
        imagen.setImageResource(peliculas.getImagen());
        titulo.setText(peliculas.getTitulo());
    }


    @Override
    public void onClick(View v)
    {
        listener.onClick(v, getAdapterPosition());
    }
}
