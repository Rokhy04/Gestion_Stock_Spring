package com.example.gestionStock.Models;


	

	import jakarta.persistence.*;
	import java.util.Objects;

	@Entity
	@Table(name = "clients")
	public class Clients {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "nom", nullable = false)
	    private String nom;

	    @Column(name = "prenom", nullable = false)
	    private String prenom;

	    @Column(name = "email", nullable = false, unique = true)
	    private String email;

	    @Column(name = "telephone")
	    private String telephone;

	    @Column(name = "adresse")
	    private String adresse;

	    // Constructeurs
	    public Clients() {
	    }

	    public Clients(String nom, String prenom, String email, String telephone, String adresse) {
	        this.nom = nom;
	        this.prenom = prenom;
	        this.email = email;
	        this.telephone = telephone;
	        this.adresse = adresse;
	    }

	    // Getters et Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getPrenom() {
	        return prenom;
	    }

	    public void setPrenom(String prenom) {
	        this.prenom = prenom;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getTelephone() {
	        return telephone;
	    }

	    public void setTelephone(String telephone) {
	        this.telephone = telephone;
	    }

	    public String getAdresse() {
	        return adresse;
	    }

	    public void setAdresse(String adresse) {
	        this.adresse = adresse;
	    }
}
