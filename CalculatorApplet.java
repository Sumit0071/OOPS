import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApplet extends Applet implements ActionListener {
    TextField num1, num2, result;
    Button add, subtract, multiply, divide;

    @Override
    public void init() {
        // Initialize components
        Label label1 = new Label("Number 1:");
        num1 = new TextField(10);

        Label label2 = new Label("Number 2:");
        num2 = new TextField(10);

        result = new TextField(20);
        result.setEditable(false);

        add = new Button("+");
        subtract = new Button("-");
        multiply = new Button("*");
        divide = new Button("/");

        // Add components to the applet
        add(label1);
        add(num1);
        add(label2);
        add(num2);
        add(add);
        add(subtract);
        add(multiply);
        add(divide);
        add(new Label("Result:"));
        add(result);

        // Add action listeners
        add.addActionListener(this);
        subtract.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double number1 = Double.parseDouble(num1.getText());
            double number2 = Double.parseDouble(num2.getText());
            double res = 0;

            if (e.getSource() == add) {
                res = number1 + number2;
            } else if (e.getSource() == subtract) {
                res = number1 - number2;
            } else if (e.getSource() == multiply) {
                res = number1 * number2;
            } else if (e.getSource() == divide) {
                if (number2 != 0) {
                    res = number1 / number2;
                } else {
                    result.setText("Error: Division by zero");
                    return;
                }
            }

            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            result.setText("Error: Invalid input");
        }
    }
}
