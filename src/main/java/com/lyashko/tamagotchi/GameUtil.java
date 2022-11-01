package com.lyashko.tamagotchi;

import java.util.Scanner;

public class GameUtil {

    public static void Runner () {
        Character character = new Character ( null , null );

        String start = "Choose animal: \n 1. Deer \n 2. Lion \n 3. Cat \n 4. Dog ";
        System.out.println ( start );
        setCharacterType ( character );
        setCharacterName ( character );
        characterInteractions ( character );

    }

    public static void setCharacterType ( Character character ) {
        Scanner scanner = new Scanner ( System.in );
        boolean setType = false;

        while ( !setType ) {
            switch (scanner.nextLine ( )) {
                case "1" -> {
                    character.setType ( Characters.Deer );
                    setType = true;
                }
                case "2" -> {
                    character.setType ( Characters.Lion );
                    setType = true;
                }
                case "3" -> {
                    character.setType ( Characters.Cat );
                    setType = true;
                }
                case "4" -> {
                    character.setType ( Characters.Dog );
                    setType = true;
                }
                default -> System.out.println ( "enter correct number" );
            }
        }
    }

    public static void setCharacterName ( Character character ) {
        Scanner scanner = new Scanner ( System.in );
        boolean setName = false;

        while ( !setName ) {
            System.out.println ( "Enter the name: " );
            String name = scanner.nextLine ( );
            if (name.length ( ) >= 3 && name.length ( ) <= 20) {
                character.setName ( name );
                setName = true;
            }
        }
    }

    public static void characterInteractions ( Character character ) {
        Scanner scanner = new Scanner ( System.in );
        boolean exit = false;
        int playCount = 0;
        int workCount = 0;

        while ( !exit ) {
            System.out.println ( character );
            System.out.println ( """
                    Choose interaction:\s
                     1. Feed\s
                     2. Play\s
                     3. Shop\s
                     4. Work\s
                     5. Treatment
                    or 0 to exit""" );

            switch (scanner.nextLine ( )) {
                case "1" -> Interactions.feed ( character );
                case "2" -> {
                    Interactions.play ( character );
                    playCount++;
                    if (playCount == 5) {
                        character.setAge ( character.age + 1 );
                        playCount = 0;
                    }
                }
                case "3" -> {
                    if (character.money > 100) {
                        Interactions.shop ( character );
                    } else System.out.println ("not enough money" );
                }
                case "4" -> {
                    Interactions.work ( character );
                    workCount++;
                    if(workCount == 6) {
                        character.setAge ( character.age + 1 );
                        workCount = 0;
                    }
                }
                case "5" -> Interactions.treatment ( character );
                case "0" -> exit = true;
                default -> System.out.println ( "wrong input" );
            }
        }
    }
}
