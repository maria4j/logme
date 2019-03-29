package com.logme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class ParametersTest {

    @Test
    void init_default_created() {
        // Given
        Parameters parameters = new Parameters();
        
        // When
        String actual = parameters.toString();
        
        // Then
        Assertions.assertEquals("{}", actual);
    }

    @Test
    void append_boolean_appended() {
        // Given
        Parameters parameters = new Parameters();
        boolean value = true;

        // When
        String actual = parameters
                .append("value", value)
                .toString();
        
        // Then
        Assertions.assertEquals("{value=" + value + "}", actual);
    }

    @Test
    void append_byte_appended() {
        // Given
        Parameters parameters = new Parameters();
        byte value = Byte.MIN_VALUE;
        
        // When
        String actual = parameters
                .append("value", value)
                .toString();
        
        // Then
        Assertions.assertEquals("{value=" + value + "}", actual);
    }

    @Test
    void append_char_appended() {
        // Given
        Parameters parameters = new Parameters();
        char value = 'c';

        // When
        String actual = parameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals("{value=" + value + "}", actual);
    }

    @Test
    void append_double_appended() {
        // Given
        Parameters parameters = new Parameters();
        double value = Double.MIN_VALUE;

        // When
        String actual = parameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals("{value=" + value + "}", actual);
    }

    @Test
    void append_float_appended() {
        // Given
        Parameters parameters = new Parameters();
        float value = Float.MIN_VALUE;

        // When
        String actual = parameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals("{value=" + value + "}", actual);
    }

    @Test
    void append_int_appended() {
        // Given
        Parameters parameters = new Parameters();
        int value = Integer.MIN_VALUE;

        // When
        String actual = parameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals("{value=" + value + "}", actual);
    }

    @Test
    void append_long_appended() {
        // Given
        Parameters parameters = new Parameters();
        long value = Long.MIN_VALUE;

        // When
        String actual = parameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals("{value=" + value + "}", actual);
    }

    @Test
    void append_nullWithNullDefault_nullDefaultAppended() {
        // Given
        Parameters parameters = new Parameters();
        Object value = null;
        String nullDefault = "<not specified>";

        // When
        String actual = parameters
                .append("value", value, nullDefault)
                .toString();

        // Then
        Assertions.assertEquals("{value=" + nullDefault + "}", actual);
    }
    
    @Test
    void append_stringArrayWitNoItems_appended() {
        // Given
        Parameters parameters = new Parameters();
        String[] value = new String[] {};

        // When
        String actual = parameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals("{value=[]}", actual);
    }

    @Test
    void append_stringArrayWitOneItems_appended() {
        // Given
        Parameters parameters = new Parameters();
        String[] value = new String[] {"1"};

        // When
        String actual = parameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals("{value=[1]}", actual);
    }

    @Test
    void append_stringArrayWithTwoItems_appended() {
        // Given
        Parameters parameters = new Parameters();
        String[] value = new String[] {"1", "2"};

        // When
        String actual = parameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals("{value=[1, 2]}", actual);
    }

    @Test
    void append_stringArrayWithThreeItems_appended() {
        // Given
        Parameters parameters = new Parameters();
        String[] value = new String[] {"1", "2", "3"};

        // When
        String actual = parameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals("{value=[1, 2, 3]}", actual);
    }

    @Test
    void append_stringCollectionWithNoItems_appended() {
        // Given
        Parameters parameters = new Parameters();
        List<String> value = Collections.emptyList();

        // When
        String actual = parameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals("{value=[]}", actual);
    }

    @Test
    void append_stringCollectionWithOneItem_appended() {
        // Given
        Parameters parameters = new Parameters();
        List<String> value = Collections.singletonList("1");

        // When
        String actual = parameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals("{value=[1]}", actual);
    }

    @Test
    void append_stringCollectionWithTwoItems_appended() {
        // Given
        Parameters parameters = new Parameters();
        List<String> value = Arrays.asList("1", "2");

        // When
        String actual = parameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals("{value=[1, 2]}", actual);
    }

    @Test
    void append_stringCollectionWithThreeItems_appended() {
        // Given
        Parameters parameters = new Parameters();
        List<String> value = Arrays.asList("1", "2", "3");

        // When
        String actual = parameters
                .append("value", value)
                .toString();

        // Then
        Assertions.assertEquals("{value=[1, 2, 3]}", actual);
    }

    @Test
    void append_parameterAndParameter_appended() {
        // Given
        Parameters parameters = new Parameters();
        
        // When
        String actual = parameters
                .append("numeric", 1)
                .append("string", "some text goes here")
                .toString();

        // Then
        Assertions.assertEquals("{numeric=1, string=some text goes here}", actual);
    }
    
    @Test
    void appendParameters_parameters_appended() {
        // Given
        Parameters rootParameters = new Parameters();
        
        // When
        String actual = rootParameters
                .appendParameters(
                        "parameters", 
                        parameters -> parameters
                                .append("numeric", 1)
                                .append("string", "some text goes here")
                )
                .toString();

        // Then
        Assertions.assertEquals("{parameters={numeric=1, string=some text goes here}}", actual);
    }

    @Test
    void appendParameters_parametersCollectionWithNoItems_appended() {
        // Given
        Parameters parameters = new Parameters();

        // When
        String actual = parameters
                .appendParameters(
                        "parametersCollection", 
                        Collections.emptyList()
                )
                .toString();

        // Then
        Assertions.assertEquals("{parametersCollection=[]}",
                actual
        );

    }

    @Test
    void appendParameters_parametersCollectionWithOneItem_appended() {
        // Given
        Parameters rootParameters = new Parameters();

        // When
        String actual = rootParameters
                .appendParameters(
                        "parametersCollection",
                        Collections.singletonList(
                                (Parameters parameters) -> parameters.append("item1", 1)
                        )
                )
                .toString();

        // Then
        Assertions.assertEquals("{parametersCollection=[{item1=1}]}",
                actual
        );

    }

    @Test
    void appendParameters_parametersCollectionWithTwoItems_appended() {
        // Given
        Parameters rootParameters = new Parameters();

        // When
        String actual = rootParameters
                .appendParameters(
                        "parametersCollection", 
                        Arrays.asList(
                                (Parameters parameters) -> parameters.append("item1", 1),
                                (Parameters parameters) -> parameters.append("item2", 2)
                        )
                )
                .toString();

        // Then
        Assertions.assertEquals("{parametersCollection=[{item1=1}, {item2=2}]}",
                actual
        );

    }

    @Test
    void appendParameters_parametersCollectionWithThreeItems_appended() {
        // Given
        Parameters rootParameters = new Parameters();

        // When
        String actual = rootParameters
                .appendParameters("parametersCollection", 
                        Arrays.asList(
                                (Parameters parameters) -> parameters.append("item1", 1),
                                (Parameters parameters) -> parameters.append("item2", 2),
                                (Parameters parameters) -> parameters.append("item3", 3)
                        )
                )
                .toString();

        // Then
        Assertions.assertEquals("{parametersCollection=[{item1=1}, {item2=2}, {item3=3}]}",
                actual
        );
    }

}
