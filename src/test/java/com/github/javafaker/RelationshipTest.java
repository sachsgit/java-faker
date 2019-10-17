package com.github.javafaker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RelationshipTest extends AbstractFakerTest {

    private Faker mockFaker;

    @Before
    public void before() {
        super.before();
        mockFaker = Mockito.mock(Faker.class);
    }

    @Test
    public void anyTest() {
        assertThat(faker.relationships().any(), not(emptyOrNullString()));
    }

    @Test
    public void directTest() {
        assertThat(faker.relationships().direct(), not(emptyOrNullString()));
    }

    @Test
    public void extendedTest() {
        assertThat(faker.relationships().extended(), not(emptyOrNullString()));
    }

    @Test
    public void inLawTest() {
        assertThat(faker.relationships().inLaw(), not(emptyOrNullString()));
    }

    @Test
    public void spouseTest() {
        assertThat(faker.relationships().spouse(), not(emptyOrNullString()));
    }

    @Test
    public void parentTest() {
        assertThat(faker.relationships().parent(), not(emptyOrNullString()));
    }

    @Test
    public void siblingTest() {
        assertThat(faker.relationships().sibling(), not(emptyOrNullString()));
    }

    @Test(expected = RuntimeException.class)
    public void anyWithIllegalArgumentExceptionThrown() {
        when(mockFaker.random()).thenThrow(new IllegalArgumentException());
        new Relationships(mockFaker).any();
    }

    @Test(expected = RuntimeException.class)
    public void anyWithSecurityExceptionThrown() {
        when(mockFaker.random()).thenThrow(new SecurityException());
        new Relationships(mockFaker).any();
    }

    @Test(expected = RuntimeException.class)
    public void anyWithIllegalAccessExceptionThrown() {
        when(mockFaker.random()).thenThrow(new IllegalAccessException());
        new Relationships(mockFaker).any();
    }

    @Test(expected = RuntimeException.class)
    public void anyWithInvocationTargetExceptionThrown() {
        when(mockFaker.random()).thenThrow(new InvocationTargetException(new Exception()));
        new Relationships(mockFaker).any();
    }

}
