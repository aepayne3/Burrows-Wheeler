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
   
 }