import edu.princeton.cs.algs4.Merge;

public class CircularSuffixArray {
 private final int n;
 private Suffix[] suffixes;
 private int[] index;

 public CircularSuffixArray(String s) {
  // Initialize size n
  this.n = s.length();

  // Initialize suffixes array
  this.suffixes = new Suffix[n];
  for (int i = 0; i < n; i++) {
   suffixes[i] = new Suffix(s, i);
  }

  // Sort suffixes
  Merge.sort(suffixes);

  // Initialize index array
  this.index = new int[n];
  for (int i = 0; i < n; i++) {
   index[suffixes[i].getIndex()] = i;
  }
 }

 public int length() {return n;}

 public int index(int i) {return index[i];}

 private static class Suffix implements Comparable<Suffix> {
  private static String s;
  private final int index;

  public Suffix(String s, int index) {
   this.s = s;
   this.index = index;
  }

  public int getIndex() {return index;}

  // Comparator for Mergesort
  public int compareTo(Suffix that) {
   if (this == that) return 0;
   int n = this.s.length();
   for (int i = 0; i < n; i++) {
    char cthis = this.s.charAt((this.index + i) % n);
    char cthat = that.s.charAt((that.index + i) % n);
    if (cthis < cthat) {return -1;}
    if (cthis > cthat) {return 1;}
   }
   return 0;
  }
 }
}