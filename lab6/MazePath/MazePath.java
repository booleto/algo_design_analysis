package MazePath;

import java.util.Stack;

import javax.swing.BoundedRangeModel;

/**
 * MazePath
 */
public class MazePath {
    /**
     * Cell
     */
    public class Cell {
        Cell up;
        Cell down;
        Cell left;
        Cell right;
        boolean isGenerated = false;
        boolean isVisited = false;
        Position pos;
    }

    /**
     * Position
     */
    public class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        
    }

    Cell generateMaze(int bound) {
        Cell init = initMaze(bound);

        return init;
    }

    void recursiveMazeGen(Cell current) {
        current.isVisited = true;
        if (current.left.isVisited = false) {
            
        }
    }

    // initialize the maze. Initially the maze has no walls other than the bounds
    Cell initMaze(int bound) {
        Cell initial = new Cell();
        initial.pos = new Position(0, 0);
        Stack<Cell> stack = new Stack<Cell>();
        Cell current = initial;

        while (!stack.isEmpty()) {
            current = stack.pop();
            if (current.pos.x != bound) {
                current.right = new Cell();
                current.right.left = current;
                current.right.pos = new Position(current.pos.x + 1, current.pos.y);
                stack.push(current.right);
            }
            if (current.pos.y != bound) {
                current.down = new Cell();
                current.down.up = current;
                current.down.pos = new Position(current.pos.x, current.pos.y + 1);
                stack.push(current.down);
            }
        }
        return initial;
    }
}