package design;

import event.*;
import javax.swing.*;

import static service.Calculator.*;

public class CalculatorListenerImpl implements CalculatorListener
{
    private JTextArea area;
    CalculatorListenerImpl(JTextArea a)
    {
        area = a;
    }

    @Override
    public void calcEventOccurred(CalculatorEvent event) {area.append(event.getText());}

    @Override
    public void clearEventOccurred(ClearEvent e) {area.setText(null);}

    @Override
    public void equalEventOccurred(EqualEvent e)
    {
        //does computation
        String text = area.getText();

        // no text
        if (text==null||text.length()==0)
            throw new NullPointerException("CANNOT COMPUTE ON EMPTY TEXT");

            //other regular cases
        else
            area.append("\n="+ compute(text) +"\n");
    }
}
