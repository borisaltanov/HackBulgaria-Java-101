import java.util.Scanner;
import java.util.Arrays;

public class Anagrams {

  public static boolean areAnagrams(String a, String b) {
    if (a.length() != b.length()) {
        return false;
    }
    a = a.toLowerCase();
    a = a.trim();
    b = b.toLowerCase();
    b = b.trim();
    char [] aChars = a.toCharArray();
    char [] bChars = b.toCharArray();
    Arrays.sort(aChars);
    Arrays.sort(bChars);
    return Arrays.equals(aChars,bChars);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String a = scanner.next();
    String b = scanner.next();

    if (areAnagrams(a, b)) {
      System.out.println("ANAGRAMS");
    } else {
      System.out.println("NOT ANAGRAMS");
    }
  }
}
