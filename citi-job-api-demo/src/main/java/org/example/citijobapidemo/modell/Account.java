/**Csomagok meghívása*/
package org.example.citijobapidemo.modell;
/**Importok*/
import jakarta.persistence.*;
import lombok.*;
/**Boiler plating, megkönnyíti a dolgokat*/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
/**Az account blueprint létrehozása, ami alapján példányokat hozhatunk létre
 * Adatok:
 *  1. id
 *  2. name
 *  3. country
 * */
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
}
