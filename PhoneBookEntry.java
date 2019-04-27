/* Given a text file of parallel arrays (the first array of last names, the second with first names, and the third with
phone numbers), this algorithm allows the user to look up the phone number of the entry via reverse look up and the name via 
look up; it also handles exceptions of an existing text file and first name/last name or the corresponding phone number
entry.
*/

import java.io.*;
import java.util.*;

class Name {
	public Name(String last, String first) {this.last = last; this.first = first;}
	public Name(String first) {this("", first);}

	public String getFormal() {return first + " " + last;}
	public String getOfficial() {return last + ", " + first;}
	public String getInitials() {return first.charAt(0) + "." + last.charAt(0) + ".";}


	public boolean equals(Name other) {return first.equals(other.first) && last.equals(other.last);}
	public String toString() {return first + " " + last;}

	public static Name read(Scanner scanner) {
		if (!scanner.hasNext()) return null;
		String last = scanner.next();
		String first = scanner.next();
		return new Name(last, first);
	}
	
	public String toString(Name name) {return new Name(last, first) + "";}

	private String first, last;

	public static void main(String [] args) throws Exception {
		Scanner scanner = new Scanner(new File("names.text"));
		int count = 0;
		Name name = read(scanner);
		Name name2 = read(scanner);
		Name name3 = read(scanner);
		Name name4 = read(scanner);
		while(name != null) {
			System.out.println("name: " + name.toString(name));
			System.out.println("formal: " + name.getFormal());
			System.out.println("official: " + name.getOfficial());
			System.out.println("initials: " + name.getInitials());
			System.out.println();
			
			if (name.equals(name2)) {
				System.out.println("Duplicate name \"" +  name2 +  "\" discovered."); 
				count++;
			}
			else {
				System.out.println("name: " + name2.toString(name));
				System.out.println("formal: " + name2.getFormal());
				System.out.println("official: " + name2.getOfficial());
				System.out.println("initials: " + name2.getInitials());
				System.out.println();
				count++;
			}
			if (name2.equals(name3)) {
				System.out.println("Duplicate name \"" + name3  + "\" discovered.");
				count++;
			}
			else {
				System.out.println("name: " + name3.toString(name));
				System.out.println("formal: " + name3.getFormal());
				System.out.println("official: " + name3.getOfficial());
				System.out.println("initials: " + name3.getInitials());
				System.out.println();
				count++;
			}
			if(name3.equals(name4)) {
				System.out.println("Duplicate name \"" + name4 + "\" discovered.");
				count++;
			}
			else {
				System.out.println("name: " + name4.toString(name));
				System.out.println("formal: " + name4.getFormal());
				System.out.println("official: " + name4.getOfficial());
				System.out.println("initials: " + name4.getInitials());
				System.out.println();
				count++;
			}
			name = read(scanner);
			name2 = read(scanner);
			name3 = read(scanner);
			name4 = read(scanner);
			count++;
		}
		System.out.println("---");
		System.out.print(count + " names processed.");
	}
}

class PhoneNumber{
	private String number;
	
	public PhoneNumber(String number) {this.number = number;}
		
	public String getAreaCode() {return number.substring(1,4);}
	public String getExchange() {return number.substring(5,8);}
	public String getLineNumber() {return number.substring(9,13);}
	public boolean isTollFree() {if (number.charAt(1) == '8') return true; else return false;}
	public String toString() {return number + ""; }
	
	public boolean equals(PhoneNumber phoneNum) {return number.equals(phoneNum.number);}
	public static PhoneNumber read(Scanner infile) {
		if(!infile.hasNext()) return null;
		String number = infile.next();
		return new PhoneNumber(number);
	}
	
	public static void main(String[] args) throws Exception{
		Scanner infile = new Scanner (new File("numbers.text"));
		int count = 0;
		PhoneNumber p = read(infile);
		while(p != null) {
			System.out.println("phone number: " + p.toString());
			System.out.println("area code: " + p.getAreaCode());
			System.out.println("exchange: " + p.getExchange());
			System.out.println("line number: " + p.getLineNumber());
			System.out.println("is toll free: " + p.isTollFree());
			System.out.println();
			count++;
			PhoneNumber p2 = read(infile);
			if(p2 != null) 
				while(p.equals(p2)) {
				System.out.println("Duplicate phone number \"" + p2 + "\" discovered.");
				p = p2;
				p2 = read(infile);
				count++;
			}
			p = p2;
		}
		System.out.println("---");
		System.out.print(count + " phone numbers processed.");
	}
}

class PhonebookEntry {
  private Name name;
  private PhoneNumber phoneNumber;
  
  public PhonebookEntry(Name name, PhoneNumber phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }
  
