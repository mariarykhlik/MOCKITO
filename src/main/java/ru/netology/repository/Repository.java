package ru.netology.repository;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class Repository {

    private Movie[] movies = new Movie[0];

    public void saveMovie(Movie movie) {
        Movie[] tmp = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[movies.length] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie findById(String id) {
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getId() == id) {
                return movies[i];
            }
        }
        return null;
    }

    public void removeById(String id) {
        Movie removeMovie = findById(id);
        int index = 0;
//        if (!removeMovie.equals(null)) {
            Movie[] tmp = new Movie[movies.length - 1];
            for (int i = 0; i < movies.length; i++) {
                if (!movies[i].equals(removeMovie)) {
                    tmp[index] = movies[i];
                    index++;
                }
            }
            movies = tmp;
//        } else {
//            return;
//        }
    }

    public void removeAll() {
        setMovies(new Movie[0]);
    }
}
