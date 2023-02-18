package Headphones;

import S.O.L.I.D.Info;

public class Airpods extends Headphone implements Info {
    public Airpods(String model, String color, int price,int id,String name) {
        super(model, color, price,id,name);
    }
    @Override
    public String info() {
        return "ID : "+ id + " || Brand : " + model + "|| Name : " + name + " || Color : " + color +" || Price : " +price;
    }
}
