package service;

import java.util.Arrays;

import datastr.MyLinkedList;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Character> symbols = new MyLinkedList<Character>();
		
		try
		{
			System.out.println("========= DARBS AR SIMBOLIEM =============");
			symbols.add('A');//A
			symbols.add('B');//B
			symbols.add('C');//C
			symbols.print();//A B C
			symbols.add('Z');//A B C Z
			symbols.print();//A B C Z
			symbols.add('X', 0);//X A B C Z
			symbols.print();//X A B C Z
			symbols.add('U', 5);//X A B C Z U
			symbols.print();//X A B C Z U
			symbols.add('Q', 2);
			symbols.print(); // X A Q B C Z U
			
			//removing
			System.out.println("========= DZESANA =============");
			symbols.remove(0); //A Q B C Z U
			symbols.print();
			symbols.remove(5); // A Q B C Z
			symbols.print();
			symbols.remove(2); // A Q C Z
			symbols.print();
			
			
			//meklesana
			System.out.println("========= MEKLESANA =============");
			System.out.println(symbols.search('A'));
			symbols.add('Q');
			System.out.println(symbols.search('Q'));
			symbols.add('Q');
			System.out.println(symbols.search('Q'));
			
			//make empty
			System.out.println("========= ATVRIVO SARAKSTU =============");
			symbols.makeEmpty();
			symbols.add('E');
			symbols.print();
			
			//ar studentiem
			System.out.println("========= STUDENTI =============");
			MyLinkedList<Student> allStudents = new MyLinkedList<Student>();
			Student s1 = new Student("Janis", "Berzins", "121212-68790");
			Student s2 = new Student("Baiba", "Jauka", "122323-23456");
			Student s3 = new Student("Liga", "Nejauka", "345675-34567");
			
			try {
				allStudents.add(s1);
				allStudents.add(s2);
				allStudents.add(s3,0);
				allStudents.print();
				System.out.println(allStudents.get(1)); //Janis
				System.out.println(allStudents.search(s3)); //0 <- kursa indeksa glabaja
				
				
				
				allStudents.print();
				allStudents.remove(2);
				allStudents.print(); // vairs nav baibas
				allStudents.makeEmpty();
				allStudents.add(new Student("Karina", "Skirmante", "121234-12212"));
				allStudents.print(); //+ karina
				
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}