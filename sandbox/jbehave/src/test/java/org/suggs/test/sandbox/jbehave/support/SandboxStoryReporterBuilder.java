package org.suggs.test.sandbox.jbehave.support;

import org.jbehave.core.configuration.spring.SpringStoryReporterBuilder;
import org.jbehave.core.io.CodeLocations;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;

/**
 * Story reporter builder for JBehave.
 */
public class SandboxStoryReporterBuilder extends SpringStoryReporterBuilder {

    public SandboxStoryReporterBuilder() {
        withCodeLocation(codeLocationFromClass(SandboxStoryReporterBuilder.class));
        withDefaultFormats();
        withFormats(HTML, CONSOLE);
        withFailureTrace(true);
    }
}
