package exercise;

// BEGIN
public class Flat implements Home{
    private final double area;
    private final double balconyArea;
    private final int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + (area + balconyArea) +
                " метров на " + floor + " этаже";
    }

    @Override
    public double getArea() {
        return (area + balconyArea);
    }

    @Override
    public int compareTo(Home another) {
        int result = 0;
        if (this.getArea() > another.getArea()) {
            result = 1;
        } else if (this.getArea() < another.getArea()) {
            result = -1;
        }
        return result;
    }
}
// END
