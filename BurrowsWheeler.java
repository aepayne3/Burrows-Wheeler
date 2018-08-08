import edu.princeton.cs.algs4;
import stdlib;

public class BurrowsWheeler {
 
 private static final int Radix = 256;
 
 public static void transform() {
  String in=BinaryStdIn.readString();
  CircularSuffixArray circSA=new CircularSuffixArray(in);
  int inSize=in.length();
  int circSize=circSA.length();
  int i=0;
  while (i<circSize) {
   if (circSA.index(i)==0) {
   break;}
   i++;
  }
  BinaryStdOut.write(i);
  
  for (int j=0; j<circSize; j++) {
   int indexNum = ((circSA.index(j)+(inSize-1))%inSize);
   BinaryStdOut.write(in.charAt(indexNum));
  }
 BinaryStdOut.close();
 }
 
 public static void inverseTransform(){
        int first = BinaryStdIn.readInt();
        String t = BinaryStdIn.readString();
        int n = t.length();
        int[] count = new int[R + 1], next = new int[n];
        for (int i = 0; i < n; i++)
            count[t.charAt(i) + 1]++;
        for (int i = 1; i < R + 1; i++)
            count[i] += count[i - 1];
        for (int i = 0; i < n; i++)
            next[count[t.charAt(i)]++] = i;
        for (int i = next[first], c = 0; c < n; i = next[i], c++)
            BinaryStdOut.write(t.charAt(i));
        BinaryStdOut.close();
    }
 
 
  public static void main(String[] args) {
        if (args.length != 1)
            throw new IllegalArgumentException("Expected + or -\n");
        else if (args[0].equals("+"))
            decode();
        else if (args[0].equals("-"))
            encode();
        else {
            String msg = "Unknown argument: " + args[0] + "\n";
            throw new IllegalArgumentException(msg);
        }
    }
}