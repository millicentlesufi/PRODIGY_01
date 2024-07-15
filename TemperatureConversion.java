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
    String[] temperature = {"Fahrenheit", "degree Celsius", "Kelvin"};
    public MyFrame()
    {
        frame = new JFrame();
        optionPane = new JOptionPane();
        optionPane.showInputDialog(null, "Enter the temperature and the units of measurement:");
        frame.add(optionPane);
    }
    public void convert(String input){
        String[] inputArray = input.split(" ");
        if(inputArray[1]== temperature[0]) // temperature in Fahrenheit 
        {
            System.out.println("");
            //convert to Kelvins and display it with dialog message

            // convert to degree Celsius and display it with dialog message
        }
        else if(inputArray[1]== temperature[1]) // temperature in degree Celsius
        {
            //convert to Kelvins and display it with dialog message
            //convert to Fahrenheit and display it with dialog message

        }
        else{ // temperature in Kelvins
            System.out.println("");
            // convert to degree Celsius and display it with dialog message
            //convert to Fahrenheit and display it with dialog message
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
