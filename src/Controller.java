import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is the controller of the Graphical User Interface (GUI)
 */
public class Controller implements ActionListener {
    private Map<Integer, Long> factorialCache = new HashMap<>();
    private GUI gui;
    public Controller(GUI gui){
        this.gui = gui;
        gui.setActionListener(this);
    }

    /**
     * This function handles all the actions performed in the gui such as button clicks
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // when an action is performed, get the value of the text field
        int number = gui.getNumber();

        // if determine if prime button was clicked
        if(e.getActionCommand().equals("Determine if Prime")){
            prime(number);
        }

        // if the get factorial button was clicked
        else if(e.getActionCommand().equals("Get Factorial")){
            long factorial = factorial(number);
            // handle negative numbers
            if(factorial == -1){
                gui.setResult("Factorial is not defined for negative numbers");
            } else {
                gui.setResult(String.valueOf(factorial));
            }
        }
    }

    /**
     * This function determines if the number is prime or not
     * @param n the number
     */
    public void prime(int n){
        // Positive numbers less than 3 are prime numbers
        if (n < 3 && n > 0) {
            gui.setResult(n + " is a Prime number");
            return;
        }
        // Other even numbers are not prime
        if (n % 2 == 0) {
            gui.setResult(n + " is not a Prime number");
            return;
        }

        // Only check for factors up to sqrt(n)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                gui.setResult(n + " is not a Prime number");
                return;
            }
        }

        // No factors found, n is prime
        gui.setResult(n + " is a Prime number");
    }

    /**
     * This function computes the factorial of a number
     * @param n the number
     * @return the factorial of the number
     */
    public long factorial(int n) {
        // block negative numbers
        if (n < 0) {
            return -1;
        }
        // if number is 0 or 1, factorial is 1
        if (n <= 1) {
            return 1;
        }

        // if the cache already has the factorial for the specific number
        if (this.factorialCache.containsKey(n)) {
            return this.factorialCache.get(n);
        }

        // get the factorial through iterative
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        // place the result in the cache
        this.factorialCache.put(n, result);
        return result;
    }
}
