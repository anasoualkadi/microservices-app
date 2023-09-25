# Projet Microservices avec Eureka Discovery Service

Ce projet est un exemple d'architecture de microservices utilisant le service de découverte Eureka, une passerelle et trois microservices métiers.

## Architecture

L'architecture du projet est composée des éléments suivants :

1. **Eureka Discovery Service** : Il s'agit du service de découverte qui maintient une liste à jour des microservices disponibles. Dispo depuis : http://localhost:8761/

2. **Gateway** : C'est le point d'entrée de toutes les requêtes. Elle est responsable de la redirection des requêtes vers les microservices appropriés. Dispo depuis : http://localhost:8888/{nom du service dans app.prop}/{chemin dans controller}
3. 
4. **Microservices métiers** : Il y a trois microservices métiers dans ce projet.

    - **Customer Service** : Ce service gère toutes les opérations liées aux clients.
    
    - **Inventory Service** : Ce service gère l'inventaire.
    
    - **Billing Service** : Ce service gère la facturation et communique avec les deux autres services en utilisant Feign.

## Utilisation de Feign

Feign est un client HTTP déclaratif qui rend l'écriture de clients HTTP plus facile. Dans ce projet, il est utilisé par le service de facturation pour communiquer avec les services client et inventaire.

## Comment démarrer

Pour démarrer ce projet, vous devez d'abord démarrer le service de découverte Eureka, puis la passerelle et enfin les microservices métiers.


