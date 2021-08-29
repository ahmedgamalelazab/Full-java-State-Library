package concretes.Counter;

import abstracted.Bloc;
import concretes.concreteStates.Decrementing;
import concretes.concreteStates.Incrementing;
import interfaces.Observer.Observer;


public class Counter implements Observer{

    public Counter(){
        this.counter = 0;
    }

    private int counter;

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void update(Bloc<?, ?> bloc) {
       bloc.getStates().forEach(state ->{
           if(state instanceof Incrementing){
                counter ++;
                System.out.println(counter);
           }else if(state instanceof Decrementing){
                counter --;
                System.out.println(counter);
           }else{
            counter = 0;
            System.out.println(counter);
           }
       });
    }


}
