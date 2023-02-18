package S.O.L.I.D;

import Headphones.Airpods;
import Headphones.Headphone;
import Headphones.JBL;
import Headphones.Sony;

import java.sql.*;
import java.util.ArrayList;

public class GetHeadphones {
    private static final String USER = "postgres";
    private static final String PASS = "1234567";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    public ArrayList<Headphone> getHeadphonesFromDb(String store) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();
        ArrayList<Headphone> headphones = new ArrayList<>();
        String sql = "select * from " + store + ".headphones";
        ResultSet resultSet = statement.executeQuery(sql);
       // String model= resultSet.getString("model");
        while (resultSet.next()) {
            if(resultSet.getString("model").equalsIgnoreCase("airpods")){
                headphones.add(new Airpods("Airpods",resultSet.getString("color"),resultSet.getInt("price"),resultSet.getInt("id"),resultSet.getString("name")));
            } else if (resultSet.getString("model").equalsIgnoreCase("JBL")) {
                headphones.add(new JBL("JBL",resultSet.getString("color"),resultSet.getInt("price"),resultSet.getInt("id"),resultSet.getString("name")));
            }
            else if(resultSet.getString("model").equalsIgnoreCase("SONY")){
                headphones.add(new Sony("Sony",resultSet.getString("color"),resultSet.getInt("price"),resultSet.getInt("id"),resultSet.getString("name")));
            }
        }
        return headphones;
    }

    public ArrayList<Headphone> getHeadphonesFromDb(String store,String model) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();
        ArrayList<Headphone> headphones = new ArrayList<>();
        String sql = "select * from " + store + ".headphones where model = '" + model + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            if(resultSet.getString("model").equalsIgnoreCase("airpods")){
                headphones.add(new Airpods("Airpods",resultSet.getString("color"),resultSet.getInt("price"),resultSet.getInt("id"),resultSet.getString("name")));
            } else if (resultSet.getString("model").equalsIgnoreCase("JBL")) {
                headphones.add(new JBL("JBL",resultSet.getString("color"),resultSet.getInt("price"),resultSet.getInt("id"),resultSet.getString("name")));
            }
            else if(resultSet.getString("model").equalsIgnoreCase("SONY")){
                headphones.add(new Sony("Sony",resultSet.getString("color"),resultSet.getInt("price"),resultSet.getInt("id"),resultSet.getString("name")));
            }
        }
        return headphones;
    }
}
