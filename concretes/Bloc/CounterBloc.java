package concretes.Bloc;

import abstracted.Bloc;
import concretes.concreteActions.Decrement;
import concretes.concreteActions.Increment;
import concretes.concreteStates.Decrementing;
import concretes.concreteStates.Incrementing;
import interfaces.Actions.CounterAction;
import interfaces.States.CounterState;

public class CounterBloc extends Bloc<CounterAction ,CounterState>{

    public CounterBloc(CounterState initialState) {
        super(initialState);
    }

    @Override
    public void mapActionsToStates(CounterAction action) {        
        if(action instanceof Increment){
            this.emit(new Incrementing());
        }else if(action instanceof Decrement){
            this.emit(new Decrementing());
        }
    }
}
