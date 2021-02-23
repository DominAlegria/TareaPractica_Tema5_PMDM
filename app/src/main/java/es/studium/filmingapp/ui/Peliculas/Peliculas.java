package es.studium.filmingapp.ui.Peliculas;

public class Peliculas
{
    // Gestiona los datos de las películas: Imagen - Título - Director - Reparto - Clasificación - Sinopsis
    private int imagen;
    private String titulo;
    private String director;
    private String reparto;
    private String sinopsi;
    private int clasificacion;

    // Constructor para cuando instanciemos desde cada elemento
    public Peliculas(int imagen, String titulo, String director, String reparto, String sinopsi, int clasificacion)
    {
        this.imagen = imagen;
        this.titulo = titulo;
        this.director = director;
        this.reparto = reparto;
        this.sinopsi = sinopsi;
        this.clasificacion = clasificacion;
    }

    public int getImagen(){return imagen;}
    public String getTitulo(){return titulo;}
    public String getDirector(){return director;}
    public String getReparto(){return reparto;}
    public String getSinopsi(){return sinopsi;}
    public int getClasificacion(){return clasificacion;}
}
