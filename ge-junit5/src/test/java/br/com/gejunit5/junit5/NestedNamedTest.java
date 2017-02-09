package br.com.gejunit5.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("A stack")
class NestedNamedTest {

	@Test
	@DisplayName("is instantiated with new Stack()")
	void isInstantiatedWithNew() {
		/* ... */ }

	@Nested
	@DisplayName("when new")
	class WhenNew {

		@Test
		@DisplayName("is empty")
		void isEmpty() {
			/* ... */ }

		@Test
		@DisplayName("throws EmptyStackException when popped")
		void throwsExceptionWhenPopped() {
			/* ... */ }

		@Test
		@DisplayName("throws EmptyStackException when peeked")
		void throwsExceptionWhenPeeked() {
			/* ... */ }

		@Nested
		@DisplayName("after pushing an element")
		class AfterPushing {

			@Test
			@DisplayName("it is no longer empty")
			void isEmpty() {
				/* ... */ }

			@Test
			@DisplayName("returns the element when popped and is empty")
			void returnElementWhenPopped() {
				/* ... */ }

			@Test
			@DisplayName("returns the element when peeked but remains not empty")
			void returnElementWhenPeeked() {
				/* ... */ }
		}
	}
}
