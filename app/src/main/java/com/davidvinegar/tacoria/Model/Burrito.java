package com.davidvinegar.tacoria.Model;

/**
 * Created by davidvinegar on 12/24/16.
 */
public class Burrito extends Orderable{
    boolean hasGuac;
    boolean hasSteak;
    boolean hasRice;
    boolean hasProtein;
    boolean hasSalsa;
    boolean hasCheese;
    boolean hasCrema;



    public Burrito(boolean hasGuac,boolean hasSteak,boolean hasRice,boolean hasProtein,boolean hasSalsa,
                   boolean hasCheese, boolean hasCrema){
        this.hasGuac = hasGuac;
        this.hasSteak = hasSteak;
        this.hasRice = hasRice;
        this.hasProtein = hasProtein;
        this.hasSalsa = hasSalsa;
        this.hasCheese = hasCheese;
        this.hasCrema = hasCrema;
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

}
