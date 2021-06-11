package com.wipro.ccbill.main;

import com.wipro.ccbill.service.ConnectionService;

public class EBMain {
	public static void main(String args[]) {
		ConnectionService cs=new ConnectionService();
		System.out.println(cs.generateBill(250, 130,"Commercial"));
		System.out.println(cs.generateBill(-250,0,"Commercial"));
		System.out.println(cs.generateBill(250, 130,"Domestic"));
		System.out.println(cs.generateBill(250, 130,"Domestic"));
		
	}

}
