package ru.project.toolkeeper.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cells_and_tools")
public class CellAndTools {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Column(name = "id_cell")
    @Getter
    @Setter
    private int idCell;

    @Column(name = "id_tool")
    @Getter
    @Setter
    private int idTool;

    @Min(value = 1, message = "Количество не может быть равно 0")
    @Max(value = 100, message = "Количество не может быть более 100")
    @Column(name = "count")
    @Getter
    @Setter
    private int count;


    public CellAndTools() {}

    public CellAndTools(int idCell, int idTool, int count) {
        this.idCell = idCell;
        this.idTool = idTool;
        this.count = count;
    }

    @OneToOne
    @JoinColumn(name = "id_tool", referencedColumnName = "id", insertable=false, updatable=false)
    @Getter
    @Setter
    private Tool tool;
}
