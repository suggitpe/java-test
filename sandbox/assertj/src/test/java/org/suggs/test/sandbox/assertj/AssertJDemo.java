package org.suggs.test.sandbox.assertj;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJDemo {

    @Test
    public void matchesTwoStringsTheSame() {
        assertThat("foo").isEqualTo("foo");
    }

    @Test
    public void identifiesTwoStringsNotTheSame() {
        assertThat("foo").isNotEqualTo("bar");
    }

    @Test
    public void identifiesItemsInAList() {
        List<String> nameList = Arrays.asList("Peter", "Paul", "Geoff");
        assertThat(nameList).hasSize(3).contains("Peter", "Paul").doesNotContain("Alice");
    }

    @Test
    @Ignore
    public void givesADecentErrorMessage() {
        // fails with the first assertion failure .. does not evaluate the second.
        assertThat("foo").isEqualTo("bar").isEqualTo("baz");
    }

    @Test
    public void matchesWithRegularExpressions() {
        assertThat("ha").matches("h.");
    }


}
