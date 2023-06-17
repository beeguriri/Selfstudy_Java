package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 별자리만들기 {

    static class Edge implements Comparable<Edge>{

        private int nodeA;
        private int nodeB;
        private double distance;

        public Edge(int nodeA, int nodeB, double distance) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }

        public double getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance < o.distance ? -1 : 1;
        }
    }

    static class Point {
        private int index;
        private double x;
        private double y;

        public Point(int index, double x, double y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }

        public int getIndex() {
            return index;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

    public static int [] parent;
    public static List<Point> points = new ArrayList<>();
    public static List<Edge> edges = new ArrayList<>();
    public static int n;
    public static double result = 0;

    public static int findParent(int x) {

        if(x == parent[x])
            return x;

        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b){

        a = findParent(a);
        b = findParent(b);

        if(a>b)
            parent[a] = b;
        else
            parent[b] = a;
    }

    public static double calDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2)+Math.pow(a.getY() - b.getY(), 2));
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        parent = new int [n];
        for(int i=0; i<n; i++)
            parent[i] = i;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            float a = Float.parseFloat(st.nextToken());
            float b = Float.parseFloat(st.nextToken());

            points.add(new Point(i, a, b));
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++) {
                Point a = points.get(i);
                Point b = points.get(j);
                double dist = calDistance(a, b);
                edges.add(new Edge(a.getIndex(), b.getIndex(), dist));
            }
        }

        Collections.sort(edges);

        for(int i=0; i<edges.size(); i++){

            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            double dist = edges.get(i).getDistance();

            if(findParent(a)!=findParent(b)) {
                unionParent(a, b);
                result += dist;
            }
        }

//        result = (int) (result * 100);
        System.out.println(result);
    }
}
