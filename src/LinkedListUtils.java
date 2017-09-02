import java.util.ArrayList;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

    public static void insertSorted(LinkedList<Integer> list, int value) {
        int indexToInsert = 0;
        try {
            if (list.isEmpty()) {
                list.addFirst(value);
            } else {
                for (int listIndex = 0; listIndex < list.size(); listIndex++) {
                    if (list.get(listIndex) <= value) {
                        indexToInsert = listIndex;
                    }
                }
                if (indexToInsert == 0) {
                    list.addFirst(value);
                } else if (indexToInsert == list.size()) {
                    list.addLast(value);
                } else {
                    list.add(indexToInsert + 1, value);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Null linked list");
        }
    }

    public static void removeMaximumValues(LinkedList<String> list, int N) {
        ArrayList<String> arrayOfMax = new ArrayList<String>();
        try {
            if (N >= list.size()) {
                list.removeAll(list);
            } else {
                for (int times = 0; times < N; times++) {
                    int max = list.getFirst().length();
                    for (String aList : list) {
                        if (aList.length() > max) {
                            arrayOfMax.add(aList);
                            max = aList.length();
                        }
                    }
                    list.removeAll(arrayOfMax);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Null linked List");
        }

    }

    public static boolean containsSubsequence(LinkedList<Integer> one,
                                              LinkedList<Integer> two) {

        boolean contains = false;
        int auxIndex = 0;
        try {
            if (!one.isEmpty() && !two.isEmpty() && one.containsAll(two)) {
                int firstIndex = one.indexOf(two.getFirst());
                for (int index = firstIndex; index < one.size(); index++) {
                    if (auxIndex < two.size()) {
                        if (one.get(index).equals(two.get(auxIndex))) {
                            contains = true;
                        } else {
                            contains = false;
                            break;
                        }
                    } else {
                        break;
                    }
                    auxIndex++;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Null linked list");
        }
        return contains;
    }
}
