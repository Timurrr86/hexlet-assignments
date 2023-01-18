package exercise;

// BEGIN
public class Flat implements Home {
    double area;
    double balconyArea;
    int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Квартира площадью "
                + getArea() + " метров на "
                + floor +
                " этаже";
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    public int compareTo(Home another) {
        return this.getArea() == another.getArea() ? 1 : -1;
    }
}
// END
