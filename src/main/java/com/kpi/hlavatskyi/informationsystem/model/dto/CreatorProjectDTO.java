package com.kpi.hlavatskyi.informationsystem.model.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.sql.Date;

@Data
public class CreatorProjectDTO {

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 10, max = 50, message = "Name should be between 10 and 50 characters")
    private String name;

    @NotEmpty(message = "Price should not be empty")
    @Positive
    private Double price;

    @NotEmpty(message = "Date should not be empty")
    @FutureOrPresent
    private Date date;

    @NotEmpty(message = "Status should not be empty")
    private String status;

    @NotEmpty(message = "Country should not be empty")
    private String country;

    @NotEmpty(message = "City should not be empty")
    private String city;

    @NotEmpty(message = "Street should not be empty")
    private String street;

    @NotEmpty(message = "Build should not be empty")
    private String build;

    @NotEmpty(message = "Mayor id should not be empty")
    @Positive
    @Min(value = 1, message = "Mayor id must be greater than 1")
    private Long mayorId;

}

