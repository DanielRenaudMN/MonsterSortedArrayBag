import java.util.Iterator;

/**
 * @author Daniel Renaud
 */

/**
 * This collection class, which uses an array to store elements, implements a
 * Bag ADT for the Monster class.
 */
public class MonsterSortedArrayBag implements Iterable<Monster> {
	private int numMonsters;
	private Monster monsters[];

	/**
	 * Constructor for the bag that takes an integer that specifies the maximum
	 * number of monsters that can be held in the bag.
	 */
	public MonsterSortedArrayBag(int maxMonsters) {
		this.monsters = new Monster[maxMonsters];
	}

	/**
	 * The add method creates an instance of the Monster class using the passed
	 * arguments, then adds the monster to the bag, keeping an ascending order.
	 */
	public void add(String name, int infamy) {
		Monster entry = new Monster(name, infamy);
		int i = 0;
		while ((i < numMonsters) && monsters[i].compareTo(entry) <= 0) {
			i++;
		} // j equals numMonsters -1 to adjust for array indexing.
		for (int j = numMonsters - 1; j >= i; j--) {// the for loop is only used if there are elements smaller than
													// entry in the list.
			monsters[j + 1] = monsters[j]; // the monster at slot j+1 becomes the monster at j
		}
		monsters[i] = entry;
		numMonsters++;
	}

	/**
	 * @returns the number of monsters in the bag
	 */
	public int size() {
		return numMonsters;
	}

	/**
	 * A nicely formatted output of the attributes of each monster in the bag.
	 */
	public String toString() {
		String output = "name\t\t     infamy \n ------------------- ------------------\n";
		for (int i = 0; i < numMonsters; i++) {
			if (monsters[i] != null) {
				output = output + String.format("%-20s %s", monsters[i].getName(), monsters[i].getInfamy()) + "\n";
			}
		}
		return output;
	}

	/**
	 * @param monster
	 * @returns the array index where the passed monster is stored or -1 if the
	 *          monster can't be found
	 */
	public int indexOf(Monster monster) {
		for (int i = 0; i < numMonsters; i++) {
			if (monsters[i].equals(monster)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * The remove method searches for the passed monster in the bag. If found, the
	 * monster is removed from the bag, and the method returns true. Otherwise, no
	 * changes to the bag are made and the method returns false.
	 */
	public boolean remove(Monster monster) {
		for (int i = 0; i < numMonsters; i++) {
			if (monsters[i].equals(monster)) {
				monsters[i] = null;
				for (int j = i + 1; j < numMonsters; j++) {
					monsters[j - 1] = monsters[j];
				}
				numMonsters--;
				return true;
			}
		}
		return false;
	}

	/**
	 * @param name
	 * @returns the number of instances of a monster stored in the bag
	 */
	public int countOccurrences(String name) {
		int total = 0;
		for (int i = 0; i < numMonsters; i++) {
			if (monsters[i].getName().equalsIgnoreCase(name)) {
				i++;
			}
		}
		return total;
	}

	/**
	 * @param index
	 * @returns the monster stored at the passed array index
	 */
	public Monster grab(int index) {
		if (index < numMonsters) {
			return monsters[index];
		}
		return null;
	}

	/**
	 * @returns the summation of the infamy of all monsters in the bag
	 */
	public int total() {
		int sum = 0;
		for (int i = 0; i < numMonsters; i++) {
			sum += monsters[i].getInfamy();
		}
		return sum;
	}

	/**
	 * The replace method searches for a monster in the array. If found, the monster
	 * is replaced by a new monster. The method will return true if the replacement
	 * is successful, false if the original monster cannot be found.
	 */
	public boolean replace(Monster oldMonster, Monster newMonster) {
		for (int i = 0; i < numMonsters; i++) {
			if (monsters[i].equals(oldMonster)) {
				monsters[i] = newMonster;
				return true;
			}
		}
		return false;
	}

	/**
	 * The method sameContents checks if the monsters in the passed bag are the same
	 * as the monsters in the calling bag. The number of instances of each monster
	 * stored in the bag can be different, so long as one instance of each monster
	 * is present in each bag.
	 */
	public boolean sameContents(MonsterSortedArrayBag bag) {
		for (int i = 0; i < numMonsters; i++) { // checks that each element in bag is also in caller
			if (this.indexOf(bag.monsters[i]) == -1) {
				return false;
			}
			for (int j = 0; j < numMonsters; j++) { // checks that each element in caller is also in bag
				if (bag.indexOf(this.monsters[j]) == -1)
					return false;
			}
		}
		return true;
	}

	/**
	 * constructor for the MonsterArrayBagIterator
	 */
	@Override
	public Iterator<Monster> iterator() {
		return new MonsterArrayBagIterator();
	}

	/**
	 * The MonsterArrayBagIterator is used to iterate over the monsters in the bag.
	 */
	public class MonsterArrayBagIterator implements Iterator<Monster> {
		private int index = 0;

		@Override
		public boolean hasNext() {
			if (index < numMonsters) {
				return true;
			}
			return false;
		}

		@Override
		public Monster next() {
			Monster output = monsters[index];
			index++;
			return output;
		}

	}
}
