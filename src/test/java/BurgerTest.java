import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.assertj.core.api.SoftAssertions;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredient2;

    private final Burger burger = new Burger();
    private static final String BUN_NAME = "Null-bun";
    private static final float BUN_PRICE = 4.04f;
    private static final String INGREDIENT_NAME = "MAYO";
    private static final float INGREDIENT_PRICE = 1.03f;
    private static final float OVERALL_PRICE = BUN_PRICE*2+INGREDIENT_PRICE;
    private static final int FIRST_INGREDIENT_INDEX = 0;
    private static final float DIFF = 0.05f;
    private static final String BURGER_RECEIPT =
                            "(==== Null-bun ====)\r\n" +
                            "= sauce MAYO =\r\n" +
                            "(==== Null-bun ====)\r\n" +
                            "\r\n" +
                            "Price: 9,110000\r\n";

    @Test
    public void setBunsTest_ok(){
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun,bun);
    }

    @Test
    public void addIngredientTest_ok(){
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredient_ok(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(FIRST_INGREDIENT_INDEX);
        Assert.assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredient_ok(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(FIRST_INGREDIENT_INDEX,FIRST_INGREDIENT_INDEX+1);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(burger.ingredients.get(0)).isEqualTo(ingredient2);
        softly.assertThat(burger.ingredients.get(1)).isEqualTo(ingredient);
        softly.assertAll();
    }

    @Test
    public void getPriceTest_ok(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);
        float price = burger.getPrice();
        Assert.assertEquals("PRICE NOT MATCHED",OVERALL_PRICE,price,DIFF);
    }

    @Test
    public void getReceiptTest_ok(){
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        String receipt = burger.getReceipt();
        Assert.assertEquals("WRONG RECEIPT",receipt,BURGER_RECEIPT);
    }
}
