package com.anilgubbala.repository;

import com.anilgubbala.domain.Pets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pets, String> {
}
