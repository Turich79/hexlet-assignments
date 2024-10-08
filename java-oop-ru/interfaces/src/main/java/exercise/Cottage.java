package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    @Override
    public String toString() {
        return "" + floorCount + " этажный коттедж площадью " + area + " метров";
    }

    @Override
    public double getArea() {
        return area;
    }

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
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
