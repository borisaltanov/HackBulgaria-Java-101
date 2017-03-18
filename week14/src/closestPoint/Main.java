package closestPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static int NUM_POINTS = 100_000;
	public static int UPPER = 10_000;
	
	public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
	}

	public static List<Point> generatePoints() {
		List<Point> resultList = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < NUM_POINTS; i++) {
			resultList.add(new Point(rand.nextInt(UPPER),rand.nextInt(UPPER)));
		}
		
		return resultList;
	}
	
	public static void calculateClosestPoint(List<Point> generatedPoints) {
		double dist;
		Point wanted;
		for (Point point1 : generatedPoints) {
			dist = distance(point1, generatedPoints.get(0));
			wanted = generatedPoints.get(0);
			for (Point point2 : generatedPoints) {
				double tempDist = distance(point1, point2);
				if (tempDist != 0 && tempDist < dist) {
					dist = tempDist;
					wanted = point2;
				}
			}
			System.out.println(point1 + " " + wanted + " " + dist);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Point> l = generatePoints();
		calculateClosestPoint(l);

	}

}
