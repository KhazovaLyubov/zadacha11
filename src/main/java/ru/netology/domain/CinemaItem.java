package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CinemaItem {
    private int id;
    private int cinemaId;
    private String cinemaName;
    private String cinemaGenre;
    private boolean date;
}
