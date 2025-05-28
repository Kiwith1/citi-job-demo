/**Csomagok meghívása*/
package org.example.citijobapidemo.controller;
/**Springboot és az osztályok importálása*/
import org.example.citijobapidemo.modell.Account;
import org.example.citijobapidemo.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**java importok*/
import java.net.URI;
import java.util.List;
/**Boiler plating, megkönnyíti a dolgokat*/
@RestController
@RequestMapping("/api/accounts")
/**Account controler metódusai*/
public class AccountController{
    /** konstruktor */
    private final AccountService service;
    public AccountController(AccountService service){
        this.service = service;
    }
    /** Accountokat lekéri (GET) */
    @GetMapping
    public ResponseEntity<List<Account>> getAll(){
        List<Account> accounts = service.getAll();
        return ResponseEntity.ok(accounts);
    }
    /** Id alapján lekéri az accountot (GET)*/
    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(@PathVariable Long id){
        Account account = service.getById(id);
        return ResponseEntity.ok(account);
    }
    /** Szerkesztés/létrehozás (POST)*/
    @PostMapping
    public ResponseEntity<Account> create(@RequestBody Account account){
        Account created = service.save(account);
        URI location = URI.create(String.format("/api/accounts/%s", created.getId()));
        return ResponseEntity.created(location).body(created);
    }
    /** Fiók törlése ID alapján (DELETE)*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
