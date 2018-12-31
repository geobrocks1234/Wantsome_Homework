package week4.OtherExercises.AuthorBook;

public class TestAuthorBook {
    public static void main(String[] args) {

        Author anAuthor = new Author("Tan Ah Teck", "ahteck@somewhere.com", 'm');
        System.out.println(anAuthor);   // call toString()
        anAuthor.setEmail("paul@nowhere.com");
        System.out.println(anAuthor);

        anAuthor.setEmail("ahteck@somewhere.com");
        Book aBook = new Book("Java for dummy", anAuthor, 19.95, 1000);
        // Use an anonymous instance of Author
        Book anotherBook = new Book("more Java for dummy", new Author("Paul", "paul@somewhere.com", 'm'), 29.95, 888);

        System.out.println("The author's name is: " + aBook.getAuthor().getName());
        System.out.println("The author's email address is: " + aBook.getAuthor().getEmail());

        System.out.println("Some information about the book's author: ");
        System.out.println("Name: " + aBook.getAuthorName());
        System.out.println("Email: " + aBook.getAuthorEmail());
        System.out.println("Gender: " + aBook.getAuthorGender());
    }
}
