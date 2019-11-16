package t4;

interface Iterator {
    boolean hasNext();
    Object next();
}

public class StackIterator implements Iterator {
    private ListItem  current;
    private Stack container; // container on tietorakenne, jota iteroidaan

    StackIterator (Stack c) { // konstruktori on "package visible"
        container = c;
        current = container.top;
    }
    // palautetaan tieto siitä, löytyyko rakenteesta seuraava alkio
    // hmm... palautetaan tieto siitä, osoittaako nykypositio (current) alkiota vai ei.
    public boolean hasNext() {
        if (current == null)
            return false;
        else
            return true;
    }
    // palautetaan nykyinen (lista-alkio) ja siirretään nykypositiota pykälä eteenpäin
    public ListItem next() {
        ListItem oldCurrent = current;
        current=current.getLink();
        return oldCurrent;
    }

}
