package com.gce.illuminati.group;

public class Group {
	String name;
	String motto;
	int power;
	int transPower;
	int resistance;
	int income;
	int bank;
	Set<Alignment> alignments;
	
	public Group(GroupBuilder b) {
		this.name = b.name;
		this.motto = b.motto;
		this.power = b.power;
		this.transPower = b.transPower;
		this.resistance = b.resistance;
		this.income = b.income;
		this.bank = b.bank;
		this.alignments = b.alignments;
		b = null;
	}
	
	/* Getters */
	public	String			getName()		{ return name;			}
	public	String			getMotto()		{ return motto;			}
	public	int				getPower()		{ return power;			}
	public	int				getTransPower()	{ return transPower;	}
	public	int				getResistance()	{ return resistance;	}	
	public	int				getIncome()		{ return income;		}
	public	int			getBank()			{ return bank;			}
	public	Set<Alignment>	getAlignments() { return alignments;	}
	
	/* Setters */
	public	void	setName(String name)			{ this.name = name;				}
	public	void	setMotto(String motto)			{ this.motto = motto;			}
	public	void	setPower(int power) 			{ this.power = power;			}
	public	void	setTransPower(int transPower)	{ this.transPower = transPower;	}
	public	void	setResistance(int resistance)	{ this.resistance = resistance;	}
	public	void	setIncome(int income)			{ this.income = income;			}
	public	void	setBank(int bank)				{ this.bank = bank;				}
	
	
	public int likeAlignments(Group g) {
		return alignments.stream()
				.filter(a -> g.getAlignments().contains(a))
				.count();				
	}
	
	public int oppositeAlignments(Group g) {
		return alignments.stream()
				.filter(a -> !g.getAlignments().contains(a))
				.count();				
	}
	
	public static void main(String[] args) {
		Group g = new Group.Builder("Test Group")
				.power(5)
				.resistance(2)
				.income(1)
				.alignment(Alignment.WEIRD)
				.alignment(Alignment.PEACEFUL)
				.build();
	}
	
	
	
	class Builder {
		private String name;
		private String motto;
		private int power;
		private int transPower;
		private int resistance;
		private int income;
		private int bank;
		private Set<Alignment> alignments = new HashSet<Alignment>();
	
	
		public GroupBuilder(String name) { this.name = name; }
	
		public GroupBuilder motto(String motto) 			{ this.motto = motto;			return this; }
		public GroupBuilder power (int power)				{ this.power = power;			return this; }
		public GroupBuilder transPower(int transPower)		{ this.transPower = transPower; return this; }
		public GroupBuilder resistance(int resistance)		{ this.resistance = resistance; return this; }
		public GroupBuilder income(int income)				{ this.income = income;			return this; }
		public GroupBuilder bank(int bank)					{ this.bank = bank;				return this; }
		public GroupBuilder alignment(Alignment alignment)	{ alignments.add(alignment)		return this; }
		
		public Group build() {
			return new Group(this);
		}
	}
}