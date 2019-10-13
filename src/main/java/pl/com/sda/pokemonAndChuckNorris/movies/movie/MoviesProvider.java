package pl.com.sda.pokemonAndChuckNorris.movies.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MoviesProvider {
    public MoviesProvider(@Autowired MoviePriceProvider moviePriceProvider) {
        this.moviePriceProvider = moviePriceProvider;
    }

    private MoviePriceProvider moviePriceProvider;

    private static final String MOVIE_API_URL = "http://www.omdbapi.com/?apikey=972ca649&s=";
    private static final String SEARCH_URL = "http://www.omdbapi.com/?apikey=972ca649&i=";

    public List<Movie> getMovies(String searchQuery){
        RestTemplate restTemplate = new RestTemplate();
        SearchMovieResponse forObject = restTemplate.getForObject(MOVIE_API_URL + searchQuery, SearchMovieResponse.class);

        List<Movie> search = forObject.getSearch();
        search.forEach(movie -> {
            movie.setPrice(moviePriceProvider.getPrice(movie.getImdbID()));
        });

                return search;
    }
    public Movie getMovieById(String id){
        RestTemplate restTemplate = new RestTemplate();
        Movie movie = restTemplate.getForObject(SEARCH_URL + id, Movie.class);
        return movie;
    }
}
