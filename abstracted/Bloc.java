package abstracted;

import java.util.ArrayList;

import interfaces.Observer.Observer;
import interfaces.Subject.Subject;

public abstract class Bloc<A,S> implements Subject{
    
    // pseudo 
    /**
     *  //should have a list of actions 
     *  //should have the ability  of adding actions 
     *  //should react when we add the action 
     *  //it's like we are implementing the template method pattern
     *  //we should also have a list of states 
     *  //about the observer and stuff we should have a list of our observers
     *  //should have the ability of getting the last action got called from  my bloc
     *  //should have the ability of getting the last state got emitted in my application
     * */ 

     private ArrayList<A>actions;

     private ArrayList<S>states;

     private ArrayList<Observer>observers;


     public Bloc(S initialState){
         actions =  new ArrayList<A>();
         states = new ArrayList<S>();
         observers = new ArrayList<Observer>();
         states.add(initialState); // this is the initial State
     }


     //section of getting stuff from the bloc

     public  ArrayList<A>getActions(){
         return this.actions;
     }

     public ArrayList<S>getStates(){
         return this.states;
     }

     //the ability of adding some actions and adding states 

     //TODO PLEAS CONTINUTE THE WHOLE ENTIRE ALGORITHM
     public final void addAction(A action){
        if(!actions.isEmpty()){
            this.actions.clear(); //  we will clear the whole entire things if it's not clear
        }
        this.actions.add(action);
        //... on testing
        mapActionsToStates(action);
     }

     public final void emit(S state){
        if(!states.isEmpty()){
            states.clear();
        }
        states.add(state);
        notifyListeners();
     }

     //mapping actions into states
     //the client should be able to call  get action ? 

     public abstract void mapActionsToStates(A action);

    /**
     * the observer in our case should be the thing that wanna update !
     * the observer will be attached to the bloc to update the whole thing
     * because the subject here <Bloc> will control the counter -> we will use the actions and  expect to have som states
     */

    @Override
    public void setObserver(Observer observer){
        observers.add(observer);
    }

    @Override
    
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    
    @Override
    public void notifyListeners(){
        for(Observer o : observers){
            o.update(this);
        }
    }

}
