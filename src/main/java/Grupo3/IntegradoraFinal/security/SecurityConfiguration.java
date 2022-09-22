package Grupo3.IntegradoraFinal.security;

import Grupo3.IntegradoraFinal.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsuarioService usuarioService;

//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/usuario/create/first").permitAll()
                .antMatchers("/consulta", "/consulta/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/dentista/create").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/dentista", "/dentista/**").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.PUT, "/dentista", "/dentista/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/dentista", "/dentista/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/paciente/create").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/paciente", "/paciente/**").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.PUT, "/paciente", "/paciente/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/paciente", "/paciente**").hasAnyRole("ADMIN")
                .antMatchers("/usuario","/usuario/**").hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated().and()
                //.formLogin();
                .httpBasic();
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usuarioService);
        return provider;
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
