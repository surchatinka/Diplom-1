import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private static final IngredientType INGREDIENT_TYPE_SAUCE = IngredientType.SAUCE;
    private static final IngredientType INGREDIENT_TYPE_FILLING = IngredientType.FILLING;
    private final IngredientType ingredientType;

    public IngredientTypeTest(IngredientType type){
        this.ingredientType = type;
    }

    @Parameterized.Parameters(name = "IngredientType -  {0}")
    public static Object[][] testData(){
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        };
    }

    @Test
    public void checkIngredientTypeIsExistTest_ok() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(ingredientType).isNotNull();
        switch(ingredientType){
            case SAUCE:
                softly.assertThat(ingredientType).isEqualTo(INGREDIENT_TYPE_SAUCE);
                break;
            case FILLING:
                softly.assertThat(ingredientType).isEqualTo(INGREDIENT_TYPE_FILLING);
                break;
            default: break;
        }
        softly.assertAll();
    }
}