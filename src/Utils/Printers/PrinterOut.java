package Utils.Printers;

import Utils.Printable;

public class PrinterOut extends Printer {
	@Override
	public void print(Printable printable) {
		System.out.print(printable.getPrintableMessage());
	}
	
	@Override
	public void print(String message) {
		System.out.print(message);
	}
	
	@Override
	public void println(Printable printable) {
		System.out.println(printable.getPrintableMessage());
	}
	
	@Override
	public void println(String message) {
		System.out.println(message);
	}
}
