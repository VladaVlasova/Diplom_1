import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;
    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Проверка ингридиентов с IngredientType={0}, name={1}, price={2}")
    public static Object[][] testData() {
        return new Object[][] {
                {null, null, 0.5f},
                {null, "котлетка", 0},
                {IngredientType.SAUCE, "chili пепперс", 300000},
        };
    }
    @Before
    public void setUp () {
        ingredient = new Ingredient(type, name, price);
    }
    @Test
    public void getIngredientPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.0f);
    }
    @Test
    public void getIngredientName() {
        Assert.assertEquals(name, ingredient.getName());
    }
    @Test
    public void getIngredientType() {
        Assert.assertEquals(type, ingredient.getType());
    }
}
