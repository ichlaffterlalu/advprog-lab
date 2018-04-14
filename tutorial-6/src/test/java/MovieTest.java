import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MovieTest {

    // TODO: Remove redundancy in setting up test fixture in each test methods
    // Hint: Make the test fixture into an instance variable

    Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("Who Killed Captain Alex?", Movie.REGULAR);
    }

    @Test
    public void getTitle() {
        assertEquals("Who Killed Captain Alex?", movie.getTitle());
    }

    @Test
    public void setTitle() {
        movie.setTitle("Bad Black");
        assertEquals("Bad Black", movie.getTitle());
    }

    @Test
    public void getPriceCode() {
        assertEquals(Movie.REGULAR, movie.getPriceCode());
    }

    @Test
    public void setPriceCode() {
        movie.setPriceCode(Movie.CHILDREN);
        assertEquals(Movie.CHILDREN, movie.getPriceCode());
    }
}