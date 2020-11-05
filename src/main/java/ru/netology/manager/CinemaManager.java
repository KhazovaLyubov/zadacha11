package ru.netology.manager;

import ru.netology.domain.CinemaItem;

public class CinemaManager {
    private CinemaItem[] items = new CinemaItem[0];
    private int numberOfCinema = 10;

    public CinemaManager() {
    }

    public void add(CinemaItem cinemaItem) {
        int length = items.length + 1;
        CinemaItem[] tmp = new CinemaItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = cinemaItem;
        items = tmp;
    }

    public CinemaItem[] getAll() {
        int count = Math.min(items.length, numberOfCinema);
        CinemaItem[] tmp = new CinemaItem[count];
        for (int i = 0; i < count; i++) {
            int index = items.length - i - 1;
            tmp[i] = items[index];
        }
        return tmp;
    }

    public CinemaManager(int numberOfCinema) {
        if (numberOfCinema < 0) {
            return;
        }
        this.numberOfCinema = numberOfCinema;
    }
}



