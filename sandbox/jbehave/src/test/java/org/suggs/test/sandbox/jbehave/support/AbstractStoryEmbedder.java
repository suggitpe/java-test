package org.suggs.test.sandbox.jbehave.support;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.LoadFromURL;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.steps.ParameterConverters.DateConverter;
import static org.suggs.test.sandbox.jbehave.support.AbstractStoryEmbedder.SandboxDateConverter;


@RunWith(AnnotatedEmbedderRunner.class)
@UsingEmbedder(embedder = Embedder.class)
@Configure(storyLoader = LoadFromURL.class,
        stepPatternParser = RegexPrefixCapturingPatternParser.class,
        parameterConverters = {SandboxDateConverter.class},
        storyReporterBuilder = SandboxStoryReporterBuilder.class)
/**
 * Abstract class to form the core basis for all Jbehave embedder usage.  To use this class
 * you need to extend it and annotate with a UsingSteps(instances = {\<steps classes\>}).  If
 * you need to selectively include or exclude stories, do so with the overloadable methods below.
 */
public abstract class AbstractStoryEmbedder extends InjectableEmbedder {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractStoryEmbedder.class);
    private final String storyLocation = codeLocationFromClass(this.getClass()).getFile();


    @Test
    public void findStories() {
        LOG.info("Finding stories from [" + codeLocationFromClass(getClass()) + "]");
        LOG.info("Finding stories from [" + getClass().getClassLoader().getResource(".").getFile() + "]");

    }

    @Test
    @Override
    public void run() throws Throwable {
        StoryFinder finder = new StoryFinder();
        LOG.info("Running stories from location [" + storyLocation + "]");
        List<String> urls = finder.findPaths(storyLocation,
                doGetStoryIncludeRegex(),
                doGetStoryExcludeRegex(),
                "file:" + storyLocation);
        LOG.info("Running stories: " + urls);
        injectedEmbedder().runStoriesAsPaths(urls);
    }

    protected List<String> doGetStoryIncludeRegex() {
        return Arrays.asList("**/*.story");
    }

    protected List<String> doGetStoryExcludeRegex() {
        return null;
    }

    public static class SandboxDateConverter extends DateConverter {

        public SandboxDateConverter() {
            super(new SimpleDateFormat("dd-MM-yyyy"));
        }
    }
}
