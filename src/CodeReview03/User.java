package CodeReview03;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class User {
    private static Integer counter =1;
    private Integer uID;
    private String uFirstName;
    private String uLastName;
    private Integer currRentedBike;
    private Integer currRentUser;
    private Rent rent;
    private ArrayList<Rent>rents = new ArrayList<>();

    public User (String uFirstName, String uLastName) {
        this.uID = counter++;
        this.uFirstName = uFirstName;
        this.uLastName = uLastName;
    }

    public User(){ }
    public void rentABike(Integer bID) {
        if (Main.bikes.get(bID).getcheckStatus() == Bike.Status.CanBeRented) {
            Main.checkStation(bID);
            this.currRentedBike = bID;
            GregorianCalendar today = (GregorianCalendar) Calendar.getInstance();
            this.rent = new Rent(bID, today);
            this.rents.add(this.rent);
        } else {
            System.out.println("Dieses Bike kann nicht ausgeliehen werden!");
        }
    }

    public Integer getCurrRentedBike() {
        return this.currRentedBike;
    }

    public void setCurrRentedBike(Integer bID) {
        this.currRentedBike = bID;
    }

    public Integer getCurrRentUser() {
        return this.currRentUser;
    }

    public void setCurrRentUser(Integer uID) {
        this.currRentUser = uID;
    }

    public int getuID(){
        return this.uID;
    }

    public void removeBike(Integer bID){
        this.rent.setRentEnd();
        this.currRentedBike = null;
    }

    public void allBikesRentedByUser(){
        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm dd.MM.yyyy");
        String showName = this.uFirstName +" "+ this.uLastName;
        System.out.printf("%S" + "%17s" + "%28s%n", showName, "Leihbeginn", "Leihende");

        for (Rent rent :rents){
            System.out.printf("Bike ID:" + "%2S" + "%23S" + "%30S%n", rent.getbID(), sdf.format(rent.getRentStart().getTime()), sdf.format(rent.getRentEnd().getTime()));

        }
    }
}
