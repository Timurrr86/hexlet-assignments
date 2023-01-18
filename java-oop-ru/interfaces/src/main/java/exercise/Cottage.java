package exercise;

// BEGIN
public class Cottage implements Home {
    double area;
    int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    public int compareTo(Home another) {
        return this.getArea() == another.getArea() ? 1 : -1;
    }

    @Override
    public String toString() {
        return "" + floorCount + " этажный коттедж площадью "
                + area +
                " метров";
    }
}
// END
