package Headphones;

import S.O.L.I.D.Info;

public abstract class Headphone implements Info {
    protected String model;
    protected String color;
    protected int price;
    protected int id;
    protected String name;

    protected Headphone(String model, String color, int price , int id,String name) {
        this.model = model;
        this.color = color;
        this.price = price;
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public int getPrice(){
        return price;
    }

}
