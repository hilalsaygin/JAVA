# Path Planning via Dijkstra and BFS - CSE 222/505

## Project Overview
[cite_start]This project, implements a path planning system designed to find feasible paths through grid-based maps[cite: 1, 5]. [cite_start]The system converts text-based map data into graph structures to calculate paths from a starting coordinate to a goal coordinate while navigating around obstacles[cite: 7, 21].

## Problem Definition
* [cite_start]**Objective**: Find a feasible path from a starting point to an end point[cite: 7].
* [cite_start]**Map Representation**: Maps are provided as text files where `0` represents unoccupied space and `1` (or `-1`) represents obstacles[cite: 18, 20].
* [cite_start]**Optimal Path**: While any feasible path is acceptable, the shortest path (calculated via edge counts) is considered optimal[cite: 8, 47].



## Technical Architecture

### 1. Data Structures
* [cite_start]**CSE222Map**: Handles file I/O, reading $n \times n$ matrices and identifying start/end coordinates[cite: 21, 172].
* [cite_start]**CSE222Graph**: Constructs a graph where nodes exist only for unoccupied (`0`) coordinates[cite: 50, 175].
* [cite_start]**Inner Node Class**: Stores $(y, x)$ coordinates, adjacency lists (neighbors), and the path back to the origin[cite: 176, 177, 178].

### 2. Adjacency Logic
[cite_start]Nodes are connected if they are adjacent in any of the 8 directions[cite: 52, 61]:
* [cite_start]**Cardinal**: North, South, East, West[cite: 54, 55].
* [cite_start]**Diagonal**: NW, NE, SW, SE[cite: 56, 57, 58].

### 3. Pathfinding Algorithms
* [cite_start]**Dijkstra’s Algorithm**: A weighted approach that finds the feasible path by exploring the smallest distance $d[u]$ from the source[cite: 66, 85].
* [cite_start]**Breadth-First Search (BFS)**: A queue-based approach that identifies nodes layer by layer to find a path[cite: 95, 96, 180].

## Installation & Usage

### Compilation
Navigate to the source folder containing the `src` package:
```bash
cd ../src
javac *.java
