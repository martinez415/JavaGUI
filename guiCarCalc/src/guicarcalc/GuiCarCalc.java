package guicarcalc;
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.border.BevelBorder;

public class GuiCarCalc {
    static JFrame frame; 
    static JPanel panel;
    static JMenuBar menuBar;
    static JMenu menu1;
    static JMenu menu2;   
    static JMenu menu3;
    static JMenuItem item1;
    static JMenuItem item2;
    static JMenuItem item3;
    static TravelCost travelObj;
    //static Image image;
    static Font font;
    static Font labelFont;
    static JLabel labelHeader;
    static JLabel labelMiles;
    static JLabel labelMPG;
    static JLabel labelGasPrice;
    static JLabel labelParkCost;
    static JLabel labelTollsCost;
    static JLabel labelResults;
    static JTextField miles;
    static JTextField mpg;
    static JTextField gasPrice;
    static JTextField parkCost;
    static JTextField tollsCost;
    static JTextField results;
    static JButton btn1;
    static JButton btn2;

    public static void main(String[] args) {
        /*
           Initialize frame and panel
        */
        frame = new JFrame("Travel Cost App");       
        panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setLayout(null);
        
        /*
           JMenu bar and items
        */
        menuBar = new JMenuBar();        
        menu1 = new JMenu("File");
        menu2 = new JMenu("Edit");
        menu3 = new JMenu("About");
        item1 = new JMenuItem("Add Me");
        item1.addActionListener(new Calculate());
        item2 = new JMenuItem("Clear");
        item2.addActionListener(new Clear());
        item3 = new JMenuItem("About this App");
        item3.addActionListener(new About());
                             
        /*
           Frame Icon
        */
        Image image = Toolkit.getDefaultToolkit().getImage("guiCarCalc/tire.png");               
        frame.setIconImage(image);
        
        /*
           Implement up the the labels, text fields, buttons  within the GUI environment.
           Notes: 
           Enlarge font, color, and font style
           align the text to the right, and close the gaps between the labels and textfields      
        */
        
        labelHeader= new JLabel("Travel Cost App:");
        labelHeader.setBounds(200, 5, 250, 30);
        font = new Font("Comic Sans MS", font.BOLD, 24);
        labelHeader.setFont(font);
        labelHeader.setForeground(Color.BLUE);
        
        
        labelMiles = new JLabel("Miles to drive:");
        labelMiles.setBounds(100, 50, 120, 30);
        miles = new JTextField(30); 
        miles.setBounds(250, 50, 120, 30);
        labelFont = new Font("Comic Sans MS", Font.PLAIN, 16);
        labelMiles.setFont(labelFont);
        
        labelMPG = new JLabel("Miles per gallon:");
        labelMPG.setBounds(100, 100, 120, 30);
        mpg = new JTextField(30); 
        mpg.setBounds(250, 100, 120, 30);
        labelMPG.setFont(labelFont);
        
        labelGasPrice = new JLabel("Gasoline Price:");
        labelGasPrice.setBounds(100, 150, 120, 30);
        gasPrice = new JTextField(30); 
        gasPrice.setBounds(250, 150, 120, 30);
        labelGasPrice.setFont(labelFont);
        
        labelParkCost=new JLabel("Parking Cost:");
        labelParkCost.setBounds(100, 200, 120, 30);
        parkCost = new JTextField(30); 
        parkCost.setBounds(250, 200, 120, 30);
        labelParkCost.setFont(labelFont);
        
        labelTollsCost=new JLabel("Tolls Cost:");
        labelTollsCost.setBounds(100, 250, 120, 30);
        tollsCost = new JTextField(30); 
        tollsCost.setBounds(250, 250, 120, 30);
        labelTollsCost.setFont(labelFont);
        
        btn1 = new JButton("Calculate");
        btn1.setBounds(100, 300, 120, 30);
        btn1.setFont(labelFont);       
        btn1.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.CYAN, Color.GRAY));        
        btn1.addActionListener(new Calculate());
        
        btn2 = new JButton ("Clear");
        btn2.setBounds(250, 300, 120, 30);
        btn2.setFont(labelFont);
        btn2.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.CYAN, Color.GRAY));        
        btn2.addActionListener(new Clear());
        
        labelResults=new JLabel("Results:");
        labelResults.setBounds(100, 350, 120, 30);
        results = new JTextField(30); 
        results.setBounds(250, 350, 180, 30);
        labelResults.setFont(labelFont);
        results.setBackground(Color.CYAN);
        results.setEditable(false);
                             
        /*
           add your content to the panel!
        */
        frame.add(panel);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menu1.add(item1);
        menu2.add(item2);
        menu3.add(item3);
        panel.add(labelHeader);
        panel.add(labelMiles);
        panel.add(miles);
        panel.add(labelMPG);
        panel.add(mpg);
        panel.add(labelGasPrice);
        panel.add(gasPrice);
        panel.add(labelParkCost);
        panel.add(parkCost);
        panel.add(labelTollsCost);
        panel.add(tollsCost);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(labelResults);
        panel.add(results);
                                                                      
        /*
           Initialize and closing the GUI environment
        */ 
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(600, 450); 
        frame.setVisible(true);                 
    }
    
    /*
       Classes for button event handlers
    */
    
    public static class Calculate implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            double milesDriven, milesPG, gasFee, parkFee, tollsFee;
            
            milesDriven=Double.parseDouble(miles.getText());
            milesPG=Double.parseDouble(mpg.getText());
            gasFee=Double.parseDouble(gasPrice.getText());
            parkFee=Double.parseDouble(parkCost.getText());
            tollsFee=Double.parseDouble(tollsCost.getText());
            
            travelObj= new TravelCost(milesDriven, milesPG, gasFee, parkFee, tollsFee);           
            travelObj.CalCost();                                             
            results.setText("Your total cost is: $"+travelObj.getTotalCost()); 
        }       
    }
    
     public static class Clear implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            miles.setText("");
            mpg.setText("");
            gasPrice.setText("");
            parkCost.setText("");
            tollsCost.setText("");
            results.setText("");
        }
     }
     
     public static class About implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JOptionPane.showMessageDialog(frame, "Travel Exp ver 1.0\nAuthor: Melissa Martinez");            
        }
     }    
}
