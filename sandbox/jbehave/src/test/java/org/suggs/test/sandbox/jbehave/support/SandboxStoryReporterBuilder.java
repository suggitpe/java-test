package org.suggs.test.sandbox.jbehave.support;

import org.jbehave.core.configuration.spring.SpringStoryReporterBuilder;
import org.jbehave.core.io.CodeLocations;

/**
 * Story reporter builder for JBehave.
 */
public class SandboxStoryReporterBuilder extends SpringStoryReporterBuilder {

    public SandboxStoryReporterBuilder() {
        withCodeLocation(CodeLocations.codeLocationFromClass(SandboxStoryReporterBuilder.class));
        withDefaultFormats();
        withFormats(org.jbehave.core.reporters.Format.HTML);
        withFailureTrace(true);
    }
}
