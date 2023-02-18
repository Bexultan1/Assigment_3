package Phones;

import S.O.L.I.D.Info;

public abstract class Phone implements Info {
    protected int id;
    protected String color;
    protected int memorySize;
    protected String name;
    protected int price;
    public Phone(String color, int memorySize, String name ,int price,int id){
        this.color = color;
        this.name = name;
        this.memorySize = memorySize;
        this.price= price;
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public int getPrice(){
        return price;
    }
}
