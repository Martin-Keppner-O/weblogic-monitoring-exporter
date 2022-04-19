// Copyright (c) 2017, 2022, Oracle and/or its affiliates.
// Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl.

package com.oracle.wls.exporter.domain;

import java.util.Arrays;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;

/**
 * @author Russell Gold
 */
class MapUtilsTest {

    private static final String[] STRING_ARRAY = {"1", "2", "3"};

    @Test
    void whenStringArrayValueIsStringArray_returnAsIs() {
        Map<String,Object> map = ImmutableMap.of("values", STRING_ARRAY);

        assertThat(MapUtils.getStringArray(map, "values"), arrayContaining(STRING_ARRAY));
    }

    @Test
    void whenStringArrayValueIsSingleObject_returnAsLengthOneArray() {
        Map<String,Object> map = ImmutableMap.of("values", 33);

        assertThat(MapUtils.getStringArray(map, "values"), arrayContaining("33"));
    }

    @Test
    void whenStringArrayValueIsList_returnAsArray() {
        Map<String,Object> map = ImmutableMap.of("values", Arrays.asList(7, 8, true));

        assertThat(MapUtils.getStringArray(map, "values"), arrayContaining("7", "8", "true"));
    }
}
