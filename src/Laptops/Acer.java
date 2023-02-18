package Laptops;

import S.O.L.I.D.Info;

public class Acer extends Laptop implements Info {
    private String model = "Acer";

    public Acer(String model,int memorySize,String color,int price,int id,String name){
        super(model,memorySize,color,price,id,name);
    }
    @Override
    public String info() {
        return "ID : "+ id + " || Brand : " + model + "|| Name : " + name + " || Color : " + color + " ||  Memory size : "+memorySize + " || Price : " +price;
    }
}
