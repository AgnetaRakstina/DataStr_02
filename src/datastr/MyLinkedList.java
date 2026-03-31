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
	
	//TODO 
	// izveidot add funkciju kura padod elementu un poziciju kur ielikt
	// veikt nepieciesamas parbaudes 
	// ja velas pievienot 0 pozicija
	// ja velas pievienot beigas
	// ja velas pievienot pa vidu
	public void  add(Ttype element, int position) throws Exception {
		if(isFull()) {
			throw new Exception("Saraksts ir pilns un nav iespejams pieveinot elementu");
		}
		if(element == null) {
			throw new Exception("Padotais elements nav noradits");
		}
		if(position < 0) {
			throw new Exception("Pozicija var but tikai pozitiva");
		}
		if(position > howManyElements) {
			throw new Exception("Pozicija nevar but lielaka par esoso elementu");
		}
		
		//ja velas pievienot 0 pozcija
		if(position == 0) {
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			
			newNode.setNextNode(firstNode);
			firstNode.setPreviousNode(newNode);
			
			firstNode = newNode;
			howManyElements++;
		}
		//ja velas pievienot beigas
		else if (position == howManyElements) {
			add(element);
		}
		//ja velas pievienot pa vidu
		else {
			
		}
		
		
	}
	
	
	
	
	public void print() throws Exception {
		if(isEmpty()) {
			throw new Exception("Saraksta nav elementu, lidz ar to nevar neko izprintet");
		}
		
		MyNode<Ttype> currentNode = firstNode;
		
		while(currentNode !=  null) {
			System.out.print(currentNode.getElement() + " ");
			currentNode = currentNode.getNextNode();
		}
		System.out.println();
	}
	
	
	
}
