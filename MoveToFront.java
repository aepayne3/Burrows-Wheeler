import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
 public static void encode() {
  // Initialize ascii ordered character array
  char[] letters = new char[256];
  for (int i = 0; i < 256; i++) {
   letters[i] = (char)i;
  }

  // Process input
  while (!BinaryStdIn.isEmpty()) {
   // Read character
   char c = BinaryStdIn.readChar(8);

   // Find index of current character
   int index = -1;
   for (int i = 0; letters[i] != c; i++) {
    index = i;
   }
   index++;

   // Output encoded character
   BinaryStdOut.write(index);
   BinaryStdOut.flush();

   // Swap recently encoded character to front of array
   for (int i = index; i - 1 >= 0; i--) {
    char temp = letters[i - 1];
    letters[i - 1] = letters[i];
    letters[i] = temp;
   }
  }
 }

 public static void decode() {
  // Initialize ascii ordered character array
  char[] letters = new char[256];
  for (int i = 0; i < 256; i++) {
   letters[i] = (char)i;
  }
  
  // Process input
  while (!BinaryStdIn.isEmpty()) {
   // Read integer
   int index = BinaryStdIn.readInt(8);
   
   // Output decoded character
   BinaryStdOut.write(letters[index]);
   BinaryStdOut.flush();
   
   // Swap recently decoded character to front of array
   for (int i = index; i - 1 >= 0; i--) {
    char temp = letters[i - 1];
    letters[i - 1] = letters[i];
    letters[i] = temp;
   }
  }
 }
}