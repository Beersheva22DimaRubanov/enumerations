package telran.measure;

public enum LengthUnit {
	MM(1), CM(10), IN(25.4f), M(1000),KM(1_000_000);
	float value;
	LengthUnit(float value) {
		this.value = value;
	}
	public Length between(Length l1, Length l2) {
		float amount = transformIntoThisUnit(l1)- transformIntoThisUnit(l2);
		if(amount < 0) {
			amount /= -1;
		}
		return new Length(amount, this);
	}
	
	private float transformIntoThisUnit(Length length) {
		return (length.getAmount()*length.getUnit().value)/value;
	}
	public float getValue() {
		return value;
	}
}
