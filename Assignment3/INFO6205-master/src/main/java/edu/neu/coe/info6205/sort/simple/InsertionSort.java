package edu.neu.coe.info6205.sort.simple;

import static edu.neu.coe.info6205.sort.simple.Helper.*;
import java.util.Random;

public class InsertionSort<X extends Comparable<X>> implements Sort<X> {
   
     private static boolean less(Comparable v, Comparable w)
{ return v.compareTo(w) < 0; }
     private static void swap(Comparable[] a, int i, int j)
{
 Comparable swap = a[i];
 a[i] = a[j];
 a[j] = swap;
}
     @Override
   
    public void sort(X[] xs, int from, int to) {
        // TODO implement insertionSort
       int N = to;
 for (int i = 0; i < N; i++)
 for (int j = i; j > 0; j--)
 if (less(xs[j], xs[j-1]))
 swap(xs, j, j-1);
 else break; 
}
//    public static void main(String args[]){
//    Random rand = new Random();
//    Comparable[] ar = new Comparable[50]; 
//    for(int i=0;i<50;i++){
//    int  n = rand.nextInt(100);
//    ar[i] = n;
//    }
//    sort((X[]) ar,0,49);
//    }
}
