GNC: Gene Network Coherence
===========================

This is a Java software for analyzing gene networks coherence using graph theory.
The executable file is on GNC Repository.

This application can be used in linux, mac, and windows. On the other hand, GNC software is parallelized using threads. If your computer allows multi-threading operation, result will be showed in a shorter period of time.

To use this tool, you must first download the GNC.exe file. This file is a self-extracting package and it contains all necesary items.

Furthermore, inside the repository there is one random yeast gene network for testing the tool. It is called "Example Input Network.txt"



Usage information
=================

To launch the app you must do a double click in “GNC.jar”. Automatically, a main windows will be appear. In this windows, a input network and well known databases can be chosen to star the process. As results will be obtained by the app, they will be showed.

If you have any question, please read "User Guide" for more details.



Troubleshooting and F.A.Q.
==========================

Be patient. Although this program is fully optimized, usually it takes a long time.
Input network files must be a “.txt” file and it must have the following aspect.

Node1,Node2

Node1,Node3

...

Node1,Node N

...

Node N, Node M

An input network without data will be represented with coherence value of 1. Furthermore, this fact will be appearing if the file does not perform the previous structure.

GNC works using 2 necessary folders, “BBDD and Matrices”. If both folders are not included with the jar file, an error message will be appear. Under no circumstances shall be modified.

COPYRIGHT
=========
AUTHORS: Francisco Gómez Vela fgomez@upo.es, José Antonio Lagares jalagrod@gmail.es, Norberto Díaz Díaz ndiaz@upo.es. Copyright © 2013 Universidad Pablo de Olavide, Spain.
