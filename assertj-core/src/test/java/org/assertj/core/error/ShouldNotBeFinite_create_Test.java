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
 * Copyright 2012-2025 the original author or authors.
 */
package org.assertj.core.error;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.error.ShouldNotBeFinite.shouldNotBeFinite;
import static org.assertj.core.presentation.StandardRepresentation.STANDARD_REPRESENTATION;

import org.assertj.core.internal.TestDescription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ShouldNotBeFinite create")
class ShouldNotBeFinite_create_Test {

  @Test
  void should_create_error_message_with_double() {
    // GIVEN
    double actual = 1.0;
    // WHEN
    String message = shouldNotBeFinite(actual).create(new TestDescription("TEST"), STANDARD_REPRESENTATION);
    // THEN
    then(message).isEqualTo("[TEST] %nExpecting 1.0 not to be finite".formatted());
  }

  @Test
  void should_create_error_message_with_float() {
    // GIVEN
    float actual = 1.0f;
    // WHEN
    String message = shouldNotBeFinite(actual).create(new TestDescription("TEST"), STANDARD_REPRESENTATION);
    // THEN
    then(message).isEqualTo("[TEST] %nExpecting 1.0f not to be finite".formatted());
  }

}
