/**Csomagok meghívása*/
package org.example.citijobapidemo;
/**Springboot importok*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**Boiler plating, megkönnyíti a dolgokat*/
@SpringBootApplication
@EnableJpaRepositories("org.example.citijobapidemo.repo")
@EntityScan("org.example.citijobapidemo.modell")
/**Main függvény, lefuttatja az applikációt*/
public class CitiJobApiDemoApplication{
    public static void main(String[] args){
        SpringApplication.run(CitiJobApiDemoApplication.class, args);
    }
}
