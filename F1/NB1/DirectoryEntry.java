/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package F1.NB1;

/**
 *
 * @author bfelt
 */
public class DirectoryEntry {
    
    public String name;
    public String number;
    
    public DirectoryEntry(String name, String number){
        this.name=name;
        this.number=number;
    }
    @Override
    //Lägg till koden för equals här
    public boolean equals(Object entity){
        if(!(entity instanceof DirectoryEntry)){
            return false;
        }
        DirectoryEntry directoryEntry = (DirectoryEntry)entity;
        return directoryEntry.name.equals(this.name);
    }
}
