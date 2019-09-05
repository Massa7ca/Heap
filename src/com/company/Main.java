package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static ArrayList<Integer> ranlist(int size){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i != size; i++) {
            int ran = (int) (Math.random() * 2100000000);
            list.add(ran);
        }
        return list;
    }

    public static void main(String[] args) {
        Heap test = new Heap();
        int size = 10000000;
        ArrayList<Integer> list = ranlist(size);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i != size; i++) {
            test.add(list.get(i));
        }
        System.out.println("Add time " + (System.currentTimeMillis() - startTime));

        Collections.sort(list);
        Collections.reverse(list);

        startTime = System.currentTimeMillis();
        ArrayList<Integer> sort = new ArrayList<>();
        for (int i = 0; i != size; i++) {
            sort.add(test.getMaxRm());
        }
        System.out.println("Sort time " + (System.currentTimeMillis() - startTime));
        System.out.println(sort.equals(list));

    }
}