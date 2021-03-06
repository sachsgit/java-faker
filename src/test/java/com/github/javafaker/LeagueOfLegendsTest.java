package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class LeagueOfLegendsTest extends AbstractFakerTest {

    @Test
    public void champion() {
        assertThat(faker.leagueOfLegends().champion(), matchesRegularExpression("^(\\w+\\.?-?'?\\s?&?\\s?)+$"));
    }

    @Test
    public void location() {
        assertThat(faker.leagueOfLegends().location(), matchesRegularExpression("^(\\w+\\s?)+$"));
    }

    @Test
    public void quote() {
        assertFalse(faker.leagueOfLegends().quote().isEmpty());
    }

    @Test
    public void summonerSpell() {
        assertThat(faker.leagueOfLegends().summonerSpell(), matchesRegularExpression("^(\\w+\\s?!?)+$"));
    }

    @Test
    public void masteries() {
        assertThat(faker.leagueOfLegends().masteries(), matchesRegularExpression("^(\\w+\\s?'?)+$"));
    }

    @Test
    public void rank() {
        assertThat(faker.leagueOfLegends().rank(), matchesRegularExpression("^\\w+(\\s[IV]+)?$"));
    }
}
