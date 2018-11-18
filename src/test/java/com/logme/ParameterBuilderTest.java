package com.logme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: move here other tests from LogmeTest related to ParameterBuilder
class ParameterBuilderTest {

    @Test
    void appendParameter_byteValue_appended() {
        byte value = 1;
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals(actualMessage, "{value=1}");
    }

    @Test
    void appendParameter_booleanValue_appended() {
        boolean value = true;
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals(actualMessage, "{value=true}");
    }

    @Test
    void appendParameter_charValue_appended() {
        char value = 'c';
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals(actualMessage, "{value=c}");
    }

    @Test
    void appendParameter_doubleValue_appended() {
        double value = 1.5d;
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals(actualMessage, "{value=1.5}");
    }

    @Test
    void appendParameter_floatValue_appended() {
        float value = 1.5f;
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals(actualMessage, "{value=1.5}");
    }

    @Test
    void appendParameter_intValue_appended() {
        int value = 1;
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals(actualMessage, "{value=1}");
    }

    @Test
    void appendParameter_longValue_appended() {
        long value = 1L;
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals(actualMessage, "{value=1}");
    }

}
