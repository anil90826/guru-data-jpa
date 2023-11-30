package com.anilgubbala.dao;

import com.anilgubbala.domain.Pets;

import java.util.List;

public interface PetsDao {

    Pets getPetsById(String id);

    Pets getPetsByName(String name, String petId);

    Pets saveNewPets(Pets pet);

    Pets updatePets(Pets pet);

    void deletePetsById(String id);

    List<Pets> getPetsByNameLike(String name);

}
