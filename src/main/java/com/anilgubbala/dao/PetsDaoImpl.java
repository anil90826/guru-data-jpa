package com.anilgubbala.dao;

import com.anilgubbala.domain.Pets;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetsDaoImpl implements PetsDao {

    private final EntityManagerFactory entityManagerFactory;

    public PetsDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Pets getPetsById(String id) {
        return getEntityManager().find(Pets.class, id);
    }

    @Override
    public Pets getPetsByName(String name, String petId) {
        TypedQuery<Pets> query = getEntityManager().createQuery("SELECT a FROM Pets a" +
                " WHERE a.petName=:name and a.petId=:petId", Pets.class);
        query.setParameter("name", name);
        query.setParameter("petId", petId);
        return query.getSingleResult();
    }

    @Override
    public Pets saveNewPets(Pets pet) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(pet);
        em.flush();
        em.getTransaction().commit();

        return pet;
    }

    @Override
    public Pets updatePets(Pets pet) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(pet);
        em.flush();
        em.clear();
        em.getTransaction().commit();
        return pet;
    }

    @Override
    public void deletePetsById(String id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Pets pet = em.find(Pets.class, id);
        em.remove(pet);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public List<Pets> getPetsByNameLike(String name) {
        EntityManager em = getEntityManager();
        try{
            Query query = em.createQuery("SELECT a FROM Pets a WHERE a.petName LIKE :pet_name");
            query.setParameter("pet_name", name + "%");
            List<Pets> pets = query.getResultList();
            return pets;
        } finally {
            em.close();
        }
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }


}
