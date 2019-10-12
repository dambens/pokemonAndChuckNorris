package pl.com.sda.pokemonAndChuckNorris.movies.movie;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchMovieResponse {

    private String totalResults;

    @JsonProperty("Search")
    private List<Movie> search;

    @JsonProperty("Response")
    private String response;

    public SearchMovieResponse() {
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<Movie> getSearch() {
        return search;
    }

    public void setSearch(List<Movie> search) {
        this.search = search;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
