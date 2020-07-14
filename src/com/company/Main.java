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

    private static void calculatePregnancyWeek(LocalDate dateBefore, LocalDate dateAfter) {

        long weeksBetween = ChronoUnit.WEEKS.between(dateBefore, dateAfter);
        long pregnancyWeek = (weeksBetween + 1);
        System.out.println(pregnancyWeek + " tydzień");
    }

    private static void calculatePrengancyMonth(LocalDate dateBefore, LocalDate dateAfter) {

        Period period = Period.between(dateBefore, dateAfter);
        int pregnancyMonth = (period.getMonths() + 1);
        System.out.println(pregnancyMonth + " miesiąc");
    }

    private static void calculatePrengancyTrimestr(LocalDate dateBefore, LocalDate dateAfter) {

        Period period = Period.between(dateBefore, dateAfter);
        int pregnancyMonth = (period.getMonths() + 1);
        if (pregnancyMonth < 4) {
            int pregnancyTrimestr = 1;
            System.out.println(pregnancyTrimestr + " trymestr");
        } else if (pregnancyMonth >= 4 && pregnancyMonth < 7) {
            int pregnancyTrimestr = 2;
            System.out.println(pregnancyTrimestr + " trymestr");
        } else if (pregnancyMonth >= 7) {
            int pregnancyTrimestr = 3;
            System.out.println(pregnancyTrimestr + " trymestr");
        }
    }

    private static void calculateDateOfDelivery(LocalDate firstDayOfTheLastMenstrual) {

        LocalDate dateOfDelivery = firstDayOfTheLastMenstrual.plusDays(280);
        System.out.println("Twój orientacyjny termin porodu to: " + dateOfDelivery + " " + dateOfDelivery.getDayOfWeek());
    }

}
