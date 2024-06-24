package ru.project.toolkeeper.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cells")
public class Cell {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Column(name = "id_closet")
    @Getter
    @Setter
    private int idCloset;

    @Column(name = "number")
    @Getter
    @Setter
    private int number;

    public Cell() {}

    public Cell(int idCloset, int number) {
        this.idCloset = idCloset;
        this.number = number;
    }

    //Метод нужен для понимания, какой номер ячейки забит в таблице
    public int getNumByPosition(int cellsInShelf, int shelfNeed, int cellNeed) {
        return (shelfNeed * cellsInShelf - cellsInShelf + cellNeed);
    }
}
