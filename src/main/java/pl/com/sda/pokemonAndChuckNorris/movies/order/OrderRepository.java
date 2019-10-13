package pl.com.sda.pokemonAndChuckNorris.movies.order;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderDocument, String> {

}
