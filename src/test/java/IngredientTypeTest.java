import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;

    public IngredientTypeTest(IngredientType type){
        this.ingredientType = type;
    }

    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        };
    }

    @Test
    public void checkIngredientTypeIsExist_ok() {
        Assert.assertNotNull(ingredientType);
    }
}
