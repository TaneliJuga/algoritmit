package t2;

public class Queue {
	
	private ListItem bottom;
        private ListItem top;
	private int size;
	
	public Queue() {
            bottom = null;
            top = null;
            size = 0;
	}
	
	public void enqueue(String aData) {
            // luo lista-alkio, vie se pinon huipulle
            ListItem newBottom = new ListItem();
            newBottom.setData(aData);
            if(bottom != null){
                bottom.setLink(newBottom);
            }
            bottom = newBottom;
            size++;
            if(top == null){
                top = bottom;
            }
	}

	public ListItem dequeue() {
            // palauta huippualkio
            // päivitä linkki
            ListItem temp = top;
            top = top != null ? top.getLink() : null;
            size--;
            return temp;
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
