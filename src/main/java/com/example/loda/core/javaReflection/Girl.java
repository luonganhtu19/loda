package com.example.loda.core.javaReflection;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

//@Setter
@NoArgsConstructor
@ToString
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Girl {
    @Id
    @Autowired
    private int id;
    @NonNull
    @NotBlank(message = "Name is mandatory")
    private String name;
}
