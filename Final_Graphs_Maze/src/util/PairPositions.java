package util;

public class PairPositions<T1,T2> {
	
	//-------Atributtes-------
	
	private T1 firstPosition;
	private T2 secondPosition;
	
	//------Builder-------
	
	public PairPositions(T1 firstPosition , T2 secondPosition) {
	
		this.firstPosition = firstPosition;
		this.secondPosition = secondPosition;
	}

	
	
	//-----Methods-------
	
	//------Gets&&Sets------
	
	public T1 getFirstPosition() {
		return firstPosition;
	}

	public void setFirstPosition(T1 firstPosition) {
		this.firstPosition = firstPosition;
	}

	public T2 getSecondPosition() {
		return secondPosition;
	}

	public void setSecondPosition(T2 secondPosition) {
		this.secondPosition = secondPosition;
	}
	

}
