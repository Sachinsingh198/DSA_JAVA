package INHERITENCE;

class Shipment extends BoxWeight{
    double cost;
    Shipment(Shipment obj){
        super(obj);
        cost = obj.cost;
    }

    Shipment(double width, double height, double depth, double weight, double cost){
        super(width, height, depth, weight);
        this.cost = cost;
    }

    Shipment(double length, double weight, double cost){
        super(length,weight);
        this.cost =cost;
    }
    Shipment(){
        super();
        cost = -1;
    }
}
public class DemoShipment {
    public static void main(String[] args) {
        Shipment shipment1 = new Shipment(10,20,15,10,34.3);
        Shipment shipment2 = new Shipment(2,3,4,0.076,1.28);


        System.out.println("Volume of shipment1 is : "+shipment1.volume() );
        System.out.println("Weight of shipment1 is : "+shipment1.weight );
        System.out.println("Shipping cost: $" + shipment1.cost);
        System.out.println();

        System.out.println("Volume of shipment2 is : "+shipment2.volume() );
        System.out.println("Weight of shipment2 is : "+shipment2.weight);
        System.out.println("Shipping cost: $" + shipment2.cost);
        System.out.println();
    }
}
