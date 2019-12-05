package CodeReview03;

public class Bike {
    private Integer bID;
    private String color;
    private Status checkStatus;
    private static Integer counter = 1;
    public enum Status {
        CanBeRented, CanNotBeRented, InService, Discarded
    }

    Bike(String color, Status checkStatus){
        this.bID = counter++;
        this.color = color;
        this.checkStatus= checkStatus;
    }

    public int getbID(){
        return this.bID;
    }

    public Status getcheckStatus() {
        return checkStatus;
    }
}
