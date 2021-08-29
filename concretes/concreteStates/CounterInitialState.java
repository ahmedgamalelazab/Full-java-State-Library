package concretes.concreteStates;

import interfaces.States.CounterState;

public class CounterInitialState implements CounterState{
    private int counterInitial = 0;

    public int getValue(){
        return this.counterInitial;
    }
}
