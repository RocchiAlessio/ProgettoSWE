package progettinoingsoftware;

import java.time.LocalDateTime;

public class Data {
    
    private int day;
    private int month;
    private int year;

    public Data(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Data() {
        LocalDateTime time = LocalDateTime.now();
        this.day = time.getDayOfMonth();
        this.month = time.getMonthValue();
        this.year = time.getYear();
    }
    
    public void stampaInfo(){
        System.out.println(day + "/" + month + "/" + year);
    }
}