  public String call(){if(phoneNumber.isTollFree()) return "Dialing (toll-free) " + name + ": " + phoneNumber; else return "Dialing " + name + ": " + phoneNumber;}
  
  public String toString() {
    return name.toString() + ": " + phoneNumber.toString();
  }
  
  public boolean equals(PhonebookEntry other) {
    return name.equals(other.name) && phoneNumber.equals(other.phoneNumber);
  }
  
  public static PhonebookEntry read(Scanner in) {
    if(!in.hasNext()) return null;
        Name name = Name.read(in);
        PhoneNumber phoneNumber = PhoneNumber.read(in);
        return new PhonebookEntry(name, phoneNumber);
  }
  
  public Name getName() {return name;}
  
  public PhoneNumber getPhoneNumber() {return phoneNumber;}
  
  public static void main(String [] args) throws Exception {
    Scanner in = new Scanner(new File("phonebook.text"));
    int count = 0;
    PhonebookEntry first = read(in);
    while(first != null) {
    	System.out.println("phone book entry: " + first.toString());
    	System.out.println(first.call());
    	System.out.println();
    	count++;
    	PhonebookEntry next = read(in);
    	if(next != null)
    		while(first.name.equals(next.name) && !first.phoneNumber.equals(next.phoneNumber)){
    			System.out.println("Warning duplicate name encountered \"" + first.name + ": "+ next.phoneNumber+ "\" discovered");
    			first = next;
    			System.out.println("phone book entry: " + first.toString());
    			System.out.println(first.call());
    			System.out.println();
    			next=read(in);
    			count++;	
    		}
    	if(next!=null)
    		while(first.name.equals(next.name) &&  first.phoneNumber.equals(next.phoneNumber)){
    			System.out.println("Duplicate phone book entry \"" + first.name + ": "+ first.phoneNumber+ "\" discovered");
    			first = next;
    			next=read(in);
    			count++;
    		} 
    	first = next;
    }
 		System.out.println("---");
 		System.out.println(count + " phonebook entries processed.");
 	}
}

class Phonebook{
	
	public static void main(String [] args) {
		try {
			Scanner sc = new Scanner(System.in);
			final int CAPACITY = 100;
			int lookUp = 0;
			int revLookUp = 0;
			PhonebookEntry [] entry = new PhonebookEntry[CAPACITY];
			int size = read(entry,CAPACITY);
			System.out.print("lookup, reverse-lookup, quit (l/r/q)? ");
			String answer = sc.next();
			while (sc.hasNextLine()) {
				if (answer.equals("l")) {
					System.out.print("last name? ");
					String last = sc.next();
					System.out.print("first name? ");
					String first = sc.next();
					Name name = new Name(last, first);
					int num = lookup(entry, size, name);
					if (num >= 0) System.out.println(entry[num].getName() + "'s phone number is " + entry[num].getPhoneNumber()+"\n");
					else System.out.println("-- Name not found\n");
					lookUp++;
				}
				if (answer.equals("r")) {
					System.out.print("phone number (nnn-nnn-nnnn)? ");
					String num = sc.next(); 
					PhoneNumber phoneNumber = new PhoneNumber(num);
					int numPos = revLook(entry, size, phoneNumber);
					if (numPos >= 0) System.out.println(num + " belongs to " + entry[numPos].getName()+"\n");
					else System.out.println("-- Phone number not found\n");
					revLookUp++;
				}
				if (answer.equals("q")) {
					System.out.println("\n" + lookUp + " lookups performed");
					System.out.print(revLookUp + " reverse lookups performed" + "\n");
					System.exit(1);
				}
				System.out.print("lookup, reverse-lookup, quit (l/r/q)? ");
				answer = sc.next();
			}
			sc.close();
		}
		catch(FileNotFoundException f) {
			System.out.println(" *** IOException *** phonebook.text (No such file or directory)");	
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static int read(PhonebookEntry[] entry, int CAPACITY) throws Exception {
	    Scanner in = new Scanner(new File("phonebook.text"));
	    PhonebookEntry pbe = PhonebookEntry.read(in);
	    int size = 0;
		while(pbe!=null) {
			if(size == CAPACITY) throw new Exception("*** Exception *** Phonebook capacity exceeded - increase size of underlying array");
			entry[size] = pbe;
			size++;
			pbe = PhonebookEntry.read(in);
		}
		return size;
	}
	public static int lookup(PhonebookEntry[] entry, int size, Name name) {
		for (int i = 0; i < size; i++)
			if((entry[i]).getName().equals(name)) 
				return i;
		return -1;
	}
	public static int revLook(PhonebookEntry[] entry, int size, PhoneNumber number) {
		for (int i = 0; i < size; i++)
			if (entry[i].getPhoneNumber().equals(number))
				return i;
		return -1;
	}
}
