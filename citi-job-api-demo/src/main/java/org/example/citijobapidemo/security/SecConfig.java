/**Csomagok meghívása*/
package org.example.citijobapidemo.security;
/**Springboot*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
/**CSRF kikapcsolása, autentikáció bekapcsolása (user, password)*/
@Configuration
public class SecConfig{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeHttpRequests(auth->auth.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
