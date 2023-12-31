public class Cinema {
    String hall;
    Movie movies;


    public Cinema(String hall, Movie movies) {
        this.hall = hall;
        this.movies = movies;
    }

    public String getHall() {
        return hall;
    }

    public Movie getMovies() {
        return movies;
    }
    public String toString() {
        return movies.getTitle() + " (" + movies.getGenre() + ")";
    }
}
