package com.crud.fun;

import java.util.ArrayList;

public class Loops {

    public Loops() {
    }

    public void getAdvancedLoop() {
        ArrayList<String> x = new ArrayList<>();
        long y = 1;
        for (int i = 1; i <= 20; i++) {
            y = (y*i);
            Integer b = i;
            if (i == 1) {
                x.add(b.toString());
            } else {
                x.add("*" + b);
            }
            System.out.print("Silnia z " + i + " czyli: ");
            x.stream()
                    .forEach(System.out::print);
            System.out.println(" wynosi: " + y);
        }
    }
    public void getLoop(int x) {
        long y = 1;
        for (int i = 1; i <= x; i++) {
            y = (y * i);
            System.out.println(y);
        }
    }



}
