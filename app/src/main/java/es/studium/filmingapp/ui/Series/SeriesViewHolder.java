package es.studium.filmingapp.ui.Series;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import es.studium.filmingapp.R;

public class SeriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public ImageView imagen;
    public TextView titulo;
    public ImageButton imagenAtras;
    private final es.studium.filmingapp.ui.Series.SeriesInterface listener;
    SeriesAdapter SeriesAdapter;

    public SeriesViewHolder(@NonNull View itemView, @NonNull es.studium.filmingapp.ui.Series.SeriesInterface listener)
    {
        super(itemView);
        imagen = (ImageView) itemView.findViewById(R.id.img_serie);
        titulo = (TextView) itemView.findViewById(R.id.titulo_serie);

        imagen.setOnClickListener(this);
        titulo.setOnClickListener(this);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void bindRow(es.studium.filmingapp.ui.Series.Series series)
    {
        imagen.setImageResource(series.getImagen());
        titulo.setText(series.getTitulo());
    }

    @Override
    public void onClick(View v)
    {
        listener.onClick(v, getAdapterPosition());
    }
}
