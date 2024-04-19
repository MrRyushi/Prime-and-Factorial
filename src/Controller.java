import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener, DocumentListener {
    private GUI gui;
    public Controller(GUI gui){
        this.gui = gui;
        gui.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int number = gui.getNumber();
        if(e.getActionCommand().equals("Determine if Prime")){

            // Positive numbers less than 3 are prime numbers
            if (number < 3) {
                gui.setResult(number + " is a Prime number");
                return;
            }
            // Other even numbers are not prime
            if (number % 2 == 0) {
                 gui.setResult(number + " is not a Prime number");
                 return;
            }

            // Only check for factors up to sqrt(n)
            for (int i = 3; i <= Math.sqrt(number); i += 2) {
                if (number % i == 0) {
                    gui.setResult(number + " is not a Prime number");
                    return;
                }
            }

            // No factors found, n is prime
            gui.setResult(number + " is a Prime number");
        } else if(e.getActionCommand().equals("Get Factorial")){

        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
