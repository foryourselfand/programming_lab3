package Utils.Printers;

import Utils.Printable;

public abstract class Printer {
	public abstract void print(Printable printable);
	
	public abstract void print(String message);
	
	public abstract void println(Printable printable);
	
	public abstract void println(String message);
}
