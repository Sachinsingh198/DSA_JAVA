package BASICS;

public class TypeCasting {
    public static void main(String[] args){
        /*
        * When you are assigning one type of data to a variable of another type, Java will convert the data to the new
variable type automatically if both the following conditions are true:
 The data type and the variable types are compatible.
 The target type has a larger range than the source type
* Converting a data type to another with a larger range is called widening conversion
*
*   Casting to New Data Types
*   Performing a conversion from a data type of larger range to one that has a smaller range is called narrowing
conversion.
*
*       (target-data-type) value
        * */
        byte byte1 = 1;
        int int1 = 1;
        byte1 = (byte) int1;
        String str = "Hello how are you";
        System.out.println(str);
        str = "Hello";
        System.out.println(str);
        StringBuffer strin= new StringBuffer("Hello");
        System.out.println(strin);
//        String s1 = "Hello from Java!";
//        String s2;
//        s2 = "Hello from Java!";
//        String s3 = new String();
//        s3 = "Hello from Java!";
//        String s4 = new String("Hello from Java!");
//        char c1[] = {'H', 'i', ' ', 't', 'h', 'e', 'r', 'e'};
//        String s5 = new String(c1);
//        String s6 = new String(c1, 0, 2);
//        String s7 = String.valueOf(c1);
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s4);
//        System.out.println(s5);
//        System.out.println(s6);
//        System.out.println(s7);
        String s1 = "Hello from Java!";
        char c1 = s1.charAt(0);
        System.out.println("The first character of \"" + s1 + "\" is " + c1);
        char chars1[] = s1.toCharArray();
        System.out.println("The second character of \"" + s1 + "\" is " + chars1[1]);
        char chars2[] = new char[5];
        s1.getChars(0, 5, chars2, 0);
        System.out.println("The first five characters of \"" + s1 + "\" are " + new
                String(chars2));

    }
}
