package io.humb1t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Prior to Java SE 1.5
        List myIntList = new LinkedList();
        myIntList.add(new Integer(0));
        Integer x = (Integer) myIntList.iterator().next();
        //After
        List<Integer> myGenericIntList = new LinkedList<Integer>();
        myGenericIntList.add(new Integer(0));
        Integer genericX = myGenericIntList.iterator().next();

        List<String> ls = new ArrayList<String>();
        List<Object> lo = ls;
        lo.add(new Object());
        String s = ls.get(0);


        Collection<?> c = new ArrayList<String>();
        c.add(new Object());
    }

    void printCollection(Collection<?> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }

    void printCollectionBounded(Collection<? extends Number> c) {
        for (Number e : c) {
            System.out.println(e);
        }
    }

    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o); // Correct
        }
    }
}
