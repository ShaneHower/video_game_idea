package vg;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class StatsGenerator {
    HashMap<String, Integer> stats = new HashMap<String, Integer>();
    List<Integer> random_numbers = new ArrayList<>();
    List<Integer> choose_stats = new ArrayList<>();




    public List generate(){
        Random rand = new Random();
        for(int i = 0; i < 5; i++){

            for (int j = 0; j < 4; j++) {
                // randomly generate a number from 1-6
                int n = rand.nextInt(6) + 1;
                random_numbers.add(n);
            }
            // get minimum of the list and remove it
            int lowest = random_numbers.indexOf(Collections.min(random_numbers));
            random_numbers.remove(random_numbers.get(lowest));

            // sum the elements of the list
            int sum = random_numbers.stream().mapToInt(Integer::intValue).sum();
            choose_stats.add(sum);

            // clear all elements from the list
            random_numbers.clear();
        }

        return choose_stats;
    }

    public HashMap allocate_stats(){
        StatsGenerator new_stat = new StatsGenerator();
        choose_stats = new_stat.generate();

        HashMap<String, HashMap<String, Integer>> creature_type = new HashMap<>();
        List<String> type_name = new ArrayList<>();
        List<String> cook_stat = new ArrayList<>();
        List<String> host_stat = new ArrayList<>();
        List<String> maint_stat = new ArrayList<>();
        List<String> waiter_stat = new ArrayList<>();

        cook_stat.add("str");
        cook_stat.add("luck");
        cook_stat.add("def");
        cook_stat.add("spd");
        cook_stat.add("mag");

        host_stat.add("mag");
        host_stat.add("spd");
        host_stat.add("luck");
        host_stat.add("def");
        host_stat.add("str");

        maint_stat.add("def");
        maint_stat.add("str");
        maint_stat.add("spd");
        maint_stat.add("luck");
        maint_stat.add("mag");

        waiter_stat.add("spd");
        waiter_stat.add("luck");
        waiter_stat.add("mag");
        waiter_stat.add("str");
        waiter_stat.add("def");

        type_name.add("Cook");
        type_name.add("Waiter");
        type_name.add("Maintenance");
        type_name.add("Host");

        Collections.sort(choose_stats);
        Collections.reverse(choose_stats);

        // this loop runs through type name of the creature makes a new entry in the hashmap and creates
        // the hashmap key that the choose_stats variables are uploaded to. the order is determined by the
        // "type_creature_stat" list we use. (example Host = host_stat)
        for(String i: type_name){
            int index = 0;
            if(i=="Cook") {
                creature_type.put(i, new HashMap<String, Integer>());
                for (String j : cook_stat) {
                    creature_type.get(i).put(j, choose_stats.get(index));
                    index += 1;
                }
            }
            else if (i == "Host"){
                creature_type.put(i, new HashMap<String, Integer>());
                for (String j : host_stat) {
                    creature_type.get(i).put(j, choose_stats.get(index));
                    index += 1;
                }

            }

            else if(i == "Maintenance") {
                creature_type.put(i, new HashMap<String, Integer>());
                for (String j : maint_stat) {
                    creature_type.get(i).put(j, choose_stats.get(index));
                    index += 1;
                }

            }
            else if(i == "Waiter"){
                creature_type.put(i, new HashMap<String, Integer>());
                for (String j : waiter_stat) {
                    creature_type.get(i).put(j, choose_stats.get(index));
                    index += 1;
                }
            }

        }

        return creature_type;

    }
}
