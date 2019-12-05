package CodeReview03;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    Station s4;
    User u4;
    Bike b11;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        b11 = new Bike("blue", Bike.Status.CanBeRented);
        Main.bikes.put(11,b11);
        s4 = new Station("Karlsplatz");
        Main.stations.put(11,s4);
        s4.addBike(11);
        u4 = new User("Mister", "Muster");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void rentABike() {
        assertNull(u4.getCurrRentedBike());
        assertEquals(1, s4.getBikes().size());
        u4.rentABike(11);
        assertEquals(11, u4.getCurrRentedBike());
        assertEquals(1, s4.getBikes().size()); // Test failed here because b11 was rented by u4 = no bike is at s4 !
    }

    @org.junit.jupiter.api.Test
    void getCurrRentedBike() {
    }

    @org.junit.jupiter.api.Test
    void setCurrRentedBike() {
    }

    @org.junit.jupiter.api.Test
    void getCurrRentUser() {
    }

    @org.junit.jupiter.api.Test
    void setCurrRentUser() {
    }

    @org.junit.jupiter.api.Test
    void getuID() {
    }

    @org.junit.jupiter.api.Test
    void removeBike() {
    }

    @org.junit.jupiter.api.Test
    void allBikesRentedByUser() {
    }
}