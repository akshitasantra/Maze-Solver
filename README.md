# Maze-Solver
Maze Solver is a Java program that reads from a maze text file, represents it as a list of points, and determines if there is a solvable path from the start point to the end point. The maze is defined by its coordinates, and the program uses a breadth-first search algorithm to find the solution.

# Features
- Maze Representation: Reads a maze from a text file and converts it into a list of points.
- Pathfinding: Implements a breadth-first search to determine if there is a path from the starting point to the ending point.
- Custom Point Class: Defines a Point class to handle the coordinates within the maze.
- Adjacency Check: Checks if two points in the maze are adjacent to each other.

# Maze File Format
The maze file (Maze1.txt) should have the following format:

- Use ' ' (space) for open paths.
- Use '1' for the start point.
- Use '2' for the end point.
- Use any other character for walls or obstacles.

Example: 

#######

#1			2#

#######
