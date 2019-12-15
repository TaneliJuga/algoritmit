/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author kamaj
 */
public class Menu {
//main alkaa-----------------------------------------------------------------------------
        public static void main(String[] args) {

                        printMenu();

        }
//main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
        private static void printMenu() {
                char select, select1;
                BinaryTree tree = null, upDated = null;
                String data;
                do {

                        System.out.println("\n\t\t\t1. Luo juurisolmu.");
                        System.out.println("\t\t\t2. Päivitä uusi uusi solmu.");
                        System.out.println("\t\t\t3. Käy puu läpi esijärjestyksessä.");
                        System.out.println("\t\t\t4. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Anna juuren sisältö (merkkijono)");
                            data = new String(Lue.rivi());
                            tree = new BinaryTree(data);
                            break;
                        case '2':
                            if (tree == null)
                                System.out.println("Et ole muodostanut juurisolmua.");
                            else {
                                System.out.println("Anna solmun sisältö (merkkijono)");
                                BinaryTree newTree = new BinaryTree(new String(Lue.rivi()));

                                tree.setNotFound();
                                tree.findWithPreOrder();
                                upDated = BinaryTree.getFound();
                                if (upDated==null) // ei valittu mitään
                                    break;
                                System.out.print("Kytke vasemmalle? (k/e)");
                                select1 = Lue.merkki();
                                if (select1=='k')
                                    upDated.setLeft(newTree);
                                else {
                                    System.out.print("Kytke oikealle? (k/e)");
                                    select1 = Lue.merkki();
                                    if (select1=='k')
                                        upDated.setRight(newTree);
                                }
                            }
                            break;
                        case '3':
                            tree.preOrder();
                            char h = Lue.merkki(); // pysäytetään kontrolli
                            break;
                        case '4':
                            break;
                        }
                }
                while (select != '4');
        }
//printMenu loppuu ----------------------------------------------------------------
}

