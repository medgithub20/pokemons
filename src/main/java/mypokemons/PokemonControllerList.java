package mypokemons;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class PokemonControllerList {

	  private final PokemonRepository repository;

	  PokemonControllerList(PokemonRepository repository) {
	    this.repository = repository;
	  }
	
    @GetMapping("/pokemonlist")
    public ModelAndView displayArticle(Map<String, Object> model) {

        List<Pokemon> pokemons = repository.findAll();
        
        model.put("pokemons", pokemons);

        return new ModelAndView("listepokemons", model);
    }
}