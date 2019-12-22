package Observers;

import Utils.Printable;

public interface Observer extends Printable {
	void update(String message);
}
