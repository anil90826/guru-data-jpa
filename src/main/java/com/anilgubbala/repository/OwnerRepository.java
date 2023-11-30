package com.anilgubbala.repository;

import com.anilgubbala.domain.Owners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owners, String> {
}
