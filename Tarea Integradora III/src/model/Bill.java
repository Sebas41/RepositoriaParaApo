package model;
import java.time.LocalDate;
public class Bill {

private double cost;
private LocalDate date;
private Affordable affordable;

public Bill( Affordable affordable, double cost, LocalDate date ) {
    this.date = date;
    this.affordable = affordable;
    this.cost = cost;
    }
   
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Affordable getAffordable() {
        return affordable;
    }

    public void setAffordable(Affordable affordable) {
        this.affordable = affordable;
    }
}
