import java.util.Comparator;

public class BinarySearch {

  // Common description of the below functions:
  // * Precondition: `a` is sorted according to the given comparator.
  // * Precondition: all arguments are non-null (no need to check).
  // * Required complexity: O(log(n)) comparisons where n is the length of `a`.

  // Check if the array `a` contains the given search key.
  //Gör om contains till recursive
  public static <T> boolean contains(T[] a, T key, Comparator<T> comparator) {
    return contains(a, key, comparator, 0, a.length - 1);
  }

  public static <T> boolean contains(T[] a, T key, Comparator<T> comparator, int lo, int hi) {
    int mid = (lo + hi)/2;
    int c = comparator.compare(a[mid], key);

    if(lo>hi){
      return false;
      }
    if (c==0){
      return true;
    }
    else if(c>0){
      return contains(a, key, comparator, lo, mid -1);
    }
    else{
      return contains(a, key, comparator, mid + 1, hi);
    }
  }

    //skapa ny Helper metod för att göra Contains recursive
  //all logik ska finnas i helper metoden

  // Return the *first position* of `key` in `a`, or -1 if `key` does not occur.
  public static <T> int firstIndexOf(T[] a, T key, Comparator<T> comparator) {
    int lo = 0;
    int hi = a.length-1;
    int index = -1;

    while(hi>=lo){
      int mid = (lo + hi)/2;
      int c = comparator.compare(a[mid], key);

      if(c>=0){
        hi = mid - 1;
      }
      else{
        lo = mid + 1;
      }
      if(c==0){
        index = mid;
      }
    }
    return index;
  }

  // Versions of the above functions that use the natural ordering of the type T.
  // T needs to be "comparable" (i.e., implement the interface Comparable).
  // Examples: Integer, String (the alphabetic ordering)

  public static <T extends Comparable<? super T>> boolean contains(T[] a, T key) {
    return contains(a, key, Comparator.naturalOrder());
  }

  public static <T extends Comparable<? super T>> int firstIndexOf(T[] a, T key) {
    return firstIndexOf(a, key, Comparator.naturalOrder());
  }

  // Your tests.

  public static void main(String[] args) {
    Integer[] a = { 1, 3, 5, 7, 9 };
    assert contains(a, 1);
    System.out.println(contains(a, 1));
    assert !contains(a, 4);
    System.out.println(contains(a, 4));
    assert contains(a, 7);
    System.out.println(contains(a, 7));


    String[] b = { "cat", "cat", "cat", "dog", "turtle", "turtle" };
    assert firstIndexOf(b, "cat") == 0;
    System.out.println(firstIndexOf(b, "cat"));
    assert firstIndexOf(b, "dog") == 3;
    System.out.println(firstIndexOf(b, "dog"));
    assert firstIndexOf(b, "turtle") == 4;
    System.out.println(firstIndexOf(b, "turtle"));
    assert firstIndexOf(b, "zebra") == -1;
    System.out.println(firstIndexOf(b, "zebra"));
    assert firstIndexOf(b, "bee") == -1;
    System.out.println(firstIndexOf(b, "bee"));
  }

}
