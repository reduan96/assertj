/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2021 the original author or authors.
 */
package org.assertj.guava.api;

import static com.google.common.collect.ImmutableRangeSet.of;
import static com.google.common.collect.TreeRangeSet.create;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.util.FailureMessages.actualIsEmpty;
import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.guava.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;

/**
 * Tests for <code>{@link RangeSetAssert#isNotEmpty()}</code>.
 *
 * @author Ilya Koshaleu
 */
@DisplayName("RangeSetAssert isNotEmpty")
class RangeSetAssert_isNotEmpty_Test {

  @Test
  void should_fail_if_the_given_set_is_empty() {
    // GIVEN
    RangeSet<Integer> rangeSet = create();
    // WHEN
    Throwable throwable = catchThrowable(() -> assertThat(rangeSet).isNotEmpty());
    // THEN
    assertThat(throwable).isInstanceOf(AssertionError.class)
                         .hasMessage(actualIsEmpty());
  }

  @Test
  void should_fail_if_the_given_set_is_null() {
    // GIVEN
    RangeSet<Integer> rangeSet = null;
    // WHEN
    Throwable throwable = catchThrowable(() -> assertThat(rangeSet).isNotEmpty());
    // THEN
    assertThat(throwable).isInstanceOf(AssertionError.class)
                         .hasMessage(actualIsNull());
  }

  @Test
  void should_pass_if_the_given_set_is_not_empty() {
    // GIVEN
    RangeSet<Integer> rangeSet = of(Range.closed(1, 10));
    // THEN
    assertThat(rangeSet).isNotEmpty();
  }
}
