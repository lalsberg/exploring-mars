package br.com.gejunit5.junit5;

public class CustomAnnotationsTest {

	@IntegrationTest
	void runsWithCustomAnnotation() {
	    System.out.println("Run even though `@IntegrationTest` is not defined by JUnit");
	}

}
