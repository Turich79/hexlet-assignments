package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            System.out.println(circle.getSquare());
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
            throw new RuntimeException(e);
        } finally {
            System.out.println("Вычисление окончено");
        }

    }
}
// END
