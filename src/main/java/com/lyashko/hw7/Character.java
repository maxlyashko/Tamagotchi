package com.lyashko.hw7;

import java.util.ArrayList;
import java.util.List;

public class Character {
    String name;
    Characters type;
    int age;
    double satiety;
    double money;
    double purity;
    double happiness;
    boolean isIll;
    List<Gift> gifts = new ArrayList<> ( );

    public Character ( String name , Characters type ) {
        this.name = name;
        this.type = type;
        age = 1;
        satiety = 100;
        money = 0;
        purity = 100;
        happiness = 50;
        isIll = false;
    }


    public void setName ( String name ) {
        this.name = name;
    }

    public void setType ( Characters type ) {
        this.type = type;
    }


    public void setAge ( int age ) {
        this.age = age;
    }

    public void setSatiety ( double satiety ) {
        this.satiety = satiety;
    }

    public void setMoney ( double money ) {
        this.money = money;
    }

    public void setPurity ( double purity ) {
        this.purity = purity;
    }

    public void setHappiness ( double happiness ) {
        this.happiness = happiness;
    }

    public void setIll ( boolean ill ) {
        isIll = ill;
    }


    @Override
    public String toString () {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", age=" + age +
                ", satiety=" + satiety +
                ", money=" + money +
                ", purity=" + purity +
                ", happiness=" + happiness +
                ", isIll=" + isIll +
                ", gifts=" + gifts +
                '}';
    }
}
