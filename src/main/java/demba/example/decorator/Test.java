package demba.example.decorator;

interface Printable {
	void print();
}

class Printer implements Printable {
	public void print() {
		System.out.println("pendant");
	}
}

class Decorateur implements Printable {
	Printable original;
	int numCall = 0;
	
	public Decorateur(Printable original) {
		this.original = original;
	}
	
	public void print() {
		System.out.println("avant");
		original.print();
		System.out.println("apres");
		numCall++;
		
	}
	public int getNumCall() {
		return numCall;
	}
}

public class Test {
	public static void main(String[] args) {
		Printable printer = new Printer();
		Decorateur decoratedPrinter = new Decorateur(printer);
		decoratedPrinter.print();
		decoratedPrinter.print();
		System.out.println(decoratedPrinter.getNumCall());
	}
}
