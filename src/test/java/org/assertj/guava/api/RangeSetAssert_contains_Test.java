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
import static com.google.common.collect.Range.closed;
import static com.google.common.collect.TreeRangeSet.create;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.error.ShouldContain.shouldContain;
import static org.assertj.core.internal.ErrorMessages.valuesToLookForIsEmpty;
import static org.assertj.core.internal.ErrorMessages.valuesToLookForIsNull;
import static org.assertj.core.util.Arrays.array;
import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.guava.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.google.common.collect.RangeSet;

/**
 * Tests for <code>{@link RangeSetAssert#contains(Comparable[])}</code>.
 *
 * @author Ilya Koshaleu
 */
@DisplayName("RangeSetAssert contains")
class RangeSetAssert_contains_Test {

  @Test
  void should_fail_if_actual_is_null() {
    // GIVEN
    RangeSet<Integer> actual = null;
    // WHEN
    Throwable throwable = catchThrowable(() -> assertThat(actual).contains(1));
    // THEN
    assertThat(throwable).isInstanceOf(AssertionError.class)
                         .hasMessage(actualIsNull());
  }

  @Test
  void should_fail_if_expected_values_are_null() {
    // GIVEN
    RangeSet<Integer> actual = create();
    Integer[] elements = null;
    // WHEN
    Throwable throwable = catchThrowable(() -> assertThat(actual).contains(elements));
    // THEN
    assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                         .hasMessage(valuesToLookForIsNull());
  }

  @Test
  void should_pass_if_both_expected_values_and_actual_are_empty() {
    // GIVEN
    RangeSet<Integer> actual = create();
    // THEN
    assertThat(actual).contains();
  }

  @Test
  void should_fail_if_expected_values_are_empty() {
    // GIVEN
    RangeSet<Integer> actual = of(closed(0, 1));
    // WHEN
    Throwable throwable = catchThrowable(() -> assertThat(actual).contains());
    // THEN
    assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                         .hasMessage(valuesToLookForIsEmpty());

  }

  @Test
  void should_fail_if_the_given_range_set_does_not_contain_element() {
    // GIVEN
    RangeSet<Integer> actual = of(closed(0, 3));
    Integer[] expected = array(3, 4, 5);
    // WHEN
    Throwable throwable = catchThrowable(() -> assertThat(actual).contains(expected));
    // THEN
    assertThat(throwable).isInstanceOf(AssertionError.class)
                         .hasMessage(shouldContain(actual, expected, array(4, 5)).create());
  }

  @Test
  void should_pass_if_the_given_range_set_contains_element() {
    // GIVEN
    RangeSet<Integer> actual = of(closed(0, 10));
    // THEN
    assertThat(actual).contains(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
  }
}
