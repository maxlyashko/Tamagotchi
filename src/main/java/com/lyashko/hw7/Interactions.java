package com.lyashko.hw7;

import java.util.*;

public class Interactions {

    public static void feed ( Character character ) {

        if (character.satiety < 95) {
            character.setSatiety ( character.satiety + 5 );
        } else character.setSatiety ( 100 );

       character.setPurity ( character.purity - removeIndex ( 2 , character ) );
        if (character.purity < 0) {
            character.setPurity ( 0 );
        }
    }

    public static void play ( Character character ) {
        isIllCheck ( character );

        if (character.satiety < 3) {
            character.setSatiety ( 0 );
        } else character.setSatiety ( character.satiety - removeIndex ( 2 , character ) );

        if (character.happiness < 94) {
            character.setHappiness ( character.happiness + 6 );
        } else character.setHappiness ( 100 );

        character.setMoney ( character.money + new Random ( ).nextInt ( 1 , 10 ) );
    }

    public static void shop ( Character character ) {
        Scanner scanner = new Scanner ( System.in );
        Gift[] giftsArr = new Gift[3];
        giftsArr[0] = new Gift ( Gift.createGiftName ( ) , 100 );
        giftsArr[1] = new Gift ( Gift.createGiftName ( ) , 150 );
        giftsArr[2] = new Gift ( Gift.createGiftName ( ) , 200 );

        System.out.println ( "Select present to buy: \n 1." + giftsArr[0]
                + "\n 2." + giftsArr[1] +
                "\n 3." + giftsArr[2] );

        boolean buyPresent = false;
        while ( !buyPresent )
            switch (scanner.nextLine ( )) {
                case "1" -> {
                    character.setMoney ( character.money - 100 );
                    character.setHappiness ( character.happiness + 20 );
                    character.gifts.add ( giftsArr[0] );
                    buyPresent = true;
                }
                case "2" -> {
                    if (character.money > 150) {
                        character.setMoney ( character.money - 150 );
                        character.setHappiness ( character.happiness + 25 );
                        character.gifts.add ( giftsArr[1] );
                        buyPresent = true;
                    } else System.out.println ( "not enough money" );
                }
                case "3" -> {
                    if (character.money > 200) {
                        character.setMoney ( character.money - 200 );
                        character.setHappiness ( character.happiness + 30 );
                        character.gifts.add ( giftsArr[2] );
                        buyPresent = true;
                    } else System.out.println ( "not enough money" );
                }
                default -> System.out.println ( "wrong input" );
            }
    }

    public static void work ( Character character ) {
        isIllCheck ( character );

        if (character.age >= 5 && character.happiness >= 20) {
            character.setMoney ( character.money + new Random ( ).nextInt ( 5 , 20 ) );

            character.setSatiety ( character.satiety - removeIndex ( 4 , character ) );
            if (character.satiety < 0) {
                character.setSatiety ( 0 );
            }

            character.setHappiness ( character.satiety - removeIndex ( 2 , character ) );
            if (character.happiness < 0) {
                character.setHappiness ( 0 );
            }

        } else if (character.happiness <= 20) {
            System.out.println ( "low happiness, can`t work" );
        } else System.out.println ( "wrong age" );
    }

    public static void treatment ( Character character ) {
        if (character.money > 50) {
            character.setMoney ( character.money - 50 );
            character.setHappiness ( 10 );
            character.setSatiety ( 70 );
            character.setPurity ( 80 );
            character.isIll = false;
        } else System.out.println ( "not enough money" );
    }

    public static void isIllCheck ( Character character ) {
        int illNumber = new Random ( ).nextInt ( 1 , 10 );
        if (illNumber == 1) {
            character.setIll ( true );
        } else if (character.purity < 50) {
            if (illNumber == 2 || illNumber == 3) {
                character.setIll ( true );
            }
        }
    }

    public static double removeIndex ( double number , Character character ) {
        if (character.satiety < 50) {
            number = number * 1.5;
        } else if (character.happiness < 10) {
            number = number * 1.2;
        } else if (character.isIll) {
            number = number * 2;
        }
        return number;
    }
}
