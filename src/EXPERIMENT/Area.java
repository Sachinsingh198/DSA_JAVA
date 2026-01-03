package EXPERIMENT;
import java.util.Scanner;

abstract class Shape {
    abstract double CalculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    double CalculateArea() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape{
    private double  side ;
    public Square (double side){
        this.side = side;
    }
    double CalculateArea(){
        return side * side;
    }
}

class Rectangle extends Shape{
    private double length ;
    private double breadth;
    public Rectangle (double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    double CalculateArea(){
        return length * breadth;
    }
}

public class Area {
    public static void main(String[] args) {
        Shape circle = new Circle(19);
        System.out.println("Area of the cirlce : " + circle.CalculateArea());
        Shape square = new Square(19);
        System.out.println("Area of the square : " + square.CalculateArea());
        Shape rectangle = new Rectangle(19, 29);
        System.out.println("Area of the rectangle : " + rectangle.CalculateArea());
    }
}
