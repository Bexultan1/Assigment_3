package S.O.L.I.D;

import Laptops.Acer;
import Laptops.Laptop;
import Laptops.Lenovo;
import Laptops.MacBook;
import Phones.Iphone;
import Phones.Oppo;
import Phones.Phone;
import Phones.Sumsung;

import java.sql.*;
import java.util.ArrayList;

public class GetLaptops {
    private static final String USER = "postgres";
    private static final String PASS = "1234567";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    public ArrayList<Laptop> getLaptopsFromDb(String store) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();
        ArrayList<Laptop> laptops = new ArrayList<>();
        String sql = "select * from " + store + ".laptops";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            if (resultSet.getString("model").equalsIgnoreCase("acer")) {
                laptops.add(new Acer(resultSet.getString("model"), resultSet.getInt("memory_size"), resultSet.getString("color"), resultSet.getInt("price"), resultSet.getInt("id"), resultSet.getString("name")));
            } else if (resultSet.getString("model").equalsIgnoreCase("macbook")) {
                laptops.add(new MacBook(resultSet.getString("model"), resultSet.getInt("memory_size"), resultSet.getString("color"), resultSet.getInt("price"), resultSet.getInt("id"),resultSet.getString("name")));
            }else if (resultSet.getString("model").equalsIgnoreCase("Lenovo")) {
                laptops.add(new Lenovo(resultSet.getString("model"), resultSet.getInt("memory_size"), resultSet.getString("color"), resultSet.getInt("price"), resultSet.getInt("id"),resultSet.getString("name")));
            }
        }
        return laptops;
    }


    public ArrayList<Laptop> getLaptopsFromDb(String store, String model) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();
        ArrayList<Laptop> laptops = new ArrayList<>();
        String sql = "select * from " + store + ".laptops where model = '" + model + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            if (resultSet.getString("model").equalsIgnoreCase("acer")) {
                laptops.add(new Acer(resultSet.getString("model"), resultSet.getInt("memory_size"), resultSet.getString("color"), resultSet.getInt("price"), resultSet.getInt("id"), resultSet.getString("name")));
            } else if (resultSet.getString("model").equalsIgnoreCase("macbook")) {
                laptops.add(new MacBook(resultSet.getString("model"), resultSet.getInt("memory_size"), resultSet.getString("color"), resultSet.getInt("price"), resultSet.getInt("id"), resultSet.getString("name")));
            } else if (resultSet.getString("model").equalsIgnoreCase("Lenovo")) {
                laptops.add(new Lenovo(resultSet.getString("model"), resultSet.getInt("memory_size"), resultSet.getString("color"), resultSet.getInt("price"), resultSet.getInt("id"), resultSet.getString("name")));
            }
        }
        return laptops;
    }
}
