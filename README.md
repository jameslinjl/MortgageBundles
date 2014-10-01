James Lin
Columbia University
jl3782@columbia.edu
(302) 668-3584
Sapient Global Coding Challenge

This code is one of the questions in the Sapient Global Coding Challenge. The code is written in Java and utilizes a generic tree structure to solve most of the problems. Running time is as expected though memory usage runs fairly high due to my implementation. However, ideally Java’s automatic garbage collection would compensate for this.

The program is run by compiling all files using…

$ javac Tester.java 

… and then running… 

$ java Tester

The Tester contains the main method and essentially opens a shell with which to interact with. Tree contains the general Tree structure and methods to interact with it. TreeNode describes the implementation of each individual Node, each of which has a Bundle to simulate a Mortgage Bundle.

Robust error and edge case testing was not done due to other assignments being due this same weekend. One notable difference in the my implementation was that Merge is NOT delimited using commas, rather only using whitespace. 

Commands:

Merge <bundle ID 1> <bundle ID2> … <bundle ID N>

Split <bundle ID> into <N>

Parent <bundle ID>

Sellable <bundle ID>

Derived <child bundle ID> <ancestor bundle ID>

Quit
