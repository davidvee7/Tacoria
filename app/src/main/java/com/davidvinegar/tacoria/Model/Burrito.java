package com.davidvinegar.tacoria.Model;

/**
 * Created by davidvinegar on 12/24/16.
 */
public class Burrito extends Orderable{
    boolean hasGuac;
    boolean hasSteak;
    boolean hasChicken;
    boolean hasRice;
    boolean hasProtein;
    boolean hasSalsa;
    boolean hasCheese;
    boolean hasCrema;



    public Burrito(){

    }

    private int getCost(){
        int totalCost = 7;
        if (this.hasGuac){
            totalCost += 1.5;
        }

        if(this.hasSteak){
            totalCost+=1;
        }
        return totalCost;
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
