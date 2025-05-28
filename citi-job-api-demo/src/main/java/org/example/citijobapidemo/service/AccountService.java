/**Csomagok meghívása*/
package org.example.citijobapidemo.service;
/**Springboot és az osztályok importálása*/
import org.example.citijobapidemo.exception.AccountNotFoundException;
import org.example.citijobapidemo.modell.Account;
import org.example.citijobapidemo.repo.AccountRepository;
import org.springframework.stereotype.Service;
/**java importok*/
import java.util.List;
/**Feladatok ellátása*/
@Service
public class AccountService{
    /**Példány változó létrehozása*/
    private final AccountRepository repository;
    public AccountService(AccountRepository repository){
        this.repository = repository;
    }
    /**Lekéri az adatbázis összes adatát */
    public List<Account> getAll(){
        return repository.findAll();
    }
    /**Lekéri az adott ID-hez tartozó fiókot, ha nincs a hibakezelés akcióba lép*/
    public Account getById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id));
    }
    /**Ment vagy frissít egy fiókot*/
    public Account save(Account account){
        return repository.save(account);
    }
    /**Törli a megadott ID-hez tartozó fiókot*/
    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new AccountNotFoundException("Account not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
