package com.lakshman.hackerrank.ctc;

import java.util.TreeSet;

/**
 * @asked Ezetap June'18
 *
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(""=="");
//        int a=10;
//        System.out.println(a -= a += a -= a += a);

        String s;
        int a;
        s = "Foolish boy.";
        a = s.indexOf("fool");
        System.out.println(a);

        System.out.println(Math.pow(3,15));

//        TreeSet t=new TreeSet();
//        t.add(null);
//        t.add("A");
//        System.out.println(t);

        try
        {
            throw new Exc1(); /* Line 9 */
        }
        catch (Exc0 e0) /* Line 11 */
        {
            System.out.println("Ex0 caught");
        }
        catch (Exception e)
        {
            System.out.println("exception caught");
        }

        StringBuffer s1 = new StringBuffer("Hello World");
        s1.insert(6 , "Good ");
        System.out.println(s1);
    }


}
class Exc0 extends Exception { }
class Exc1 extends Exc0 { }

interface Colorable {}
class Vehicle {}
class Car extends Vehicle implements Colorable {}
 class Tester {
    public static void main(String[] args) {
        Vehicle a = new Car();
        Colorable i = (Colorable) a; //Line 1
        Vehicle b = new Vehicle();
        Colorable j = (Colorable) b;  //Line 2
    }
}

/*
class Super
{
    public int i = 0;

    public Super(String text)
    {
        i = 1;
    }
}


class Sub extends Super
{
    public Sub(String text)
    {
        i = 2;
    }

    public static void main(String args[])
    {
        Sub sub = new Sub("Hello");
        System.out.println(sub.i);
    }
}
*/

class PetA
{
    public static void main(String [] args)
    {
        PetA p = new PetA();
        p.start();
    }

    void start()
    {
        long [] a1 = {3,4,5};
        long [] a2 = fix(a1);
        System.out.print(a1[0] + a1[1] + a1[2] + " ");
        System.out.println(a2[0] + a2[1] + a2[2]);
    }

    long [] fix(long [] a3)
    {
        a3[1] = 7;
        return a3;
    }
}