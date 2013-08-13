package org.suggs.test.sandbox.jbehave.support;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClasspathStoryFinder {

    public static List<String> findStories(List<String> resources) {
        List<String> paths = new ArrayList<String>();
        for (String resource : resources) {
            paths.addAll(findStories(resource));
        }
        return paths;
    }

    public static List<String> findStories(String resource) {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            List<Resource> resources = Arrays.asList(resolver.getResources(resource));
            //List<URL> resources = toList(ClasspathStoryFinder.class.getClassLoader().getResources(resource));
            return transformUrlsToStrings(resources);

        } catch (IOException ioe) {
            throw new ClasspathStoryFinderException("Failed to find resources", ioe);
        }
    }

    private static List<String> transformUrlsToStrings(List<Resource> resources) throws IOException {
        List<String> listOfLocations = new ArrayList<String>();
        for (Resource resource : resources) {
            listOfLocations.add(resource.getURL().toString());
        }
        return listOfLocations;

    }

    private static class ClasspathStoryFinderException extends RuntimeException {
        public ClasspathStoryFinderException(String theMessage, IOException theRootCause) {
            super(theMessage, theRootCause);
        }
    }
}
