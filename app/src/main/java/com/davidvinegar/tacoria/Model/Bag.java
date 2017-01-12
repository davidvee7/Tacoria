package com.davidvinegar.tacoria.Model;

import java.util.ArrayList;

/**
 * Created by davidvinegar on 12/28/16.
 */

//there should only be one bag per customer at all times
public class Bag {
    ArrayList<Orderable> itemsInOrder;

    private static Bag bag = new Bag();

    private Bag() {
        this.itemsInOrder = new ArrayList<Orderable>();
    }

    public static Bag getInstance() {
        return bag;
    }

    public void addItemToBag(Orderable item) {
        itemsInOrder.add(item);
    }

    public void removeItemFromBag(Orderable item) {
        itemsInOrder.remove(item);
    }

    public void removeLastItem() {
        itemsInOrder.remove(itemsInOrder.size() - 1);
    }

    public ArrayList<Orderable> getOrderablesList() {
        return this.itemsInOrder;
    }

    public int getSizeOrderablesList() {
        return itemsInOrder.size();
    }

    public void clearOrderables() {
        itemsInOrder.clear();
    }

    public double getBagTotalCostPreTax() {
        double cost = 0;
        for (Orderable o : this.itemsInOrder) {
            cost += o.getcost();
        }
        return cost;
    }

    public double getBagTax() {
        double totalCost = getBagTotalCostPreTax();
        double tax = totalCost * .012;
        return tax;
    }

    public double getBagTotalCostWithTax() {
        return getBagTotalCostPreTax() + getBagTax();
    }

}
