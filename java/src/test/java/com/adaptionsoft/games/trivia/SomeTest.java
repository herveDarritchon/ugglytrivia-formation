package com.adaptionsoft.games.trivia;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SomeTest {

	@Test
	public void true_is_true() {
		assertTrue(false); // JUnit 5 assertions
		assertThat(false).isTrue(); // JAssert
	}
}
