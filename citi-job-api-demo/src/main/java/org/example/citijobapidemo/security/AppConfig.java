/**Csomagok meghívása*/
package org.example.citijobapidemo.security;
/**Springboot és az osztályok importálása*/
import org.example.citijobapidemo.repo.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
/**Bean létrehozása, mert az autómatikus szkennelés nem oldotta meg magától*/
@Configuration
public class AppConfig{
    @Bean
    public AccountRepository accountRepository(EntityManager entityManager){
        JpaRepositoryFactory factory = new JpaRepositoryFactory(entityManager);
        return factory.getRepository(AccountRepository.class);
    }
}