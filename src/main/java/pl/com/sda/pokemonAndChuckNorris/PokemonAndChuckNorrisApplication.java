package pl.com.sda.pokemonAndChuckNorris;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
		"pl.com.sda.pokemonAndChuckNorris.pokemon",
		"pl.com.sda.pokemonAndChuckNorris.movies"})
public class PokemonAndChuckNorrisApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(PokemonAndChuckNorrisApplication.class, args);
	}

}
