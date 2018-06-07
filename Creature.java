package vg;

import java.util.*;

public class Creature {

    String name = new String();
    String specialty = new String();
    int health, mana, magic, spd, str, def, luck;

    StatsGenerator new_generator = new StatsGenerator();
    HashMap<String, HashMap<String, Integer>> creature_stats = new_generator.allocate_stats();

    // has to be same name as class
    public Creature(String name, String specialty){
        this.name = name;
        this.specialty = specialty;
        System.out.println(creature_stats);

    }


    public int get_def(){
        HashMap<String, Integer> stats = creature_stats.get(specialty);
        def = stats.get("def");
        return def;
    }

    public int get_health(){
        return health;
    }

    public int get_mana(){
        return mana;
    }

    public int get_str(){
        HashMap<String, Integer> stats = creature_stats.get(specialty);
        str = stats.get("str");
        return str;
    }

    public int get_magic(){
        HashMap<String, Integer> stats = creature_stats.get(specialty);
        def = stats.get("mag");
        return magic;
    }

    public int get_spd(){
        HashMap<String, Integer> stats = creature_stats.get(specialty);
        def = stats.get("spd");
        return spd;
    }

    public int get_luck(){
        HashMap<String, Integer> stats = creature_stats.get(specialty);
        luck = stats.get("luck");
        return luck;
    }
    public String get_name(){
        return name;
    }

    public String get_specialty(){
        return specialty;
    }


}
