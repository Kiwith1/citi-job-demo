/**Csomagok meghívása*/
package org.example.citijobapidemo.exception;
/**Hibaosztály, amely a nem talált accountokat kezeli*/
public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message){
        super(message);
    }
}
