package ru.netology.manager;


import ru.netology.domain.FilmItem;
import ru.netology.repository.FilmRepository;

public class FilmManager {
    private FilmRepository repository;

    public FilmManager(FilmRepository repository) {this.repository = repository;}

    public void save(FilmItem item) {
        repository.save(item);
    }

    public FilmItem[] getAll() {
        FilmItem[] films = repository.findAll();
        FilmItem[] result = new FilmItem[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}