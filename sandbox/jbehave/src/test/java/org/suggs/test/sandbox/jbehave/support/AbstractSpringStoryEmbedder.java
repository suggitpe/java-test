package org.suggs.test.sandbox.jbehave.support;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromURL;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * This classes responsibility is:
 * 1. Define the basic JBehave embedder for spring managed applications
 * Deprecated in favour of the embedder runner builder style
 */
@Deprecated
@RunWith(SpringAnnotatedEmbedderRunner.class)
@Configure(storyLoader = LoadFromURL.class, storyReporterBuilder = SandboxStoryReporterBuilder.class, parameterConverters = {SandboxDateConverter.class})
@UsingEmbedder(embedder = Embedder.class)
public abstract class AbstractSpringStoryEmbedder extends InjectableEmbedder {

    private static final Logger LOG = getLogger(AbstractSpringStoryEmbedder.class);

    @Test
    @Override
    public void run() throws Exception {
        List<String> paths = createStoryPaths();
        if (paths == null || paths.isEmpty()) {
            throw new IllegalStateException("No story paths found for state machine");
        }
        LOG.info("Running [" + this.getClass().getSimpleName() + "] with spring_stories [" + paths + "]");
        injectedEmbedder().runStoriesAsPaths(paths);
    }

    private List<String> createStoryPaths() {
        String storyLocation = codeLocationFromClass(this.getClass()).getFile();
        LOG.info("Running spring_stories from [" + storyLocation + "]");
        StoryFinder finder = new StoryFinder();
        return finder.findPaths(storyLocation,
                doGetStoryIncludeRegex(),
                doGetStoryExcludeRegex(),
                "file:" + storyLocation);
    }

    protected List<String> doGetStoryIncludeRegex() {
        return Arrays.asList("**/*.story");
    }

    protected List<String> doGetStoryExcludeRegex() {
        return null;
    }


}
