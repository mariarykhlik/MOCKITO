package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {

    Movie first = new Movie("1id", "1title", "1genre", "1imageUrl", false);
    Movie second = new Movie("2id", "2title", "2genre", "2imageUrl", true);
    Movie third = new Movie("3id", "3title", "3genre", "3imageUrl", false);
    Movie fourth = new Movie("4id", "4title", "4genre", "4imageUrl", false);
    Movie fifth = new Movie("5id", "5title", "5genre", "5imageUrl", true);
    Movie sixth = new Movie("6id", "6title", "3genre", "6imageUrl", false);
    Movie seventh = new Movie("7id", "7title", "5genre", "7imageUrl", false);
    Movie eighth = new Movie("8id", "8title", "1genre", "8imageUrl", false);
    Movie ninth = new Movie("9id", "9title", "1genre", "9imageUrl", true);
    Movie tenth = new Movie("10id", "10title", "3genre", "10imageUrl", false);
    Movie eleventh = new Movie("11id", "11title", "5genre", "11imageUrl", true);

    Manager defaultLimitManager = new Manager();
    Manager manager = new Manager(5);


    @Test
    public void shouldFindAll() {

        Movie[] actual = defaultLimitManager.findAll();

        Movie[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovie() {

        defaultLimitManager.addMovie(first);
        defaultLimitManager.addMovie(second);

        Movie[] expected = {first, second};
        Movie[] actual = defaultLimitManager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastForOverLimit() {

        defaultLimitManager.addMovie(first);
        defaultLimitManager.addMovie(second);
        defaultLimitManager.addMovie(third);
        defaultLimitManager.addMovie(fourth);
        defaultLimitManager.addMovie(fifth);
        defaultLimitManager.addMovie(sixth);
        defaultLimitManager.addMovie(seventh);
        defaultLimitManager.addMovie(eighth);
        defaultLimitManager.addMovie(ninth);
        defaultLimitManager.addMovie(tenth);
        defaultLimitManager.addMovie(eleventh);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);

        Movie[] defaultActual = defaultLimitManager.findLast();
        Movie[] actual = manager.findLast();

        Movie[] defaultExpected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] expected = {fifth, fourth, third, second, first};
        assertArrayEquals(defaultExpected, defaultActual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastForLimit() {

        defaultLimitManager.addMovie(first);
        defaultLimitManager.addMovie(second);
        defaultLimitManager.addMovie(third);
        defaultLimitManager.addMovie(fourth);
        defaultLimitManager.addMovie(fifth);
        defaultLimitManager.addMovie(sixth);
        defaultLimitManager.addMovie(seventh);
        defaultLimitManager.addMovie(eighth);
        defaultLimitManager.addMovie(ninth);
        defaultLimitManager.addMovie(tenth);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);

        Movie[] defaultActual = defaultLimitManager.findLast();
        Movie[] actual = manager.findLast();

        Movie[] defaultExpected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] expected = {fifth, fourth, third, second, first};
        assertArrayEquals(defaultExpected, defaultActual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastForUnderLimit() {

        defaultLimitManager.addMovie(first);
        defaultLimitManager.addMovie(second);
        defaultLimitManager.addMovie(third);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);

        Movie[] defaultActual = defaultLimitManager.findLast();
        Movie[] actual = manager.findLast();

        Movie[] defaultExpected = {third, second, first};
        Movie[] expected = {third, second, first};
        assertArrayEquals(defaultExpected, defaultActual);
        assertArrayEquals(expected, actual);
    }
}
