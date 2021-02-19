package test;


import com.jokecompany.Services.ConsoleService;
import org.junit.Before;
import org.junit.Test;

public class ConsoleServiceTests {
    ConsoleService consoleService;

    @Before
    public void setUp() {
//        this.consoleService = new ConsoleService();
    }

    @Test
    public void testGetCategories() {
        consoleService.getCategories();
    }


    @Test
    public void testGetRandomJokeByCategory() {

    }


}
