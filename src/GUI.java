import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The Graphical User Interface Using Java Swing
 */
public class GUI extends JFrame {
    /**
     * Create an input text field and buttons
     */
    private JTextField input;
    private JButton btnDetermineIfPrime;
    private JButton btnGetFactorial;
    private JLabel result;
    public GUI() {
        super("GUI");
        // set layout to border layout
        this.setLayout(new BorderLayout());
        // set the gui size
        this.setSize(400, 200);
        // set resizable to false
        this.setResizable(false);
        // set to exit program when gui is closed
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // call function to layout components in gui
        layoutComponents();
        // set to center gui
        this.setLocationRelativeTo(null);
        // set gui to visible
        this.setVisible(true);
    }

    public void layoutComponents() {
        // Create a panel and set its layout to GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(4, 47, 46));

        // Create label
        JLabel label = new JLabel("Enter a number:");
        label.setForeground(Color.WHITE);

        // Create text field
        input = new JTextField(20);  // size by columns

        // Create a panel for the buttons
        JPanel panelBtns = new JPanel();
        panelBtns.setBackground(new Color(4, 47, 46));

        // Create determine if prime button
        btnDetermineIfPrime = new JButton("Determine if Prime");

        // Create get factorial button
        btnGetFactorial = new JButton("Get Factorial");

        // Add the buttons to this new panel
        panelBtns.add(btnDetermineIfPrime);
        panelBtns.add(btnGetFactorial);

        // Create label for result
        result = new JLabel("Result");
        result.setForeground(Color.WHITE);

        // Create GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;  // end row after this component
        gbc.fill = GridBagConstraints.HORIZONTAL;      // make component wide as its display area
        gbc.insets = new Insets(4, 4, 4, 4);          // padding for components

        // Add components to panel with constraints
        panel.add(label, gbc);
        panel.add(input, gbc);
        panel.add(panelBtns, gbc);
        panel.add(result, gbc);

        // Add panel to the frame
        this.add(panel, BorderLayout.CENTER);
    }

    public void setActionListener(ActionListener listener) {
        // add an event listener to button 1
        btnDetermineIfPrime.addActionListener(listener);
        // add an event listener to button 2
        btnGetFactorial.addActionListener(listener);
    }

    /**
     * This function returns the text input in the text box
     * @return the number
     */
    public int getNumber() {
        return Integer.parseInt(this.input.getText());
    }

    /**
     * This function sets the text of the JLabel result
     * @param result is the text to be used
     */
    public void setResult(String result) {
        this.result.setText(result);
    }
}
