package com.davidvinegar.tacoria.Model;

/**
 * Created by davidvinegar on 12/28/16.
 */
public class Orderable {
    float cost;
    String foodType;
    boolean hasGuac;
    boolean hasSteak;
    boolean hasChicken;
    boolean hasRice;
    boolean hasProtein;
    boolean hasSalsa;
    boolean hasCheese;
    boolean hasCrema;
    int id;
    public Orderable(){

    }

    public Orderable(float cost){
        this.cost = cost;
    }

    public void setCost(float cost){
        this.cost = cost;
    }

    public double getcost(){
        double totalCost=0.00;
        if (foodType == "Burrito"){
            totalCost = 7.00;
            if (this.hasGuac){
                totalCost += 1.50;
            }

            if(this.hasSteak){
                totalCost+=1;
            }

        }
        else if(foodType == "Tacos"){
            totalCost = 7.00;
            if (this.hasGuac){
                totalCost += 1.5;
            }

            if(this.hasSteak){
                totalCost+=2.5;
            }
        }

        return totalCost;
    }

    public String getFoodType(){
        return this.foodType;
    }

    public void setFoodType(String name) {
        this.foodType = name;
    }

    public void addSteak(){
        this.hasSteak = true;
    }

    public void removeSteak(){
        this.hasSteak = false;
    }

    public void addChicken(){
        this.hasChicken = true;
    }

}
