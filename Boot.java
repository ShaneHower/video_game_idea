package vg;

import java.util.Scanner;

import java.text.MessageFormat;

public class Boot {


    public static void main(String[] args){
        // Create creatures
        Creature attacking_creature = new Creature("blue guy", "Cook");
        Creature defending_creature = new Creature("green guy", "Waiter");

        // create combat
        Combat attacker = new Combat(attacking_creature, defending_creature);
        Combat defender = new Combat(defending_creature, attacking_creature);

        // user input
        String user_input = new String();
        System.out.println("Would you like to attack?: ");
        Scanner in = new Scanner(System.in);
        user_input = in.nextLine();

        // battle
        while(user_input != "yes") {

            // attacker attacks
            double attacker_damage = attacker.attack();
            String damage_message = MessageFormat.format("{0} took {1} damage", defending_creature.get_name(), attacker_damage);
            System.out.println(damage_message);
            double defender_remaining_health = attacker.take_damage(attacker_damage);
            String health_message = MessageFormat.format("{0} has {1} health remaining", defending_creature.get_name(), defender_remaining_health);
            System.out.println(health_message);
            System.out.println();

            // defender attacks
            double defender_damage = defender.attack();
            damage_message = MessageFormat.format("{0} took {1} damage", attacking_creature.get_name(), defender_damage);
            System.out.println(damage_message);
            double attacker_remaining_health = defender.take_damage(defender_damage);
            health_message = MessageFormat.format("{0} has {1} health remaining", attacking_creature.get_name(), attacker_remaining_health);
            System.out.println(health_message);
            System.out.println();

            System.out.println("Would you like to attack?: ");
            user_input = in.nextLine();
        }
    }
}
