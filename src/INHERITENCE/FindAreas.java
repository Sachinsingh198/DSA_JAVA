package INHERITENCE;

/*Method Overriding : Using Run time polymorphism*/
class Figure{
    double dim1;
    double dim2;
    Figure(){

    }
    Figure(double dim1, double dim2){
        this.dim1 = dim1;
        this.dim2 = dim2;
    }
    double area(){
        System.out.println("Area of the figure is undefined: ");
        return 0;
    }
}
class Rectangle extends Figure{
    Rectangle(double a, double b){
        super(a,b);
    }

    double area(){
        System.out.println("The area of the Rectangle.");
        return dim1 * dim2;
    }
}

class Triangle extends Figure{
    Triangle(double a, double b){
        super(a,b);
    }

    double area(){
        System.out.println("The area of the Triangle.");
        return (dim1 * dim2)/2;
    }
}
public class FindAreas {
    public static void main(String[] args) {
        Figure f = new Figure(10,10);
        Rectangle r = new Rectangle(9,5);
        Triangle t = new Triangle(10,8);
        Figure figRef;
        figRef = r;
        System.out.println("Area is " + figRef.area());

        figRef = t;
        System.out.println("Area is " + figRef.area());

        figRef = f;
        System.out.println("Area is " + figRef.area());
    }
}
