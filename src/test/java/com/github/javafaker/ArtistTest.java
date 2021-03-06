package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ArtistTest extends AbstractFakerTest {

    @Test
    public void name() {
        assertThat(faker.artist().name(), matchesRegularExpression("(\\w+ ?){1,2}"));
    }
}
