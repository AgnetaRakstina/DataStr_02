package datastr;

public class MyLinkedList<Ttype> {
	private MyNode<Ttype> firstNode = null;
	private MyNode<Ttype> lastNode= null;
	private int howManyElements = 0;
	
	//set funkciju netaisam, jo lietotajs nedrikst mainit howManyElements vertibu patstavigi
	public int getHowManyElements() {
		return howManyElements;
	}
	
	//firstNode un lastNode nataisam ne set ne get, jo nelausim lietotajam 
	//pieklut vai mainit blokus
	
	//bezargumenta konstruktors bus no object klases,
	//bez argumenta nevajag taisit
	
	public boolean isEmpty() {
		return (howManyElements == 0);
	}
	
	public boolean isFull() {
		try {
			new MyNode<Character>('A'); //megina ram atmina rezervet vietu
			return false;
		}
		catch (OutOfMemoryError e) {
			return true;
		}
	}
	
	public void add(Ttype element) throws Exception{
		if(isFull()) {
			throw new Exception("Saraksts ir pilns un nav iespejams pieveinot elementu");
		}
		if(element == null) {
			throw new Exception("Padotais elements nav noradits");
		}
		//ja bus pievienots pirmais bloks
		if(isEmpty()) {
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			lastNode = newNode;
			firstNode = newNode;
			howManyElements++;
		}
		else { //ja jau ir vismaz viens bloks ieksa ieraksta
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			
			lastNode.setNextNode(newNode);
			newNode.setPreviousNode(lastNode);
			
			lastNode = newNode;
			howManyElements++;
		}
	}
	
	
	
	
	
}
