import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    // TODO: Remove redundancy in setting up test fixture in each test methods
    // Hint: Make the test fixture into an instance variable

    Customer customer;
    Movie movie;
    Movie movie2;
    Rental rent;

    @Before
    public void setUp() {
        customer = new Customer("Alice");
        movie = new Movie("Who Killed Captain Alex?", Movie.REGULAR);
        rent = new Rental(movie, 3);
    }

    @Test
    public void getName() {
        assertEquals("Alice", customer.getName());
    }

    @Test
    public void statementWithSingleMovie() {
        customer.addRental(rent);

        String result = customer.statement();
        String[] lines = result.split("\n");

        assertEquals(4, lines.length);
        assertTrue(result.contains("Amount owed is 3.5"));
        assertTrue(result.contains("1 frequent renter points"));
    }

    // TODO Implement me!
    public void statementWithMultipleMoviesTest() {
        // TODO Implement me!
        Movie movie = new Movie("Ninja Hattori", Movie.CHILDREN);
        Rental rent = new Rental(movie, 7);
        Customer customer = new Customer("Safira");
        customer.addRental(rent);

        String result = customer.statement();
        String[] lines = result.split("\n");

        assertEquals(4, lines.length);
        assertTrue(result.contains("Amount owed is 7.5"));
        assertTrue(result.contains("1 frequent renter points"));


        movie = new Movie("Ready Player One", Movie.NEW_RELEASE);
        rent = new Rental(movie, 10);
        customer = new Customer("Parzival");
        customer.addRental(rent);

        result = customer.statement();
        lines = result.split("\n");

        assertEquals(4, lines.length);
        assertTrue(result.contains("Amount owed is 30.0"));
        assertTrue(result.contains("2 frequent renter points"));
    }

    public void htmlStatementTest() {
        // TODO Implement me!
        Movie movie = new Movie("Ninja Hattori", Movie.CHILDREN);
        Rental rent = new Rental(movie, 7);
        Customer customer = new Customer("Safira");
        customer.addRental(rent);

        String result = customer.htmlStatement();
        String[] lines = result.split("\n");

        assertEquals(4, lines.length);
        assertTrue(result.contains("You owe <em> 7.5</em>"));
        assertTrue(result.contains("<em>1</em> frequent renter points"));


        movie = new Movie("Ready Player One", Movie.NEW_RELEASE);
        rent = new Rental(movie, 10);
        customer = new Customer("Parzival");
        customer.addRental(rent);

        result = customer.htmlStatement();
        lines = result.split("\n");

        assertEquals(4, lines.length);
        assertTrue(result.contains("You owe <em>30.0</em>"));
        assertTrue(result.contains("<em>2</em> frequent renter points"));
    }
}