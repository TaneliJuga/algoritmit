/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package t3;


/**
 *
 * @author kamaj
 */
import lajitteludemo.*;
import java.util.Random;
import java.util.function.Supplier;

public class SortAlgorithms {

    /**
     * @return the counter
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * @param aCounter the counter to set
     */
    public static void setCounter(int aCounter) {
        counter = aCounter;
    }

    /**
     * @return the MAX
     */
    public static int getMAX() {
        return MAX;
    }

    /**
     * @param aMAX the MAX to set
     */
    public static void setMAX(int aMAX) {
        MAX = aMAX;
    }
    private static int MAX=30000;
    
    private static int counter = 0;
    
    private static boolean smallerThan(int a, int b){
        counter++;
        return a < b;
    }
    
    private static boolean largerThan(int a, int b){
        counter++;
        return a > b;
    }
    
    private static boolean equals(int a, int b){
        counter++;
        return a == b;
    }
    
    private static boolean notEquals(int a, int b){
        counter++;
        return a != b;
    }
    
    private static boolean smallerThanOrEqual(int a, int b){
        counter++;
        return a <= b;
    }
    
    private interface Comparison{
        public boolean compare(int a, int b);
        
        public static Comparison smallerThan(){
            return (a, b) -> a < b;
        }
        
        public static Comparison largerThan(){
            return (a, b) -> a > b;
        }
        
        public static Comparison equals(){
            return (a, b) -> a > b;
        }
    }
    
    private enum Comparisons{
        SMALLER_THAN((a,b) -> a < b),
        LARGER_THAN((a,b) -> a > b),
        EQUALS((a,b) -> a == b);
        
        private final Comparison comparison;
        private static int counter = 0;
        
        Comparisons(Comparison comparison){
            this.comparison = comparison;
        }
        
        public boolean compare(int a, int b){
            counter ++;
            return comparison.compare(a, b);
        }
        
        public static int getCount(){
            return counter;
        }
    }
    
    private static boolean makeComparison(int a, int b, Comparison c){
        setCounter(getCounter() + 1);
        return c.compare(a, b);
    }


    public static void main(String[] args) {

        selectSort();
        mergeSort();
    }

    public static void selectSort() {
        setCounter(0);
        int[] taul = new int[getMAX()]; //taul tallettaa lajiteltavat tiedot
        int i, j, k, apu, pienin;
        Random r = new Random(); //luodaan satunnaislukugeneraattori
        System.out.println("Generoidaan syöttöaineisto: ");
        for (i=0; i<getMAX();i++) {

            taul[i] = r.nextInt(1000); //generoidaan luvut
            System.out.print(taul[i]+" ");
            if (i > 0 && i%40==0) // rivinvaihto
                System.out.println();
        }
        System.out.println("\nSuoritetaan valintalajittelu, paina Enter ");
        //Lue.merkki();
        
        for (i=0;smallerThan(i, getMAX());i++) {
            pienin=i;
            for (j=i+1;smallerThan(j, getMAX());j++) {
                /* löytyykö taulukon loppupäästä pienempää alkiota? */
                if (smallerThan(taul[j], taul[pienin])) {
                    pienin=j;
                }
            }
            if (notEquals(pienin, i)) {
                /* jos löytyi suoritetaan alkioiden vaihto */
                apu=taul[pienin];
                taul[pienin]=taul[i];
                taul[i]=apu;
            }
        }
        System.out.println();
        for (i=0;smallerThan(i, getMAX());i++) {
            System.out.print(taul[i]+" ");
            if (largerThan(i, 0) && equals(i%40, 0)) // rivinvaihto
                System.out.println();
        }
        System.out.println("\nKuittaa tulos, paina Enter ");
        //Lue.merkki();

    }

