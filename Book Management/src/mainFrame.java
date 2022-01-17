import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class mainFrame extends JFrame {
    JLabel id, title, stock, price;
    JTextField t1, t2, t3, t4;
    JComboBox<String> category;
    JButton addrec, search, quit;
    ArrayList<Book> books = new ArrayList<>();
    File f= new File("file.ser");
    ObjectInputStream read=null;
    ObjectOutputStream write=null;


    public mainFrame() {
        super("ADDING BOOKS");
        setLayout(new FlowLayout());
        String[] names = {"Science", "Arts", "Geogprahy", "Politics"};
        category = new JComboBox<String>(names);
        category.setMaximumRowCount(4);
        for(String s:names) {
            category.addItem(s);
        }
        //Creating Labels and TextFields
        id = new JLabel("BOOK ID");
        title = new JLabel("BOOK TITLE");
        price = new JLabel("BOOK PRICE");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        addrec = new JButton("ADD RECORD");
        search = new JButton("SEARCH RECORD");
        quit = new JButton("EXIT");
        add(id);
        add(t1);
        add(title);
        add(t2);
        add(price);
        add(t3);
        add(category);
        add(addrec);
        add(search);
        add(quit);
        //Event Handling...I have used Anonymous classses
        addrec.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent e) {
                                         //Before Reading data from file first i m writing, this will open file
                                         try {
                                             write = new ObjectOutputStream(new FileOutputStream(f));
                                         } catch (IOException ex) {
                                             ex.printStackTrace();
                                         }
                                         //Checking if the given ID already Exist or not
                                         boolean add = true;
                                         //Parsing String to Int
                                         int idGiven = Integer.parseInt(t1.getText());
                                         String titletemp = t2.getText();
                                         int price = Integer.parseInt(t3.getText());
                                         try {
                                             read = new ObjectInputStream(new FileInputStream(f));
                                         } catch (IOException ex) {
                                             ex.printStackTrace();
                                         }
                                         //Now reading Arraylist of Books from the file which was saved as objects due to object serilizarion
                                         //and saving this arraylist to our book arraylist
                                         try {
                                             books = (ArrayList<Book>) read.readObject();
                                         } catch (IOException ex) {
                                             ex.printStackTrace();
                                         } catch (ClassNotFoundException ex) {
                                             ex.printStackTrace();
                                         }
                                         //As now our arraylist has file's arraylist of books
                                         //so checking if the given id already exist or not
                                             for (Book currentBook : books) {
                                                 if (currentBook.getBookID() == idGiven) {
                                                     add = false;
                                                 } else
                                                     add = true;
                                             }
                                         //Now as we know that first time when program runs there will be no data in file
                                         // so the arraylist will be empty and out upper part of checking id will not execute
                                         //But as the add has true value by default given by us the following part will execute
                                         // And first book will be added
                                         if(add){
                                             //Making object of book
                                             Book temp=new Book(titletemp,idGiven,category.getSelectedItem().toString(),price);
                                             //Adding object to book arraylist
                                             books.add(temp);
                                             try {
                                                 //Now the previous books that were saved in book arraylist when we read object and the new
                                                 //book object that is added to book arraylist will be wriiten in the file
                                                 write.writeObject(books);
                                             } catch (IOException ex) {
                                                 ex.printStackTrace();
                                             }
                                             JOptionPane.showMessageDialog(null,"Added");

                                         }else
                                             JOptionPane.showMessageDialog(null,"already exist");
                                     }
                                 });
                //Searching Data
                search.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int id=Integer.parseInt(JOptionPane.showInputDialog("Enter BOOK ID"));
                        for (Book b : books) {
                            if (id == b.getBookID()) {
                                JOptionPane.showMessageDialog(null, b.toString());
                            } else
                                JOptionPane.showMessageDialog(null, "ID NOT FOUND");
                        }
                    }
                });
        //Quit Button will open the previous login frame
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                    setVisible(false);
                    loginPage page=new loginPage();
                    page.setSize(300,200);
                    page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    page.setVisible(true);

                }
            });
        }
}