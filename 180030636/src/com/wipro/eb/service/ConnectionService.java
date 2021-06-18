package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;
public class ConnectionService {
public boolean validate(int currentReading,int previousReading,String type)throws InvalidReadingException,InvalidConnectionException {
		
		if((currentReading<previousReading)
				||(currentReading<0)
				||(previousReading<0)) {
			throw new InvalidReadingException();
		}
		
		//else if(!type.equals("Domestic")&&!type.equals("Commercial"))
		else if( !(type.equals("Domestic")
				||type.equals("Commercial") )){
			throw new InvalidConnectionException();
			}
		else {
			return true;
		}
	}
	
	/*public float calculateBillAmt(int currentReading,int previousReading,String type) {
		try {
			validate(currentReading,previousReading,type);
			if(type.equals("Domestic")) {
				float[] slabs= {2.3f,4.8f,5.5f};
				Domestic d=new Domestic(currentReading,previousReading,slabs);
				float bill=d.computeBill();
				return bill;
			}
			else {
				float[] slabs= {5.2f,6.8f,8.3f};
				Commercial c=new Commercial(previousReading, previousReading, slabs);
				float bill=c.computeBill();
				return bill;
			}	
		}
		catch (InvalidReadingException e) {
			return -1;
		}
        catch (InvalidConnectionException e) {
        	return -2;
		}
		}
		*/	
	public float calculateBillAmt(int currentReading,int previousReading,String type) {
		try {
			//Call the validate method to check inputs
			validate(currentReading,previousReading,type);
			float[] slabs;
			Connection conn;
			//Invoke appropriate Connection type object
			if(type.equals("Domestic")) {
				slabs= new float[]{2.3f,4.2f,5.5f};
				conn=new Domestic(currentReading,previousReading,slabs);
			}
			else {
				slabs= new float[]{5.2f,6.8f,8.3f};
				conn=new Commercial(currentReading, previousReading, slabs);
			}
			//Calculate the bill and return the value
			float bill=conn.computeBill();
			return bill;
		}
		catch (InvalidReadingException e) {
			return -1;
		}
        catch (InvalidConnectionException e) {
        	return -2;
		}
		}
	public String generateBill(int currentReading,int previousReading,String type) {
		float amount=calculateBillAmt(currentReading,previousReading,type);
		if(amount==-1) {
			return "Incorrect Reading";
		}
		else if(amount==-2) {
			return "Invalid ConnectionType";
		}
		else {
			return "Amount to be paid:"+amount;
		}
	}
}
