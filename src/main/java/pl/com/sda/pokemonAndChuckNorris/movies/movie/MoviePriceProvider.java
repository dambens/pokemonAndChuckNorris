package pl.com.sda.pokemonAndChuckNorris.movies.movie;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class MoviePriceProvider {

    private Map<String, Double> prices = new HashMap<>();

    public double getPrice(String movieId){
        if (prices.containsKey(movieId)
        ) {
            return prices.get(movieId);
        }
double generatedPrice = new Random().nextDouble() * 100;
        prices.put(movieId, generatedPrice);
        return generatedPrice;
    }
}
