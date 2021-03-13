package com.limdongjin.ps.s.p11650;

import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        points.sort(Comparator.comparingInt(Point::getX).thenComparingInt(Point::getY));
        for (Point point : points)
            bw.write(point.x + " "+ point.y + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
