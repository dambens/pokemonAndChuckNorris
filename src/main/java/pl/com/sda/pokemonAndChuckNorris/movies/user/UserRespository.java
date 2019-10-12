package pl.com.sda.pokemonAndChuckNorris.movies.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRespository extends MongoRepository<UserDocument, String> {

}
