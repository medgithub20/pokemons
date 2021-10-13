
# Test technique PetalMD : API Restful pour gérer des Pokémons.
## Auteur : Mohamed Ragued


Ce projet est realisé avec la plateforme **Java Spring** et le gestionnaire de projet **Maven**.

Le controlleur REST se trouve dans le fichier PokemonControllerCrud.java
La liste paginée des Pokémons est générée par le fichier PokemonControllerList.java
L'affichage de cette liste se fait avec le moteur de template Mustache.

J'ai joint à ce projet une collection Postman qui contient les differents End Points REST ainsi que le End Point HTML pour la liste paginée.

Pour lancer le projet il faut : 
- se placer dans la racine du projet 
- executer la commande suivant pour lancer Spring Boot : `./mvnw clean spring-boot:run`