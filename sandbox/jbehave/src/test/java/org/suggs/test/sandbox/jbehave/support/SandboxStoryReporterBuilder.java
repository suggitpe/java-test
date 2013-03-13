package org.suggs.test.sandbox.jbehave.support;

import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;

/**
 * Story reporter builder for JBehave.
 */
public class SandboxStoryReporterBuilder extends StoryReporterBuilder {

    public SandboxStoryReporterBuilder() {
        withCodeLocation(CodeLocations.codeLocationFromClass(SandboxStoryReporterBuilder.class));
        withDefaultFormats();
        withFormats(org.jbehave.core.reporters.Format.HTML);
    }
}
