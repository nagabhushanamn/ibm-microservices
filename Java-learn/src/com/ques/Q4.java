package com.ques;

/*
 *  e.g
 *  
 *   dependency ==> Wheel
 *   dependent ==> Car
 * 
 * 
 */

/*
 * 
 *  OOP ==> 'closed for modification , open for extension"
 * 
 */

//--------------------------------------------------------------------

// common wheel-community

interface Wheel {
	int RADIUS = 10;
	void rotate();
	void commonMethod();
}

// MRF

abstract class MRFWheel implements Wheel {
	@Override
	public void commonMethod() {
	}
}

class MRFTwoWheel extends MRFWheel {
	public void rotate() {
		System.out.println("MRF-Two-Wheel rotating...");
	}

}

class MRFFourWheel extends MRFWheel {
	public void rotate() {
		System.out.println("MRF-Four-Wheel rotating...");
	}
}



//// CEAT
class CEATWheel implements Wheel {
	public void rotate() {
		System.out.println("CEAT-Wheel rotating...");
	}
	@Override
	public void commonMethod() {
		// TODO Auto-generated method stub
		
	}
}

// --------------------------------------------------------------------

// BMW

class BMWCar {

	private Wheel wheel;

	public BMWCar(Wheel wheel) {
		super();
		this.wheel = wheel;
	}

	public void move() {
		wheel.rotate();
		System.out.println("BMW-Car moving......");
	}

}

public class Q4 {

	public static void main(String[] args) {

		// some-one

		Wheel mrfFourWheel = new MRFFourWheel();
		Wheel ceatWheel=new CEATWheel();
		

		BMWCar murgaihCar = new BMWCar(ceatWheel);
		murgaihCar.move();

	}

}
