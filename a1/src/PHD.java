/**Time Spent: 7 hours
 * An instance maintains info about the PHD of a person.  */

public class PHD {
	private String n; 	 /**name of the person with a PHD, length>0*/
	private char g; 	 /**gender of the person,'f'for female,'m'for male*/
	private int y;	 	 /**year PHD awarded*/
	private int m;	 	 /**month PHD awarded, range:1-12,1 for January*/

	public PHD advisor1;	 /**1st advisor of this person
	 *advisor 1 is 'null'if unknown*/
	public PHD advisor2;	 /** 2nd advisor of this person
	 						*advisor 2 is 'null'if unknown
	 						*or only had advisor1
	 						*or advisor1=unkown */

	public int numadvisees; /**number of advisees */


	/**Constructor1: an instance for a person with name n,gender g, PHD year y,
	 *and PHD month m. Its advisors are unknown, and it has no advisees.
	 *Precondition: n has at least 1 char. m is in 1..12. 
	 *g is 'f' for female or 'm' for male */
	public PHD(String n, char g, int y, int m){
		assert n != null && n.length() >=1;
		assert g == 'f'|| g == 'm';
		assert m >= 1 && m <= 12;
		this.n = n;
		this.g = g;
		this.y = y;
		this.m = m;
		this.advisor1 = null;
		this.advisor2 = null;
		this.numadvisees = 0;
	}

	/**Constructor2: a PHD with name n, gender g, PHD year y, PHD month m,
	 * first advisor adv, and no second advisor.
	 * Precondition: n has at least 1 char,g is 'f' for female or 'm' for male,
	 * m is in 1..12, and adv is not null.*/
	public PHD(String n, char g, int y, int m, PHD adv){
		assert n != null && n.length() >=1;
		assert g == 'f'|| g == 'm';
		assert m >= 1 && m <= 12;
		assert this.advisor1 == null && adv != null;
		this.n = n;
		this.g = g;
		this.y = y;
		this.m = m;	
		this.advisor1 = null;
		this.advisor2 = null;
		this.numadvisees = 0;
		this.setAdvisor1(adv);
	}

	/** Constructor3: a PHD with name n, gender g, PHD year y, PHD month m,
	 * 	first advisor adv1, and second advisor adv2.
	 *  Precondition: n has at least 1 char.g is 'f' for female or 'm' for male.
	 *  m is in 1..12.adv1 and adv2 are not null.adv1 and adv2 are different.*/
	public PHD(String n, char g, int y, int m, PHD adv1, PHD adv2){
		assert n != null && n.length() >=1;
		assert g == 'f'|| g == 'm';
		assert m >= 1 && m <= 12;
		assert adv1 != null && adv2 != null && adv1 != adv2;
		
		this.n = n;
		this.g = g;
		this.y = y;
		this.m = m;	
		this.advisor1 = null;
		this.advisor2 = null;
		this.numadvisees = 0;
		this.setAdvisor1(adv1);
		this.setAdvisor2(adv2);
	}
	/**Return the name of this person*/
	public String getName(){
		return this.n;
	}
	/**Return the year this person got their PHD*/
	public int getYear(){
		return this.y;
	}

	/**Return the month this person got their PHD*/
	public int getMonth(){
		return this.m;
	}

	/**Return the value of the sentence "This person is male."*/
	public boolean isMale(){
		return this.g == 'm';
	}

	/**Return the first advisor of this PHD (null if unknown)*/
	public PHD advisor1(){
		return this.advisor1;
	}

	/**Return the second advisor of this PHD (null if unknown or non-existent)*/
	public PHD advisor2(){
		return this.advisor2;
	}

	/**Return the number of PHD advisees of this person.*/
	public int numAdvisees(){
		return this.numadvisees;
	}
	
	/**Add p as the first advisor of this person.
	Precondition: the first advisor is unknown and p is not null.*/
	public void setAdvisor1(PHD p){
		assert this.advisor1 == null && p != null;
		this.advisor1 = p;
		p.numadvisees++;
	} 

	/**Add p as the second advisor of this person.
	 * Precondition:The first advisor (of this person) is known,
	 * the second advisoris unknown, p is not null, 
	 * and p is different from the first advisor.*/
	public void setAdvisor2(PHD p){
		assert this.advisor1 != null && this.advisor2 == null && p != null 
				&& p != this.advisor1;
		this.advisor2 = p;
		p.numadvisees++;
	} 
	
	/**Return value of "this person got their PHD before p did."
	 * Precondition: p is not null.*/
	public boolean gotBefore(PHD p) {
		assert p != null;
		return (p.getYear() > this.getYear() ||
				(p.getYear() == this.getYear() 
				&& p.getMonth() >= this.getMonth()));
	}
	/**Return value of ¡°p is not null and this person and p are
	 * intellectual siblings." */
	public boolean arePHDSiblings(PHD p) {
		assert p != null && p != this;
		return (p.advisor1() == this.advisor1() 
				|| p.advisor1() == this.advisor2()
				|| p.advisor2() == this.advisor1()
				|| p.advisor2() == this.advisor2());
	}

}

