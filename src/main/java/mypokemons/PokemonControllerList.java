package mypokemons;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PokemonControllerList {

	  private final PokemonRepository repository;

	  PokemonControllerList(PokemonRepository repository) {
	    this.repository = repository;
	  }
	
//    @GetMapping("/pokemonlist")
//    public ModelAndView displayList(Map<String, Object> model) {
//
//        List<Pokemon> pokemons = repository.findAll();
//        
//        model.put("pokemons", pokemons);
//
//        return new ModelAndView("listepokemons", model);
//    }
    
    @GetMapping("/pokemonlist")
    public ModelAndView displayListPaginated(Map<String, Object> model) {

    	int pageSize = 50;
        List<Pokemon> allPokemons = repository.findAll();
        
        int numberOfPokemons = allPokemons.size();
    	int numberOfPages = (int)Math.ceil(numberOfPokemons / (float) pageSize);
		
	    List<Integer> navigation = new ArrayList<Integer>(); 
	    for (int i = 0; i < numberOfPages; i++) { 
	    	navigation.add(i) ; // TODO  change path }
	    }
		 
    	String endPoint = "/pokemonlist/";
    	
        Pageable firstPageWithFiftyElements = PageRequest.of(0, pageSize);
    	
        Page<Pokemon> pokemons = repository.findAll(firstPageWithFiftyElements);
        
        model.put("pokemons", pokemons);
        model.put("endPoint", endPoint);
        model.put("navigation", navigation);

        return new ModelAndView("listepokemons", model);
    }
    
    
    @GetMapping("/pokemonlist/{pageNumber}")
    public ModelAndView displayListPaginated(Map<String, Object> model, @PathVariable int pageNumber) {

    	int pageSize = 50;
        List<Pokemon> allPokemons = repository.findAll();
        
        int numberOfPokemons = allPokemons.size();
    	int numberOfPages = (int)Math.ceil(numberOfPokemons / (float) pageSize);
		
	    List<Integer> navigation = new ArrayList<Integer>(); 
	    for (int i = 0; i < numberOfPages; i++) { 
	    	navigation.add(i) ; // TODO  change path }
	    }
		 
    	String endPoint = "/pokemonlist/";
    	
        Pageable requestedPage = PageRequest.of(pageNumber, pageSize);
    	
        Page<Pokemon> pokemons = repository.findAll(requestedPage);
        
        model.put("pokemons", pokemons);
        model.put("endPoint", endPoint);
        model.put("navigation", navigation);

        return new ModelAndView("listepokemons", model);
    }
}



