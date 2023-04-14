import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import org.junit.Assert;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;
    private Bun bun;
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {"fалафеlь", 100000000},
                {"1234567890!!!", 0},
                {"", 0.5f},
        };
    }
    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }
    @Test
    public void getBunName() {
        Assert.assertEquals(name, bun.getName());
    }
    @Test
    public void getBunPrice() {
        Assert.assertEquals(price, bun.getPrice(), 0.0);
    }
}
