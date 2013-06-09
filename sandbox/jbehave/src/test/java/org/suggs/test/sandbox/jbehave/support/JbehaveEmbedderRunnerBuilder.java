package org.suggs.test.sandbox.jbehave.support;

import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromURL;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.junit.Assert.assertThat;

public class JbehaveEmbedderRunnerBuilder extends ConfigurableEmbedder {

    private static final Logger LOG = LoggerFactory.getLogger(JbehaveEmbedderRunnerBuilder.class);

    private List<String> storyLocatorIncludeRegex;
    private List<String> storyLocatorExcludeRegex;
    private InjectableStepsFactory stepsFactory;


    private JbehaveEmbedderRunnerBuilder() {
    }

    public static JbehaveEmbedderRunnerBuilder aJbehaveEmbedderRunner() {
        return new JbehaveEmbedderRunnerBuilder();
    }

    @Override
    public void run() throws Exception {
        List<String> paths = createStoryPaths();
        if (paths == null || paths.isEmpty()) {
            throw new IllegalStateException("No story paths found for state machine");
        }
        LOG.info("Running [" + this.getClass().getSimpleName() + "] with spring_stories [" + paths + "]");
        configuredEmbedder().runStoriesAsPaths(paths);
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        assertThat(stepsFactory, is(notNullValue()));
        return stepsFactory;
    }

    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromURL())
                .useParameterConverters(new ParameterConverters().addConverters(new SandboxDateConverter()))
                .useStoryReporterBuilder(new SandboxStoryReporterBuilder());
    }

    private List<String> createStoryPaths() {
        String storyLocation = codeLocationFromClass(this.getClass()).getFile();
        LOG.info("Running spring_stories from [" + storyLocation + "]");
        StoryFinder finder = new StoryFinder();
        return finder.findPaths(storyLocation,
                storyLocatorIncludeRegex,
                storyLocatorExcludeRegex,
                "file:" + storyLocation);
    }

    public JbehaveEmbedderRunnerBuilder withIncludedStoriesFoundBy(String... aStoryLocatorRegex) {
        storyLocatorIncludeRegex = asList(aStoryLocatorRegex);
        return this;
    }

    public JbehaveEmbedderRunnerBuilder withExcludedStoriesFilteredWith(String... aStoryFilterRegex) {
        storyLocatorExcludeRegex = asList(aStoryFilterRegex);
        return this;
    }

    public JbehaveEmbedderRunnerBuilder usingStepsFrom(Object... stepsSource) {
        stepsFactory = new InstanceStepsFactory(configuration(), stepsSource);
        return this;
    }

    public JbehaveEmbedderRunnerBuilder usingContextFrom(Class<?>... someContextClasses) {
        stepsFactory = new SpringStepsFactory(configuration(), new AnnotationConfigApplicationContext(someContextClasses));
        return this;
    }

    public JbehaveEmbedderRunnerBuilder usingContextFrom(String... someContextResources) {
        stepsFactory = new SpringStepsFactory(configuration(), new ClassPathXmlApplicationContext(someContextResources));
        return this;
    }

}
