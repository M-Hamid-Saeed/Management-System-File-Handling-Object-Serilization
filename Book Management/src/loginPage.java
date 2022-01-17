import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class loginPage extends JFrame {
    JLabel l1,l2;
    JTextField username;
    JPasswordField password;
    JButton loginButton;
    Formatter file;

    public loginPage()  {
        super("LOGIN PAGE");
        setLayout(new FlowLayout());

        l1 = new JLabel("ENTER USERNAME");
        l2= new JLabel("ENTER PASSWORD");

        username = new JTextField(10);
        password = new JPasswordField(10);
        loginButton = new JButton("LOGIN");

        add(l1);
        add(username);
        add(l2);
        add(password);
        add(loginButton);
        //Anonymous class
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = null;
                String pass = null;
                Scanner sc = null;
                boolean found=true;
                try {
                    sc = new Scanner(Paths.get("logindata.txt"));
                    //using delimeter , and next line because each line has username and passowrd separated by ','.
                    sc.useDelimiter("[,\n]");
                    while (sc.hasNext()) {
                        //as we know the first word is user name and next is password
                        user = sc.next();
                        pass = sc.next();
                        //checking if it matched the password or username given by USER.
                        if (password.getText().equals(pass) && username.getText().equals(user) ) {
                            JOptionPane.showMessageDialog(null,"Access Granted");
                            setVisible(false);
                            mainFrame f = new mainFrame();
                            f.setSize(1000, 200);
                            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            f.setVisible(true);
                            found = false;
                        }
                    }
                    if(found)
                        JOptionPane.showMessageDialog(null,"Access Denied");
                } catch (IOException ex) {
                    System.out.println("EXCEPTION OCCURS");
                }
            }
        });
    }
}
