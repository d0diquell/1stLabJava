package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter your k for 10^(-k): ");
            int k = in.nextInt();
            if(k < 0){
                throw new Exception("Error!!! K is out of range [0,+inf)");
            }
            System.out.println("Enter x (-1,1]: ");
            double x = in.nextDouble();

                if(x <= -1 || x > 1){
                    throw new Exception("Error!!! X is out of range (-1,1]");
                }
                    double actualSum = getActualSum(x);
                    double ourSum = getSum(getLimit(k),x);
                    System.out.printf("Actual sum is: %.3f\n", actualSum);
                    System.out.printf("Our sum is: %.3f\n ", ourSum);

                }
                catch(Exception ex) {
                    System.out.println(ex.getMessage());
                }

    }

    public static double getActualSum (double x){
        return Math.log(1 + x);
    }

    public  static  double getLimit (int k){
        return Math.pow(10, -k);
    }

    public static double getSum (double e, double x){
        double elem = 100;
        double sum = 0;
        int index = 1;
        while (Math.abs(elem) >= Math.abs(e)){
            elem = Math.pow(-1, index-1) * Math.pow(x, index) / index;
            sum += elem;
            index++;
        }
        return sum;
    }

}
