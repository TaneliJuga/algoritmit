package pino;




public class Queue {
	
    private static final int MAX_SIZE = 100;
    private String[] array;
    private ListItem bottom;
    private ListItem top;
    private int size;
	
	public Queue() {
            array = new String[MAX_SIZE];
	}
	
	public void enqueue(String aData) {
            // luo lista-alkio, vie se pinon huipulle
            array[size++] = aData;
	}

	public String dequeue() {
            // palauta huippualkio
            // päivitä linkki
            return array[size--];
	}
	public int amount() {
            return size;
	}
	
	// operaatio, joka tulostaa pinon sisällön
        public void printItems(){
            ListItem item = top;
            while(item != null){
                System.out.println(item.getData());
                item = item.getLink();
            }
        }
}
