package br.com.gejunit5.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedLifecyleTest {

	int count = Integer.MIN_VALUE;

	@BeforeEach
	void setCountToZero() {
		count = 0;
	}

	@Test
	void countIsZero() {
		Assertions.assertEquals(0, count);
	}

	@Nested
	class CountGreaterZero {

		@BeforeEach
		void increaseCount() {
			count++;
		}

		@Test
		void countIsGreaterZero() {
			Assertions.assertTrue(count > 0);
		}

		@Nested
		class CountMuchGreaterZero {

			@BeforeEach
			void increaseCount() {
				count += Integer.MAX_VALUE / 2;
			}

			@Test
			void countIsLarge() {
				Assertions.assertTrue(count > Integer.MAX_VALUE / 2);
			}
		}
	}
}