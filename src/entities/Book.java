package entities;

public class Book {
    private int bookID;           // ID given by a library to a book to make it distinguishable from other books
    private String title;         // Title of a book
    private String subject;       // Subject to which a book is related
    private String author;        // Author of book
    private String language;      // In which language had been written

    // Constructor which contain ID,Title,Subject,Author,Language of the Book
    public Book(int bookID, String title, String subject, String author,String language) {
        setBookID(bookID);
        setTitle(title);
        setSubject(subject);
        setAuthor(author);
        setLanguage(language);
    }

    // Constructor which contain Title,Subject,Author,Language of Book
    public Book(String title, String subject, String author,String language) {
        setTitle(title);
        setSubject(subject);
        setAuthor(author);
        setLanguage(language);
    }

    // Empty constructor
    public Book() {}

    // Getter and Setter functions
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }


    // Overriding methods to show data of Book
    @Override
    public String toString() {
        return bookID + " | " + title +" | "+author+" | "+subject+" | "+language+"\n";
    }

    // To show books with same Subjects, or they have at least one same subject
    public void toStringSubject() {
        System.out.println(title +" | "+ author+" | " + language+"\n");
    }

    // To show books with same Author
    public void toStringAuthor() {
        System.out.println(title +" | "+subject + " | "+language+"\n");
    }

    //To show book with same written language
    public void toStringLanguage() {
        System.out.println(title +" | "+author+" | "+subject+"\n");
    }
}
