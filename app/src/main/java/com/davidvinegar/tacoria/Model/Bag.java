package com.davidvinegar.tacoria.Model;

import java.util.ArrayList;

/**
 * Created by davidvinegar on 12/28/16.
 */
public class Bag {
    ArrayList<Orderable> itemsInOrder;

    public Bag(){
        this.itemsInOrder = new ArrayList<Orderable>();
    }

    private void addItemToBag(Orderable item){
        itemsInOrder.add(item);
    }

    private void removeItemFromBag(Orderable item){
        itemsInOrder.remove(item);
    }

}
