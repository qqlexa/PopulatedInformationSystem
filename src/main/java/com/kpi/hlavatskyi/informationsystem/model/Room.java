package com.kpi.hlavatskyi.informationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Room {

    private String name;

    private Integer numberRows;

    private Integer numberSeats;

}
