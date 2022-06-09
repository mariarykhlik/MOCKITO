package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ManagerTest {

    Movie first = new Movie("1id", "1title", "1genre", "1imageUrl", false);
    Movie second = new Movie("2id", "2title", "2genre", "2imageUrl", true);
    Movie third = new Movie("3id", "3title", "3genre", "3imageUrl", false);
    Movie fourth = new Movie("4id", "4title", "4genre", "4imageUrl", false);
    Movie fifth = new Movie("5id", "5title", "5genre", "5imageUrl", true);
    Movie sixth = new Movie("6id", "6title", "3genre", "6imageUrl", false);

    Repository repository = new Repository();
    Manager manager = new Manager(repository, 5);

    @Test
    public void shouldGetAll() {

        Movie[] actual = manager.getAll();

        Movie[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovie() {

        manager.addMovie(first);
        manager.addMovie(second);

        Movie[] expected = {first, second};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastForOverLimit() {

        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);

        Movie[] actual = manager.findLast();

        Movie[] expected = {fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastForLimit() {

        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);

        Movie[] actual = manager.findLast();

        Movie[] expected = {fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastForUnderLimit() {

        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);

        Movie[] actual = manager.findLast();

        Movie[] expected = {third, second, first};
        assertArrayEquals(expected, actual);
    }
}
