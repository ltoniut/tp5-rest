package com.example.aeroperu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esq.models.Offer;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Long> {

}