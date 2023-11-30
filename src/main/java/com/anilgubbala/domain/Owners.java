package com.anilgubbala.domain;


import jakarta.persistence.*;
import lombok.Data;


@NamedQueries({
        @NamedQuery(name = "owners_find_all", query = "From Owners o Where o.zipCode = :zipCode"),
        @NamedQuery(name = "owners_find_by_name", query = "From Owners o Where o.ownerSurname Like :ownerSurname")
})
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
