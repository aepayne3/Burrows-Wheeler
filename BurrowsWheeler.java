import edu.princeton.cs.algs4;
import stdlib;

// You only write for one word. Is this what you want?
public class BurrowsWheeler {
 
 private static final int Radix = 256;
 
 public static void transform() {
  // Get string
  String in=BinaryStdIn.readString();
  
  // Initialize circular suffix array
  CircularSuffixArray circSA=new CircularSuffixArray(in);
  
  // Get string size and circular suffix array size
  //  NOTE: These sizes are equal. You only need one variable.
  int inSize=in.length();
  int circSize=circSA.length();
  
  // Find rank (i) in circular suffix array for originial string
  int i=0;
  while (i<circSize) {
   if (circSA.index(i)==0) {
   break;}
   i++;
  }
  // Write the rank of the orignial word
  BinaryStdOut.write(i);
  
  // Iterate over entire circular suffix array
  for (int j=0; j<circSize; j++) {
   // indexNum = ((rank of circular siffix j) + (n - 1)) % n
   int indexNum = ((circSA.index(j)+(inSize-1))%inSize);
   // Write character at indexNum
   BinaryStdOut.write(in.charAt(indexNum));
  }
 // Close output
 BinaryStdOut.close();
 }
 
 public static void inverseTransform(){
  int first = BinaryStdIn.readInt();
        String t = BinaryStdIn.readString();
        int n = t.length();
        
  // Maintain a letter count for each string processed
  // Make this count indexed by ASCII char value
  int[] count = new int[R + 1]
  int[] next = new int[n];
        
  // Increment count of each letter in t
  for (int i = 0; i < n; i++)
            count[t.charAt(i) + 1]++;
        
  // Make the count at i be a cummulative sum of all other counts
  // E.g. count[3] = count[0] + count[1] + count[2] + count[3];
  for (int i = 1; i < R + 1; i++)
            count[i] += count[i - 1];
        
  // The 'next' array has not be declared until before, so it is unclear what you are doing here
  // Iterate over each character in t
  for (int i = 0; i < n; i++)
            // index = count[t.charAt(i)]
   //  index is the cummulative count of all letter occurance before t.charAt(i)
   // next[index] = i
   next[count[t.charAt(i)]++] = i;
        
  // Iterate over each character in t
  // Let i be initialized to next[first]
  // Change i to next[i] after processing a character in t
  for (int i = next[first], c = 0; c < n; i = next[i], c++)
            // Write the character at i in t
   BinaryStdOut.write(t.charAt(i));
        
  // Close output
  BinaryStdOut.close();
    }
 
  // This main will work for MoveToFront, but not BurrowsWheeler
  public static void main(String[] args) {
        if (args.length != 1)
            throw new IllegalArgumentException("Expected + or -\n");
        else if (args[0].equals("+"))
            transform(); // Change to transform
        else if (args[0].equals("-"))
            inverseTransform(); // Change to inverseTransform
        else {
            String msg = "Unknown argument: " + args[0] + "\n";
            throw new IllegalArgumentException(msg);
        }
    }
}