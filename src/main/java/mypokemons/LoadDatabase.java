package mypokemons;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opencsv.CSVReader;

@Configuration
class LoadDatabase {

	private static final String csv_path = "pokemon.csv";
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(PokemonRepository repository) {

    return args -> {
    	System.out.println("++++++++++++++++++++");
    	String  aff = readAllExample();
    	System.out.println(aff);
    	System.out.println("++++++++++++++++++++");
    	readAllExample2();
    	System.out.println("++++++++++++++++++++");
    	String  aff2 = oneByOneExample();
    	System.out.println(aff2);
    	System.out.println("**********************************************");
      //log.info("Preloading " + repository.save(new Pokemon("Bilbo Baggins", "burglar")));
      //log.info("Preloading " + repository.save(new Pokemon("Frodo Baggins", "thief")));
    	
	    Reader reader = Files.newBufferedReader(Paths.get(
	  	      ClassLoader.getSystemResource(csv_path).toURI()));
  	    List<String[]> xx = readAll(reader);
  	    xx.remove(0);
  	    for (String[] x:xx) {
  	    	log.info("Preloading " + repository.save(new Pokemon(x[1], x[2], x[3], Integer.parseInt(x[4]), Integer.parseInt(x[5]), Integer.parseInt(x[6]), Integer.parseInt(x[7]), Integer.parseInt(x[8]), Integer.parseInt(x[9]), Integer.parseInt(x[10]), Integer.parseInt(x[11]), Boolean.parseBoolean(x[12]))));
  	    	//System.out.println(Arrays.toString(x));
  	    }
    };
  }
  
  
  public List<String[]> readAll(Reader reader) throws Exception {
	    CSVReader csvReader = new CSVReader(reader);
	    List<String[]> list = new ArrayList<>();
	    list = csvReader.readAll();
	    reader.close();
	    csvReader.close();
	    return list;
	}
  
  public String readAllExample() throws Exception {
	    Reader reader = Files.newBufferedReader(Paths.get(
	      ClassLoader.getSystemResource(csv_path).toURI()));
	    return readAll(reader).toString();
	}
  public void readAllExample2() throws Exception {
	    Reader reader = Files.newBufferedReader(Paths.get(
	      ClassLoader.getSystemResource(csv_path).toURI()));
	    List<String[]> xx = readAll(reader);
	    for (String[] x:xx) System.out.println(Arrays.toString(x));
	}
  
  public List<String[]> oneByOne(Reader reader) throws Exception {
	    List<String[]> list = new ArrayList<>();
	    CSVReader csvReader = new CSVReader(reader);
	    String[] line;
	    while ((line = csvReader.readNext()) != null) {
	        list.add(line);
	    }
	    reader.close();
	    csvReader.close();
	    return list;
	}
  public String oneByOneExample() throws Exception {
	    Reader reader = Files.newBufferedReader(Paths.get(
	      ClassLoader.getSystemResource(csv_path).toURI()));
	    return oneByOne(reader).toString();
	}
}