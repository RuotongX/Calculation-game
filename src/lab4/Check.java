package lab4;

public class Check {
	double a;
	double b;
	public Check(double a,double b) {
		this.a = a;
		this.b = b;
	}
	public boolean row() {
		 if (Math.abs(a - b) <= 0.1) {
	            return true;
	        }
	        return false;

	}
}
