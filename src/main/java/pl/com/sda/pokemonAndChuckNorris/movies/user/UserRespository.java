package pl.com.sda.pokemonAndChuckNorris.movies.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRespository extends MongoRepository<UserDocument, String> {

    boolean existsByUsername(String username);

    UserDocument getById(String id);

}
