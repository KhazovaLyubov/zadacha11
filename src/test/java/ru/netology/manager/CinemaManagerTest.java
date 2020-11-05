package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.CinemaItem;

import static org.junit.jupiter.api.Assertions.*;

class CinemaManagerTest {

    @Test
    void getLastTwo() {
        CinemaManager manager = new CinemaManager(2);
        CinemaItem first = new CinemaItem(1, 1, "first", "cartoon", true);
        CinemaItem second = new CinemaItem(2, 2, "second", "adventures", true);
        manager.add(first);
        manager.add(second);
        CinemaItem[] actual = manager.getAll();
        CinemaItem[] expected = new CinemaItem[]{second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastTen() {
        CinemaManager manager = new CinemaManager();
        CinemaItem one = new CinemaItem(1, 1, "one", "cartoon", true);
        CinemaItem two = new CinemaItem(2, 2, "two", "adventures", true);
        CinemaItem three = new CinemaItem(3, 3, "three", "fantasy", true);
        CinemaItem four = new CinemaItem(4, 4, "four", "detective", true);
        CinemaItem five = new CinemaItem(5, 5, "five", "melodrama", true);
        CinemaItem six = new CinemaItem(6, 6, "six", "horror", true);
        CinemaItem seven = new CinemaItem(7, 7, "seven", "action", true);
        CinemaItem eight = new CinemaItem(8, 8, "eight", "sport", true);
        CinemaItem nine = new CinemaItem(9, 9, "nine", "thriller", true);
        CinemaItem ten = new CinemaItem(10, 10, "ten", "comedy", true);
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
        CinemaItem[] actual = manager.getAll();
        CinemaItem[] expexcted = new CinemaItem[]{ten, nine, eight, seven, six, five, four, three, two, one};
        assertArrayEquals(expexcted, actual);
    }

    @Test
    public void getLastEleven() {
        CinemaManager manager = new CinemaManager(10);
        CinemaItem one = new CinemaItem(1, 1, "one", "cartoon", true);
        CinemaItem two = new CinemaItem(2, 2, "two", "adventures", true);
        CinemaItem three = new CinemaItem(3, 3, "three", "fantasy", true);
        CinemaItem four = new CinemaItem(4, 4, "four", "detective", true);
        CinemaItem five = new CinemaItem(5, 5, "five", "melodrama", true);
        CinemaItem six = new CinemaItem(6, 6, "six", "horror", true);
        CinemaItem seven = new CinemaItem(7, 7, "seven", "action", true);
        CinemaItem eight = new CinemaItem(8, 8, "eight", "comedy", true);
        CinemaItem nine = new CinemaItem(9, 9, "nine", "sport", true);
        CinemaItem ten = new CinemaItem(10, 10, "ten", "thriller", true);
        CinemaItem eleven = new CinemaItem(11, 11, "eleven", "comedy", true);
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);
        CinemaItem[] actual = manager.getAll();
        CinemaItem[] expected = new CinemaItem[]{eleven, ten, nine, eight, seven, six, five, four, three, two};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getNull() {
        CinemaManager manager = new CinemaManager(0);
        CinemaItem[] actual = manager.getAll();
        CinemaItem[] expected = new CinemaItem[]{, };
        assertArrayEquals(expected, actual);
    }
    @Test
    void getToNull() {
        CinemaManager manager = new CinemaManager(-1);
        CinemaItem[] actual = manager.getAll();
        CinemaItem[] expected = new CinemaItem[]{, };
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLessThanLimit() {
        CinemaManager manager = new CinemaManager(5);
        CinemaItem first = new CinemaItem(1, 1, "first", "cartoon", true);
        CinemaItem second = new CinemaItem(2, 2, "second", "adventures", true);
        CinemaItem three = new CinemaItem(3, 3, "three", "fantasy", true);
        CinemaItem four = new CinemaItem(4, 4, "four", "detective", true);
        manager.add(first);
        manager.add(second);
        manager.add(three);
        manager.add(four);
        CinemaItem[] actual = manager.getAll();
        CinemaItem[] expected = new CinemaItem[]{four, three, second, first};
        assertArrayEquals(expected, actual);
    }

}
