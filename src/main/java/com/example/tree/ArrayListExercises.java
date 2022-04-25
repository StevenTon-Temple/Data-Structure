package com.example.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExercises {
    public static void main(String args[]) {
        List<Integer> listInt = new ArrayList<Integer>(){{
        add(1); add(25); add(2); add(5);add(30); add(19); add(57); add(2); add(25); // <--got from https://www.geeksforgeeks.org/initializing-a-list-in-java/
        }};
        List<Integer> listIn = new ArrayList<Integer>(){{
            add(1);add(4);add(5);add(6);add(5);add(5);add(2);
        }};
        List<Integer> listS = new ArrayList<Integer>(){{
            add(1);add(2);add(4);
        }};
        List<Integer> listT = new ArrayList<Integer>(){{
            add(2);add(1);add(4);
        }};
        List<String> listString = Arrays.asList("I", "like", "to", "eat", "eat", "eat", "apples", "and", "bananas");// <--got from https://www.geeksforgeeks.org/initializing-a-list-in-java/
        System.out.println(unique(listInt));
        System.out.println(AllMultiples(listInt, 5));
        System.out.println(AllStringsofSize(listString, 3));
        System.out.println(isPermutaion(listS,listT));
        System.out.println(stringToListOfWords("I am used to eating white rice than eating colored rice."));
        System.out.println(removeAllInstances(listIn,5));


    }

    public static <E> boolean unique(List<E> s) {
        for (int i = 0; i < s.size(); i++) {
            for (int j = i + 1; j < s.size(); j++) {
                if (s.get(i).equals(s.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Integer> AllMultiples(List<Integer> s, int num) {
        List<Integer> newlist = new ArrayList<Integer>();
        for (int i = 0; i < s.size(); i++) {
            if ((s.get(i) % num == 0)) {
                newlist.add(s.get(i));
            }
        }


        return newlist;
    }

    public static List<String> AllStringsofSize(List<String> s, int length) {
        List<String> newlist = new ArrayList<String>();
        for (int i = 0; i < s.size(); i++) {
            if ((s.get(i).length() == length)) {
                newlist.add(s.get(i));
            }
        }
        return newlist;
    }

    public static <E> boolean isPermutaion(List<E> s, List<E> t) { //<--Given to us by teacher.
        if (s.size() != t.size()) {
            return false;
        }
        for (E item : s) {
            int counts = 0;
            int countt = 0;
            for (int i = 0; i < s.size(); i++) {
                if (s.get(i).equals(item)) {
                    counts++;
                }

            }
            for (int i = 0; i < t.size(); i++) {
                if (t.get(i).equals(item)) {
                    countt++;

                }

            }
            if (counts != countt){
                return false;
            }
        }
        return true;
    }

    public static String stringToListOfWords(String s) {
        int length = s.split("([ .])+").length;
        String[] newlist = new String[length];
        for (int i = 0; i < length; i++) {
            newlist[i] = s.split("([ .])+")[i];


            }
        return Arrays.toString(newlist);
    }

    public static <E> List removeAllInstances(List<E> s, E  num) {
        for (int i = 1; i < s.size(); i++) {
            if (s.get(i).equals(num)) {
                s.remove(i);
                i = i-1;
            }
        }
        return s;
    }
}
