import org.junit.Test;
import org.junit.Assert;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void valueOfSauce() {
        Assert.assertEquals(IngredientType.valueOf("SAUCE"),IngredientType.SAUCE);
    }

    @Test
    public void valueOfFilling() {
        Assert.assertEquals(IngredientType.valueOf("FILLING"),IngredientType.FILLING);
    }
}
