# Sort 
This is one of the assigments I had for my Operating Systems course (CSC438). It was an indviudal project, and we had one week to complete it. 



Here is the assigment: 

The Assignment:
You should write a program called sort. This program should take a file (presumably containing plain text) and print the lines of the file to the screen, sorted into order. The default sort will be using string comparisons (basically, comparing the ASCII values of the characters in the lines).

Minimum Requirements:
Your program should do the following: (1) The program should take one command line parameter (in addition to the name of the program). This parameter is the name of the file to be sorted. (2) The program should sort the file (in the default sorting order) line by line, and print the lines in sorted order to the screen. (3) If this portion of the program works properly, you will receive a total of 16 of the 20 points available for the assignment.

Add-On Functionality:
To achieve the full 20 points (or more), you must add on some command line options. The options you can add are as follows: (1) -b : ignore leading blanks. The sort should function as normal, but ignore any blank spaces at the beginning of the line. (2)-f : ignore case. The sort should function as normal, but should ignore the difference between upper- and lower-case letters while sorting. (3)	-r : reverse sort. The sort should sort the lines in reverse order.(4)	-u : only print unique lines.The sort should print all the sorted lines, but if there are multiple copies of the same line, that line should only be printed once.

Examples:
Here are some examples of calling the program (on a command line) and what the program should do.
(1)	sort;This should be an error, since it does not have a file parameter. (2)	sort file.txt. This should print the sorted lines of file.txt to the screen. (3)sort file.txt other.txt; his should be an error, since it has too many parameters.
(4) sort -r file.txt; This should print the lines of file.txt to the screen in reverse sorted order.
(5)	sort -u -r -f output.txt file.txt; This should write the reverse sorted lines of file.txt, only unique lines, and ignore case.

** Note you will need a test file. 
