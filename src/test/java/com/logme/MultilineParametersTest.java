package com.logme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MultilineParametersTest {

    private static final String EOL = System.lineSeparator();
    private static final String TAB = "    ";
    
    @Test
    void init_default_created() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        
        // When
        String actual = multilineParameters.toString();
        
        // Then
        Assertions.assertEquals(
                "{" + EOL 
                + TAB + EOL 
                + "}",
                actual
        );
    }

    @Test
    void append_boolean_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        boolean value = true;

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=" + value + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_byte_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        byte value = Byte.MAX_VALUE;

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=" + value + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_char_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        char value = 'c';

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=c" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_double_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        double value = Double.MAX_VALUE;

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=" + value + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_float_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        float value = Float.MAX_VALUE;

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=" + value + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_int_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        int value = Integer.MAX_VALUE;

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=" + value + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_long_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        long value = Long.MAX_VALUE;

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=" + value + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_nullWithNullDefault_nullDefaultAppended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        Object value = null;
        String nullDefault = "<not specified>";

        // When
        String actual = multilineParameters
                .append("value", value, nullDefault)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=" + nullDefault + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_stringArrayWithNoItems_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        String[] value = {};

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=[]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_stringArrayWithOneItem_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        String[] value = {"1"};

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=[1]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_stringArrayWithTwoItems_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        String[] value = {"1", "2"};

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=[1, 2]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_stringArrayWithThreeItems_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        String[] value = {"1", "2", "3"};

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=[1, 2, 3]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_stringArrayAndMultilineValueIsFalse_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        String[] value = {"1", "2", "3"};

        // When
        String actual = multilineParameters
                .append("value", value, false)
                .toString();
        
        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=[1, 2, 3]" + EOL
                        + "}",
                actual
        );
    }
    
    @Test
    void append_stringArrayAndMultilineValueIsTrue_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        String[] value = {"1", "2", "3"};

        // When
        String actual = multilineParameters
                .append("value", value, true)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=[" + EOL
                        + TAB + TAB + "1," + EOL
                        + TAB + TAB + "2," + EOL
                        + TAB + TAB + "3" + EOL
                        + TAB + "]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_stringCollectionWithNoItems_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        List<String> value = Collections.emptyList();

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=[]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_stringCollectionWithOneItem_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        List<String> value = Collections.singletonList("1");

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=[1]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_stringCollectionWithTwoItems_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        List<String> value = Arrays.asList("1", "2");

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=[1, 2]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_stringCollectionWithThreeItems_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        List<String> value = Arrays.asList("1", "2", "3");

        // When
        String actual = multilineParameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=[1, 2, 3]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_stringCollectionAndMultilineValueIsFalse_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        List<String> value = Arrays.asList("1", "2", "3");

        // When
        String actual = multilineParameters
                .append("value", value, false)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=[1, 2, 3]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_stringCollectionAndMultilineValueIsTrue_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();
        List<String> value = Arrays.asList("1", "2", "3");

        // When
        String actual = multilineParameters
                .append("value", value, true)
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "value=[" + EOL
                        + TAB + TAB + "1," + EOL
                        + TAB + TAB + "2," + EOL
                        + TAB + TAB + "3" + EOL
                        + TAB + "]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_parameterAndParameter_appended() {
        // Given
        MultilineParameters multilineParameters = new MultilineParameters();

        // When
        String actual = multilineParameters
                .append("numeric", 1)
                .append("string", "some text goes here")
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL 
                        + TAB + "numeric=1," + EOL 
                        + TAB + "string=some text goes here" + EOL 
                        + "}", 
                actual
        );
    }
    
    @Test
    void appendParameters_parameters_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendParameters(
                        "parameters",
                        parameters -> parameters
                                .append("numeric", 1)
                                .append("string", "some text goes here")
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL 
                        + TAB + "parameters={numeric=1, string=some text goes here}" + EOL 
                        + "}", 
                actual
        );
    }

    @Test
    void appendParameters_parametersCollectionWithNoItems_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendParameters(
                        "parametersCollection", 
                        Collections.emptyList()
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "parametersCollection=[]" + EOL
                        + "}",
                actual
        );
    }
    
    @Test
    void appendParameters_parametersCollectionWithOneItem_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendParameters(
                        "parametersCollection", 
                        Collections.singletonList(
                                (Parameters parameters) -> parameters.append("item1", 1)
                        )
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "parametersCollection=[{item1=1}]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void appendParameters_parametersCollectionWithTwoItems_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendParameters(
                        "parametersCollection", 
                        Arrays.asList(
                                (Parameters parameters) -> parameters.append("item1", 1),
                                (Parameters parameters) -> parameters.append("item2", 2)
                        )
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "parametersCollection=[{item1=1}, {item2=2}]" + EOL
                        + "}",
                actual
        );

    }

    @Test
    void appendParameters_parametersCollectionWithThreeItems_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendParameters(
                        "parametersCollection", 
                        Arrays.asList(
                                (Parameters parameters) -> parameters.append("item1", 1),
                                (Parameters parameters) -> parameters.append("item2", 2),
                                (Parameters parameters) -> parameters.append("item3", 3)
                        )
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "parametersCollection=[{item1=1}, {item2=2}, {item3=3}]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void appendParameters_parametersCollectionAndMultilineValueIsFalse_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendParameters(
                        "parametersCollection",
                        Arrays.asList(
                                (Parameters parameters) -> parameters.append("item1", 1),
                                (Parameters parameters) -> parameters.append("item2", 2)
                        ),
                        false
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "parametersCollection=[{item1=1}, {item2=2}]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void appendParameters_parametersCollectionAndMultilineValueIsTrue_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendParameters(
                        "parametersCollection",
                        Arrays.asList(
                                (Parameters parameters) -> parameters.append("item1", 1),
                                (Parameters parameters) -> parameters.append("item2", 2)
                        ),
                        true
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "parametersCollection=[" + EOL
                        + TAB + TAB + "{item1=1}," + EOL
                        + TAB + TAB + "{item2=2}" + EOL
                        + TAB + "]" + EOL
                        + "}",
                actual
        );
    }
    
    @Test
    void appendMultilineParameters_multilineParameters_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendMultilineParameters(
                        "multilineParameters",
                                (MultilineParameters multilineParameters) -> multilineParameters
                                        .append("numeric", 1)
                                        .append("string", "some text goes here")
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "multilineParameters={" + EOL
                        + TAB + TAB + "numeric=1," + EOL 
                        + TAB + TAB + "string=some text goes here" + EOL
                        + TAB + "}" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void appendMultilineParameters_multilineParametersCollectionWithNoItems_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendMultilineParameters(
                        "multilineParametersCollection",
                        Collections.emptyList()
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "multilineParametersCollection=[]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void appendMultilineParameters_multilineParametersCollectionWithOneItem_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendMultilineParameters(
                        "multilineParametersCollection",
                        Collections.singletonList(
                                (MultilineParameters multilineParameters) -> multilineParameters.append("item1", 1)
                        )
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "multilineParametersCollection=[{" + EOL
                        + TAB + TAB + "item1=1" + EOL
                        + TAB + "}]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void appendMultilineParameters_multilineParametersCollectionWithTwoItems_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendMultilineParameters(
                        "multilineParametersCollection",
                        Arrays.asList(
                                (MultilineParameters multilineParameters) -> multilineParameters.append("item1", 1),
                                (MultilineParameters multilineParameters) -> multilineParameters.append("item2", 2)
                        )
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "multilineParametersCollection=[{" + EOL
                        + TAB + TAB + "item1=1" + EOL
                        + TAB + "}, {" + EOL
                        + TAB + TAB + "item2=2" + EOL
                        + TAB + "}]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void appendMultilineParameters_multilineParametersCollectionWithThreeItems_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendMultilineParameters(
                        "multilineParametersCollection",
                        Arrays.asList(
                                (MultilineParameters multilineParameters) -> multilineParameters.append("item1", 1),
                                (MultilineParameters multilineParameters) -> multilineParameters.append("item2", 2),
                                (MultilineParameters multilineParameters) -> multilineParameters.append("item3", 3)
                        )
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "multilineParametersCollection=[{" + EOL
                        + TAB + TAB + "item1=1" + EOL
                        + TAB + "}, {" + EOL
                        + TAB + TAB + "item2=2" + EOL
                        + TAB + "}, {" + EOL
                        + TAB + TAB + "item3=3" + EOL
                        + TAB + "}]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void appendMultilineParameters_multilineParametersCollectionAndMultilineValueIsFalse_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendMultilineParameters(
                        "multilineParametersCollection",
                        Arrays.asList(
                                (MultilineParameters multilineParameters) -> multilineParameters.append("item1", 1),
                                (MultilineParameters multilineParameters) -> multilineParameters.append("item2", 2)
                        ),
                        false
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "multilineParametersCollection=[{" + EOL
                        + TAB + TAB + "item1=1" + EOL
                        + TAB + "}, {" + EOL
                        + TAB + TAB + "item2=2" + EOL
                        + TAB + "}]" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void appendMultilineParameters_multilineParametersCollectionAndMultilineValueIsTrue_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendMultilineParameters(
                        "multilineParametersCollection",
                        Arrays.asList(
                                (MultilineParameters multilineParameters) -> multilineParameters.append("item1", 1),
                                (MultilineParameters multilineParameters) -> multilineParameters.append("item2", 2)
                        ),
                        true
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "multilineParametersCollection=[" + EOL
                        + TAB + TAB + "{" + EOL
                        + TAB + TAB + TAB + "item1=1" + EOL
                        + TAB + TAB + "}," + EOL
                        + TAB + TAB + "{" + EOL
                        + TAB + TAB + TAB + "item2=2" + EOL
                        + TAB + TAB + "}" + EOL
                        + TAB + "]" + EOL
                        + "}",
                actual
        );
    }
    
    @Test
    void append_multilineParametersWithThreeLevelHierarchy_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();
        
        // When
        String actual = rootMultilineParameters
                .appendMultilineParameters(
                        "multilineParameters1",
                        (MultilineParameters multilineParameters1) -> multilineParameters1
                                .append("level", 1)
                                .append("type", "object")
                                .appendMultilineParameters(
                                        "multilineParameters2-1",
                                        Collections.singletonList((MultilineParameters multilineParameters2) -> multilineParameters2
                                                .append("level", 2)
                                                .append("type", "collection")
                                                .append("multilineValue", "true")
                                                .appendMultilineParameters(
                                                        "multilineParameters3",
                                                        (MultilineParameters multilineParameters3) -> multilineParameters3
                                                                .append("level", 3)
                                                                .append("type", "object")
                                                )
                                        ),
                                        true
                                )
                                .appendMultilineParameters(
                                        "multilineParameters2-2",
                                        Collections.singletonList((MultilineParameters multilineParameters2) -> multilineParameters2
                                                .append("level", 2)
                                                .append("type", "collection")
                                                .append("multilineValue", "false")
                                                .appendMultilineParameters(
                                                        "multilineParameters4",
                                                        (MultilineParameters multilineParameters3) -> multilineParameters3
                                                                .append("level", 3)
                                                                .append("type", "object")
                                                )
                                        ),
                                        false
                                )
                )
                .toString();
        
        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "multilineParameters1={" + EOL
                        + TAB + TAB + "level=1," + EOL
                        + TAB + TAB + "type=object," + EOL
                        + TAB + TAB + "multilineParameters2-1=[" + EOL
                        + TAB + TAB + TAB + "{" + EOL
                        + TAB + TAB + TAB + TAB + "level=2," + EOL
                        + TAB + TAB + TAB + TAB + "type=collection," + EOL
                        + TAB + TAB + TAB + TAB + "multilineValue=true," + EOL
                        + TAB + TAB + TAB + TAB + "multilineParameters3={" + EOL
                        + TAB + TAB + TAB + TAB + TAB + "level=3," + EOL
                        + TAB + TAB + TAB + TAB + TAB + "type=object" + EOL
                        + TAB + TAB + TAB + TAB + "}" + EOL
                        + TAB + TAB + TAB + "}" + EOL
                        + TAB + TAB + "]," + EOL
                        + TAB + TAB + "multilineParameters2-2=[{" + EOL
                        + TAB + TAB + TAB + "level=2," + EOL
                        + TAB + TAB + TAB + "type=collection," + EOL
                        + TAB + TAB + TAB + "multilineValue=false," + EOL
                        + TAB + TAB + TAB + "multilineParameters4={" + EOL
                        + TAB + TAB + TAB + TAB + "level=3," + EOL
                        + TAB + TAB + TAB + TAB + "type=object" + EOL
                        + TAB + TAB + TAB + "}" + EOL
                        + TAB + TAB + "}]" + EOL
                        + TAB + "}" + EOL
                        + "}",
                actual
        );
    }

    @Test
    void append_parametersAndMultilineParameters_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .appendParameters(
                        "parameters",
                        Collections.singletonList(
                                (Parameters parameters) -> parameters.append("item1", "1")
                        )
                )
                .appendMultilineParameters(
                        "multilineParameters",
                        Collections.singletonList(
                                (MultilineParameters multilineParameters) -> multilineParameters.append("item2", "2")
                        )
                )
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "parameters=[{item1=1}]," + EOL
                        + TAB + "multilineParameters=[{" + EOL
                        + TAB + TAB + "item2=2" + EOL
                        + TAB + "}]" + EOL
                        + "}",
                actual
        );
    }
    
    @Test
    void append_parameterAndMultilineParametersAndParametersAndParameter_appended() {
        // Given
        MultilineParameters rootMultilineParameters = new MultilineParameters();

        // When
        String actual = rootMultilineParameters
                .append("type", "pdf")
                .appendMultilineParameters(
                        "files",
                        Arrays.asList(
                                (MultilineParameters multilineParameters) -> multilineParameters
                                        .append("type", "pdf")
                                        .append("path", "C:/doc/1.pdf"),
                                (MultilineParameters multilineParameters) -> multilineParameters
                                        .append("type", "txt")
                                        .append("path", "C:/doc/2.txt")
                        )
                )
                .appendParameters(
                        "files",
                        Arrays.asList(
                                (Parameters parameters) -> parameters
                                        .append("type", "pdf")
                                        .append("path", "C:/doc/1.pdf"),
                                (Parameters parameters) -> parameters
                                        .append("type", "txt")
                                        .append("path", "C:/doc/2.txt")
                        )
                )
                .append("path", "C:/doc/1.pdf")
                .toString();

        // Then
        Assertions.assertEquals(
                "{" + EOL
                        + TAB + "type=pdf," + EOL
                        + TAB + "files=[{" + EOL
                        + TAB + TAB + "type=pdf," + EOL
                        + TAB + TAB + "path=C:/doc/1.pdf" + EOL
                        + TAB + "}, {" + EOL
                        + TAB + TAB + "type=txt," + EOL
                        + TAB + TAB + "path=C:/doc/2.txt" + EOL
                        + TAB + "}]," + EOL
                        + TAB + "files=[{type=pdf, path=C:/doc/1.pdf}, {type=txt, path=C:/doc/2.txt}]," + EOL
                        + TAB + "path=C:/doc/1.pdf" + EOL
                        + "}",
                actual
        );
    }
}
