package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryTest {

    @Test
    void save() {
        FilmRepository filmRepository = new FilmRepository();
        FilmItem one = new FilmItem(1, 1, "one", "cartoon", true);
        FilmItem two = new FilmItem(2, 2, "two", "adventures", true);
        FilmItem three = new FilmItem(3, 3, "three", "fantasy", true);
        filmRepository.save(one);
        filmRepository.save(two);
        filmRepository.save(three);
        FilmItem[] actual = filmRepository.findAll();
        FilmItem[] expected = new FilmItem[]{one, two, three};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        FilmRepository filmRepository = new FilmRepository();
        FilmItem one = new FilmItem(1, 1, "one", "cartoon", true);
        FilmItem two = new FilmItem(2, 2, "two", "adventures", true);
        FilmItem three = new FilmItem(3, 3, "three", "fantasy", true);
        filmRepository.save(one);
        filmRepository.save(two);
        filmRepository.save(three);
        filmRepository.findAll();
        FilmItem[] actual = filmRepository.findAll();
        FilmItem[] expected = new FilmItem[]{one, two, three};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        FilmRepository filmRepository = new FilmRepository();
        int idToFind = 2;
        FilmItem one = new FilmItem(1, 1, "one", "cartoon", true);
        FilmItem two = new FilmItem(2, 2, "two", "adventures", true);
        FilmItem three = new FilmItem(3, 3, "three", "fantasy", true);
        filmRepository.save(one);
        filmRepository.save(two);
        filmRepository.save(three);
        FilmItem actual = filmRepository.findById(idToFind);
        FilmItem expected = two;
        assertEquals(expected, actual);
    }

    @Test
    public void NotId() {
        FilmRepository filmRepository = new FilmRepository();
        int idToFind = 5;
        FilmItem one = new FilmItem(1, 1, "one", "cartoon", true);
        FilmItem two = new FilmItem(2, 2, "two", "adventures", true);
        FilmItem three = new FilmItem(3, 3, "three", "fantasy", true);
        filmRepository.save(one);
        filmRepository.save(two);
        filmRepository.save(three);
        FilmItem actual = filmRepository.findById(idToFind);
        FilmItem expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void removeById() {
        FilmRepository filmRepository = new FilmRepository();
        int idToRemove = 3;
        FilmItem one = new FilmItem(1, 1, "one", "cartoon", true);
        FilmItem two = new FilmItem(2, 2, "two", "adventures", true);
        FilmItem three = new FilmItem(3, 3, "three", "fantasy", true);
        filmRepository.save(one);
        filmRepository.save(two);
        filmRepository.save(three);
        filmRepository.removeById(idToRemove);
        FilmItem[] actual = filmRepository.findAll();
        FilmItem[] expected = new FilmItem[]{one, two};
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        FilmRepository filmRepository = new FilmRepository();
        FilmItem one = new FilmItem(1, 1, "one", "cartoon", true);
        FilmItem two = new FilmItem(2, 2, "two", "adventures", true);
        FilmItem three = new FilmItem(3, 3, "three", "fantasy", true);
        filmRepository.save(one);
        filmRepository.save(two);
        filmRepository.save(three);
        filmRepository.removeAll();
        FilmItem[] actual = filmRepository.findAll();
        FilmItem[] expected = {};
        assertArrayEquals(expected, actual);
    }
}