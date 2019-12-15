/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testit;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tanel
 */
public class Recursion {
    public static void main(String... args){
//        int luku = 5;
//        
//        System.out.println("kertoma1(" + luku + ") " + kertoma1(luku));
//        System.out.println("kertoma2(" + luku + ") " + kertoma2(luku));
//        System.out.println("kertoma3(" + luku + ") " + kertoma3(luku));
//        f1(10);

        array = new int[100];
        for(int i=0; i<array.length; i++){
            array[i] = i+100;        
        }
        value = 173;
        System.out.println("binarySearch " + value + " = " + binarySearch(0, 100));
    }
    
    public static int kertoma1(int n){
        if(n < 3){
            return n;
        }
        
        int tulo = 1;
        
        for(int i=2; i<=n; i++){
            tulo *= i;
        }
        
        return tulo;
    }
    
    public static int kertoma2(int n){
        if(n == 1){
            return 1;
        }else{
            return n * kertoma2(n-1); 
        }
    }
    
    public static int kertoma3(int n){
        Stack<Integer> pino = new Stack<>();
        while(n != 1){
            pino.add(n);
            n--;
        }
        
        while(pino.hasNext()){
            n *= pino.pop();
        }
        
        return n;
    }
    
    public static void f1(int a){
        if(a>0){
            f2(a-1);
        }
        System.out.print(" " + a);
    }
    
    public static void f2(int b){
        System.out.print(".");
        if(b>0){
            f1(b-1);
        }
    }
    
    private static class Stack<T>{
        private List<T> list = new LinkedList<>();
        
        public void add(T t){
            list.add(t);
        }
        
        public  T pop(){
            return list.remove(list.size()-1);
        }
        
        public boolean hasNext(){
            return !list.isEmpty();
        }
                
    }
    
    private final static int N = 2;
    
    public static double sum(double[] series){
        double sum = 0;
        double[] buffer;
        buffer = Arrays.copyOf(series, series.length);
        
        for(int i=0; i<series.length; i+=N){
            double partialSum = 0;
            for(int j=i; j < Math.min(series.length,i+N); j++){
                buffer[i] += series[j]; 
            }
            sum += partialSum;
        }
        
        return sum;
    }
    
    private static int array[];
    private static int value;
    
    public static int binarySearch(int l, int r){
        System.out.println("binarySearch(" + l + ", " + r + ")");
        if(l > r){
            return -1;
        }
        int m = Math.floorDiv(l+r, 2);
        if(array[m] < value){
            return binarySearch(m+1,r);
        }else if(array[m] > value){
            return binarySearch(l,m-1);
        }
        return m;
    }
}
