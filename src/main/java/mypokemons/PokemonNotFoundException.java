package mypokemons;

class PokemonNotFoundException extends RuntimeException {

  PokemonNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}