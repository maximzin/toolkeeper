package ru.project.toolkeeper.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "closet_type")
public class ClosetType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 1, max = 50, message = "Название должно содержать от 1 до 50 символов")
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Min(value = 0, message = "Не может быть меньше 0 полок")
    @Max(value = 50, message = "Не может быть больше 50 полок")
    @Column(name = "shelves")
    @Getter
    @Setter
    private int shelves;

    @Min(value = 0, message = "На полке не может быть меньше 0 ячеек")
    @Max(value = 30, message = "На полке не может быть больше 30 ячеек")
    @Column(name = "cells_for_shelf")
    @Getter
    @Setter
    private int cellsForShelf;

    @Min(value = 1, message = "Количество ячеек не может быть равно 0")
    @Max(value = 1001, message = "Количество ячеек не может быть более 1000")
    @Column(name = "capacity")
    @Getter
    @Setter
    private int capacity;

    public ClosetType() {}

    public ClosetType(String name, int shelves, int cellsForShelf, int capacity) {
        this.name = name;
        this.shelves = shelves;
        this.cellsForShelf = cellsForShelf;
        this.capacity = capacity;
    }
}

