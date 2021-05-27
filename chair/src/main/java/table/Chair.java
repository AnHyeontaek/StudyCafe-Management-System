/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

/**
 *
 * @author pkm30
 */
public class Chair {
    
    private State State;

    public Chair(){
        
    }

    public void setState(State powerState){
        this.State = powerState;
    }

    public void powerPush(String chair_state){
        State.powerPush(chair_state);
    }
}

