public class User {
    private static User user;
    private static String name = "";
    private static int balance = 0;

    private User(){};

    public static User getInstance(){
        if(user == null){
            return new User();
        }
        return user;
    }

    public String getName(){
        return name;
    }
    public int getBalance(){
        return balance;
    }

    public void topUpBalance(int money){
        balance+=money;
    }
    public void setName(String name){
        User.name = name;
    }
    public void buyThing(int cash){
        balance-=cash;
    }
}
