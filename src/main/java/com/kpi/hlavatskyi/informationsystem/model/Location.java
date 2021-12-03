package com.kpi.hlavatskyi.informationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {

    private String county;

    private String city;

    private String street;

    private String build;

}
