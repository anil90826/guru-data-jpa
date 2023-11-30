package com.anilgubbala.integration;


import com.anilgubbala.dao.OwnersDao;
import com.anilgubbala.dao.PetsDao;
import com.anilgubbala.domain.Owners;
import com.anilgubbala.domain.Pets;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;


@ComponentScan(basePackages = {"com.anilgubbala.dao"})
@SpringBootTest
public class DaoIntegrationTest {

    @Autowired
    PetsDao petsDao;

    @Autowired
    OwnersDao ownersDao;

    @Test
    void testGetPet() {
        Pets pets = petsDao.getPetsById("J6-8562");
        assert(pets != null);
    }

    @Test
    void getPetByName() {
        Pets pets = petsDao.getPetsByName("Danger", "G4-8096");
        assert(pets != null);
    }

    @Test
    void testSaveNewPet() {
        Pets pets = new Pets();
        pets.setPetId("Test");
        pets.setPetGender("male");
        pets.setPetKind("testKind");
        pets.setPetName("testbame");
        pets.setOwnerId("Test");
        pets.setPetAge("23");

        Pets saved = petsDao.saveNewPets(pets);
        assert(saved != null);
    }

    @Test
    void testUpdatePet() {

        Pets pets = petsDao.getPetsById("Test");
        pets.setPetId("1234");
        pets.setPetGender("Female");
        Pets updated = petsDao.updatePets(pets);

        assert(updated != null);
    }

    @Test
    void testDeletePet() {
        Pets pets = petsDao.getPetsById("1234");
        petsDao.deletePetsById(pets.getPetId());
        Pets deleted  = petsDao.getPetsById(pets.getPetId());
        assert(deleted == null);
    }

    @Test
    void testListPetsByNameLike() {
        List<Pets> pets = petsDao.getPetsByNameLike("Biscuit");
        assert (pets != null);
        assert(pets.size() > 0);
    }

    //OWNERS

    @Test
    void testFindOwnerById() {


    }

    @Test
    void testFindAllOwnerByZipCode() {
        List<Owners> owners = ownersDao.findAllOwnersByZipCode("49503");
        assert (owners != null);
        assert (owners.size() > 0);
    }




}
