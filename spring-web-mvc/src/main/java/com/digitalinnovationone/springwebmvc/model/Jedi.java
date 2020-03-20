package com.digitalinnovationone.springwebmvc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Jedi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 10, message = "Nome deve conter entre 3 e 10 caracteres")
    @NotBlank(message = "Nome nao pode estar em branco")
    private String name;

    @NotBlank(message = "Nome nao pode estar em branco")
    private String lastName;

    public Jedi(){};

    public Jedi(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
