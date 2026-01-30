package Heaps;

import java.util.Arrays;

class Student implements Comparable<Student>{
    String name;
    int rno;
    double cgpa;
    Student(String name, int rno, double cgpa){
        this.name = name;
        this.rno = rno;
        this.cgpa = cgpa;
    }
    public int compareTo(Student s){
        return this.rno - s.rno;
    }
}
public class CustomComparator {
    public static void main(String[] args) {
        Student s1 = new Student("Sachin", 48, 7.4);
        Student s2 = new Student("Saksham",6 , 5.6);
        Student s3 = new Student("Ajay", 28, 6.8);
        Student s4 = new Student("Bhawesh", 49, 9.3);
        Student s5 = new Student("Aryan", 3, 6.7);

        Student[] arr = {s1, s2, s3, s4, s5};
        Arrays.sort(arr);
        for(Student s : arr){
            System.out.println(s.name + " " + s.rno  + " " + s.cgpa);
        }
    }
}
