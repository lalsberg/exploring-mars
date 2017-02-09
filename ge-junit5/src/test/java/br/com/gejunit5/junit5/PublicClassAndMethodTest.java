package br.com.gejunit5.junit5;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
@DisplayName("Deve funcionar mesmo que essa classe nao seja publica")
class PackageVisibilityClassAndMethodTest {
 
	@Test
	@DisplayName("Deve funcionar mesmo que esse metodo nao seja publico")
	void packageMethodTest() {
		System.out.println("Hello, JUnit 5.");
	}
 
	@Test
	@DisplayName("Essa mensagem nunca sera exibida")
	private void privateMethodTest() {
		Assert.fail();
	}
}
