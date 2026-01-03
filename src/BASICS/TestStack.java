package BASICS;
class Stack{
    int[] stock = new int[10];
    int tos;
    Stack(){ // Initial top of the Stack
        tos = -1;
    }

    // Push an item on the Stack
    void push(int item){
        if(tos == 9){
            System.out.println("Stack Overflow!");
        }
        else{
            stock[++tos] = item;
        }
    }

    int pop(){
        if(tos == -1){
            System.out.println("Stack Underflow!");
            return 0;
        }
        else return stock[tos--];
    }
}

public class TestStack {
    public static void main(String[] args) {
        Stack myStack1 = new Stack();
        Stack myStack2 = new Stack();
        //push some numbers onto the stack
        for(int i = 0; i< 10; i++){
            myStack1.push(i);
        }
        for(int i = 10; i< 20; i++){
            myStack2.push(i);
        }

        // Pop those number off the stack
        System.out.println("Stack in myStack1");
        for(int i = 0; i < 10; i++){
            System.out.print(myStack1.pop() + " ");
        }
        System.out.println();
        System.out.println("Stack in myStack2");
        for(int i = 0; i< 10 ; i++){
            System.out.print(myStack2.pop() + " ");
        }

    }
}
