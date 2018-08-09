/******************************************************************************
*  Name:   Abigail Payne  
	ID: L20471771744  
   
 *  
 *
 *  Partner Name: Elaine Schutte    

 *  Partner LUID:  L20469954  
 *  *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 4: Burrows-Wheeler



/******************************************************************************
 *  List in table format which input files you used to test your program.
 *  Fill in columns for how long your program takes to compress and
 *  decompress these instances (by applying BurrowsWheeler, MoveToFront,
 *  and Huffman in succession). Also, fill in the third column for
 *  the compression ratio (number of bytes in compressed message 
 *  divided by the number of bytes in the message).
 *****************************************************************************/

File     Encoding Time    Decoding time      Compression ratio
------------------------------------------------------------------------
abra.txt .6 sec


/******************************************************************************
 *  Compare the results of your program (compression ratio and running
 *  time) on mobydick.txt to that of the most popular Windows
 *  compression program (pkzip) or the most popular Unix/Mac one (gzip).
 *  If you don't have pkzip, use 7zip and compress using zip format.
 *****************************************************************************/


/******************************************************************************
 *  Give the order of growth of the running time of each of the 6
 *  methods as a function of the input size n and the alphabet size R
 *  both in practice (on typical English text inputs) and in theory
 *  (in the worst case), e.g., n, n + R, n log n, n^2, or R n.
 *
 *  Include the time for sorting circular suffixes in Burrows-Wheeler
 *  transform().
 *****************************************************************************/

                                      typical            worst
---------------------------------------------------------------------
BurrowsWheeler transform()			nlogn			nlogn
BurrowsWheeler inverseTransform()	nlogn			nlogn
MoveToFront encode()                     R+ n                R + n
MoveToFront decode()                     R + n               R + n
Huffman compress()                    n + R log R        n + R log R
Huffman expand()                      n                  n





/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
There are no known bugs or limitations


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
1. https://stackoverflow.com/questions/1200621/how-do-i-declare-and-initialize-an-array-in-java

2.https://docs.oracle.com/javase/8/docs/api/index.html?java/util/package-summary.html

3.https://www.cs.cmu.edu/~ckingsf/bioinfo-lectures/bwt.pdf

4.https://www.geeksforgeeks.org/inverting-burrows-wheeler-transform/

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
Project had to run from the command line and one partner had issues with java mismatches between what Dr. Java used and what the terminal tried to use.
Unable to use a batch file to get the timing for the files


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it. Additionally, you may include any suggestions
 *  for what to change or what to keep (assignments or otherwise) in future 
 *  semesters. 
*****************************************************************************
