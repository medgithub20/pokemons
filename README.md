
# Test technique PetalMD : API Restful pour gérer des Pokémons.
## Auteur : Mohamed Ragued


Ce projet est réalisé avec la plateforme `Java Spring` et le gestionnaire de projet `Maven`.  

Le contrôleur REST se trouve dans le fichier `PokemonControllerCrud.java`    
La liste paginée des Pokémons est générée par le fichier `PokemonControllerList.java`  
L'affichage de cette liste se fait avec le moteur de template `Mustache`.  

J'ai joins à ce projet une collection Postman qui contient les différents End Points REST ainsi que le End Point HTML pour la liste paginée.   
La collection Postman se trouve à la racine du projet sous le nom : `pokemons.postman_collection.json`  

Pour lancer le projet il faut :   
- se placer dans la racine du projet   
- exécuter la commande suivant pour lancer Spring Boot : `./mvnw clean spring-boot:run`  
