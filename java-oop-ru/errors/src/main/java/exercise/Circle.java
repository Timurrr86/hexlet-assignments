package exercise;

// BEGIN
class Circle {
    private final Point point;
    private static int radius;

    public Point getPoint() {
        return point;
    }

    public int getRadius() {
        return radius;
    }

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("");
        }
        return Math.PI * radius * radius;
    }
}
// END
