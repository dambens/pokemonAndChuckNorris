package pl.com.sda.pokemonAndChuckNorris.movies.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRespository userRespository;
    private ModelMapper modelMapper;

    public UserService(@Autowired UserRespository userRespository, @Autowired ModelMapper modelMapper) {
        this.userRespository = userRespository;
        this.modelMapper = modelMapper;
    }
    public String saveUser(UserDTO userToSave){
        //todo sprawdzić czy nazwa usera istnieje
        UserDocument userDocumentToSave = modelMapper.map(userToSave, UserDocument.class);
        UserDocument savedUserDocument = userRespository.save(userDocumentToSave);
        return savedUserDocument.getId();
    }
}
