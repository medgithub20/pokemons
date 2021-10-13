package mypokemons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class PokemonControllerList {

	  private final PokemonRepository repository;

	  PokemonControllerList(PokemonRepository repository) {
	    this.repository = repository;
	  }
	
    @GetMapping("/pokemonlist")
    public ModelAndView displayList(Map<String, Object> model) {

        List<Pokemon> pokemons = repository.findAll();
        
        model.put("pokemons", pokemons);

        return new ModelAndView("listepokemons", model);
    }
}