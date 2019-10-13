package pl.com.sda.pokemonAndChuckNorris.movies.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MovieDatabaseController {

    private static final String LAST_SEARCH_QUERY = "lastSearchQuery";
    private final MoviesProvider moviesProvider;

    public MovieDatabaseController(@Autowired MoviesProvider moviesProvider) {
        this.moviesProvider = moviesProvider;
    }

    @GetMapping
    @RequestMapping("/showMoviesPage")
    public String showMoviesPage(Model model) {
        String searchQuery = "reich";
        List<Movie> movies = moviesProvider.getMovies(searchQuery);
        model.addAttribute("movies", movies);
        model.addAttribute("searchQuery", new SearchQuery());
        return "showMoviesPage";
    }

    @PostMapping
    @RequestMapping("/searchMoviesAction")
    public String searchMovies(@ModelAttribute SearchQuery searchQuery, Model model, HttpSession httpSession) {
        List<Movie> movies = moviesProvider.getMovies(searchQuery.getQuery());
        model.addAttribute("movies", movies);
        httpSession.setAttribute(LAST_SEARCH_QUERY, searchQuery.getQuery());
        return "showMoviesPage";
    }
}
