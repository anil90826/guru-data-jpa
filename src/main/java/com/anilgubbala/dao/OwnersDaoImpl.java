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

    @Override
    public List<Owners> findAllOwnersByLastName(String lastName) {
        EntityManager entityManager = getEntityManager();

        try{
            TypedQuery<Owners> query = entityManager.createNamedQuery("owners_find_by_name", Owners.class)
                    .setParameter("ownerSurname", lastName);
            return query.getResultList();
        }finally {
            entityManager.close();
        }

    }

    @Override
    public List<Owners> findAllOwnersByNameCriteria(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<Owners> findAllOwnersByNameNativeQuery(String firstName, String lastName) {
        EntityManager entityManager = getEntityManager();

        try{
            Query query = entityManager.createNativeQuery("SELECT * FROM Owners o" +
                    " WHERE o.owner_name = ? AND o.owner_surname = ?", Owners.class);
            query.setParameter(1, firstName);
            query.setParameter(2, lastName);

            return query.getResultList();
        }finally {
            entityManager.close();
        }
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
