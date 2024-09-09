package edu.studying.junit.presentation.d.testtemplate;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureConverterTest {

    @TestTemplate
    // @TestTemplate annotation is used to signal that the annotated method is a test template method.
    // In contrast to @Test methods, a test template is not itself a test case but rather a template for test cases.
    // As such, it is designed to be invoked multiple times depending on the number of invocation contexts returned by the registered providers.
    // Must be used together with at least one provider
    @ExtendWith(TemperatureTestProvider.class)
        // @ExtendWith annotation allows you to register extensions, which can intercept the test execution lifecycle to add additional behavior or services
    void testCelsiusToFahrenheit(double celsius, double fahrenheit) {
        double result = TemperatureConverter.celsiusToFahrenheit(celsius);
        System.out.println("Input fahrenheit: " + fahrenheit + " -> Results in " + result + " Celsius");
        assertEquals(fahrenheit, result, 0.001);
    }

    // TemperatureTestProvider
    public static class TemperatureTestProvider implements TestTemplateInvocationContextProvider {
        // Method is responsible for determining whether a given TestTemplateInvocationContextProvider can support
        // a specific test template method given the context.
        // An ExtensionContext instance that provides context information for the test template method being evaluated.
        // This context includes details such as the test class, test method, test instance, and so on.
        @Override
        public boolean supportsTestTemplate(ExtensionContext context) {
            // will always support the test template method, regardless of the context
            return true;
        }

        // Method returns a Stream of "TestTemplateInvocationContext" objects, each object acts like a test case
        @Override
        public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
            return Stream.of(
                    invocationContext(0.0, 32.0),
                    invocationContext(100.0, 212.0),
                    invocationContext(36.6, 97.88)
            );
        }

        // Factory method for "TestTemplateInvocationContext" objects creation
        private TestTemplateInvocationContext invocationContext(double celsius, double fahrenheit) {
            return new TestTemplateInvocationContext() {
                @Override
                public String getDisplayName(int invocationIndex) {
                    return "Test " + invocationIndex;
                }

                @Override
                public List<Extension> getAdditionalExtensions() {
                    return Collections.singletonList(
                            new ParameterResolver() {
                                // method indicates type of supported arguments
                                @Override
                                public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
                                    return parameterContext.getParameter().getType() == double.class;
                                }

                                // method sets the arguments
                                @Override
                                public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
                                    return parameterContext.getIndex() == 0 ? celsius : fahrenheit;
                                }
                            }
                    );
                }
            };
        }
    }

}