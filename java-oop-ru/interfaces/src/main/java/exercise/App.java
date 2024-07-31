package exercise;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
//        System.out.println("привет");
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = buildApartmentsList(apartments, 3);
        System.out.println(result); // =>
// [
//     Квартира площадью 44.0 метров на 10 этаже,
//     Квартира площадью 90.0 метров на 2 этаже,
//     2 этажный коттедж площадью 125.5 метров
// ]
        CharSequence text = new ReversedSequence("abcdef");
        System.out.println(text.toString()); // "fedcba"
        System.out.println(text.charAt(1)); // 'e'
        System.out.println(text.length()); // 6
        System.out.println(text.subSequence(1, 4).toString()); // "edc"
    }
    public static List<String> buildApartmentsList(List<Home> list, int n) {
        List<String> newList = new ArrayList<>();

        List<Home> sortedBuilds = list.stream()
                .sorted(Comparator.comparing(Home::getArea))
                .collect(Collectors.toList());
//        System.out.println("sortedList::" + sortedBuilds);
        for (int i = 0; i < sortedBuilds.size() && i < n; i++) {
            newList.add(sortedBuilds.get(i).toString());
        }
        return newList;
    }
}
// END
