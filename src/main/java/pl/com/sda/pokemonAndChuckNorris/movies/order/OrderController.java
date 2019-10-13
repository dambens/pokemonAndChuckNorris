package pl.com.sda.pokemonAndChuckNorris.movies.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.sda.pokemonAndChuckNorris.movies.movie.Movie;
import pl.com.sda.pokemonAndChuckNorris.movies.movie.MoviesProvider;
import pl.com.sda.pokemonAndChuckNorris.movies.movie.SearchQuery;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderController {
    private static final String CHART_SESSION_LIST = "chartSessionList";
    private static final String LAST_SEARCH_QUERY = "lastSearchQuery";

    private final MoviesProvider moviesProvider;

    public OrderController(@Autowired MoviesProvider moviesProvider) {
        this.moviesProvider = moviesProvider;
    }

    private List<String> getMovieListFromSessionOrEmpty(HttpSession session) {
        List<String> movieList = (List<String>) session.getAttribute(CHART_SESSION_LIST);

        if (movieList == null) {
            return new ArrayList<>();
        }
        return movieList;
    }

    @GetMapping
    @RequestMapping("/addMovieToCart/{movieId}")
    public String addMovieToCart(
            @PathVariable("movieId") String movieId,
            HttpSession httpSession,
            Model model) {

        List<String> movieListFromSessionOrEmpty = getMovieListFromSessionOrEmpty(httpSession);
        movieListFromSessionOrEmpty.add(movieId);
        httpSession.setAttribute(CHART_SESSION_LIST, movieListFromSessionOrEmpty);

        String lastSearchQuery = (String) httpSession.getAttribute(LAST_SEARCH_QUERY);
        List<Movie> movies = moviesProvider.getMovies(lastSearchQuery);

        model.addAttribute("movies", movies);
        model.addAttribute("searchQuery", new SearchQuery(lastSearchQuery));


        return "showMoviesPage";
    }

    @RequestMapping("/userCartPage")
    public String userCartPage(HttpSession httpSession, Model model) {
        List<String> movieIds = getMovieListFromSessionOrEmpty(httpSession);

        List<Movie> movies = movieIds.stream()
                .map(moviesProvider::getMovieById)
                .collect(Collectors.toList());
        double sum = movies.stream().mapToDouble(Movie::getPrice).sum();

        model.addAttribute("movieIds", movieIds);
        model.addAttribute("sum", sum);
        return "userCartPage";
    }

}
