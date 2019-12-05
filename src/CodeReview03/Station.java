package CodeReview03;

import java.util.ArrayList;

public class Station {
    private static int counter = 1;
    private Integer sID;
    private String location;
    private ArrayList<Integer> bikes;

    Station(String location) {
        this.sID = counter++;
        this.location = location;
        this.bikes = new ArrayList<>();
    }

    public Station() {
    }

    public Integer getsID() {
        return this.sID;
    }

    public String getLocation(){
        return this.location;
    }

    public void addBike(Integer bID) {
        this.bikes.add(bID);
    }

    public void removeBike(Integer bID) {
        this.bikes.remove(bID);
    }

    public ArrayList<Integer> getBikes() {
        return this.bikes;
    }

    public void returnBike(Integer bID) {
        if (this.bikes.size() < 5) {
            addBike(bID);
            Main.checkWhichUser(bID);
        } else {
            System.out.println("\nNix geht mehr! Die Station " + getLocation() + " ist schon voll!\n");
        }
    }
}
