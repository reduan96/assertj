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

import static java.lang.String.format;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.error.ShouldBeInSameSecondWindow.shouldBeInSameSecondWindow;
import static org.assertj.core.util.DateUtil.parseDatetimeWithMs;

import org.assertj.core.description.TextDescription;
import org.assertj.core.presentation.StandardRepresentation;
import org.junit.jupiter.api.Test;

/**
 * Tests for
 * <code>{@link ShouldBeInSameSecondWindow#create(org.assertj.core.description.Description, org.assertj.core.presentation.Representation)}</code>
 * .
 *
 * @author Joel Costigliola
 * @author Mikhail Mazursky
 */
class ShouldBeInSameSecondWindow_create_Test {

  @Test
  void should_create_error_message() {
    // GIVEN
    ErrorMessageFactory factory = shouldBeInSameSecondWindow(parseDatetimeWithMs("2011-01-01T05:00:01.000"),
                                                             parseDatetimeWithMs("2011-01-01T05:00:02.001"));
    // WHEN
    String message = factory.create(new TextDescription("Test"), new StandardRepresentation());
    // THEN
    then(message).isEqualTo(format("[Test] %n" +
                                   "Expecting actual:%n" +
                                   "  2011-01-01T05:00:01.000 (java.util.Date)%n" +
                                   "to be close to:%n" +
                                   "  2011-01-01T05:00:02.001 (java.util.Date)%n" +
                                   "by less than one second (strictly) but difference was: 1s and 1ms"));
  }

}
