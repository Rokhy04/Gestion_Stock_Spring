 
package com.example.gestionStock.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gestionStock.Models.Clients;
import com.example.gestionStock.Repository.ClientsRepository;


@Service
public class ClientsService   {
	private final ClientsRepository clientsRepository;

    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    
    }
        public Clients créerclients(Clients clients) {
            return clientsRepository.save(clients);
        }

        public Optional<Clients> trouverParId(Long id) {
            return clientsRepository.findById(id);
        }

        public List<Clients> listerClients() {
            return clientsRepository.findAll();
        }

        
        public Clients mettreAJourClients(Long id, Clients article) {
                Optional<Clients> articleExistant = clientsRepository.findById(id);
                if (articleExistant.isPresent()) {
                    article.setId(id);
                    return clientsRepository.save(article);
                }
                throw new RuntimeException("Article introuvable.");
            }

        
        public void supprimerClients(Long id) {
            clientsRepository.deleteById(id);
        }
		
	    public Optional<Clients> findById(Long id) {
	        return clientsRepository.findById(id); // Utilise la méthode fournie par JpaRepository
	    }
    


}
	