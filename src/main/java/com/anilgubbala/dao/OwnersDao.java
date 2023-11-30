package com.anilgubbala.dao;

import com.anilgubbala.domain.Owners;

import java.util.List;

public interface OwnersDao {

    Owners findOwnersById(String ownerId);

    List<Owners> findAllOwnersByZipCode(String zipCode);

}
