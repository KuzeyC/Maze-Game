//kc18182 - 1803189

package maze;

import java.util.*;

class Maze {
    private int x;
    private int y;
    private Tile[][] mazeGrid;
    private Stack<Tile> neighbours = new Stack<>();

    Maze(Tile[][] mazeGrid, int x, int y){
        this.mazeGrid = mazeGrid;
        this.x = x;
        this.y = y;
        generateMaze();
    }

    //Maze Generation Algorithm
    //recursive backtracking (dfs with backtracking)
    //https://en.wikipedia.org/wiki/Maze_generation_algorithm#Recursive_backtracker
    private void generateMaze(){
        //Set current tile.
        Tile current = mazeGrid[0][0];
        current.visited = true;
        //repaint to refresh tile.
        current.repaint();
        //Add current tile to stack.
        neighbours.push(current);
        //While there are neighbours from the current tile.
        while (neighbours.size() > 0) {
            //Pop current tile from the stack.
            current = neighbours.pop();
            //If the current cell has a neighbour.
            if (checkNeighbours(current)) {
                //Add the current tile to the stack
                neighbours.push(current);
                //Get next random tile from the neighbours of the current tile.
                Tile next = getRandomNeighbour(current);
                //Set visited of the next tile to true
                next.visited = true;
                neighbours.push(next);
                //remove the walls between current and the next tile
                removeWalls(current, next);
                //repaint to refresh tile.
                next.repaint();
                //try { Thread.sleep(0); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        }
    }

    //Removing Walls method to remove certain walls (still part of the algorithm).
    private void removeWalls(Tile current, Tile next) {
        //Getting the values of the differences between the x and the y.
        int y = next.y - current.y;
        int x = next.x - current.x;

        //If going up
        if (y == -1) {
            current.walls[0] = false;
            next.walls[2] = false;
        } else if (y == 1) { //If going down
            current.walls[2] = false;
            next.walls[0] = false;
        }

        //If going left
        if (x == -1) {
            current.walls[3] = false;
            next.walls[1] = false;
        } else if (x == 1) { //If going right
            current.walls[1] = false;
            next.walls[3] = false;
        }
    }

    //Method for checking if there are neighbours that are not visited.
    private boolean checkNeighbours(Tile current) {
        //Up
        if (current.y > 0 && !mazeGrid[current.x][current.y - 1].visited)
            return true;
        //Down
        if (current.y < 19 && !mazeGrid[current.x][current.y + 1].visited)
            return true;
        //Left
        if (current.x > 0 && !mazeGrid[current.x - 1][current.y].visited)
            return true;
        //Right
        if (current.x < 19 && !mazeGrid[current.x + 1][current.y].visited)
            return true;
        return false;
    }

    //Method for getting a random neighbour.
    private Tile getRandomNeighbour(Tile current) {
        //ArrayList for neighbours.
        ArrayList<Tile> neighbours =  new ArrayList<>();

        //Up
        if (current.y > 0 && !mazeGrid[current.x][current.y - 1].visited)
            neighbours.add(mazeGrid[current.x][current.y - 1]);
        //Down
        if (current.y < 19 && !mazeGrid[current.x][current.y + 1].visited)
            neighbours.add(mazeGrid[current.x][current.y + 1]);
        //Left
        if (current.x > 0 && !mazeGrid[current.x - 1][current.y].visited)
            neighbours.add(mazeGrid[current.x - 1][current.y]);
        //Right
        if (current.x < 19 && !mazeGrid[current.x + 1][current.y].visited)
            neighbours.add(mazeGrid[current.x + 1][current.y]);

        //Choosing one of the neighbours in random.
        Random rand = new Random();
        int r = rand.nextInt(neighbours.size());
        //returning that random chosen neighbour.
        return neighbours.get(r);
    }
}
