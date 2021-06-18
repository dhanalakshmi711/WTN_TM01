package com.wipro.eb.entity;

public class Commercial extends Connection{
	public Commercial(int currentReading, int previousReading, float[] slabs) {
		super(currentReading, previousReading, slabs);
		// TODO Auto-generated constructor stub
	}

	/*public Commercial() {
		super(getPreviousReading(),getCurrentReading(),slabs);
		
		// TODO Auto-generated constructor stub
	}*/

	@Override
	public float computeBill() {
		// TODO Auto-generated method stub
		int units=getCurrentReading()-getPreviousReading();
		float bill=0;
		//Compute the bill based on slabs
		if(units<=50) {
			bill=units*slabs[0];
		}
		else if(units>50) {
			bill=50*slabs[0]+(units-50)*slabs[1];
		}
		else {
			bill=50*slabs[0]+50*slabs[1]+(units-100)*slabs[2];
		}
		//Compute the duty charge for Commercial Connection
		
		if(bill>=10000) {
			bill*=0.09;
		}
		else if(bill>=5000) {
			bill*=0.06;
		}
		else  {
			bill*=0.02;
		}
		
		return bill;
	}
}
