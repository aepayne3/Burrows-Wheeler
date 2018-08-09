import edu.princeton.cs.algs4.Merge;

public class CircularSuffixArray {
 private final int n;
 private Suffix[] suffixes;
 private int[] index;

 public CircularSuffixArray(String s) {
     if (s == null){ throw new IllegalArgumentException();}
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
   index[i] = suffixes[i].getIndex();
    //  System.out.println(suffixes[i].getIndex());
      //System.out.println();
  }
 }

 public int length(){return n;}

 public int index(int i) {
     if (i < 0) {throw new IllegalArgumentException();}
     if (i > this.n-1) {throw new IllegalArgumentException();}
     return index[i];
 }

 private class Suffix implements Comparable<Suffix> {
  private String s;
  private final int index;

  private Suffix(String s, int index) {
      if ( s == null) {throw new IllegalArgumentException();}
      if (index < 0) {throw new IllegalArgumentException();}
     // if (index > 0) {throw new IllegalArgumentException();}
      this.s = s;
      this.index = index;
  }

  public int getIndex() {return index;}

  // Comparator for Mergesort
  public int compareTo(Suffix that) {
      if (that == null) {throw new IllegalArgumentException();}
   if (this == that) return 0;
   int n = this.s.length();
   for (int i = 0; i < n; i++) {
    char cthis = s.charAt((this.index + i) % n);
    char cthat = s.charAt((that.index + i) % n);
    if (cthis < cthat) {return -1;}
    if (cthis > cthat) {return 1;}
   }
   return 0;
  }
 }
  public static void main(String[] args)
    {
    String test=args[0];
    CircularSuffixArray circSA=new CircularSuffixArray(test);
    int n=test.length();
    for (int i=0; i<n; i++) {
      System.out.println(circSA.index(i));}
  }
}