import com.example.Feline;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(Parameterized.class)
public class FelineTest {

    private final List<String> expectedFood;
    private final int inputKittens;
    private final int expectedKittens;
    private final String expectedFamily;

    public FelineTest(List<String> expectedFood, int inputKittens, int expectedKittens, String expectedFamily) {
        this.expectedFood = expectedFood;
        this.inputKittens = inputKittens;
        this.expectedKittens = expectedKittens;
        this.expectedFamily = expectedFamily;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {FelineTestData.getEatMeatTestData().get(0)[0], 1, 1, FelineTestData.getFamilyTestData().get(0)[0]},
                {null, 3, 3, FelineTestData.getFamilyTestData().get(0)[0]}
        });
    }

    @Test
    public void testEatMeat() throws Exception {
        if (expectedFood != null) {
            Feline feline = Mockito.spy(new Feline());
            doReturn(expectedFood).when(feline).getFood("Хищник");
            List<String> result = feline.eatMeat();
            assertEquals(expectedFood, result);
        }
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int result = (inputKittens == 1) ? feline.getKittens() : feline.getKittens(inputKittens);
        assertEquals(expectedKittens, result);
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String result = feline.getFamily();
        assertEquals(expectedFamily, result);
    }
}