package Markets;

import Headphones.Headphone;
import Laptops.Laptop;
import Phones.Phone;
import S.O.L.I.D.GetHeadphones;
import S.O.L.I.D.GetLaptops;
import S.O.L.I.D.GetPhones;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Market {
    protected String MarketName;
    private ArrayList<Laptop> laptops;
    private ArrayList<Headphone> headphones;
    private ArrayList<Phone> phones;
    public Market(){}
    public ArrayList<Phone> getPhones() throws SQLException {
        GetPhones getPhones = new GetPhones();
        return getPhones.getPhonesFromDb(this.getMarketName());
    }
    public ArrayList<Phone> getPhones(String model) throws SQLException {
        GetPhones getPhones = new GetPhones();
        return getPhones.getPhonesFromDb(MarketName,model);
    }


    public ArrayList<Laptop> getLaptops() throws SQLException{
        GetLaptops getLaptops = new GetLaptops();
        return getLaptops.getLaptopsFromDb(MarketName);
    }

    public ArrayList<Laptop> getLaptops(String model) throws SQLException{
        GetLaptops getLaptops = new GetLaptops();
        return getLaptops.getLaptopsFromDb(MarketName,model);
    }
    public String getMarketName(){
        return MarketName;
    }


    public ArrayList<Headphone> getHeadphones() throws SQLException{
        GetHeadphones getHeadphones = new GetHeadphones();
        return getHeadphones.getHeadphonesFromDb(MarketName);
    }

    public ArrayList<Headphone> getHeadphones(String model) throws SQLException{
        GetHeadphones getHeadphones = new GetHeadphones();
        return getHeadphones.getHeadphonesFromDb(MarketName,model);
    }
}
