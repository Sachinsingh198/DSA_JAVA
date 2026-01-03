package OOPS;

public class student {


        String name ;
        int rln;
        double percent;
        final String scholl = "RGNV" ;
        static int count;
        student(){
            count++;
        }
        student(String name, int rln, double percent) {
            this.name = name;
            this.rln = rln;
            this.percent = percent;
            count++;
        }
    }


    /*
    * Default value:
    * Access Modifiers:
    *   1) Public:
    *           all packages
    *   2) Private:
    *           same class
    *   3) Default: same package
    *
    * Final keyword:
    *       final keyword makes the variable unchangable i.e., we can not change the assigned value to the same, this value will always be same for every object of the class
    * static keyword:
    *       static variable can be referenced from a static constant
    *       They are also access just using the class, for eg., (Student.count)
    * static function:
    *       Also same as static keyword, can be acccesed using class
    *       Used if we want to access  a function int the class through just the class name
    *  */
