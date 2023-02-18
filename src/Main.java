import Headphones.Headphone;
import Laptops.Laptop;
import Markets.Market;
import Phones.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final User user = new User();
    private static final String USER = "postgres";
    private static final String PASS = "1234567";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Statement statement;

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Main() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {
        boolean running = true;

        Market Alser = new Market("alser");
        Market Mechta = new Market("mechta");
        Market Tehnodom = new Market("tehnodom");

        System.out.println("Welcome to the our marketplace \"Ozimiz Goi\"!");
        System.out.print("Please enter your name : ");
        user.setName(in.next());
        System.out.print("Now , enter your balance : ");
        user.setBalance(in.nextInt());
        System.out.println("Your data was entered. Enjoy with shopping, " + user.getName() + "!");
        while (running) {
            System.out.println("Now , Choose the market : ");
            System.out.println("0. Exit\n1. Alser\n2. Mechta\n3. Tehnodom\n4. Top up my balance");
            int market = in.nextInt();
            if (market == 0) {
                System.out.println("Goodbye!");
                return;
            }
            switch (market) {
                case 1 -> menu(Alser);
                case 2 -> menu(Mechta);
                case 3 -> menu(Tehnodom);
                case 4 -> {
                    System.out.print("Do you have " + user.getBalance() + " dollars, how much do you want to fill it with?");
                    int cash = in.nextInt();
                    user.setBalance(user.getBalance() + cash);
                    System.out.println("The money has been successfully deposited into your account!");
                }

                default -> {
                }
            }
        }
    }

    public static void menu(Market market) throws SQLException {
        System.out.println("What kind of electronic thing u wanna buy?\nIn our shop we have : \n1. Phones\n2. Headphones\n3. Laptops\n0. If you wanna leave");
        int n = in.nextInt();
        while (n > 3 || n < 0) {
            System.out.print("Please, choose the correct one: ");
            n = in.nextInt();
        }
        if (n == 0) {
            return;
        }
        System.out.println("What type you wanna see?");
        if (n == 1) {
            System.out.println("1. Sumsung\n2. Oppo\n3. Iphone\n4. See all\n\n0. Leace");
            int choose = in.nextInt();
            while (choose < 0 || choose > 4) {
                System.out.print("Please, choose the correct variant :");
                choose = in.nextInt();
            }
            ArrayList<Phone> phones;
            if (choose == 1) {
                phones = market.getPhones("Sumsung");
            } else if (choose == 2) {
                phones = market.getPhones("Oppo");
            } else if (choose == 3) {
                phones = market.getPhones("Iphone");
            } else {
                phones = market.getPhones();
            }
            for (Phone phone : phones) {
                System.out.print(phone.info());
            }
            System.out.print("Choose the id of phone : ");
            int id = in.nextInt();
            for (Phone phone : phones) {
                if (phone.getId() == id) {
                    if (user.getBalance() >= phone.getPrice()) {
                        user.setBalance(user.getBalance() - phone.getPrice());
                        System.out.println("Phone was succesfully bought!");
                        System.out.println("You have "+user.getBalance()+" dollars left");
                        String sql = "delete FROM " + market.getMarketName() + ".phones WHERE id = " + phone.getId();
                        statement.executeUpdate(sql);
                        return;
                    } else {
                        System.out.println("You have not enough money!");
                        return;
                    }
                }
            }
        }
        if (n == 2) {
            System.out.println("1. Airpods\n2. Sony\n3. JBL\n4. See all");
            int choose = in.nextInt();
            ArrayList<Headphone> headphones;
            if (choose == 1) headphones = market.getHeadphones("Airpods");
            else if (choose == 2) headphones = market.getHeadphones("Sony");
            else if (choose == 3) headphones = market.getHeadphones("JBL");
            else headphones = market.getHeadphones();

            for (Headphone headphone : headphones) {
                System.out.println(headphone.info());
            }
            System.out.print("Choose the id of headphone : ");
            int id = in.nextInt();
            for (Headphone headphone : headphones) {
                if (headphone.getId() == id) {
                    if (user.getBalance() >= headphone.getPrice()) {
                        System.out.println("Headphone was succesfully bought!");
                        System.out.println("You have "+user.getBalance()+" dollars left");
                        String sql = "delete FROM " + market.getMarketName() + ".headphones WHERE id = " + headphone.getId();
                        statement.executeUpdate(sql);
                        user.setBalance(user.getBalance() - headphone.getPrice());
                        return;
                    } else {
                        System.out.println("You not have not enough money!");
                        return;
                    }
                }
            }
            System.out.println("Headphone was not found");
        }
        if (n == 3) {
            System.out.println("1. Acer\n2. Lenovo\n3. Macbook\n4. See all ");
            int choose = in.nextInt();
            ArrayList<Laptop> laptops;
            if (choose == 1) laptops = market.getLaptops("Acer");
            else if (choose == 2) laptops = market.getLaptops("Lenovo");
            else if (choose == 3) laptops = market.getLaptops("Macbook");
            else laptops = market.getLaptops();
            for (Laptop laptop : laptops) {
                System.out.println(laptop.info());
            }
            System.out.print("Choose the id : ");
            int id = in.nextInt();
            for (Laptop laptop : laptops) {
                if (laptop.getId() == id) {
                    if (user.getBalance() >= laptop.getPrice()) {
                        System.out.println("Headphone was succesfully bought!");
                        System.out.println("You have "+user.getBalance()+" dollars left");
                        String sql = "delete FROM " + market.getMarketName() + ".laptops WHERE id = " + laptop.getId();
                        statement.executeUpdate(sql);
                        user.setBalance(user.getBalance() - laptop.getPrice());
                        return;
                    } else {
                        System.out.println("You not have not enough money!");
                        return;
                    }
                }
            }
            System.out.println("Headphone was not found");
        }
    }
}