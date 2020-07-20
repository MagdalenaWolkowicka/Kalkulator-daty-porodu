package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Podaj datę pierwszego dnia ostatniej miesiączki (yyyy-MM-dd)");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        LocalDate firstDayOfTheLastMenstrual = LocalDate.parse(date);

        calculatePregnancyWeek(firstDayOfTheLastMenstrual, LocalDate.now());
        calculatePrengancyMonth(firstDayOfTheLastMenstrual, LocalDate.now());
        calculatePrengancyTrimestr(firstDayOfTheLastMenstrual, LocalDate.now());
        calculateDateOfDelivery(firstDayOfTheLastMenstrual);
        System.out.println("Gratulacje!");
    }

    private static void calculatePregnancyWeek(LocalDate firstDayOfTheLastMenstrual, LocalDate currentDate) {

        long weeksBetween = ChronoUnit.WEEKS.between(firstDayOfTheLastMenstrual, currentDate);
        long pregnancyWeek = (weeksBetween + 1);
        System.out.println(pregnancyWeek + " tydzień");
    }

    private static void calculatePrengancyMonth(LocalDate firstDayOfTheLastMenstrual, LocalDate currentDate) {

        Period period = Period.between(firstDayOfTheLastMenstrual, currentDate);
        int pregnancyMonth = (period.getMonths() + 1);
        System.out.println(pregnancyMonth + " miesiąc");
    }

    private static void calculatePrengancyTrimestr(LocalDate firstDayOfTheLastMenstrual, LocalDate currentDate) {

        Period period = Period.between(firstDayOfTheLastMenstrual, currentDate);
        int pregnancyMonth = (period.getMonths() + 1);
        if (pregnancyMonth < 4) {
            System.out.println("1 trymestr");
        } else if (pregnancyMonth >= 4 && pregnancyMonth < 7) {
            System.out.println("2 trymestr");
        } else {
            System.out.println("3 trymestr");
        }
    }

    private static void calculateDateOfDelivery(LocalDate firstDayOfTheLastMenstrual) {

        LocalDate dateOfDelivery = firstDayOfTheLastMenstrual.plusDays(280);
        System.out.println("Twój orientacyjny termin porodu to: " + dateOfDelivery + " " + dateOfDelivery.getDayOfWeek());
    }

}
