/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author adral
 */
public class DateFormatException extends Exception{
    
    public DateFormatException(){
        
    }
    public String getMessage(){
        return "format de date invalide veuillez respecter jj/MM/AAAA";
    }
    
}
