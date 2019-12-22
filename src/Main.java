import Observers.ObservableOwl;
import Observers.Observer;
import Observers.ObserverWinnieThePooh;
import Utils.Breath;
import Utils.Printable;
import Utils.Printers.Printer;
import Utils.Printers.PrinterOut;
import Utils.RandomHolder;
import Words.*;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		class PrinterNothingLocal extends Printer {
			@Override
			public void print(Printable printable) {
			}
			
			@Override
			public void print(String message) {
			}
			
			@Override
			public void println(Printable printable) {
			}
			
			@Override
			public void println(String message) {
			}
		}
		
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
		
		ElementGetter[] elementGetters = new ElementGetter[]{elementGetterStart, elementGetterEnd};
		IndexManipulator[] indexManipulators = new IndexManipulator[]{new IndexManipulator.Sequence.Increasing(1)};
		
		ElementsGetter wordGetterRightOrder = new ElementsGetter(elementGetters, indexManipulators);
		ElementsGetter wordGetterReverseOrder = new ElementsGetter(elementGetters, indexManipulators,
				new ElementFormatter(new StringFormatter.Reverse(), index->true));
		
		long seedStart = RandomHolder.getInstance().random.nextLong();
		
		RandomHolder.getInstance().random.setSeed(seedStart);
		for (int i = 0; i < 10; i++) {
			String fullWord = wordGetterRightOrder.getElements();
			observableOwl.addMessage(fullWord);
			for (Observer observer : observersOwl)
				printer.println(observer);
		}
		
		String firstMessage = observableOwl.getFirstMessage();
		observableOwl.reset();
		
		printer.println("Первое сообщение: " + firstMessage);
		printer.println("");
		
		printer.println("Обратный порядок");
		RandomHolder.getInstance().random.setSeed(seedStart);
		for (int i = 0; i < 10; i++) {
			String fullWord = wordGetterReverseOrder.getElements();
			observableOwl.addMessage(fullWord);
			for (Observer observer : observersOwl)
				printer.println(observer);
		}
		
		ElementGetter nameGetter = new ElementGetter(ElementFiller.ENGLISH.ALPHABET_AND_SYLLABLES,
				new ElementFormatter(String::toUpperCase, index->index <= 1),
				new ElementFormatter(new StringFormatter.Mirror(), index->RandomHolder.getInstance().random.nextFloat() <= 0.1f),
				new ElementFormatter(new StringFormatter.Multiple(), new ConditionFilter.Random(0.3f)),
				new ElementFormatter(new StringFormatter.Reverse(), new ConditionFilter.Random.Wrapper(0.7f, index->index % 3 == 1))
		);
		ElementGetter spaces = new ElementGetter(ElementFiller.SPACE);
		
		ElementGetter[] fullNameElements = new ElementGetter[]{nameGetter, spaces, nameGetter};
		IndexManipulator[] fullNameLengths = new IndexManipulator[]{
				index->RandomHolder.getInstance().random.nextInt(3) + 4,
				index->1,
				index->RandomHolder.getInstance().random.nextInt(7) + 4
		};
		ElementsGetter namesGetter = new ElementsGetter(fullNameElements, fullNameLengths);
		
		String name;
		do {
			name = namesGetter.getElements();
		} while (RandomHolder.getInstance().random.nextInt(100) != 50);
		printer.println("Зачитать это объявление должен: " + name);
		
		List<String> messages = observableOwl.getMessages();
		for (String message : messages) {
			printer.println(message);
		}
	}
}
