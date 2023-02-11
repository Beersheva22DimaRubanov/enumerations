package telran.measure;

public class Length implements Comparable<Length> {
	private float amount;
	private LengthUnit lengthUnit;

	public Length(float amount, LengthUnit lengthUnit) {
		this.amount = amount;
		this.lengthUnit = lengthUnit;
	}

	@Override
	public boolean equals(Object obj) {
		Length length = (Length) obj;
		return amount / length.lengthUnit.value == (length.amount / lengthUnit.value);
	}

	@Override
	public int compareTo(Length o) {
		int res = -1;
		if (this.equals(o)) {
			res = 0;
		} else if (amount / o.lengthUnit.value > (o.amount / lengthUnit.value)) {
			res = 1;
		}
		return res;
	}

	public Length convert(LengthUnit unit) {
		return new Length((amount * lengthUnit.value / unit.value), unit);
	}

	@Override
	public String toString() {
		return amount + "" + lengthUnit;
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return lengthUnit;
	}
}
