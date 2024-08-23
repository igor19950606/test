import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LionTest {
    @Mock
    private Feline mockFeline;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetKittens() throws Exception {
        when(mockFeline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец");
        int kittens = lion.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    void testDoesHaveMane() throws Exception {
        Lion lionMale = new Lion("Самец");
        Lion lionFemale = new Lion("Самка");
        assertTrue(lionMale.doesHaveMane());
        assertFalse(lionFemale.doesHaveMane());
    }

    @Test
    void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец");
        List<String> food = lion.getFood();
        assertNotNull(food);
        assertEquals(expectedFood, food);
    }

    @Test
    void testInvalid() {
        String invalidSex = "Исключение";
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(invalidSex);
        });
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
}