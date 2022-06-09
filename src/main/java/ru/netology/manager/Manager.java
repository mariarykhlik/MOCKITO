package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;
import ru.netology.repository.Repository;


@NoArgsConstructor
@Data
public class Manager {

    private Repository repository;
    private int limit = 10;

    public Manager (Repository repository) { this.repository = repository; }
    public Manager(Repository repository, int limit) {
        this.repository = repository;
        this.limit = limit;
    }

    public void addMovie(Movie movie) { repository.saveMovie(movie); }

    public Movie[] getAll() {
        return repository.findAll();
    }

    public Movie[] findLast() {
        Movie[] all =  repository.findAll();
        int resultLength = (all.length > this.limit) ? this.limit : all.length;
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = resultLength - 1 - i;
            result[i] = all[index];
        }
        return result;
    }
}
