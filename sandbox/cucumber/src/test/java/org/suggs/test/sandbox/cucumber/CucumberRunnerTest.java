package org.suggs.test.sandbox.cucumber;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"progress", "html:build/cucumber"},
        glue = "org.suggs.test.sandbox.cucumber",
        features = "classpath:org/suggs/test/sandbox/cucumber")
public class CucumberRunnerTest {
}
