/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lajitteludemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @author tanel
 */
public class LajitteluTesti {
    public static void main(String... args){
        int[] arraySizes = {10000, 20000, 30000}; 
 
        for(int arraySize : arraySizes){
            for(SortingAlgorithm alg : SortingAlgorithm.values()){
                alg.getComparisonCount(arraySize);
            }
        }
        System.out.println();
        System.out.print("results:" + "\t");
        for(int arraySize : arraySizes){
            System.out.print(arraySize + "\t");
        }
        System.out.println();
        
        for(SortingAlgorithm alg : SortingAlgorithm.values()){
            alg.printResults();
        }
    }
    
    enum SortingAlgorithm{
        SELECT_SORT(SortAlgorithms::selectSort, "select sort"),
        MERGE_SORT(SortAlgorithms::mergeSort, "merge sort"),
        QUICK_SORT(SortAlgorithms::quickSortLoop, "quick sort");
        
        private Runnable algorithm;
        private List<Integer> list = new ArrayList<>();
        private String name;
        
        SortingAlgorithm(Runnable algorithm, String name){
            this.algorithm = algorithm;
            this.name = name;
        } 
        
        public int getComparisonCount(int arraySize){
            SortAlgorithms.setMAX(arraySize);
            algorithm.run();
            list.add(SortAlgorithms.getCounter());
            return SortAlgorithms.getCounter();
        }
        
        public void printResults(){
            System.out.println(name + ": "  + "\t" + list);
        }
    }
}
