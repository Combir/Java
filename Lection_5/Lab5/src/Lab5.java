package src;

import java.util.Scanner;

public class Lab5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the coordinates of the points, each on a separate line");

        Point3d point_1 = new Point3d(sc.nextInt(), sc.nextInt(), sc.nextInt());
        Point3d point_2 = new Point3d(sc.nextInt(), sc.nextInt(), sc.nextInt());
        Point3d point_3 = new Point3d(sc.nextInt(), sc.nextInt(), sc.nextInt());

        if (point_1.equals(point_2) || point_1.equals(point_3) || point_2.equals(point_3)) {
            System.out.println("The points are equal, there is no triangle");
        } else {
            System.out.printf("Square = %.2f", CalculateArea(point_1, point_2, point_3));
        }

    }

    public static double CalculateArea(Point3d p_1, Point3d p_2, Point3d p_3) {
        double edge_1 = p_1.distanceTo(p_2);
        double edge_2 = p_2.distanceTo(p_3);
        double edge_3 = p_3.distanceTo(p_1);

        double semi_perimeter = (edge_1 + edge_2 + edge_3) / 2;

        double square = Math.sqrt(semi_perimeter * (semi_perimeter - edge_1) * (semi_perimeter - edge_2) * (semi_perimeter - edge_3));
        return square;
    }

}