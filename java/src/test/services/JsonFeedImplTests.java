package test.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.jokecompany.interfaces.IJsonFeed;
import com.jokecompany.models.Person;
import com.jokecompany.services.JsonFeedImpl;

/**
 * Unit tests for {@link JsonFeedImpl}
 *
 * Basic tests added, provide edge cases if allowed.
 */
public class JsonFeedImplTests {

    private IJsonFeed testJsonFeed = new JsonFeedImpl();

    @Before
    public void setUp() {
    }

    @Test
    public void testGetCategories() {

        List<String> categories = this.testJsonFeed.getCategories();

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }

    @Test
    public void testGetRandomPerson() {
        Person person = testJsonFeed.getRandomPerson();
        assertNotNull(person);
    }

    @Test
    public void testGetRandomJoke() {
        String joke = testJsonFeed.getRandomJokes("first", "last", "female", null);
        assertNotNull(joke);
    }

    @Test
    public void testGetRandomJokeByCategory() {
        String joke = testJsonFeed.getRandomJokes(null, null, null, "travel");
        assertNotNull(joke);

    }

}
