package com.codersmart.algorithms.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RobotRoomCleaner {
    enum Dir{
        UP, RIGHT, DOWN, LEFT
    };
    Robot robot;
    Map<Coord, Integer> map = new HashMap(); // key - visited cell, val : 1 is block
    static final Integer CLEANED = 0;
    public static class Coord{
        Integer x;
        Integer y;
        public Coord(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o){
            if(false == (o instanceof Coord)) return false;
            Coord coord = (Coord)o;
            return Objects.equals(x, coord.x) && Objects.equals(y, coord.y);
        }
        @Override
        public int hashCode(){
            return x.hashCode() ^ y.hashCode();
        }
        public int getX(){return x;};
        public int getY(){return y;};
        public void setX(int val){x = val;};
        public void setY(int val){y = val;};
        public Coord get(Dir dir){
            int newX = x;
            int newY = y;
            switch (dir){
                case UP: newY --; break;
                case RIGHT: newX ++; break;
                case DOWN: newY ++; break;
                case LEFT: newX --;
            }
            return new Coord(newX, newY);
        }
    }

    private void turnBack(Robot robot){
        robot.turnLeft();
        robot.turnLeft();
    }
    private void moveBack(Robot robot){
        turnBack(robot);
        robot.move();
        turnBack(robot);
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        clean(new Coord(0,0), Dir.UP);
    }

    private void clean(Coord coord, Dir dir){
        robot.clean();
        map.put(coord, CLEANED);
        int n = dir.ordinal();
        int N = Dir.values().length;
        for(int i = n; i < n + N; i++){
            Dir dirNew = Dir.values()[i%N];
            Coord newCoord = coord.get(dirNew);
            if(!map.containsKey(newCoord) && robot.move()){
                clean(newCoord, dirNew);
                moveBack(robot);
            }
            robot.turnRight();
        }

    }



    public static void main(String[] args) {
        System.out.println("A " + ( Dir.RIGHT.ordinal()) + Dir.values()[0]);
        int n = Dir.UP.ordinal();
        int N = Dir.values().length;
        for(int i = n; i < n + N; i++) {
            Dir dirNew = Dir.values()[i % N];
            System.out.println(dirNew);
        }
    }

    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();
        void turnRight();

        // Clean the current cell.
        public void clean();
    }
}
