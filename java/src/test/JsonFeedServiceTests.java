package test;

import com.jokecompany.Services.JsonFeedService;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JsonFeedServiceTests {
    JsonFeedService jsonFeedService = new JsonFeedService();

    @Before
    public void setUp() {
        this.jsonFeedService = new JsonFeedService();
    }

    @Test
    public void testGetCategories() {
        List<String> categories = jsonFeedService.getCategories();
        assertThat(categories, is(CoreMatchers.notNullValue()));

    }

    @Test
    public void testGetRandomJoke() {
        String joke = jsonFeedService.getRandomJokes(null,null,null,"dev");
    }

    @Test
    public void testGetRandomJokeByCategory() {
        String joke = jsonFeedService.getRandomJokes(null, null, null,"dev");

    }


}
