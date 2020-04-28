package Misc;

import org.bukkit.Material;

public class BasePet {
    protected String displayName;
    protected Material mat;
    protected short data;
    protected int id;
    protected PetType type;

    public BasePet(String displayName, Material mat, short data){
        this.displayName = displayName;
        this.mat = mat;
        this.data = data;
    }

}
