package datastr;

public class MyLinkedList<Ttype> {
	private MyNode<Ttype> firstNode = null;
	private MyNode<Ttype> lastNode= null;
	private int howManyElements = 0;
	
	//set funkciju netaisam, jo lietotajs nedrikst mainit howManyElements vertibu patstavigi
	public int getHowManyElements() {
		return howManyElements;
	}
	
	//firstNode un lastNode netaisam ne set ne get, jo nelausim lietotajam 
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
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			
			//veicam lecienu lidz pozicijai -1
			MyNode<Ttype> currentNode = firstNode;// TODO noskaidrot no kuras
			
			for(int i = 1; i <= position-1; i++) {
				currentNode = currentNode.getNextNode();
			}
			
			MyNode<Ttype> leftNode = currentNode;
			MyNode<Ttype> rightNode = leftNode.getNextNode();
			
			leftNode.setNextNode(newNode);
			newNode.setPreviousNode(leftNode);
			
			rightNode.setPreviousNode(newNode);
			newNode.setNextNode(rightNode);
			
			howManyElements++;
			
		}
	}

	//TODO
	//1. remove by position
	//2. veicam nepieciesamas parbaudes
	//3. ja dzesam no prieksas
	//4. ja dzesam pedejo (position == howmanyElements-1
	//5. ja jadzess kads elements pa vidu
	// veicam leksanu lidz tai pozicijai, noskaidrojam bloku, kas pa labi
	// kas pa kreisi un tas sava starpa saista
	//6. samazinat how manyelements
	
	public void remove(int position) throws Exception {
		if (isEmpty()) {
			throw new Exception("Saraksta nav nevienu elementu");
		}
		else if (position < 0) {
			throw new Exception("Pozicija var but tikai pozitiva");
		}
		else if (position >= howManyElements) {
			throw new Exception("Pozicija nevar but lielaka par esoso elementu skaitu");
		}
		
		// dzess no prieksas
		if (position == 0) {
			firstNode = firstNode.getNextNode();
			firstNode.setPreviousNode(null);
			
			howManyElements--;
		}
		else if (position == howManyElements-1) {
			lastNode = lastNode.getPreviousNode();
			lastNode.setNextNode(null);
			howManyElements--;
		}
		else {
			MyNode<Ttype> currentNode = firstNode;
			
			for(int i = 1; i < position; i++) {
				currentNode = currentNode.getNextNode();
			}
			
			MyNode<Ttype> leftNode = currentNode.getPreviousNode();
			MyNode<Ttype> rightNode = currentNode.getNextNode();
			
			leftNode.setNextNode(rightNode);
			rightNode.setPreviousNode(leftNode);
			
			howManyElements--;

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
