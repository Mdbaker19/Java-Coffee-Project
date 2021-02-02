package model;

public class Coffee {
    private double price;
    private String type;
    private String name;
    private int user_id;

    public Coffee(){}
    public Coffee(int user_id, String name, String type, double price){
        this.user_id = user_id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public int getUser_id(){
        return this.user_id;
    }
    public void setUser_id(int id){
        this.user_id = id;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
