package com.stackroute.oops;

import java.util.List;

public class Traveller {

    private int id;
    private String travelType;
    private double price;
    private List<String> locations;

    /*Default constructor*/
    public Traveller(){

    }
    public Traveller(int id){
        this.id=id;
    }
    public Traveller(int id,String travelType){
        this.id=id;
        this.travelType=travelType;
    }

    public Traveller(int id,String travelType,double price){
        this.id=id;
        this.travelType=travelType;
        this.price=price;

    }

    /*Define overloaded constructors as per the problem.md*/

    public Traveller(int id, String travelType, double price, List<String> locations) {
        this.id = id;
        this.travelType = travelType;
        this.price = price;
        this.locations = locations;
    }
    /*Getter and Setter methods*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    /*
        This method should return a string containing the Traveller details in format mentioned in problem.md

        */


    public String getTravellerDetails() {
        String str= "Traveller{" +
                "id=" + id +
                ", price=" + price +
                ", travelType='" + travelType + '\'' +
                ", locations=" + locations +
                '}';
        return str;
    }
}
