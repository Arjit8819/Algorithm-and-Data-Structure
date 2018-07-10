/*
 * Copyright (c) 2018. Phasmid Software
 */

package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.simple.InsertionSort;
import edu.neu.coe.info6205.sort.simple.SelectionSort;
import edu.neu.coe.info6205.sort.simple.Sort;
import java.util.Random;

import java.util.function.Function;

public class Benchmark<T> {
        public static Integer[] random = new Integer[10000];
        public static Integer[] sorted = new Integer[10000];
        public static Integer[] partially = new Integer[10000] ;
        public static Integer[] reverse = new Integer[10000] ;
    public Benchmark(Function<T, Void> f) {
        this.f = f;
    }

    public double run(T t, int n) {
//        return 0;  // TODO
    long initial_time = System.nanoTime();

        for(int i = 0; i < n; i++)
        {
            random      = random();
            sorted     = ordered();
            partially = partiallyOrdered();
            reverse   = reverseOrdered();  
            T a= t;
            f.apply(a);
        }
        long final_time = System.nanoTime() - initial_time;
        double avg = final_time / 1000;
        avg = avg/n;
        return avg;
        
    }

    public static Integer[] random(){
        //Integer[] random_Array = new Integer[10000];
        //initialise random array
        Random rand = new Random();
        for(int i = 0; i <random.length ; i++){            
            random[i] = rand.nextInt(i+1);
        }
        return random;
    }
    

    public static Integer[] ordered(){
        //Integer[] orderedarr = new Integer[10000];
        //initialise ordered array
        for(int i = 0; i < sorted.length ; i++){
            sorted[i] = i;
        }
        return sorted;
    }
    

    public static Integer[] partiallyOrdered(){
        //Integer[] partiallyOrderedarr = new Integer[10000];
        Random rand = new Random();
      
        
        for(int i = 0; i <= partially.length / 2; i++){
            partially[i] = i;
        }
       // int remaining_half = partiallyOrderedarr.length / 2 + 1; 
        
        for(int i =  partially.length / 2 + 1 ; i < partially.length ; i++){            
            partially[i] = rand.nextInt(partially.length - i);
        }
        return partially;
    }
    

    public static Integer[] reverseOrdered(){
       // Integer[] reverseOrderedarr = new Integer[10000];
        int j= 0;
        for(int i =reverse.length-1 ; i >=0; i--){
            reverse[j] = i;
            j++;
        }
        return reverse;
    }

    private final Function<T, Void> f;

    public static void main(String[] args) {
        int m = 100; // This is the number of repetitions: sufficient to give a good mean value of timing
        Integer[] array = new Integer[10000];
//        for (int i = 0; i < 1000; i++)
//            array[i] = i; // TODO populate the array with real random data
//        int n = 200;
//        // TODO You need to apply doubling to n
//        benchmarkSort(array, n, "SelectionSort", new SelectionSort<>(), m);
//        benchmarkSort(array, n, "InsertionSort", new InsertionSort<>(), m);
        int n = 200;    
        for(int i = n ; i <= 10000; i=i*2){   //run for 5 different values of n
            n=i;
            random      = random();
            sorted     = ordered();
            partially = partiallyOrdered();
            reverse   = reverseOrdered();
        
            System.out.println("For sorted array");   
            benchmarkSort(sorted, n, "SelectionSort", new SelectionSort<>(), m);
            benchmarkSort(sorted, n, "InsertionSort", new InsertionSort<>(), m);
            System.out.println("For reverse array");
            benchmarkSort(reverse, n, "SelectionSort", new SelectionSort<>(), m);
            benchmarkSort(reverse, n, "InsertionSort", new InsertionSort<>(), m);
            System.out.println("For partially sorted array");
            benchmarkSort(partially, n, "SelectionSort", new SelectionSort<>(), m);
            benchmarkSort(partially, n, "InsertionSort", new InsertionSort<>(), m);
            System.out.println("For random array");
            benchmarkSort(random, n, "SelectionSort ", new SelectionSort<>(), m);
            benchmarkSort(random, n, "InsertionSort", new InsertionSort<>(), m);

//            shuffle(sorted);
//            shuffle(reverse);
//            shuffle(partially);
//            shuffle(random);
           
          //   n = n * 2;
        }
    }

    private static void benchmarkSort(Integer[] xs, Integer n, String name, Sort<Integer> sorter, int m) {
        Function<Integer, Void> sortFunction = (x) -> {
            sorter.sort(xs, 0, x);
            return null;
        };
        Benchmark<Integer> bm = new Benchmark<>(sortFunction);
        double x = bm.run(n, m);
        System.out.println(name + ": " + x + " millisecs for n=" + n);
    }
}
