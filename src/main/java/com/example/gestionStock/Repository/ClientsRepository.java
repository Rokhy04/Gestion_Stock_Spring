package com.example.gestionStock.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.gestionStock.Models.Clients;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
    // Méthodes personnalisées (optionnelles)
	List<Clients> findByNomContainingIgnoreCase(String nom);
}