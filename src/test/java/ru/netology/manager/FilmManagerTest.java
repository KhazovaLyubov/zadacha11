package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmItem;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FilmManagerTest {

    @Mock
    private FilmRepository repository;

    @InjectMocks
    FilmManager manager;

    FilmItem one = new FilmItem(1, 1, "one", "action", true);
    FilmItem two = new FilmItem(2, 2, "two", "comedy", true);
    FilmItem three = new FilmItem(3, 3, "three", "horror", true);

    @BeforeEach
    public void setUp() {
        manager.save(one);
        manager.save(two);
        manager.save(three);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        FilmItem[] returned = new FilmItem[]{two, three};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        FilmItem[] expected = new FilmItem[]{three, two};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        FilmItem[] returned = new FilmItem[]{one, two, three};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        FilmItem[] expected = new FilmItem[]{three, two, one};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }
}
