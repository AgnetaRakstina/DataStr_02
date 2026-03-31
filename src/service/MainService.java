package service;

import datastr.MyLinkedList;

public class MainService {
	
	public static void main(String[] args) {
		MyLinkedList<Character> symbols = new MyLinkedList<Character>();
		
		try {
			
			symbols.add('A');
			symbols.add('B');
			symbols.add('C');
			symbols.print();
			symbols.add('Z');
			symbols.add('X', 0); //X A B C Z
			symbols.print();
			symbols.add('U', 5); //X A B C Z U
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
