package event;

import java.util.*;

public class CalculatorEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	private String text;

	public CalculatorEvent(Object src, String t) 
	{
		super(src);
		text= t;
	}
	public String getText() {return text;}

}
