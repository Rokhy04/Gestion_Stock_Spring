package com.example.gestionStock.Controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionStock.Models.Clients;
import com.example.gestionStock.Service.ClientsService;



@RestController
@RequestMapping("/api/clients")
public class ClientsController {
	private final ClientsService ClientsService;

    public ClientsController(ClientsService clientsService) {
        this.ClientsService=clientsService;
}

 // Créer un nouvel article
    @PostMapping
    public ResponseEntity<Clients> créerClients(@RequestBody Clients clients) {
        Clients nouvelclients = ClientsService.créerclients(clients);
        return new ResponseEntity<>(nouvelclients, HttpStatus.CREATED);
    }
    // Obtenir tous les articles
    @GetMapping
    public ResponseEntity<List<Clients>> listerClients() {
        List<Clients> articles = ClientsService.listerClients();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
    // Obtenir un article par ID
    @GetMapping("/{id}")
    public ResponseEntity<Clients> trouverClientParId(@PathVariable("id") Long id) {

        return ClientsService.trouverParId(id)
                .map(article -> new ResponseEntity<>(article, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
 // Mettre à jour un article
    @PutMapping("/{id}")
    public ResponseEntity<Clients> mettreAJourClients(@PathVariable("id") Long id, @RequestBody Clients clients) {
        try {
            Clients clientsMisAJour = ClientsService.mettreAJourClients(id, clients);
            return new ResponseEntity<>(clientsMisAJour, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer un article
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerClients(@PathVariable("id") Long id) {
        ClientsService.supprimerClients(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}