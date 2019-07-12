import java.util.*;
import java.io.*;

class Node{
	
	char type; int col2; double cost; Node next = null;

	public Node(char type,int col2,double cost) {this.type = type; this.col2 = col2; this.cost = cost;}

	public Node(char type,int col2) {this.type = type; this.col2 = col2;}
}

public class LinkedList{
	
	Node front = null, tail = null;
	
	public void insert(char type,int col2, double cost){

		Node n1 = new Node(type, col2, cost);

		if(front == null) {front = n1; tail = n1;}
		
		else {tail.next = n1; tail = n1;}
	}

	public void insert(char type,int col2){

		Node n2 = new Node(type,col2);

		if(front == null) {front = n2; tail = n2;}
		
		else {tail.next = n2; tail = n2;}
	}
	
	public Node delete(){

		if(front == null) {return null;}

		Node n3 = front; front = front.next; return n3;
	}

	public void input(){

		String fileName = "data.text";

		try{

			File file = new File(fileName); Scanner input = new Scanner(file);

			while(input.hasNextLine()){

				String line = input.nextLine(); String[] arr = line.split("\\s+");
				
				if(arr.length == 3){
					
					char type = arr[0].charAt(0); int col2 = Integer.parseInt(arr[1]);

					double price = Double.parseDouble(arr[2]); insert(type,col2,price);
				}
				
				else if(arr.length==2){

					char type = arr[0].charAt(0); int col2 = Integer.parseInt(arr[1]);

					insert(type,col2);
				}	
			} 
			input.close();
		}
		catch(FileNotFoundException e) {
			
			System.out.println(fileName + " not found. Exiting the program.");
		}	
	}
	
	public void process(){

		Node current = front, sale = front; int custNum = 0; double discount = 0;

		while(current != null){

			if(current.type == 'R'){

				double finalPrice = current.col2*current.cost;

				System.out.println(current.col2 + " widgets received at $" + current.cost + " each.");

				System.out.println("Total Received: $" + finalPrice);
			}
			
			else if(current.type == 'P'){

				System.out.println("Next 2 customers will receive " + current.col2 + "% discount.");

				custNum = 2; discount = current.col2;
			}
			
			else{

				Node sale2 = sale; int widgetNum = 0;

				while(sale2 != current && widgetNum <= current.col2){
					
					if(sale2.type == 'R') {widgetNum += sale2.col2;}
					
					sale2 = sale2.next;
				}

				if(widgetNum >= current.col2) {widgetNum = current.col2;}
				
				System.out.println(widgetNum + " Widgets sold");
				
				double totalPrice = 0; sale2 = sale;
				
				while(sale2 != current && widgetNum > 0){

					if(sale2.type == 'R'){

						double newPrice = sale2.cost * 1.3;

						if(sale2.col2 <= widgetNum){

							System.out.println(sale2.col2 + " at $" + newPrice + " each\tSales: $"+ newPrice*sale2.col2);

							totalPrice += (newPrice * sale2.col2); widgetNum -= sale2.col2;

							sale2.col2 = 0; sale2 = sale2.next;
						}
						
						else{

							System.out.println(widgetNum + " at $" + newPrice + " each\tSales: $"+ newPrice*widgetNum);

							totalPrice += (newPrice * widgetNum); sale2.col2 -= widgetNum; widgetNum = 0;
						}	
					}
					
					else {sale2 = sale2.next;}	
				}

				sale = sale2; System.out.println("\t\tTotal Sales: $" + totalPrice);

				if(custNum > 0){
					
					double finalDiscount = totalPrice*(discount/100);
					
					System.out.println("\t\tDiscount: $" + finalDiscount);

					custNum--;
				}
				
				double totalSales = totalPrice*(1-discount/100);
				
				System.out.println("\tTotal Sales after Discount: $" + totalSales);
			}
			
			current = current.next; System.out.println();
		}
	}

	public static void main(String[] args) throws Exception{

		LinkedList list = new LinkedList(); list.input(); list.process();
	}
