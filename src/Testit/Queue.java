package Testit;

import pino.*;




public class Queue implements Iterable{
	
    private static final int MAX_SIZE = 100;
    private String[] array;
    private String top;
    private int index;
	
	public Queue() {
            array = new String[MAX_SIZE];
            index = 0;
	}
	
	public void enqueue(String aData) {
            // luo lista-alkio, vie se pinon huipulle
            array[index++] = aData;
	}

	public String dequeue() {
            // palauta huippualkio
            // päivitä linkki
            return array[index--];
	}
	public int amount() {
            return index;
	}
	
	// operaatio, joka tulostaa pinon sisällön
        public void printItems(){
            Iterator iterator = this.getIterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }

    @Override
    public Iterator getIterator() {
        return new QueueIterator(this);
    }
        
    private static class QueueIterator implements Iterator {
        private Queue container; // container on tietorakenne, jota iteroidaan
        private int current;

        QueueIterator (Queue c) { // konstruktori on "package visible"
            container = c;
            current = container.index;
        }
        // palautetaan tieto siitä, löytyyko rakenteesta seuraava alkio
        // hmm... palautetaan tieto siitä, osoittaako nykypositio (current) alkiota vai ei.
        public boolean hasNext() {
            if (current <= 0)
                return false;
            else
                return true;
        }
        // palautetaan nykyinen (lista-alkio) ja siirretään nykypositiota pykälä eteenpäin
        public String next() {
            return container.array[current--];
        }
    }
}
