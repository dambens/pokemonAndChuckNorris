package pl.com.sda.pokemonAndChuckNorris.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.com.sda.pokemonAndChuckNorris.movies.user.UserService;


public class WebSecurityConfigDemo extends WebSecurityConfigurerAdapter {
}