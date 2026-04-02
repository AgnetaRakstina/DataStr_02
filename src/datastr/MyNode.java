package datastr;

public class MyNode<Ttype> {
	// mainigie
	private Ttype element;
	private MyNode<Ttype> nextNode = null;
	private MyNode<Ttype> previousNode = null;
	
	//getters
	public Ttype getElement() {
		return element;
	}
	public MyNode<Ttype> getNextNode() {
		return nextNode;
	}
	public MyNode<Ttype> getPreviousNode() {
		return previousNode;
	}

	//setters
	public void setElement(Ttype inputElement) {
		if(inputElement != null) {
			element = inputElement;
		}
		else {
			element = (Ttype)new Object();
		}
		
	}
	//nav javeic not null parbaudes, jo var but gacijumi, ka ir null vieniba
		public void setNextNode(MyNode<Ttype> nextNode) {
			this.nextNode = nextNode;
	}
		public void setPreviousNode(MyNode<Ttype> previousNode) {
			this.previousNode = previousNode;
	}
	//bez argumenta konstruktors nav vajadzigs, jo vienmer lietotajam but japadod elements
	public MyNode(Ttype inputElement) {
		setElement(inputElement);
	}
	//pievieno klat "" + lai elements tiktu parveidots par string
	public String toString() {
		return "" + element;
	}
		
		
		
		
		
		
}
