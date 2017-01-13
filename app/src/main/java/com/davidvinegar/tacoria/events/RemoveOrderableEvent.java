package com.davidvinegar.tacoria.events;

/**
 * Created by davidvinegar on 1/13/17.
 */
public class RemoveOrderableEvent {
    int orderablePosition; //position of orderable in bag
    public RemoveOrderableEvent(int orderablePosition){
        this.orderablePosition = orderablePosition;
    }

    public int getOrderablePosition(){
        return orderablePosition;
    }
}
