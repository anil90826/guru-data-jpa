package com.anilgubbala.dao;

import com.anilgubbala.domain.Owners;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnersDaoImpl implements OwnersDao {

    private final EntityManagerFactory entityManagerFactory;

    public OwnersDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Owners findOwnersById(String ownerId) {

        EntityManager entityManager = getEntityManager();
        try{
            TypedQuery<Owners> query = entityManager.createQuery("SELECT o FROM Owners o" +
                    " WHERE o.ownerId = :ownerId", Owners.class);
            query.setParameter("ownerId", ownerId);
            Owners owners =  query.getSingleResult();
            return owners;
        }finally {
            entityManager.close();
        }


    }

    @Override
    public List<Owners> findAllOwnersByZipCode(String zipCode) {

        EntityManager entityManager = getEntityManager();
        try{
            TypedQuery<Owners> query = entityManager.createNamedQuery("owners_find_all", Owners.class)
                    .setParameter("zipCode", zipCode);
            return query.getResultList();
        }finally {
            entityManager.close();
        }
    }


    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
