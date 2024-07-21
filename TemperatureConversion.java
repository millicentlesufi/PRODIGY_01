import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TemperatureConversion
{
    public static void main(String[] args)
    {
        new MyFrame();
    }
}

class MyFrame extends JFrame implements ActionListener
{
    JFrame frame;
    JOptionPane optionPane;
    String[] temperature = {"Fahrenheit", "degrees Celsius", "Kelvin"};
    JButton convertButton;

    public MyFrame()
    {
        frame = new JFrame("Temperature Conversion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        optionPane = new JOptionPane();
        convertButton = new JButton("Convert Temperature");

        convertButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(convertButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == convertButton)
        {
            String input = optionPane.showInputDialog(frame, "Enter the temperature and the unit of measurement (e.g., 25 Kelvins):");
            convert(input);
        }
    }

    public void convert(String input)
    {
        try
        {
            String[] inputArray = input.split(" ");
            double temperatureValue = Double.parseDouble(inputArray[0]);
            String unit = inputArray[1];
            
            // if the temperature is in degrees Celsius
            if (unit.equalsIgnoreCase(temperature[1].split(" ")[0]))
            {
                unit = inputArray[1] + " " + temperature[1].split(" ")[1];
            }

            if (unit.equalsIgnoreCase(temperature[0]))
            { // temperature in Fahrenheit
                double toCelsius = (temperatureValue - 32) * 5/9;
                double toKelvins = (temperatureValue - 32) * 5/9 + 273.15;
                JOptionPane.showMessageDialog(frame, String.format("Temperature in Celsius: %.2f", toCelsius), "Converted Temperature", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(frame, String.format("Temperature in Kelvin: %.2f", toKelvins), "Converted Temperature", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (unit.equalsIgnoreCase(temperature[1])) 
            { // temperature in degrees Celsius
                double toFahrenheit = (temperatureValue * 9/5) + 32;
                double toKelvins = temperatureValue + 273.15;
                JOptionPane.showMessageDialog(frame, String.format("Temperature in Fahrenheit: %.2f", toFahrenheit), "Converted Temperature", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(frame, String.format("Temperature in Kelvin: %.2f", toKelvins), "Converted Temperature", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (unit.equalsIgnoreCase(temperature[2]))
            { // temperature in Kelvins
                double toCelsius = temperatureValue - 273.15;
                double toFahrenheit = (temperatureValue - 273.15) * 9/5 + 32;
                JOptionPane.showMessageDialog(frame, String.format("Temperature in Celsius: %.2f", toCelsius), "Converted Temperature", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(frame, String.format("Temperature in Fahrenheit: %.2f", toFahrenheit), "Converted Temperature", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(frame, "Invalid unit of measurement. Please enter Fahrenheit, Celsius, or Kelvin.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(frame, "Invalid input format. Please enter the temperature and the unit of measurement correctly (e.g., 25 degrees Celsius).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
