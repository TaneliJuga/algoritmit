package t4;
        
public class Stack {

        ListItem top; // top näkyy oletuspakkaukseen
        private int size;

        public Stack() {
                top = null;
                size = 0;
        }
        //  palautetaan pino-iteraattori
        public StackIterator iterator() {
            return new StackIterator(this);
        }
        // muodostetaan uusi alkio ja viedään se huipulle
        public void push(String aData) {
                ListItem newItem = new ListItem(); // luodaan uusi lista-alkio
                newItem.setData(aData);
                newItem.setLink(top); // kytketään uusi alkio aikaisempaan huippualkioon
                top = newItem; // uusi alkio pinon 1:ksi
                size++;
        }
        // poistetaan alkio pinon huipulta, jos pinossa ei alkioita palautetaan null
        public ListItem pop() {
                ListItem takeAway;
                if (top == null) {
                        takeAway = null; // pino on tyhjä
                }
                else
                {
                        size--;
                        takeAway = top;
                        top = top.getLink();
                }
                return takeAway;
        }
        // palautetaan pinottujen alkioiden lukumäärä
        public int amount() {
                return size;
        }
        // listataan sisältö
        public void printItems() {
                ListItem lPointer = top;
                while (lPointer != null) {
                        System.out.print(lPointer.getData()+", ");
                        lPointer = lPointer.getLink();
                }

        }
}
