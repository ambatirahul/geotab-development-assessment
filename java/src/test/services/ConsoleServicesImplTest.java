package test.services;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.jokecompany.interfaces.IConsole;
import com.jokecompany.services.ConsoleServiceImpl;
import com.jokecompany.services.JsonFeedImpl;

/**
 * Unit tests for {@link ConsoleServicesImpl}
 * 
 *
 */
public class ConsoleServicesImplTest {

    private IConsole iConsole = new ConsoleServiceImpl(new JsonFeedImpl());

    @Before
    public void setUp() {
    }

    @Test
    public void testGetCategories() {
        iConsole.getCategories();
    }

    @Test
    public void testGetRandomJokeByCategory() {
        iConsole.getRandomJokes("animal", 2);
    }

}
