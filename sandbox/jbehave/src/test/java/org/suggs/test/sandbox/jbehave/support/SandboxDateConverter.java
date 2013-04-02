package org.suggs.test.sandbox.jbehave.support;

import org.jbehave.core.steps.ParameterConverters;

import java.text.SimpleDateFormat;

/**
 * This classes responsibility is:
 * 1. Converts all dates into a Uk format.
 */
public class SandboxDateConverter extends ParameterConverters.DateConverter {

    public SandboxDateConverter() {
        super(new SimpleDateFormat("dd-MM-yyyy"));
    }
}


