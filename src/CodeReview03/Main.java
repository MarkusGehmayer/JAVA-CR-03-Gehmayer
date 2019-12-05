// CodeReview 03

package CodeReview03;

import java.util.Map;
import java.util.HashMap;

public class Main {
    static HashMap<Integer, Bike> bikes = new HashMap<>();
    static HashMap<Integer, Station> stations = new HashMap<>();
    static HashMap<Integer, User> users = new HashMap<>();

    public static void main(String[] args) {
        // --> BIKES
        Bike b1 = new Bike("lightorange", Bike.Status.CanBeRented);
        Bike b2 = new Bike("transparent", Bike.Status.CanBeRented);
        Bike b3 = new Bike("grey", Bike.Status.CanBeRented);
        Bike b4 = new Bike("black", Bike.Status.CanBeRented);
        Bike b5 = new Bike("red", Bike.Status.CanBeRented);
        Bike b6 = new Bike("magenta", Bike.Status.CanBeRented);
        Bike b7 = new Bike("yellow", Bike.Status.CanBeRented);
        Bike b8 = new Bike("white", Bike.Status.InService);
        Bike b9 = new Bike("rusty", Bike.Status.Discarded);
        Bike b10 = new Bike("purple", Bike.Status.CanNotBeRented);

        bikes.put(b1.getbID(), b1); bikes.put(b2.getbID(), b2);
        bikes.put(b3.getbID(), b3); bikes.put(b4.getbID(), b4);
        bikes.put(b5.getbID(), b5); bikes.put(b6.getbID(), b6);
        bikes.put(b7.getbID(), b7); bikes.put(b8.getbID(), b8);
        bikes.put(b9.getbID(), b9); bikes.put(b10.getbID(), b10);

        // --> STATIONS
        Station s1 = new Station("Kettenbrückengasse");
        Station s2 = new Station("Praterstern");
        Station s3 = new Station("Landstraße");

        stations.put(s1.getsID(), s1);
        stations.put(s2.getsID(), s2);
        stations.put(s3.getsID(), s3);

        // add the BIKES into the STATIONS, except of b8, b9, b10
        s1.addBike(1); s1.addBike(2); s1.addBike(3);
        s2.addBike(4); s2.addBike(5); s2.addBike(6);
        s2.addBike(7);

        // added 3 bikes in s1
        System.out.println("In der Station " + s1.getLocation() + " stehen folgende Bikes zur Leihe zur Verfügung: "+ s1.getBikes().toString());

        // added 4 bikes in s2
        System.out.println("In der Station " + s2.getLocation() + " stehen folgende Bikes zur Leihe zur Verfügung: "+ s2.getBikes().toString());

        // added no bikes in s3 = [] !
        System.out.println("In der Station " + s3.getLocation() + " stehen momentan keine Bikes zur Leihe zur Verfügung! --> "+ s3.getBikes().toString());

        // --> USERS
        User u1 = new User("Mark", "Meyer");
        User u2 = new User("Karl", "Krapf");
        User u3 = new User("Paul", "Pille");

        users.put(u1.getuID(), u1);
        users.put(u2.getuID(), u2);
        users.put(u3.getuID(), u3);

        /*  rental procedure:
            u(1,2,3) rent & return a
            b(1,2,3,4,5,6,7; --> b8 is InService, b9 is Discarded, b10 CanNotBeRented) at a
            s(1,2,3) */
        System.out.println("--------------------------------------------------------------------------------------------\n");
        System.out.println("RENTAL PROCEDURE:");

        System.out.println("- - - - - - - - - - - - -");
        System.out.println("Folgende Bikes befinden sich in der Station " + s1.getLocation() + ": " + s1.getBikes().toString());
        u1.rentABike(2);
        System.out.println("::: LEIHPROZESS -->\nDer User mit der ID " + u1.getuID() + " hat das Bike mit der ID " + u1.getCurrRentedBike() + " aus dieser Station ausgeliehen.");
        System.out.println("Restliche Bikes in dieser Station: "+ s1.getBikes().toString());
        System.out.println("Das Bike mit der ID " + u1.getCurrRentedBike() + " wurde vom User mit der ID " + u1.getuID() + " in die Station " + s3.getLocation() + " zurückgebracht.");
        s3.returnBike(2);
        System.out.println("Alle Bikes in dieser Station: "+ s3.getBikes().toString());
        System.out.println("\n- - - - - - - - - - - - -");

        System.out.println("Folgende Bikes befinden sich in der Station " + s2.getLocation() + ": " + s2.getBikes().toString());
        u2.rentABike(4);
        System.out.println("::: LEIHPROZESS -->\nDer User mit der ID " + u2.getuID() + " hat das Bike mit der ID " + u2.getCurrRentedBike() + " aus dieser Station ausgeliehen.");
        System.out.println("Restliche Bikes in dieser Station: "+ s2.getBikes().toString());
        System.out.println("Das Bike mit der ID " + u2.getCurrRentedBike() + " wurde vom User mit der ID " + u2.getuID() + " in die Station " + s3.getLocation() + " zurückgebracht.");
        s3.returnBike(4);
        System.out.println("Alle Bikes in dieser Station: "+ s3.getBikes().toString());
        System.out.println("\n- - - - - - - - - - - - -");

        System.out.println("Folgende Bikes befinden sich in der Station " + s3.getLocation() + ": " + s3.getBikes().toString());
        u3.rentABike(2);
        System.out.println("::: LEIHPROZESS -->\nDer User mit der ID " + u3.getuID() + " hat das Bike mit der ID " + u3.getCurrRentedBike() + " aus dieser Station ausgeliehen.");
        System.out.println("Restliche Bikes in dieser Station: "+ s3.getBikes().toString());
        System.out.println("Das Bike mit der ID " + u3.getCurrRentedBike() + " wurde vom User mit der ID " + u3.getuID() + " in die Station " + s1.getLocation() + " zurückgebracht.");
        s1.returnBike(2);
        System.out.println("Alle Bikes in dieser Station: "+ s1.getBikes().toString());

/* test of functionality, add more than 5 bikes to s1 -->
        u3.rentABike(5);
        s1.returnBike(5);
        u3.rentABike(2);
        s1.returnBike(2);
        u1.rentABike(4);
        s1.returnBike(4);
        u2.rentABike(7);
        s1.returnBike(7);
        u2.rentABike(6);
        s1.returnBike(6);
        System.out.println(b8.getcheckStatus()); = InService
        System.out.println(b9.getcheckStatus()); = Discarded
        System.out.println(b10.getcheckStatus()); = CanNotBeRented
        */

        System.out.println("\nBONUS: rental tracking");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        u1.allBikesRentedByUser();
        System.out.println("");
        u2.allBikesRentedByUser();
        System.out.println("");
        u3.allBikesRentedByUser();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    // --> check USER and check STATION methods
    public static void checkWhichUser(Integer bID){
        User u = new User();
        for(Map.Entry<Integer, User> entry: users.entrySet()){
            if(entry.getValue().getCurrRentedBike() == bID){
                u = entry.getValue();
                break;
            }
        }
        u.removeBike(bID);
    }

    public static void checkStation(Integer bID) {
        Station s = new Station();
        for (Map.Entry<Integer, Station> entry : stations.entrySet()) {
            if (entry.getValue().getBikes().contains(bID)) {
                s = entry.getValue();
                break;
            }
        }
        s.removeBike(bID);
    }

}