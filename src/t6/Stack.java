package t6;
        
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class Stack {
    private LinkedList<String> list;
    
    public Stack() {
        list = new LinkedList<>();
    }

    public void push(String aData) {
        // luo lista-alkio, vie se pinon huipulle
        list.addFirst(aData);
    }

    public String pop() {
        // palauta huippualkio
        // päivitä linkki
        return list.removeFirst();
    }
    public int amount() {
        return list.size();
    }

    // operaatio, joka tulostaa pinon sisällön
    public void printItems(){
        String string = "";
        Iterator<String> iterator = list.iterator();
        StringBuilder sb = new StringBuilder();
//        while(iterator.hasNext()){
//            sb.append(", ").append(iterator.next());
//        }
        //System.out.println(sb.substring(2));
        class StateMachine{
            private Consumer<String> operation;
            private Consumer<String> operation1 = (s) -> {sb.append(", ").append(s);};
            private Consumer<String> operation2 = (s) -> {sb.append(s); operation = operation1;};
            
            public StateMachine(){
                operation = operation2;
            } 
            
            public void run(){
                while(iterator.hasNext()){
                    operation.accept(iterator.next());
                }
            }
        }
        
        StateMachine st = new StateMachine();
        st.run();
        System.out.println(sb.toString());
//        
//        Iterator<String> iterator = list.iterator();
//        StringBuilder sb = new StringBuilder();
//        while(iterator.hasNext()){
//            sb.append(", ").append(iterator.next());
//        }
//        System.out.println(sb.substring(2));
    }
}
