import java.util.Scanner;

import abstracted.Bloc;
import concretes.Bloc.CounterBloc;
import concretes.Counter.Counter;
import concretes.concreteActions.Decrement;
import concretes.concreteActions.Increment;
import concretes.concreteStates.CounterInitialState;
import interfaces.Actions.CounterAction;
import interfaces.States.CounterState;

public class Main {
    public static void main(String [] args){
       
        Counter simpleCounter = new Counter();

        Bloc<CounterAction,CounterState> javaBloc = new CounterBloc(new CounterInitialState()); 

        javaBloc.setObserver(simpleCounter);

        int interfaceController = 0;

        Scanner scanner = new Scanner(System.in);
        

        do{

            System.out.println(">> enter -1 to close this application <<");
            System.out.println(">> enter 1 for increasing ! <<");
            System.out.println(">> enter 2  for decreasing ! <<");
            System.out.print("enter any number to update ! : ");
            interfaceController = scanner.nextInt();            
            //close this 
            if(interfaceController == -1){
                scanner.close();
            }else if(interfaceController == 1){
                javaBloc.addAction(new Increment());
            }else if(interfaceController == 2){
                javaBloc.addAction(new Decrement());
            }            
            

        }while(interfaceController != -1);

    }    
}
