/**Csomagok meghívása*/
package org.example.citijobapidemo.repo;
/**Springboot és az osztályok importálása*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.citijobapidemo.modell.Account;
/**Interfész létrehozása, ami összeköt az applikációt és adatbázist*/
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{};