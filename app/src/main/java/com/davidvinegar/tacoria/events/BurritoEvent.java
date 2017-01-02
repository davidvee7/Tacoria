package com.davidvinegar.tacoria.events;

import com.davidvinegar.tacoria.Model.Burrito;

/**
 * Created by davidvinegar on 1/2/17.
 */
public class BurritoEvent {
    Burrito burrito;
    public BurritoEvent(){
        this.burrito = new Burrito();
    }

    public Burrito getBurrito(){
        return this.burrito;
    }
}
