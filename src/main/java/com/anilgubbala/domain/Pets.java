package com.anilgubbala.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "dbo", name = "pets")
public class Pets {

    @Id
    private String petId;
    private String petName;
    private String petKind;
    private String petGender;
    private String petAge;
    private String ownerId;

}
