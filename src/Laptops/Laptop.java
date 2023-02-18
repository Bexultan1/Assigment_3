package Laptops;

import S.O.L.I.D.Info;

public abstract class Laptop implements Info {
    protected int id;
    protected String model;
    protected String name;
    protected int memorySize;
    protected String color;
    protected int price;
    public Laptop(String model,int memorySize,String color,int price, int id,String name){
        this.id = id;
        this.model = model;
        this.memorySize = memorySize;
        this.color = color;
        this.price = price;
        this.name = name;
    }

   public int getId(){
        return  id;
    }

    public int getPrice() {
        return price;
    }
}
