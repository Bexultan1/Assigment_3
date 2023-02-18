package Phones;

import S.O.L.I.D.Info;

public class Sumsung extends Phone implements Info {
    private String type = "Sumsung";
    public Sumsung(String color, int memorySize, String name,int price,int id) {
        super(color, memorySize, name,price,id);}

    @Override
    public String info() {
        return "ID : "+ id + " || Brand : " + type + "|| Name : " + name + " || Color : " + color + " ||  Memory size : "+memorySize + " || Price : " +price +"\n";
    }
}
