package vg;
import java.util.Scanner;

import java.text.MessageFormat;
public class Creature {

    String name = new String();
    String specialty = new String();
    int health, mana, str, magic, spd, def;


    // has to be same name as class
    public Creature(String name, String specialty, int health, int mana, int str, int magic, int spd, int def){
        this.name = name;
        this.specialty = specialty;
        this.health = health;
        this.mana = mana;
        this. str = str;
        this.magic = magic;
        this.spd = spd;
        this.def = def;
    }
    public int get_def(){
        return def;
    }

    public int get_health(){
        return health;
    }

    public int get_mana(){
        return mana;
    }

    public int get_str(){
        return str;
    }

    public int get_magic(){
        return magic;
    }

    public int get_spd(){
        return spd;
    }

    public String get_name(){
        return name;
    }

    public String get_specialty(){
        return specialty;
    }


}
