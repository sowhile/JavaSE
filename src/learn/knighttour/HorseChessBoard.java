package learn.knighttour;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author sowhile
 * <p>
 * 2022/12/2 13:25
 */
public class HorseChessBoard {
    //column
    private static int X = 6;
    //row
    private static int Y = 6;
    private static int[][] chessBoard = new int[Y][X];
    //记录某个位置是否走过
    private static boolean[] visited = new boolean[X * Y];
    //是否结束
    private static boolean finished = false;

    public static void main(String[] args) {
        int row = 2;
        int col = 2;
        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard, row - 1, col - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        for (int[] rows : chessBoard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    //写一个方法，对ps的各个位置，可以走的下一个位置的次数进行排序, 把可能走的下一个位置从小到大排序
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }

    /**
     * 核心算法，遍历棋盘，遍历成功就把 finished 设为true
     * 并把马走的每一步记录到 chessBoard
     *
     * @param chessBoard 棋盘
     * @param col        行
     * @param row        列
     * @param step       步数
     */
    public static void traversalChessBoard(int[][] chessBoard, int row, int col, int step) {
        //先把 step 记录到 chessBoard
        chessBoard[row][col] = step;
        //把这个位置设置为已经访问
        visited[row * X + col] = true;
        //获取当前位置可以走的下一个位置
        ArrayList<Point> ps = next(new Point(col, row));
        sort(ps);
        //遍历
        while (!ps.isEmpty()) {
            //取出当前 ps 第一个位置
            Point p = ps.remove(0);
            //判断该位置是否走过
            if (!visited[p.y * X + p.x]) {
                //递归遍历
                traversalChessBoard(chessBoard, p.y, p.x, step + 1);
            }

        }
        //退出while后，看看是否遍历成功，如果没有成功，就重置相应的值，进行回溯
        if (step < X * Y && !finished) {
            //重置
            chessBoard[row][col] = 0;
            visited[row * X + col] = false;
        } else finished = true;
    }

    //获取当前位置可以走的下一步位置
    public static ArrayList<Point> next(Point current) {
        ArrayList<Point> ps = new ArrayList<>();
        //创建Point对象
        Point p1 = new Point();
        //判断在 current 位置是否可以走如下位置，如果可以走就将该点放入 ps

        //判断是否可以走5位置
        if ((p1.x = current.x - 2) >= 0 && (p1.y = current.y - 1) >= 0) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走6位置
        if ((p1.x = current.x - 1) >= 0 && (p1.y = current.y - 2) >= 0) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走7位置
        if ((p1.x = current.x + 1) < X && (p1.y = current.y - 2) >= 0) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走0位置
        if ((p1.x = current.x + 2) < X && (p1.y = current.y - 1) >= 0) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走1位置
        if ((p1.x = current.x + 2) < X && (p1.y = current.y + 1) < Y) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走2位置
        if ((p1.x = current.x + 1) < X && (p1.y = current.y + 2) < Y) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走3位置
        if ((p1.x = current.x - 1) >= 0 && (p1.y = current.y + 2) < Y) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走4位置
        if ((p1.x = current.x - 2) >= 0 && (p1.y = current.y + 1) < Y) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        return ps;
    }
}
