
import java.util.EventListener;

public interface CalculatorListener extends EventListener
{
	public void calcEventOccured(CalculatorEvent e);
	public void clearEventOccured(ClearEvent e);
	public void equalEventOccured(EqualEvent e);
}
