package assignment6;

import java.util.InputMismatchException;

public class HTag extends Tag{
	
	public HTag(String text, int num) {
		super("h", text);
		if(num < 1 || num > 6) {
			throw new InputMismatchException("Must be between 1 and 6");
		}
		this.tagName = tagName + num;
	}
}
