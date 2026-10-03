import java.util.Scanner;

interface Plot {
    String getOwner();
    String getShape();
    double getArea();
}

class CirclePlot implements Plot {
    private String owner;
    private double radius;

    public CirclePlot(String owner, double radius) {
        this.owner = owner;
        this.radius = radius;
    }

    public String getOwner() { return owner; }
    public String getShape() { return "CIRCLE"; }
    public double getArea() { return Math.PI * radius * radius; }
}

class RectanglePlot implements Plot {
    private String owner;
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        this.owner = owner;
        this.length = length;
        this.width = width;
    }

    public String getOwner() { return owner; }
    public String getShape() { return "RECTANGLE"; }
    public double getArea() { return length * width; }
}

class TrianglePlot implements Plot {
    private String owner;
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        this.owner = owner;
        this.base = base;
        this.height = height;
    }

    public String getOwner() { return owner; }
    public String getShape() { return "TRIANGLE"; }
    public double getArea() { return 0.5 * base * height; }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Plot[] plots = new Plot[n];
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            if (shape.equals("CIRCLE")) {
                double radius = sc.nextDouble();
                plots[i] = new CirclePlot(owner, radius);
            } else if (shape.equals("RECTANGLE")) {
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                plots[i] = new RectanglePlot(owner, length, width);
            } else if (shape.equals("TRIANGLE")) {
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                plots[i] = new TrianglePlot(owner, base, height);
            }
        }

        for (Plot plot : plots) {
            double area = plot.getArea();
            System.out.printf("%s (%s): %.2f\n", plot.getOwner(), plot.getShape(), area);
            totalArea += area;
        }

        System.out.printf("Total Area: %.2f\n", totalArea);
        sc.close();
    }
}