package S.O.L.I.D;

import Phones.Iphone;
import Phones.Oppo;
import Phones.Phone;
import Phones.Sumsung;

import java.sql.*;
import java.util.ArrayList;

public class GetPhones {
    private static final String USER = "postgres";
    private static final String PASS = "1234567";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    public ArrayList<Phone> getPhonesFromDb(String store) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();
        ArrayList<Phone> phones = new ArrayList<>();
        String sql = "select * from " + store + ".phones";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            if (resultSet.getString("model").equalsIgnoreCase("Oppo")) {
                phones.add(new Oppo(resultSet.getString("color"), resultSet.getInt("memory_size"), resultSet.getString("name"), resultSet.getInt("memory_size"), resultSet.getInt("id")));
            } else if (resultSet.getString("model").equalsIgnoreCase("Sumsung")) {
                phones.add(new Sumsung(resultSet.getString("color"), resultSet.getInt("memory_size"), resultSet.getString("name"), resultSet.getInt("memory_size"), resultSet.getInt("id")));
            } else if (resultSet.getString("model").equalsIgnoreCase("Iphone")) {
                phones.add(new Iphone(resultSet.getString("color"), resultSet.getInt("memory_size"), resultSet.getString("name"), resultSet.getInt("memory_size"), resultSet.getInt("id")));
            }
        }
        return phones;
    }

    public ArrayList<Phone> getPhonesFromDb(String store,String model) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();
        ArrayList<Phone> phones = new ArrayList<>();
        String sql = "select * from " + store + ".phones where model = '" + model + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            if (resultSet.getString("model").equalsIgnoreCase("Oppo")) {
                phones.add(new Oppo(resultSet.getString("color"), resultSet.getInt("memory_size"), resultSet.getString("name"), resultSet.getInt("price"), resultSet.getInt("id")));
            } else if (resultSet.getString("model").equalsIgnoreCase("Sumsung")) {
                phones.add(new Sumsung(resultSet.getString("color"), resultSet.getInt("memory_size"), resultSet.getString("name"), resultSet.getInt("price"), resultSet.getInt("id")));
            } else if (resultSet.getString("model").equalsIgnoreCase("Iphone")) {
                phones.add(new Iphone(resultSet.getString("color"), resultSet.getInt("memory_size"), resultSet.getString("name"), resultSet.getInt("price"), resultSet.getInt("id")));
            }
        }
        return phones;
    }
}
