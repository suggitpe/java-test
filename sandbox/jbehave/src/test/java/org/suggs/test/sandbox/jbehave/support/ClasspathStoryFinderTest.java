package org.suggs.test.sandbox.jbehave.support;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.suggs.test.sandbox.jbehave.support.ClasspathStoryFinder.findStories;

public class ClasspathStoryFinderTest {

    private static final Logger LOG = LoggerFactory.getLogger(ClasspathStoryFinderTest.class);

    @Test
    public void shouldFindTestTextFileFromClasspath() {
        List<String> files = findStories("**/testFile*.txt");
        LOG.debug("Found the following {} text files {}", files.size(), files);
        assertThat(files.size(), is(3));
    }

    @Test
    public void shouldFindTextFileByFullName(){
        List<String> files = findStories("**/testFile2.txt");
        assertThat( files.size(), is(1) );

    }
}
