package es.studium.filmingapp.ui.Series;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.studium.filmingapp.R;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesViewHolder>
{
    private List<Series> datos;
    public final SeriesInterface seriesInterface;

    public SeriesAdapter(List<Series> datos, SeriesInterface seriesInterface)
    {
        this.datos = datos;
        this.seriesInterface = seriesInterface;
    }

    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_series, parent, false);
        return new SeriesViewHolder(row, seriesInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder viewHolder, int position)
    {
        viewHolder.bindRow(datos.get(position));
    }

    @Override
    public int getItemCount()
    {
        return datos.size();
    }
}
