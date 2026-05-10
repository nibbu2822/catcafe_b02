package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatCafeTest {

    private CatCafe cafe;

    @BeforeEach
    void setup() {
        cafe = new CatCafe();
    }

    @Test
    void given_EmptyCafe_when_GetCatCount_then_ZeroReturned() {
        // given
        // empty cafe

        // when
        long count = cafe.getCatCount();

        // then
        assertEquals(0, count);
    }

    // 2
    @Test
    void given_OneCat_when_Added_then_CountIsOne() {
        // given
        FelineOverLord cat = new FelineOverLord("Mimi", 4);

        // when
        cafe.addCat(cat);
        long count = cafe.getCatCount();

        // then
        assertEquals(1, count);
    }

    // 3
    @Test
    void given_MultipleCats_when_Added_then_CorrectCount() {
        // given
        cafe.addCat(new FelineOverLord("A", 3));
        cafe.addCat(new FelineOverLord("B", 5));

        // when
        long count = cafe.getCatCount();

        // then
        assertEquals(2, count);
    }

    // 4
    @Test
    void given_CatExists_when_GetCatByName_then_CatReturned() {
        // given
        FelineOverLord cat = new FelineOverLord("Luna", 4);
        cafe.addCat(cat);

        // when
        FelineOverLord result = cafe.getCatByName("Luna");

        // then
        assertNotNull(result);
        assertEquals("Luna", result.name());
        assertEquals(4, result.weight());
    }

    // 5
    @Test
    void given_CatDoesNotExist_when_GetCatByName_then_NullReturned() {
        // given
        cafe.addCat(new FelineOverLord("Milo", 4));

        // when
        FelineOverLord result = cafe.getCatByName("Unknown");

        // then
        assertNull(result);
    }

    // 6
    @Test
    void given_NullName_when_GetCatByName_then_NullReturned() {
        // when
        FelineOverLord result = cafe.getCatByName(null);

        // then
        assertNull(result);
    }

    // 7
    @Test
    void given_ValidWeightRange_when_GetCatByWeight_then_CatReturned() {
        // given
        FelineOverLord cat = new FelineOverLord("Kitty", 5);
        cafe.addCat(cat);

        // when
        FelineOverLord result = cafe.getCatByWeight(4, 6);

        // then
        assertNotNull(result);
        assertEquals("Kitty", result.name());
        assertEquals(5, result.weight());
    }

    // 8
    @Test
    void given_OutOfRangeWeight_when_GetCatByWeight_then_NullReturned() {
        // given
        cafe.addCat(new FelineOverLord("Heavy", 10));

        // when
        FelineOverLord result = cafe.getCatByWeight(1, 5);

        // then
        assertNull(result);
    }

    // 9
    @Test
    void given_InvalidWeightRange_when_GetCatByWeight_then_NullReturned() {
        // when
        FelineOverLord result = cafe.getCatByWeight(10, 5);

        // then
        assertNull(result);
    }

    // 10
    @Test
    void given_NegativeMinWeight_when_GetCatByWeight_then_NullReturned() {
        // when
        FelineOverLord result = cafe.getCatByWeight(-1, 5);

        // then
        assertNull(result);
    }

    // 11
    @Test
    void given_MultipleCats_when_GetCatByName_then_FirstMatchReturned() {
        // given
        FelineOverLord c1 = new FelineOverLord("Leo", 3);
        FelineOverLord c2 = new FelineOverLord("Leo", 5);

        cafe.addCat(c1);
        cafe.addCat(c2);

        // when
        FelineOverLord result = cafe.getCatByName("Leo");

        // then
        assertNotNull(result);
        assertEquals("Leo", result.name());
        assertEquals(3, result.weight());
    }
}
