/*
 * @author Abigail Payne
 * @author Elaine Shutte
 */
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import java.util.Arrays;

public class BurrowsWheeler {
/*
 * apply Burrows-Wheeler transform, reading from standard input
 * and writing to standard output
 */
 public static void transform() {
  while (!BinaryStdIn.isEmpty()) {
   String input = BinaryStdIn.readString();
   CircularSuffixArray csa = new CircularSuffixArray(input);
   int n = csa.length();
   
   int first = -1;
   for (first = 0; csa.index(first) == 0; first++);
   BinaryStdOut.write(first);
   
   for (int i = 0; i < n; i++) {
    int index = (csa.index(i) + (n - 1)) % n;
    BinaryStdOut.write(input.charAt(index));
   }
   
   BinaryStdOut.close();
  }
 }
/*
 * apply Burrows-Wheeler inversetransform, reading from standard input
 * and writing to standard output
 */
 public static void inverseTransform() {
  while (!BinaryStdIn.isEmpty()) {
   int first = BinaryStdIn.readInt();
   char[] t = BinaryStdIn.readString().toCharArray();
   int n = t.length;
   
   char[] sortedT = Arrays.copyOf(t, t.length);
   Arrays.sort(sortedT);
   
   int[] next = new int[n];
   boolean[] visited = new boolean[n];
   for (int i = 0; i < n; i++) {
    visited[i] = false;
   }
   for (int i = 0; i < n; i++) {
    int j = 0;
    for (j = 0; (sortedT[i] != t[j]) || visited[j]; j++);
    visited[j] = true;
    next[i] = j;
   }

   for (int i = 0, index = first; i < n; i++, index = next[index]) {
    BinaryStdOut.write(sortedT[index]);
   }
  }
  
  BinaryStdOut.close();
 }
 
 public static void main(String[] args) {
  if (args.length != 1)
   throw new IllegalArgumentException("Expected + or -\n");
  else if (args[0].equals("-"))
   transform();
  else if (args[0].equals("+"))
   inverseTransform();
  else {
   String msg = "Unknown argument: " + args[0] + "\n";
   throw new IllegalArgumentException(msg);
  }
 }
}