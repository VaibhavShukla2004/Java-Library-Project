package OOPs.Obj;
import java.util.Locale;
import java.util.Scanner;
class Library
{
    String [] AvailableBooks = new String[10];
    String [] IssuedBooks = new String[10];

    int NoOfBooksAvailable = 0;
    int NoOfBooksIssued = 0;

    void addBook(String Book)
    {
        AvailableBooks [NoOfBooksAvailable] = Book;
        NoOfBooksAvailable++;
        System.out.format("%s has been added to Library\n",Book);
    }

    void showAvailableBooks()
    {
       if(NoOfBooksAvailable <= 0)
       {
           System.out.println("No Books are Available in Library");
       }
       else
       {
           for(int i = 0; i < NoOfBooksAvailable; i++)
           {
               System.out.println(AvailableBooks[i]);
           }
       }
    }

    void showIssuedBooks()
    {
        if(NoOfBooksIssued <= 0)
        {
            System.out.println("No books have been issued");
        }
        else
        {
            for(int i = 0; i < NoOfBooksIssued; i++)
            {
                System.out.println(IssuedBooks[i]);
            }
        }
    }

    void showAllBooks()
    {
        showAvailableBooks();
        showIssuedBooks();
    }


    void issueBook(String Book)
    {
        if(NoOfBooksAvailable <= 0)
        {
            System.out.println("No books Available, cannot issue");
        }
        else
        {
            int flag = 0;

            for(int i = 0; i < NoOfBooksAvailable; i++)
            {
                if(AvailableBooks[i].equalsIgnoreCase(Book))
                {
                    flag = 1;
                    for(int j = i; j < NoOfBooksAvailable ; j++)
                    {
                        AvailableBooks[j] = AvailableBooks[j+1];
                    }
                    NoOfBooksAvailable--;
                    IssuedBooks[NoOfBooksIssued] = Book;
                    NoOfBooksIssued++;
                    System.out.format("%s has been issued\n",Book);
                    break;
                }
                else if (i == (NoOfBooksAvailable -1))
                {
                    System.out.println("Book not available");
                    break;
                }
            }
            if(flag == 0)
            {
                System.out.println("This book is not in the library or not issued");
            }
        }
    }

    void returnBook(String Book)
    {
        if(NoOfBooksIssued <= 0)
        {
            System.out.println("No books have been issued so return is not possible,use issue to issue a book first");
        }
        else
        {
            for(int i = 0; i < NoOfBooksIssued; i++)
            {
                if(IssuedBooks[i].equalsIgnoreCase(Book))
                {
                    for(int j = i; j < NoOfBooksIssued; j++)
                    {
                        IssuedBooks[i] = IssuedBooks[i+1];
                    }
                    NoOfBooksIssued--;
                    AvailableBooks[NoOfBooksAvailable] = Book;
                    NoOfBooksAvailable++;
                    System.out.format("%s has been returned to Library\n",Book);
                    break;
                }
                else if (i == (NoOfBooksIssued -1))
                {
                    System.out.println(" This book has not been issued so it cannot be returned");
                    break;
                }
            }
        }
    }

}

public class Project4 {
    public static void main(String[] args) {

        System.out.println("Welcome to your very own Library NLB");
        System.out.println("here to add books use = add/add book");
        System.out.println("To issue a book use = issue/borrow");
        System.out.println("To return a book use = return");
        System.out.println("Enjoy your visit at NLB");
        Scanner sc = new Scanner(System.in);

        Library NLB = new Library();

        String Book;

        String Option;

        for(int i = 0; ; i++)
        {
            System.out.println("Enter Option = ");
            Option = sc.nextLine();

            if(Option.equalsIgnoreCase("exit"))
            {
                System.out.println("You are now Leaving NLB");
                break;
            }
            else if (Option.equalsIgnoreCase("add")||Option.equalsIgnoreCase("add book"))
            {
                System.out.println("Enter book to add = ");
                Book = sc.nextLine();
                NLB.addBook(Book.toLowerCase());
            }
            else if (Option.equalsIgnoreCase("show all"))
            {
                NLB.showAllBooks();
            }
            else if(Option.equalsIgnoreCase("show available"))
            {
                NLB.showAvailableBooks();
            }
            else if (Option.equalsIgnoreCase("show issued"))
            {
                NLB.showIssuedBooks();
            }
            else if(Option.equalsIgnoreCase("issue")||Option.equalsIgnoreCase("borrow"))
            {
                System.out.println("Enter Book to Issue/Borrow = ");
                Book = sc.nextLine();
                NLB.issueBook(Book);
            }
            else if(Option.equalsIgnoreCase("Return")||Option.equalsIgnoreCase("Return book"))
            {
                System.out.println("Enter Book to Return = ");
                Book = sc.nextLine();
                NLB.returnBook(Book);
            }
            else
            {
                System.out.println("Wrong input!!");
            }
        }
    }
}
