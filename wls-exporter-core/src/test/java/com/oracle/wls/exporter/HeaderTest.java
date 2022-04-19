// Copyright (c) 2020, 2022, Oracle and/or its affiliates.
// Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl.

package com.oracle.wls.exporter;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class HeaderTest {

  @Test
  void fetchHeaderName() {
    Header header = new Header("Content-type: text/plain");

    assertThat(header.getName(), equalTo("Content-type"));
  }

  @Test
  void fetchMainValue() {
    Header header = new Header("Content-type: text/plain");

    assertThat(header.getValue(), equalTo("text/plain"));
  }

  @Test
  void whenSeparatorPresent_truncateValue() {
    Header header = new Header("Content-type: text/plain; more stuff");

    assertThat(header.getValue(), equalTo("text/plain"));
  }

  @Test
  void whenParametersPresent_fetchValues() {
    Header header = new Header("Content-disposition: form-data; name=\"file1\"; filename=\"a.txt\"");

    assertThat(header.getValue(), equalTo("form-data"));
    assertThat(header.getValue("name"), equalTo("file1"));
    assertThat(header.getValue("filename"), equalTo("a.txt"));
  }
}