    public static void mergeSort() {
        setCounter(0);
        int[] a= new int[getMAX()];
        int i;
        Random r = new Random(); //luodaan satunnaislukugeneraattori
        //System.out.println("\nGeneroidaan syöttöaineisto: ");
        for (i=0; i<getMAX(); i++) {
            a[i] = r.nextInt(1000); //generoidaan luvut
            System.out.print(a[i]+" ");
            if (i > 0 && i%40==0) // rivinvaihto
                System.out.println();
        }
        System.out.println("\nSuoritetaan lomituslajittelu, paina Enter ");
        //Lue.merkki();

        mergeSort(a, 0, getMAX()-1);
        for (i=0;i<getMAX();i++) {
            System.out.print(a[i]+" ");
             if (i > 0 && i%40==0) // rivinvaihto
                System.out.println();
        }
    }

    private static int[] tau = new int[getMAX()]; // aputaulukko (ei varata tätä pinosta!)

    //oletus: osataulukot t[p..q] ja t[q+1...r] ovat järjestyksess„
    public static void merge(int t[], int p, int q, int r) {
        //i osoittaa 1. osataulukkoa, j osoittaa 2. osataulukkoa
        // k osoittaa aputaulukkoa, johon yhdiste kirjoitetaan.
        int i=p, j=q+1, k=0;
        while(smallerThan(i, q+1) && smallerThan(j, r+1)) {
                if (smallerThan(t[i], t[j])) {
                    tau[k++]=t[i++];
                }
                else {
                    tau[k++]=t[j++];
                }
        }
        //toinen osataulukko käsitelty, siirretään toisen käsittelemättömät
        while (smallerThan(i, q+1))
                tau[k++]=t[i++];
        while (smallerThan(j, r+1))
                tau[k++]=t[j++];
        //siirretään yhdiste alkuperäiseen taulukkoon
        for (i=0;smallerThan(i, k);i++) {
                t[p+i]=tau[i];
        }
    }

    public static void mergeSort(int t[],  int alku,  int loppu) {
        int ositus;
        long la, ll, lt;
        if (smallerThan(alku, loppu)) { //onko väh. 2 alkiota, että voidaan suorittaa ositus

                la=alku; ll=loppu;
                lt=(la+ll)/2;
                ositus=(int)lt;
                mergeSort(t, alku, ositus);//lajitellaan taulukon alkupää
                mergeSort(t, ositus+1, loppu);//lajitellaan taulukon loppupää
                merge(t, alku, ositus, loppu);//yhdistetään lajitellut osataulukot
        }

    }
    
    public static void quickSortLoop() {
        counter = 0;
        int taulukko[] = new int[MAX];
        Random r = new Random();

        for (int i = 0; i < MAX; i++) {
            taulukko[i] = r.nextInt(1000);
            System.out.print(taulukko[i] + " ");
            if (i > 0 && i % 40 == 0) {// rivinvaihto
                System.out.println();
            }
        }
        System.out.println("\nJärjestellään käyttämällä Quicksorttia, paina Enter");
        //Lue.merkki();
        qs(taulukko, MAX);
        System.out.println("Valmis");
        System.out.println("Vertailujen lukumäärä: " + counter);
    }

    public static void quickSort(int table[], int lo0, int hi0) {
        int lo = lo0;
        int hi = hi0;
        int mid, swap;

        mid = table[ (lo0 + hi0) / 2];
        while (smallerThanOrEqual(lo, hi)) {
            while (smallerThan(table[lo], mid)) {
                ++lo;
            }

            while (largerThan(table[hi], mid)) {
                --hi;
            }

            if (smallerThanOrEqual(lo, hi)) {
                swap = table[lo];
                table[lo] = table[hi];
                ++lo;
                table[hi] = swap;
                --hi;
            }
        }

        if (smallerThan(lo0, hi)) {
            quickSort(table, lo0, hi);
        }
        if (smallerThan(lo, hi0)) {
            quickSort(table, lo, hi0);
        }
    }

    public static void qs(int table[], int values) {
        quickSort(table, 0, values - 1);

        System.out.println("\nJärjestetty aineisto:\n");
        for (int i = 0; i < values; i++) {
            System.out.print(table[i] + " ");
            if (i > 0 && i % 40 == 0) { // rivinvaihto
                System.out.println();
            }
        }
    }

}

