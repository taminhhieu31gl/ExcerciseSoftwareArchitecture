package com.java;

import javax.naming.Context;
import javax.naming.InitialContext;

import example.com.CalculatorBeanRemote;

public class MainDemoHello {
	public static void main(String[] args) {
		Context context;
		try {
			context = new InitialContext();
			CalculatorBeanRemote cal = (CalculatorBeanRemote) context.lookup("ejb/DemoHello");
			System.out.println("testt: "+cal.getAll());
			//System.out.println("testt: "+cal.demoHello());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
