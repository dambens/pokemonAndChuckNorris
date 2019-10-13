package pl.com.sda.pokemonAndChuckNorris.movies.order;

import pl.com.sda.pokemonAndChuckNorris.movies.user.UserDocument;

import java.util.Date;
import java.util.List;

public class OrderDTO {
    private String id;
    private UserDocument userDocument;
    private List<String> movies;
    private Date orderDate;

    public OrderDTO() {
    }

    public OrderDTO(String id, UserDocument userDocument, List<String> movies, Date orderDate) {
        this.id = id;
        this.userDocument = userDocument;
        this.movies = movies;
        this.orderDate = orderDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDocument getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(UserDocument userDocument) {
        this.userDocument = userDocument;
    }

    public List<String> getMovies() {
        return movies;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
