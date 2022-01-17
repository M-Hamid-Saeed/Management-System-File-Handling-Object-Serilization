import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class filehandling {
    ObjectOutputStream write = null;
    ObjectInputStream read= null;
    ArrayList<Book> books= new ArrayList<>();
    public void readFile(String path) {
        try {
            read = new ObjectInputStream(new FileInputStream(path));
            if (read != null) {
                books = (ArrayList<Book>) read.readObject();
            }

        } catch (Exception ex) {
            System.out.println("EXCEPTION OCCURS");
        }
    }}
