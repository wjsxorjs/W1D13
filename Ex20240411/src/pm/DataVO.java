package pm;

import java.io.Serializable;

public class DataVO implements Serializable {
	private String name;
	private int value;
	
	// getter
	public String getName() {
		return name;
	}
	public int getValue() {
		return value;
	}
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
}
