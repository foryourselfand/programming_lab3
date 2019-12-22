import Observers.ObservableOwl;
import Observers.Observer;
import Observers.ObserverWinnieThePooh;
import Utils.Breath;
import Utils.Printers.Printer;
import Utils.Printers.PrinterOut;
import Utils.RandomHolder;
import Words.*;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		Printer printer = new PrinterOut();
		
		ObservableOwl observableOwl = new ObservableOwl();
		
		ObserverWinnieThePooh observerWinnieThePooh = new ObserverWinnieThePooh(observableOwl, Breath.STRONG);
		printer.println(observerWinnieThePooh);
		printer.println("");
		
		ObserverWinnieThePooh.MonitorMessage monitorMessage = observerWinnieThePooh.new MonitorMessage();
		ObserverWinnieThePooh.Length length = observerWinnieThePooh.new Length();
		ObserverWinnieThePooh.Sequence sequence = observerWinnieThePooh.new Sequence();
		ObserverWinnieThePooh.MonitorBlank monitorBlank = observerWinnieThePooh.new MonitorBlank();
		List<Observer> observersOwl = observableOwl.getObservers();
		
		
		ElementGetter elementGetterStart = new ElementGetter(
				ElementFiller.RUSSIAN.ALPHABET,
				(int index)->RandomHolder.getInstance().random.nextInt(index),
				new ElementFormatter(String::toUpperCase, index->index <= 1),
				new ElementFormatter(element->new StringBuilder(element).reverse().toString(), index->true)
		);
		
		ElementGetter elementGetterEnd = new ElementGetter(
				ElementFiller.SYMBOLS.DEFAULT/*,
				new ElementFormatter(element->
				{
					StringBuilder stringBuilder = new StringBuilder(element);
					int multiplier = RandomHolder.getInstance().random.nextInt(2) + 1;
					for (int i = 0; i < multiplier; i++)
						stringBuilder.append(")");
					return stringBuilder.toString();
				}, (index)->true)*/
		);
		
		ElementsGetter wordGetter = new ElementsGetter(
				new ElementGetter[]{elementGetterStart, elementGetterEnd},
				new IndexManipulator[]{new IndexManipulator.Sequence.Increasing(1), index->1},
				new ElementFormatter(new StringFormatter.Reverse())
		);
		
		long seedStart = RandomHolder.getInstance().random.nextLong();
		
		RandomHolder.getInstance().random.setSeed(seedStart);
		for (int i = 0; i < 10; i++) {
			String fullWord = wordGetter.getElements();
			observableOwl.addMessage(fullWord);
			for (Observer observer : observersOwl)
				printer.println(observer);
		}
		
		String firstMessage = observableOwl.getFirstMessage();
		String lastMessage = observableOwl.getLastMessage();
		
		printer.println("Первое сообщение: " + firstMessage);
		printer.println("Последнее сообщение: " + lastMessage);
		printer.println("");
		
		observableOwl.announceReader();
	}
}
