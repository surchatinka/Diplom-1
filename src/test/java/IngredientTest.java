import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    private static final IngredientType INGREDIENT_TYPE = IngredientType.SAUCE;
    private static final String INGREDIENT_NAME = "Mayo";
    private static final float INGREDIENT_PRICE = 5.45f;
    private static final float DELTA = 0.0005f;

    private Ingredient ingredient;

    @Before
    public void before(){
        ingredient = new Ingredient(INGREDIENT_TYPE, INGREDIENT_NAME, INGREDIENT_PRICE);
    }

    @Test
    public void getPriceTest_ok(){
        float ingredientPrice = ingredient.getPrice();
        Assert.assertEquals("Цена не совпадает",INGREDIENT_PRICE,ingredientPrice,DELTA);
    }
    @Test
    public void getNameTest_ok(){
        String ingredientName = ingredient.getName();
        Assert.assertEquals("Название ингредиента не совпадает",INGREDIENT_NAME,ingredientName);
    }
    @Test
    public void getTypeTest_ok(){
        IngredientType ingredientType = ingredient.getType();
        Assert.assertEquals("Тип ингредиента не совпадает",INGREDIENT_TYPE,ingredientType);
    }
}
