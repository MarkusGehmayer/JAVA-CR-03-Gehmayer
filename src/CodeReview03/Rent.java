package CodeReview03;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Rent {
    private Integer bID;
    private GregorianCalendar rentStart;
    private GregorianCalendar rentEnd;

    public Rent(Integer bID, GregorianCalendar rentStart){
        this.bID = bID;
        this.rentStart = rentStart;
    }

    public void setRentEnd(){
        this.rentEnd = (GregorianCalendar) Calendar.getInstance();
    }

    public Integer getbID(){
        return bID;
    }

    public GregorianCalendar getRentStart(){
        return rentStart;
    }

    public GregorianCalendar getRentEnd(){
        return rentEnd;
    }
}
