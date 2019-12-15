package Testit;
        
import pino.*;



public class ListItem {
	private String data; // datamuuttuja
	private ListItem next; // viite seuraaja-alkioon
	
	public ListItem() {
		next = null; // taitaa olla oletusarvo
	}
	public String getData() {
		return data;
	}
	public void setData(String aData){
		data = aData;
	}
	public void setLink(ListItem aLink){
		next = aLink;
	}
	public ListItem getLink(){
		return next;
	}
}
