import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;


public class BunTest {
    private Bun bun;
    private static final String BUN_NAME = "Null-bun";
    private static final float BUN_PRICE = 10.5f;
    private static final float DELTA = 0.00f;

    @Before
    public void before(){
        bun = new Bun(BUN_NAME,BUN_PRICE);
    }

    @Test
    public void getNameTest_ok(){
        String bunName = bun.getName();
        Assert.assertEquals("Название булки не совпадает",BUN_NAME,bunName);
    }
    @Test
    public void getPriceTest_ok(){
        float bunPrice = bun.getPrice();
        Assert.assertEquals("Цена булки не совпадают",BUN_PRICE,bunPrice,DELTA);
    }
}
