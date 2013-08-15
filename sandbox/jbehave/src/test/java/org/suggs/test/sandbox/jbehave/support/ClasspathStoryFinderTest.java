package org.suggs.test.sandbox.jbehave.support;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.suggs.test.sandbox.jbehave.support.ClasspathStoryFinder.findFilenamesThatMatch;

public class ClasspathStoryFinderTest {

    private static final Logger LOG = LoggerFactory.getLogger(ClasspathStoryFinderTest.class);

    @Test
    public void shouldFindTestTextFileFromClasspath() {
        List<String> filenames = findFilenamesThatMatch("testFile*.txt");
        LOG.debug("Found the following {} text filenames {}", filenames.size(), filenames);
        assertThat(filenames.size(), is(3));
    }

    @Test
    public void shouldFindTextFileByFullName() {
        List<String> filenames = findFilenamesThatMatch("testFile2.txt");
        assertThat(filenames.size(), is(1));
    }
}
