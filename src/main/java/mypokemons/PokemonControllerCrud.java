package mypokemons;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.fluttercode.datafactory.impl.DataFactory;

@RestController
class PokemonControllerCrud {

	private final PokemonRepository repository;

	PokemonControllerCrud(PokemonRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/pokemons")
	List<Pokemon> all() {
		return repository.findAll();
	}

	
	
	@PostMapping("/pokemons")
	Pokemon newPokemon(@RequestBody Pokemon newPokemon) {
		return repository.save(newPokemon);
	}

	// Single item

	@GetMapping("/pokemon/{id}")
	Pokemon one(@PathVariable Long id) {

		return repository.findById(id).orElseThrow(() -> new PokemonNotFoundException(id));
	}

	@PutMapping("/pokemon/{id}")
	Pokemon replacePokemon(@RequestBody Pokemon newPokemon, @PathVariable Long id) {

		return repository.findById(id).map(pokemon -> {
			pokemon.setName(newPokemon.getName());
			pokemon.setType1(newPokemon.getType1());
			pokemon.setType2(newPokemon.getType2());
			pokemon.setTotal(newPokemon.getTotal());
			pokemon.setHp(newPokemon.getHp());
			pokemon.setAttack(newPokemon.getAttack());
			pokemon.setDefense(newPokemon.getDefense());
			pokemon.setSpatk(newPokemon.getSpatk());
			pokemon.setSpdef(newPokemon.getSpdef());
			pokemon.setSpeed(newPokemon.getSpeed());
			pokemon.setGeneration(newPokemon.getGeneration());
			pokemon.setLegendary(newPokemon.getLegendary());
			return repository.save(pokemon);
		}).orElseGet(() -> {
			newPokemon.setId(id);
			return repository.save(newPokemon);
		});
	}

	@DeleteMapping("/pokemon/{id}")
	void deletePokemon(@PathVariable Long id) {
		repository.deleteById(id);
	}

}