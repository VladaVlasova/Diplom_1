import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import praktikum.Bun;
import praktikum.Burger;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Ingredient;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;
    @Before
    public void setUp() {
        burger = new Burger();
    }
    @Test
    public void addBurgerIngredients() {
        burger.addIngredient(ingredient1);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertTrue(burger.ingredients.contains(ingredient1));
    }
    @Test
    public void removeBurgerIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }
    @Test
    public void moveBurgerIngredient() {
        Mockito.when(ingredient2.getName()).thenReturn("соус2");
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        Assert.assertEquals("соус2", burger.ingredients.get(0).getName());
    }
    @Test
    public void getBurgerPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100.0f);
        Mockito.when(ingredient1.getPrice()).thenReturn(100.0f);
        Mockito.when(ingredient2.getPrice()).thenReturn(100.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Assert.assertEquals(400.0f, burger.getPrice(), 0.0f);
    }
        @Test
    public void getBurgerReceipt() {
        Mockito.when(bun.getName()).thenReturn("Булка");
        Mockito.when(bun.getPrice()).thenReturn(100.0f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.valueOf("FILLING"));
        Mockito.when(ingredient1.getName()).thenReturn("начинка");
        Mockito.when(ingredient1.getPrice()).thenReturn(100.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
            String expectedReceipt = "(==== Булка ====)\n" +
                    "= filling начинка =\n" +
                    "(==== Булка ====)\n" +
                    "\n" +
                    "Price: 300,000000\n";
            Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
