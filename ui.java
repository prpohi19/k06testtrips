
public class ui {
	Trips tripsArr;
	Trips tripsFile; // class vaja sellele veel teha
	
	public static void main(String[] args) {
		while(checkIfWon(tripsArr)) {
			render(tripsArr);
		}
	}
	
	public boolean checkIfWon(Trips trips) {
		// TODO loogika
		char symbls = {'X', '0'};
		boolean isDone = false;
		
		for(int i = 0; i < symbls.length; i++) {
			if(!isDone) {
				if((trips.kysi(0,0) == symbls[i] && trips.kysi(1,0) == symbls[i] && trips.kysi(2,0) == symbls[i]) || // ülevalt alla 1 tulp
				(trips.kysi(0,1) == symbls[i] && trips.kysi(1,1) == symbls[i] && trips.kysi(2,1) == symbls[i]) || // ülevalt alla 2 tulp
				(trips.kysi(0,2) == symbls[i] && trips.kysi(1,2) == symbls[i] && trips.kysi(2,2) == symbls[i]) || // ülevalt alla 2 tulp
				// vaja teha sideways ja diagonaalid
				//...) {
					
				}
			}
		}
		
		return isDone;
	}
	
	public static void render(Trips trips) {
		System.out.println(trips.kysi(0,0)+"|"+trips.kysi(0,1)+"|"+trips.kysi(0,2));
		System.out.println(trips.kysi(1,0)+"|"+trips.kysi(1,1)+"|"+trips.kysi(1,2));
		System.out.println(trips.kysi(2,0)+"|"+trips.kysi(2,1)+"|"+trips.kysi(2,2));
	}
}