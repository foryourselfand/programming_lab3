package Other;

import java.util.ArrayList;
import java.util.List;

public class Displayers {
	private List<Displayable> displayables;

	public Displayers() {
		displayables = new ArrayList<>();
	}

	public void addDisplayable(Displayable displayable) {
		displayables.add(displayable);
	}

	public void displayAll() {
		for (Displayable displayable : displayables)
			System.out.println(displayable.display());
	}
}
