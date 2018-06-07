package vg;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Combat {

    Creature att_creature;
    Creature def_creature;
    int str, magic, spd;
    double att_mod;
    int opp_def;
    int opp_health;
    String opp_name, specialty, opp_spec;

    List<Double> percent_list = new ArrayList<Double>();
    Random randomizer = new Random();



    //this is the init function in python
    public Combat(Creature att_creature, Creature def_creature){
        this.att_creature = att_creature;
        this.def_creature = def_creature;
        //attacking creature stats
        this.specialty = att_creature.get_specialty();
        this.str = att_creature.get_str();
        this.magic = att_creature.get_magic();
        this.spd = att_creature.get_spd();
        this.att_mod = Math.ceil(str/10);

        //defending creature stats
        this.opp_name = def_creature.get_name();
        this.opp_spec = def_creature.get_specialty();
        this.opp_def = def_creature.get_def();

        this.opp_health = def_creature.get_health();

    }

    public double attack(){
        double damage = 0;

        //Calculate damage
        damage = Math.ceil(Math.abs(att_mod/opp_def) * str);
        System.out.println(damage);

        return damage;


    }

    public double take_damage(double damage){

        if(specialty == "Cook" && opp_spec == "Host"){
            damage = Math.round(damage * 1.3);
        }
        else if(specialty == "Host" && opp_spec == "Maintenance"){
            damage = Math.round((damage *1.3));
        }
        else if(specialty == "Maintenance" && opp_spec == "Waiter"){
            damage = Math.round(damage *1.3);
        }
        else if(specialty == "Waiter" && opp_spec == "Cook"){
            damage = Math.round(damage * 1.3);
        }
        else if(specialty == "Cook" && opp_spec == "Waiter"){
            damage = Math.round(damage * 0.7);
        }
        else if(specialty == "Host" && opp_spec=="Cook"){
            damage = Math.round(damage * 0.7);
        }
        else if(specialty == "Maintenance" && opp_spec == "Host"){
            damage = Math.round(damage * 0.7);
        }
        else if(specialty =="Waiter" && opp_spec == "Maintenance"){
            damage = Math.round(damage * 0.7);
        }
        else {
            damage = Math.round(damage);
        }
        double opp_health = this.opp_health;
        System.out.println(opp_health);
        System.out.println(damage);
        opp_health = Math.round(opp_health - damage);
        return opp_health;

    }
}
