# Persons Directory

This is an assignment for my first CS course at UMass, CS 160 - Object Oriented Programming. It implements a directory and a command line menu that allows users to work with this directory. Using this interface, users are able to view the directory, add entries, modify entries, search for entries, and delete entries. In this case, the directory is an object called Persons and stores different kind of people; objects of type Person, or objects that inherit from Person - Student and Employee. It stores these people in the form of an Array List.

## Future Work

The main program may be edited to be able to be used for more general directories. Currently, it implements specific code relating to the Persons object. This code may be delegated to other objects instead, so to make the code more useful and to better follow principles of OOP.

An interface may be created for directories, so that any object that implements this interface may work on the main program. This would allow us to have different directories, rather than just Persons.
