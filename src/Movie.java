import java.util.*;

class Movie {
    private int movieId;
    private String title;
    private String genre;

    public void setShowtimes(List<String> showtimes) {
        this.showtimes = showtimes;
    }

    private List<String> showtimes;

    public Movie(int movieId, String title, String genre, List<String> showtimes) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.showtimes = new ArrayList<>(showtimes);;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public List<String> getShowtimes() {
        return showtimes;
    }

    @Override
    public String toString() {
        return title + " (" + genre + ")";
    }
}