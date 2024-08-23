import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;
    Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
        String result = cat.getSound();
        assertEquals("Мяу", result);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFoodList = new ArrayList<>();
        expectedFoodList.add("Мясо");
        when(feline.eatMeat()).thenReturn(expectedFoodList);
        List<String> result = cat.getFood();
        assertEquals(expectedFoodList, result);
        Mockito.verify(feline).eatMeat();
    }
}



