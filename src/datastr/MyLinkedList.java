package datastr;

import java.util.ArrayList;


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
			
			MyNode<Ttype> currentNode = null;
			
			if(position < howManyElements/2) {
				currentNode = firstNode;
				for(int i = 1; i <= position-1; i++) {
					currentNode = currentNode.getNextNode();
				}
			}
			//pozicija ir tuvak pedejam blokam un veic leksanu
			//no pedeja bloka uz atpakalu
			else {
				currentNode = lastNode;
				for(int i = howManyElements; i > position; i--) {
					currentNode = currentNode.getPreviousNode();
				}
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
			
			for(int i = 1; i <= position; i++) {
				currentNode = currentNode.getNextNode();
			}
			
			MyNode<Ttype> leftNode = currentNode.getPreviousNode();
			MyNode<Ttype> rightNode = currentNode.getNextNode();
			
			leftNode.setNextNode(rightNode);
			rightNode.setPreviousNode(leftNode);
			
			howManyElements--;

		}
	}
	
	public Ttype get(int position) throws Exception {
		if(isEmpty()) {
			throw new Exception("Saraksts ir tukss, lidz ar to nevaram veikt elementa atgriesanu");
		}
		else if(position < 0) {
			throw new Exception("Pozicija nevar but negativa");
		}
		else if(position >= howManyElements) {
			throw new Exception("Pozicija nevar but lielaka vai vienada par elementu skaitu");
		}
		
		MyNode<Ttype> currentNode = null;
		
		if(position < howManyElements/2) {
			currentNode = firstNode;
			for(int i = 1; i <= position; i++) {
				currentNode = currentNode.getNextNode();
			}
		}
		else {
			currentNode = lastNode;
			for(int i = howManyElements; i > position+1; i--) {
				currentNode = currentNode.getPreviousNode();
			}
		}
		
		return currentNode.getElement();
	}
	
	public ArrayList<Integer> search(Ttype element) throws Exception {
		if(isEmpty()) {
			throw new Exception("Saraksts ir tukss un nevar neko atgriezt");
		}
		else if (element == null) {
			throw new Exception("Padotais elements nav noradits");
		}
		
		ArrayList<Integer> foundPositions = new ArrayList<Integer>();
		int tempPosition = 0;
		MyNode<Ttype> currentNode = firstNode;
		
		while(currentNode != null) {
			if (currentNode.getElement().equals(element)) {
				foundPositions.add(tempPosition);
			}
			tempPosition++;
			
			currentNode = currentNode.getNextNode();
		}
		
		if(foundPositions.isEmpty()) {
			throw new Exception("Nav atrasts neviens tads elements");
		}
		
		return foundPositions;
	}
	
	public void makeEmpty() {
		firstNode = null;
		lastNode = null;
		howManyElements = 0;
		System.gc();
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
