package com.lyashko.hw7;

import java.util.Random;

public class Gift {
    String name;
    int price;

    public Gift ( String name , int price ) {
        this.name = name;
        this.price = price;
    }

    public static String createGiftName () {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @Override
    public String toString () {
        return "Gift{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
