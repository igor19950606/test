import com.example.Animal;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class AnimalTest {

    private final Animal animal = new Animal();

    @Test
    public void testFoodHerbivore() throws Exception {
        List<String> expectedFood = List.of("Трава", "Различные растения");
        List<String> actualFood = animal.getFood("Травоядное");
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testFoodPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = animal.getFood("Хищник");
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testFoodUnknownAnimal() {
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Неизвестное животное");
        });

        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testFamily() {
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualFamily = animal.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }
}