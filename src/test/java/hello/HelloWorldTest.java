package hello;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    private static final float DELTA = 0.0001f;

    @Test
    public void cosineSimilarityCorrectlyComparesTwoStrings() {

        assertEquals(0.4767F, HelloWorld.sentenceComparison1(), DELTA);

    }

    @Test
    public void secondCosineSimilarityMethodCorrectlyComparesTwoStrings() {

        assertEquals(0.5720F, HelloWorld.sentenceComparison2(), DELTA);
    }


}
