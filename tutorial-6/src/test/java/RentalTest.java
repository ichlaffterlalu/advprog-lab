import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RentalTest {

    // TODO: Remove redundancy in setting up test fixture in each test methods
    // Hint: Make the test fixture into an instance variable

    Movie movie;
    Rental rent;

    @Before
    public void setUp() {
        movie = new Movie("Who Killed Captain Alex?", Movie.REGULAR);
        rent = new Rental(movie, 3);
    }

    @Test
    public void getMovie() {
        assertEquals(movie, rent.getMovie());
    }

    @Test
    public void getDaysRented() {
        assertEquals(3, rent.getDaysRented());
    }
}