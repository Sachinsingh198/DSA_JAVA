package INHERITENCE;
/*This program uses Inheritence to extend Box*/
class Box{
    private double width;
    private double height;
    private double depth;
    Box(Box obj){// passes the object to the constructor
        this.width = obj.width;
        this.depth = obj.depth;
        this.height = obj.height;
    }

    // when all dimensions are specified
    Box(double width,double height,double depth ){
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    //When no dimensions are specified
    Box(){
        this.width = -1;
        this.depth = -1;
        this.height = -1;
    }

    //When cube is created
    Box(double len){
        this.width = len;
        this.depth = len;
        this.height = len;
    }

    //return  the volume of the box
    double volume(){
        return this.width * this.height * this.depth;
    }
}

/* Here box is extended to include weight */
class BoxWeight extends Box{
    double weight;

    //Construct clone of an object
    BoxWeight(BoxWeight obj){
        super(obj);
        weight = obj.weight;
    }
    BoxWeight(double w, double h, double d, double m){
        super(w,h,d);
        weight = m;
    }

    BoxWeight(){
        super();
        weight = -1;
    }

    BoxWeight(double len, double m){
        super(len);
        weight = m;
    }
}
public class DemoBoxWeight {
    public static void main(String[] args) {
        BoxWeight mybox1 = new BoxWeight(10,20,15,34.3);
        BoxWeight mybox2 = new BoxWeight(2,3,4,0.076);
        BoxWeight cube = new BoxWeight(3,2);
        BoxWeight clone = new BoxWeight(mybox1);

        System.out.println("Volume of mybox1 is : "+mybox1.volume() );
        System.out.println("Weight of mybox1 is : "+mybox1.weight );
        System.out.println();

        System.out.println("Volume of mybox2 is : "+mybox2.volume() );
        System.out.println("Weight of mybox2 is : "+mybox2.weight );
        System.out.println();

        System.out.println("Volume of cube is : "+cube.volume() );
        System.out.println("Weight of cube is : "+cube.weight );
        System.out.println();

        System.out.println("Volume of clone is : "+clone.volume() );
        System.out.println("Weight of clone is : "+clone.weight );

        System.out.println();
    }
}
