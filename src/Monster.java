/**
 * @author Daniel Renaud
 */

/**
 * A monster could be a creature of myth, a notorious criminal, or a
 * particularly awful piece of furniture.
 */
public class Monster implements Comparable<Monster> {
	private String name;
	private int infamy;

	/**
	 * @param name
	 * @param infamy, standard constructor
	 */
	public Monster(String name, int infamy) {
		super();
		this.name = name;
		this.infamy = infamy;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name, set the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the infamy
	 */
	public int getInfamy() {
		return infamy;
	}

	/**
	 * @param infamy, set the infamy
	 */
	public void setInfamy(int infamy) {
		this.infamy = infamy;
	}

	/**
	 * This simple override of toString returns the name of the Monster and its
	 * infamy in a single line separated by two tabs.
	 */
	@Override
	public String toString() {
		return this.name + "\t\t" + this.infamy;
	}

	/**
	 * Two monsters are equal if they have the same name (case insensitive) and the
	 * same infamy.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Monster)) {
			return false;
		}
		Monster other = (Monster) obj;
		if (infamy != other.infamy) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equalsIgnoreCase(other.name)) {
			return false;
		}
		return true;
	}

	/**
	 * The below method is used to compare the value of monsters for sorting
	 * purposes, usually by name (a < z). If they have the same name, then their
	 * level of infamy is compared. Two monsters with the same name and same infamy
	 * are considered to have equal value.
	 */
	@Override
	public int compareTo(Monster monster) {
		// TODO Auto-generated method stub
		if (this.name.compareToIgnoreCase(monster.getName()) < 0) {
			return -1;
		} else if (this.name.compareToIgnoreCase(monster.getName()) > 0) {
			return 1;
		} else {
			if (this.infamy < monster.getInfamy()) {
				return -1;
			} else if (this.infamy > monster.getInfamy()) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
