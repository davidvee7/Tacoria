package com.davidvinegar.tacoria.Model;

import java.util.ArrayList;

/**
 * Created by davidvinegar on 12/28/16.
 */

//there should only be one bag per customer at all times
public class Bag {
    ArrayList<Orderable> itemsInOrder;

    private static Bag bag = new Bag();

    private Bag(){
        this.itemsInOrder = new ArrayList<Orderable>();
    }

    public static Bag getInstance(){
        return bag;
    }

    private void addItemToBag(Orderable item){
        itemsInOrder.add(item);
    }

    private void removeItemFromBag(Orderable item){
        itemsInOrder.remove(item);
    }

}
