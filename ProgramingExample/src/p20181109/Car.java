package p20181109;

public class Car {


	int gas;
	void setGas(int gas) {
		this.gas = gas;
	}
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("없습니다.");
			return false;
		}else {
			System.out.println("있습니다.");
			return true;
		}
	}
	
	void run() {
		while(true) {
			if(gas>0) {
				System.out.println("달립니다. 잔량("+gas+")");
				gas--;
			}else {
				System.out.println("멈췄습니다. 잔량("+gas+")");
				return;
			}
		}
	}

}
