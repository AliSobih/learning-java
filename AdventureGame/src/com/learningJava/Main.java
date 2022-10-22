package com.learningJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, Location> locations = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // variables
        int location = 1;
        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "you are sitting in front of a computer learning java",tempExit));


        tempExit = new HashMap<>();
        //add exits for location 1
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        // end adding exits for location 1
        locations.put(1, new Location(1, "you are standing at the end of a road before small brick building",tempExit));

        tempExit = new HashMap<>();
        // add exits for location 2
        tempExit.put("N", 5);
        //end adding exits for location 2
        locations.put(2, new Location(2, "your are at the top of a hill",tempExit));

        tempExit = new HashMap<>();
        // add exits for location 3
        tempExit.put("W", 1);
        //end adding exits for location 3
        locations.put(3, new Location(3, "you are inside a building, a well house for a small spring",tempExit));

        tempExit = new HashMap<>();
        // add exits for location 4
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        //end adding exits for location 4
        locations.put(4, new Location(4, "you are in a valley beside a stream",tempExit));

        tempExit = new HashMap<>();
        // add exits for location 5
        tempExit.put("S", 1);
        tempExit .put("W", 2);
        //end adding exits for location 5
        locations.put(5, new Location(5, "you are in the forest",tempExit));

        // make map for direction
        Map<String,String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","s");
        vocabulary.put("WEST","W");
        vocabulary.put("EAST","E");


        // print the location description
        System.out.println(locations.get(location).getDescription());

        while (true){
            // take the exits for the location
            Map<String, Integer> exits = locations.get(location).getExits();

            System.out.println("Available exits are ");
            //print the available exits
            exits.forEach((key, value) -> System.out.print(key + ", "));
            System.out.println();

            // input the moving direction
            String direction = scanner.nextLine().toUpperCase();

            //to search for the direction in input line and agnor other words
            if(direction.length() > 1){
                String[] words = direction.split(" ");
                for(String word: words){
                    if(vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);
                        break;
                    }//end nested if
                }//end for
            }//end if

            //check if the direction in the exits of location or not
            if(exits.containsKey(direction)){
                location = exits.get(direction);// move to another location if true
            }else {// Stand in the same place
                System.out.println("you enter wrong value");
                continue;
            }

            // print the location description
            System.out.println(locations.get(location).getDescription());

            //check for endgame
            if(location == 0){
                System.out.println("End of our game");
                // endgame
                break;
            }
        }


    }//end Main method
}
