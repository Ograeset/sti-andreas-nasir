package sti.andreas.nasir.domain;

public class Teacher extends Person {
    private int hourlyWage;

    public void setHourlyWage(int hourlyWage){
        this.hourlyWage = hourlyWage;
    }

    public int getHourlyWage() {
        return hourlyWage;
    }
}
