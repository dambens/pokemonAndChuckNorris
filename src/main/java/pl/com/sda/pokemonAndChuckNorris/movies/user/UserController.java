package pl.com.sda.pokemonAndChuckNorris.movies.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    @RequestMapping("/registerPage")
    public String registerUserPage(Model model){
        model.addAttribute("newUser", new UserDTO());
        return "registerPage";
    }

    @PostMapping
    @RequestMapping("/registerAction")
    public String registerUserAction(@ModelAttribute("newUser") UserDTO userDTO){
        userService.saveUser(userDTO);
        return "registerUserSuccess";
    }
    /*
    public String saveUser(UserDTO userDTO){
        userService.saveUser(userDTO);
        return "registerUserSuccess";
    }*/
}
