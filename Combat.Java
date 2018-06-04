package vg;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Combat {

    Creature att_creature;
    Creature def_creature;
    int str, magic, spd;
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

        //defending creature stats
        this.opp_name = def_creature.get_name();
        this.opp_def = def_creature.get_def();
        this.opp_spec = def_creature.get_specialty();
        this.opp_health = def_creature.get_health();

        // get damage multipliers
        percent_list.add(0.3);
        percent_list.add(0.4);
        percent_list.add(0.6);
        percent_list.add(0.1);
        percent_list.add(0.2);

    }

    public float attack(){
        float damage = 0;

        int index = randomizer.nextInt(percent_list.size());
        double percent = percent_list.get(index);
        //Calculate damage
        if(specialty == "Cook"){
            damage = Math.round(Math.abs(opp_def - str) * percent);
        }
        else if(specialty == "Host"){
            damage = Math.round(Math.abs(opp_def - magic) * percent);
        }
        else if (specialty == "Waiter"){
            damage = Math.round(Math.abs(opp_def - spd) * percent);
            String report = MessageFormat.format("inside the if statement {0}", Math.abs(opp_def - spd));
            System.out.println(report);
        }
        else if(specialty == "Clean"){
            damage = Math.round(Math.abs(opp_def - str)* percent);
        }
        System.out.println(damage);
        return damage;

    }

    public float take_damage(float damage){

        if(specialty == "Cook" && opp_spec == "Host"){
            damage = Math.round(damage*1.2);
        }
        else if(specialty == "Host" && opp_spec == "Maintenance"){
            damage = Math.round(damage*1.2);
        }
        else if(specialty == "Maintenance" && opp_spec == "Waiter"){
            damage = Math.round(damage*1.2);
        }
        else if(specialty == "Waiter" && opp_spec == "Cook"){
            damage = Math.round(damage*1.2);
        }
        else if(specialty == "Cook" && opp_spec == "Waiter"){
            damage = Math.round(damage*0.8);
        }
        else if(specialty == "Host" && opp_spec=="Cook"){
            damage = Math.round(damage*0.8);
        }
        else if(specialty == "Maintenance" && opp_spec == "Host"){
            damage = Math.round(damage*0.8);
        }
        else if(specialty =="Waiter" && opp_spec == "Maintenance"){
            damage = Math.round(damage*0.8);
        }
        System.out.println(damage);
        opp_health = Math.round(opp_health - damage);
        return opp_health;

    }
}
