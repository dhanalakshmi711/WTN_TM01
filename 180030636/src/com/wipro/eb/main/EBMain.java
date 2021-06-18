package com.wipro.eb.main;

import java.util.Scanner;

import com.wipro.eb.entity.Domestic;
import com.wipro.eb.service.ConnectionService;

public class EBMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        /*Scanner sc = new Scanner(System.in);
	        System.out.println("Enter current Reading");
	        int currentReading = sc.nextInt();
	        System.out.println("Enter previous Reading");
	        int previousReading = sc.nextInt();
	        System.out.println("Enter type of connection");
	        String ctype = sc.next();
	        */
		
		    System.out.println (new ConnectionService().generateBill(-130,100,"Commercial"));
		    System.out.println (new ConnectionService().generateBill(130,-100,"Commercial"));
		    System.out.println (new ConnectionService().generateBill(30,100,"Commercial"));
		    
		    System.out.println (new ConnectionService().generateBill(130,100,"commercial"));
		    System.out.println (new ConnectionService().generateBill(130,100,"mytype"));
		    System.out.println (new ConnectionService().generateBill(130,100,""));
		    
		    System.out.println (new ConnectionService().generateBill(130,100,"Domestic"));
		    System.out.println (new ConnectionService().generateBill(180,100,"Domestic"));
		    System.out.println (new ConnectionService().generateBill(230,100,"Domestic"));
		    
		    System.out.println (new ConnectionService().generateBill(130,100,"Commercial"));
		    System.out.println (new ConnectionService().generateBill(180,100,"Commercial"));
		    System.out.println (new ConnectionService().generateBill(230,100,"Commercial"));

	        
	        
	}

}
