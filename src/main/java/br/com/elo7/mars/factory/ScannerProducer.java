package br.com.elo7.mars.factory;

import java.util.Scanner;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

public class ScannerProducer {
	
	@Produces @Singleton
	public Scanner get() {
		return new Scanner(System.in);
	}
	
}
