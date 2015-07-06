package br.com.elo7.mars.factory;

import java.util.Scanner;

import javax.enterprise.inject.Produces;

public class ScannerFactory {
	
	@Produces
	public Scanner get() {
		return new Scanner(System.in);
	}
	
}
