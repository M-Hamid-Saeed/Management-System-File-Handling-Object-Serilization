import java.io.Serializable;
//Serilizable class Book
public class Book implements Serializable {
    private String bookTitle;
    private int bookID;
    private String bookCategory;
    private int bookPrice;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }


    public Book(String bookTitle, int bookID, String bookCategory, int bookPrice) {
        this.bookTitle = bookTitle;
        this.bookID = bookID;
        this.bookCategory = bookCategory;
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return String.format("Book ID --> %d \n Book Title --> %s \n Book Category --> %s \n Book Price -->%d",getBookID(),getBookTitle(),getBookCategory(),getBookPrice());
    }
}
