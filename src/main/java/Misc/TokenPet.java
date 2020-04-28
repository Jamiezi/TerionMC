package Misc;

import org.bukkit.Material;

public class TokenPet extends BasePet{

    public TokenPet(String displayName, Material mat, short data, int id, PetType type){
        super(displayName, mat, data);
        this.id = id;
    }




    public int getId(){
        return id;
    }

    public PetType getType(){
        return type;
    }

    public String getName(){
        return displayName;
    }

    public String toString(){
        return "ID: " + id + ", Name: " + displayName + ", Material: " + mat.toString();
    }




}
