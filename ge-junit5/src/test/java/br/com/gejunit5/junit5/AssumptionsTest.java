package br.com.gejunit5.junit5;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AssumptionsTest {

	@Test
	void exitIfFalseIsTrue() {
		Assumptions.assumeTrue(false);
		System.out.println("nao chega aqui");
	    System.exit(1);
	}

	@Test
	void exitIfTrueIsFalse() {
		Assumptions.assumeFalse(this::truism);
	    System.exit(1);
	}

	private boolean truism() {
	    return true;
	}

	@Test
	void exitIfNullEqualsString() {
		Assumptions.assumingThat(
	             // state an assumption (a false one in this case) ...
	   		 "null".equals(null),
	             // … and only execute the lambda if it is true
	   		 () -> System.exit(1)
	    );
	}

	/*
	 * Assumptions can either be used to abort tests whose preconditions are not met (assumeTrue and assumeFalse) 
	 * or to execute specific parts of a test when a condition holds (assumimgThat). The main difference is that 
	 * aborted tests are reported as disabled, whereas a test that was empty because a condition did not hold shows green.
	 */
}
