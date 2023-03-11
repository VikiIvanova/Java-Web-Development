package tasks_week_1;

import java.util.Scanner;

public class Main {

    //task 0
    public static int factorial(int num) {
        int fact = 1;
        for(int i = 1; i <= num; i++)
        {
            fact *= i;
        }
        return fact;
    }

    //task 1
    public static int indexFirstOccurrence(int[] arr, int element)
    {
        for(int i = 0; i < arr.length; ++i)
        {
            if(arr[i] == element)
                return i;
        }
        return -1;
    }

    //task 2
    public static int nthOddElement(int[] arr, int element)
    {
        int counter = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] % 2 != 0)
            {
                counter++;
            }
            if(counter == element)
                return arr[i];
        }
        return -1;
    }

    //task 3
    public static boolean isPalindrome(String str)
    {
        int strLen = str.length();

        for(int i = 0, j = strLen - 1; i < strLen / 2; i++, j--)
        {
            if(str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }

    //task4
    public static void printStars(int rows)
    {
        int counter = 1;
        while(counter <= rows)
        {
            int count = 0;
            while(count < counter)
            {
                System.out.print("* ");
                count++;
            }
            System.out.print('\n');
            counter++;
        }
    }
    // ако искаме даден метод да не се override трябва да го напишем final

    public static void main(String[] args) {

        System.out.println(factorial(5));

        int[] arr = {1, 2, 3, 4, 5};
        int element = 2;
        System.out.println(indexFirstOccurrence(arr, element));

        int[] arrNthOddElement = {5, 3, 8, 1, 9};
        int nthOddElem = 4;
        System.out.println(nthOddElement(arrNthOddElement, nthOddElem));

        String str = "abcba";
        String str2 = "abvvba";
        String str3 = "abcce";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome(str2));
        System.out.println(isPalindrome(str3));

        printStars(5);

        //task 8
        Car lada = new Car("Lada", "5", 75, 1989);
        System.out.println(lada.insuranceValue());

        Car mercedes = new Car("Mercedes-Benz", "S220", 160, 2009);
        System.out.println(mercedes.insuranceValue());

        //task 9
        Scanner scanner = new Scanner(System.in);
        int year1 = scanner.nextInt();
        int month1 = scanner.nextInt();
        int day1 = scanner.nextInt();
        FMIDate date1 = new FMIDate(year1, month1, day1);
        int year2 = scanner.nextInt();
        int month2 = scanner.nextInt();
        int day2 = scanner.nextInt();
        FMIDate date2 = new FMIDate(year2, month2, day2);
        System.out.println(date1.getDaysDifference(date2));
        date1.printInfo();
        date2.printInfo();

    }
}
