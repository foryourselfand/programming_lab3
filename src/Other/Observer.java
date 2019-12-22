package Other;

import Utils.Displayable;

public interface Observer extends Displayable {
	void update(String message);
}
