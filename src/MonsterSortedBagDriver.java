import java.util.Iterator;

public class MonsterSortedBagDriver {

	public static void main(String[] args) {
		MonsterSortedArrayBag myBag = new MonsterSortedArrayBag(20);
		myBag.add("a", 3);
		myBag.add("b", 4);
		myBag.add("c", 5);
		assert (myBag.grab(0).compareTo(myBag.grab(1)) == -1);
		assert myBag.size() == 3;
		assert myBag.total() == 11;
		MonsterSortedArrayBag herBag = new MonsterSortedArrayBag(20);
		herBag.add("a", 3);
		herBag.add("b", 4);
		herBag.add("c", 5);
		herBag.add("c", 6);
		assert herBag.countOccurrences("a") == 1;
		assert myBag.sameContents(herBag) == false;
		herBag.remove(herBag.grab(3));
		assert myBag.sameContents(herBag) == true;
		herBag.replace(herBag.grab(1), herBag.grab(2));
		System.out.println(herBag.toString());

		for (Monster x : myBag) {
			System.out.println(x);
		}
		Iterator<Monster> itr = herBag.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
