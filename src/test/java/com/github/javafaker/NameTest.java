package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.Test;

import com.github.javafaker.repeating.Repeat;

public class NameTest extends AbstractFakerTest {

    @Test
    public void testName() {
        assertThat(faker.name().name(), matchesRegularExpression("([\\w']+\\.?( )?){2,3}"));
    }

    @Test
    public void testNameWithMiddle() {
        assertThat(faker.name().nameWithMiddle(), matchesRegularExpression("([\\w']+\\.?( )?){3,4}"));
    }

    @Test
    @Repeat(times = 10)
    public void testNameWithMiddleDoesNotHaveRepeatedName() {
        String nameWithMiddle = faker.name().nameWithMiddle();
        String[] splitNames = nameWithMiddle.split(" ");
        String firstName = splitNames[0];
        String middleName = splitNames[1];
        assertThat(firstName, not(equalTo(middleName)));
    }

    @Test
    public void testFullName() {
        assertThat(faker.name().fullName(), matchesRegularExpression("([\\w']+\\.?( )?){2,4}"));
    }

    @Test
    public void testFirstName() {
        assertThat(faker.name().firstName(), matchesRegularExpression("\\w+"));
    }

    @Test
    public void testFirstNameLength() {
        for (int i = 2; i < 14; i++) {
            try {
                assertThat(faker.name().firstName(i), matchesRegularExpression("\\w{" + i + "}"));
            } catch (RuntimeException re) {
                String message = "name.first_name with size " + i + " resulted in null expression";
                assertEquals(message, re.getMessage());
            }
        }
    }

    @Test
    public void testLastName() {
        assertThat(faker.name().lastName(), matchesRegularExpression("[A-Za-z']+"));
    }

    @Test
    public void testLastNameLength() {
        for (int i = 4; i < 14; i++) {
            assertThat(faker.name().lastName(i), matchesRegularExpression("[A-Za-z']{" + i + "}"));
        }
    }

    @Test
    public void testPrefix() {
        assertThat(faker.name().prefix(), matchesRegularExpression("\\w+\\.?"));
    }

    @Test
    public void testSuffix() {
        assertThat(faker.name().suffix(), matchesRegularExpression("\\w+\\.?"));
    }

    @Test
    public void testTitle() {
        assertThat(faker.name().title(), matchesRegularExpression("(\\w+\\.?( )?){3}"));
    }

    @Test
    public void testUsername() {
        assertThat(faker.name().username(), matchesRegularExpression("^(\\w+)\\.(\\w+)$"));
    }

    @Test
    public void testUsernameWithSpaces() {
        final Name name = spy(new Name(faker));
        doReturn("Compound Name").when(name).firstName();
        doReturn(name).when(faker).name();
        assertThat(faker.name().username(), matchesRegularExpression("^(\\w+)(\\w+)\\.(\\w+)$"));
    }
    
    @Test
    public void testBloodGroup() {
        assertThat(faker.name().bloodGroup(), matchesRegularExpression("(A|B|AB|O)[+-]"));
    }

    @Test
    public void testUsernameAlt() {
        for (int i = 4; i < 12; i++) {
            assertThat(faker.name().username(i),
                matchesRegularExpression("[a-z][a-z]\\d{2," + (i - 2) + "}"));
        }
    }
}