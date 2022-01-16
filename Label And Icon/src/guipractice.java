import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.*;
import javax.swing.Icon;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


//import java.awt.*;
//import javax.swing.JRadioButton;
public class guipractice extends JFrame {
    JButton b1,b2;
    public guipractice(){
        super("FRAME");
        setLayout(new FlowLayout());
        Icon image1=new ImageIcon(getClass().getResource("ss.png"));
        Icon image2=new ImageIcon(getClass().getResource("stats.png"));
   
        b1=new JButton("SIMPLE BUTTON");
        b2=new JButton("FancyButton",image1);
        b2.setRolloverIcon(image2);
        add(b1);
        add(b2);
        handler h=new handler();
        b1.addActionListener(h);
        b2.addActionListener(h);
       

    }
    private class handler implements ActionListener{
        private void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,String.format("You clicked %s",e.getActioncommand()));
        }
    }
}
