package br.com.gejunit5.junit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
@DisplayName("Essa classe")
class DisplayNameTest {
 
	@Test
	@DisplayName("Deve fazer isso")
	void helloJUnit5() {
		System.out.println("Hello, JUnit 5.");
	}
 
}
