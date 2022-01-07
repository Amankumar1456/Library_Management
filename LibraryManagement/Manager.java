package LibraryManagement;
import java.util.*;

public class Manager
{
    
    // Data structures


    //#region Book
    class Book
    {
        String title;
        String author;
        String genere;
        String status;
        ArrayList<CustomerIssued> CustomerIssuedHistory=new ArrayList<CustomerIssued>();
        Book(String title,
        String author,
        String genere)
        {
            this.title=title;
            this.author=author;
            this.genere=genere;
        }

        //#region get+set

        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getAuthor() {
            return author;
        }
        public void setAuthor(String author) {
            this.author = author;
        }
        public String getGenere() {
            return genere;
        }
        public void setGenere(String genere) {
            this.genere = genere;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        //#endregion
    }
    class CustomerIssued
    {
        String doi,dor,Customer;
        // doi->date of issue
        // dor-> date of return
        CustomerIssued(String doi,String Customer)
        {
            this.doi=doi;
            this.Customer=Customer;
        }
        //#region get+set
        public String getDoi() {
            return doi;
        }
        public void setDoi(String doi) {
            this.doi = doi;
        }
        public String getDor() {
            return dor;
        }
        public void setDor(String dor) {
            this.dor = dor;
        }
        public String getCustomer() {
            return Customer;
        }
        public void setCustomer(String Customer) {
            this.Customer = Customer;
        }
        //#endregion
    }
    //#endregion
    //#region Customer
    class Customer
    {
        String Name;
        String BookStatus;
        ArrayList<BookIssued> BookIssuedHistory=new ArrayList<BookIssued>();
        public String getName() {
            return Name;
        }
        public void setName(String name) {
            Name = name;
        }
        public String getBookStatus() {
            return BookStatus;
        }
        public void setBookStatus(String bookStatus) {
            BookStatus = bookStatus;
        }
        public ArrayList<BookIssued> getBookIssuedHistory() {
            return BookIssuedHistory;
        }
        public void setBookIssuedHistory(ArrayList<BookIssued> bookIssuedHistory) {
            BookIssuedHistory = bookIssuedHistory;
        } 
        
        
    }
    class BookIssued
    {
        String doi,dor,Book;
        // doi->date of issue
        // dor-> date of return
        BookIssued(String doi,String Book)
        {
            this.doi=doi;
            this.Book=Book;
        }
        //#region get+set
        public String getDoi() {
            return doi;
        }
        public void setDoi(String doi) {
            this.doi = doi;
        }
        public String getDor() {
            return dor;
        }
        public void setDor(String dor) {
            this.dor = dor;
        }
        public String getBook() {
            return Book;
        }
        public void setBook(String Book) {
            this.Book = Book;
        }
        //#endregion
    }
    //#endregion

    //#region Library
    ArrayList<Book> Library=new ArrayList<Book>();
    // HashMap for Book management with custome ID for managing book issue
    // HashTable<Integer,Book> Library=new HashTable<Integer,Book>();
    // int BookCounter;
    // String generateId(Book book,Customer customer)
    // {
    //      return book.getTitle().substring(0,4)+cutomer.getName().substring(0,4)+BookCounter++;
    // }

    //#endregion
    Scanner sc=new Scanner(System.in);
    private char[] passCode={'a','m','a','n'};
    
    
    public static void main(String[] args)
    { 
       Manager m=new Manager();
       m.start();
    }
    
    void start()
    {
        System.out.println(" Welcome to the library \n  1. Add a book to the collection \n 2. Search for a book by title \n 3. Browse Genere \n 4. Remove a book from the collection \n 5 Exit ");
        int choice=sc.nextInt();
        driver(choice);
    }
    void driver(int choice)
    {
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                searchBook();
                break;
            case 3:
                searchGenere();
                break;
            case 4:
                removeBook();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("invalid choice, try again!!!");
                start();
                break;
        }
    }
    void addBook()
    {
        try {
            print("Enter book title");
            String title=sc.next();
            print("author's name");
            String author=sc.next();
            print("genere=");
            String genere=sc.next();
            Library.add(new Book(title,author,genere));
            print(title+"added to the Library");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    void searchBook()
    {
        // post database integeration
        print("Reading...");
    }
    void searchGenere()
    {
        // post database integeration
        print("reading");
    }
    void removeBook()
    {
        try {
            print("Athorizing passCode =");
            char[] temp=sc.next().toCharArray();
            if(Arrays.equals(temp,passCode))
            {
                print("Enter book title to be removed");
                String title=sc.nextLine();
                print("author's name");
                String author=sc.nextLine();
                print("genere=");
                String genere=sc.nextLine();
                Library.add(new Book(title,author,genere));
                print(title+"removed from the Library");
            }
            else
            {
                print("You are not authorized");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }




    //#region laziness
    static void print(String str)
    {
        System.out.println(str);
    }
    //#endregion 
}