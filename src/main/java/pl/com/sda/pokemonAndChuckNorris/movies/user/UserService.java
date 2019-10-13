package pl.com.sda.pokemonAndChuckNorris.movies.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRespository userRespository;
    private ModelMapper modelMapper;

    public UserService(@Autowired UserRespository userRespository, @Autowired ModelMapper modelMapper) {
        this.userRespository = userRespository;
        this.modelMapper = modelMapper;
    }
    public Optional<String> saveUser(UserDTO userToSave){
        //todo sprawdzić czy nazwa usera istnieje
        if(userRespository.existsByUsername(userToSave.getUsername())){
            return Optional.empty();
        }
        UserDocument userDocumentToSave = modelMapper.map(userToSave, UserDocument.class);
        UserDocument savedUserDocument = userRespository.save(userDocumentToSave);
        return Optional.of(savedUserDocument.getId());
    }
    public List<UserDocument> getAllUsers(){
        return userRespository.findAll();
    }
}
