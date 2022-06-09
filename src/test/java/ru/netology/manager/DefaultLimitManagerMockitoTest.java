package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Movie;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class DefaultLimitManagerMockitoTest {
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

    private Repository repository = Mockito.mock(Repository.class);
    private Manager defaultLimitManager = new Manager(repository);

    @Test
    public void shouldFindLastForOverLimit() {

        Movie[] returned = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = defaultLimitManager.findLast();

        Movie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);

        verify (repository).findAll();
    }

    @Test
    public void shouldFindLastForLimit() {

        Movie[] returned = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = defaultLimitManager.findLast();

        Movie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);

        verify (repository).findAll();
    }
}
