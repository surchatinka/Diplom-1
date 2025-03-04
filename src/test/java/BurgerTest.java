import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Spy
    private Burger burger = new Burger();
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
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void addIngredientTest_ok(){
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
    }

    @Test
    public void removeIngredient_ok(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(FIRST_INGREDIENT_INDEX);
        Mockito.verify(burger).removeIngredient(FIRST_INGREDIENT_INDEX);
    }

    @Test
    public void moveIngredient_ok(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(FIRST_INGREDIENT_INDEX,FIRST_INGREDIENT_INDEX+1);
        Mockito.verify(burger).moveIngredient(FIRST_INGREDIENT_INDEX,FIRST_INGREDIENT_INDEX+1);
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
