package com.anilgubbala.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;


@NamedQuery(name = "owners_find_all", query = "From Owners o Where o.zipCode = :zipCode")
@Data
@Entity
@Table(schema = "dbo", name = "owners")
public class Owners {

    @Id
    private String ownerId;
    private String ownerName;
    private String ownerSurname;
    private String streetAddress;
    private String city;
    private String state;
    private String stateFull;
    private String zipCode;

}
