import java.util.Arrays;
import java.util.List;

public class FelineTestData {

    public static List<Object[]> getEatMeatTestData() {
        return Arrays.asList(new Object[][] {
                {Arrays.asList("Животные", "Птицы", "Рыба")}
        });
    }

    public static List<Object[]> getKittensTestData() {
        return Arrays.asList(new Object[][] {
                {1, 1},
                {3, 3}
        });
    }

    public static List<Object[]> getFamilyTestData() {
        return Arrays.asList(new Object[][] {
                {"Кошачьи"}
        });
    }
}