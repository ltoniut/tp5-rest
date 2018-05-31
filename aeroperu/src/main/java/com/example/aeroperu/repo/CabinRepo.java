package com.example.aeroperu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esq.models.Cabin;

@Repository
public interface CabinRepo extends JpaRepository<Cabin, Long> {

}