package pino;
        


public class QueueMenu {
//main alkaa-----------------------------------------------------------------------------
        public static void main(String[] args) {

                        printMenu();

        }
//main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
        private static void printMenu() {
                char select;
                Queue q = new Queue(); // pino-olio
                String data; // Pinon data-kenttä
                do {

                        System.out.println("\n\t\t\t1. Alkion lisääminen.");
                        System.out.println("\t\t\t2. Alkion poistaminen.");
                        System.out.println("\t\t\t3. Jonon sisältö.");
                        System.out.println("\t\t\t4. Alkioiden lukumäärä.");
                        System.out.println("\t\t\t5. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Anna alkion sisältö (merkkijono)");
                            data = new String(Lue.rivi());
                            q.enqueue(data);
                            break;
                        case '2':
                            ListItem item = q.dequeue();
                            if (item == null)
                                System.out.println("Jono on tyhjä");
                            else
                                System.out.println("Poistettu alkio: "+item.getData());
                            break;
                        case '3':
                            q.printItems();
                            break;
                        case '4':
                            System.out.println("Lukumäärä = "+q.amount());
                            break;
                        case '5':
                            break;
                        }
                }
                while (select != '5');
        }
//printMenu loppuu ----------------------------------------------------------------
}
