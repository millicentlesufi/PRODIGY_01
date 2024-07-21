import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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

    public MyFrame()
    {
        frame = new JFrame();
        optionPane = new JOptionPane();
        String input = optionPane.showInputDialog(null, "Enter the temperature and the unit of measurement (e.g., 25 Kelvins):");
        convert(input);
    }

    public void convert(String input)
    {
        try {
            String[] inputArray = input.split(" ");
            double temperatureValue = Double.parseDouble(inputArray[0]);
            String unit = inputArray[1];
            // if the temperature is in degrees celsius
            if(unit.equalsIgnoreCase(temperature[1].split(" ")[0]))
            {
                unit = inputArray[1] + " " + temperature[1].split(" ")[1];
            }
            
            if (unit.equalsIgnoreCase(temperature[0]))
            { // temperature in Fahrenheit
                double toCelsius = (temperatureValue - 32) * 5/9;
                double toKelvins = (temperatureValue - 32) * 5/9 + 273.15;
                // I want this to have a message type of 
                JOptionPane.showMessageDialog(frame, String.format("Temperature in Celsius: %.2f", toCelsius));
                JOptionPane.showMessageDialog(frame, String.format("Temperature in Kelvin: %.2f", toKelvins));
            }
            else if (unit.equalsIgnoreCase(temperature[1])) { // temperature in degress Celsius
                double toFahrenheit = (temperatureValue* 9/5) + 32;
                double toKelvins = temperatureValue + 273.15;
                JOptionPane.showMessageDialog(frame, String.format("Temperature in Fahrenheit: %.2f", toFahrenheit));
                JOptionPane.showMessageDialog(frame, String.format("Temperature in Kelvin: %.2f", toKelvins));

            }
            else if (unit.equalsIgnoreCase(temperature[2])) { // temperature in Kelvins
                double toCelsius = temperatureValue - 273.15;
                double toFahrenheit = (temperatureValue - 273.15) * 9/5 + 32;
                JOptionPane.showMessageDialog(frame, String.format("Temperature in Celsius: %.2f", toCelsius));
                JOptionPane.showMessageDialog(frame, String.format("Temperature in Fahrenheit: %.2f", toFahrenheit));
            } 
            else
            {
                // I want this to have a message type of warning message
                JOptionPane.showMessageDialog(frame, "Invalid unit of measurement. Please enter Fahrenheit, Celsius, or Kelvin.");
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Invalid input format. Please enter the temperature and the unit of measurement correctly (e.g., 25 degrees Celsius).");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // No implementation needed for this example
    }
}
