package edu.neu.coe.info6205.sort.simple;

import static edu.neu.coe.info6205.sort.simple.Helper.less;
import static edu.neu.coe.info6205.sort.simple.Helper.swap;

public class SelectionSort<X extends Comparable<X>> implements Sort<X> {

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
 for (int i = from; i < N; i++)
 {
 int min = i;
 for (int j = i+1; j < N; j++)
 if (less(xs[j], xs[min]))
 min = j;
 swap(xs, i, min);
 }
    }
}

