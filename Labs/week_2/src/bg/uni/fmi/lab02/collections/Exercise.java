package bg.uni.fmi.lab02.collections;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;

public class Exercise {

    //task 0
    public static void addElement(List<String> list, String element) {
        list.add(0, element);
    }

    //task 1
    public static String retrieveElement(List<String> list, int index) {
        return list.get(index);
    }

    //task 2
    public static void removeElement(List<String> list, int index) {
        try {
            list.remove(index);
        } catch (Exception e) {
            System.out.println("Not enough elements!");
        }
    }

    //task 3
    public static int searchElement(List<String> list, String element) {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).equals(element)) {
                return i;
            }
        }
        return -1;
    }

    //task 4
    public static void sortArrayWithDogs(List<Dog> list) {
        list.sort(new ComparatorByWeight());
    }

    //task 5
    public static <T> void replaceElement(List<T> list, T element, int pos) {
        try {
            if (list.size() >= pos) {
                list.set(pos, element);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The index you have entered is invalid");
            System.out.println(e.getMessage());
        }
    }

    //task 6
    public static int countMapPair(Map<String, Integer> map) {
        return map.size();
    }


    public static void main(String[] args) {

        //task 0
        List<String> names = new ArrayList<>();
        names.add("Niki");
        addElement(names, "Viki");
        System.out.println(names);


        //task 1
        names.add("Maria");
        names.add("Georgi");
        names.add("Ivan");
        System.out.println(retrieveElement(names, 2));

        //task 2
        final int THIRD_ELEMENT = 3;
        removeElement(names, THIRD_ELEMENT - 1);
        System.out.println(names);

        //task 3
        System.out.println(searchElement(names, "Viki"));
        System.out.println(searchElement(names, "Petar"));

        //task 4
        names.sort(String::compareTo);
        System.out.println(names);

        List<Integer> numbers = Arrays.asList(1, 5, 2, 6, 3, 7, 4);
        numbers.sort(Integer::compareTo);
        System.out.println(numbers);

        List<Dog> dogs = new ArrayList<>();
        Dog second = new Dog(10, 15);
        Dog first = new Dog(5, 10);
        Dog third = new Dog(2, 25);

        dogs.add(first);
        dogs.add(second);
        dogs.add(third);

        sortArrayWithDogs(dogs);
        System.out.println(dogs);

        //task 5
        final int SECOND_ELEMENT = 2;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter specific element: ");
        String element = input.next();
        replaceElement(names, element, SECOND_ELEMENT - 1);
        System.out.println(names);

        //task 6
        Map<String, Integer> map = new HashMap<>();
        map.put("Banana", 5);
        map.put("Orange", 3);
        map.put("Tomatoes", 4);
        System.out.println(countMapPair(map));

        //task 7
        Aircraft aircraft = new Aircraft("9H-VCA");
        aircraft.addFlightLeg("LBSF", "EBBR", LocalDate.of(2023, 3, 10));
        aircraft.addFlightLeg("LBSF", "EGLL", LocalDate.of(2023, 3, 11));
        aircraft.addFlightLeg("EBBR", "LBSF", LocalDate.of(2023, 3, 12));

        List<FlightLeg> lbsfFlightLegs = aircraft.getFlightLegs("LBSF");
        System.out.println("Flight legs for LBSF:");
        for (FlightLeg flightLeg : lbsfFlightLegs) {
            System.out.println(flightLeg);
        }
    }
}

