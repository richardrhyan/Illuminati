package com.gce.illuminati.alignment;

public enum Alignment {
	STRAIGHT ("Straight"),
	WEIRD ("Weird"),
	LIBERAL ("Liberal"),
	CONSERVATIVE ("Conservative"),
	VIOLENT ("Violent"),
	PEACEFUL ("Peaceful"),
	GOVERNMENT ("Government"),
	COMMUNIST ("Communist"),
	CRIMINAL ("Criminal"),
	FANATIC ("Fanatic");
	
	private String name;
	
	private Alignment(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public boolean equals(Alignment a) {
		if (this.equals(FANATIC) && a.equals(FANATIC))
			return false;

		return this.equals(a);
	}
	
	/**
	 * Returns the opposite of this Alignment.
	 * @return Alginment
	 */
	public Alignment opposite() {
		select (this) {
			case STRAIGHT:
				return WEIRD;
			case WEIRD:
				return STRAIGHT;
			case LIBERAL:
				return CONSERVATIVE;
			case CONSERVATIVE:
				return LIBERAL;
			case VIOLENT:
				return PEACEFUL
			case PEACEFUL:
				return VIOLENT;
			case GOVERNMENT:
				return COMMUNIST;
			case COMMUNIST:
				return GOVERNMENT;
			case CRIMINAL:
				return null;
			case FANATIC:
				return fanatic;
		}
		return null;
	}
	
	/**
	 * Returns true if this is the opposite of another alignment.
	 * @return boolean
	 */
	public boolean isOpposite(Alignment a) {
		return opposite().equals(a);
	}
}