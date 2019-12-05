package pino;
        


public class Stack {
	
	ListItem top;
	private int size;
	
	public Stack() {
		top = null;
		size = 0;
	}
	
	public void push(String aData) {
            // luo lista-alkio, vie se pinon huipulle
            ListItem newTop = new ListItem();
            newTop.setData(aData);
            newTop.setLink(top);
            top = newTop;
            size++;
	}

	public ListItem pop() {
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
