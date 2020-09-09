package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class GenderTest extends AbstractFakerTest {

    @Test
    public void types() {
        assertThat(faker.gender().types(), matchesRegularExpression("(\\w+ ?){1,2}"));
    }

    @Test
    public void binaryTypes() {
        assertThat(faker.gender().binaryTypes(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void shortBinaryTypes() {
        assertThat(faker.gender().shortBinaryTypes(), matchesRegularExpression("f|m"));
    }

}
