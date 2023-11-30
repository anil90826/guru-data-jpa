package com.anilgubbala.dao;

import com.anilgubbala.domain.Owners;

import java.util.List;

public interface OwnersDao {

    Owners findOwnersById(String ownerId);

    List<Owners> findAllOwnersByZipCode(String zipCode);

    List<Owners> findAllOwnersByLastName(String lastName);

    List<Owners> findAllOwnersByNameCriteria(String firstName, String lastName);

    List<Owners> findAllOwnersByNameNativeQuery(String firstName, String lastName);
}
