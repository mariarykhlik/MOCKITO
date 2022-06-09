package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {

    Movie first = new Movie("1id", "1title", "1genre", "1imageUrl", false);
    Movie second = new Movie("2id", "2title", "2genre", "2imageUrl", true);
    Movie third = new Movie("3id", "3title", "3genre", "3imageUrl", false);

    Repository repository = new Repository();

    @Test
    public void shouldFindAll() {

        Movie[] actual = repository.findAll();

        Movie[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveMovie() {

        repository.saveMovie(first);
        repository.saveMovie(second);
        repository.saveMovie(third);

        Movie[] expected = {first, second, third};
        Movie[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {

        repository.saveMovie(first);
        repository.saveMovie(second);
        repository.saveMovie(third);

        Movie actual = repository.findById("1id");

        Movie expected = first;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdForNull() {

        repository.saveMovie(first);
        repository.saveMovie(second);

        Movie actual = repository.findById("3id");

        assertNull(actual);
    }

    @Test
    public void shouldRemoveById() {

        repository.saveMovie(first);
        repository.saveMovie(second);
        repository.saveMovie(third);

        repository.removeById("3id");

        Movie[] expected = {first, second};
        Movie[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldRemoveByIdForNull() {
//
//        repository.saveMovie(first);
//        repository.saveMovie(second);
//        repository.saveMovie(third);
//
//        repository.removeById("6id");
//
//        Movie[] expected = {first, second, third};
//        Movie[] actual = repository.findAll();
//        assertArrayEquals(expected, actual);
//    }
//
    @Test
    public void shouldRemoveAll() {

        repository.saveMovie(first);
        repository.saveMovie(second);
        repository.saveMovie(third);

        repository.removeAll();

        Movie[] expected = {};
        Movie[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
