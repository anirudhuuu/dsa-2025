package realdsa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Find Year
 * =========
 * Given a value, find if it exists in any year and month. If yes, return the year.
 *
 * You have a folder structure like `data/<year>/<month>.txt`.
 * Each file contains a line: `[[Number of people: <value>]]`.
 *
 * Example: In `data/8879/August.txt`, the value might be `47359253`.
 *
 * Rules
 * - In each year, each month's number is bigger than the previous month.
 * - Each year is bigger than the previous year.
 * - Every year has all 12 months.
 * - Years are consecutive.
 *
 * Time Complexity: O(log Y)
 * where Y is the number of years
 */
public class FindYear {
    private List<Integer> years;
    private String[] months;

    public FindYear() {
        this.years = new ArrayList<>();

        this.months = new String[]{
                "January.txt",
                "February.txt",
                "March.txt",
                "April.txt",
                "May.txt",
                "June.txt",
                "July.txt",
                "August.txt",
                "September.txt",
                "October.txt",
                "November.txt",
                "December.txt",
        };
    }

    // to get the list of all years from the data folder
    void getListOfAllYears() {
        // from data folder, get all the years
        File dataFolder = new File("data");

        // check if folder is present and read all the files in dir
        if (dataFolder.exists() && dataFolder.isDirectory()) {
            File[] files = dataFolder.listFiles();
            for (File file : files) {
                if (file.isDirectory() && file.getName().matches("\\d+")) {
                    years.add(Integer.parseInt(file.getName()));
                }
            }
        }

        // sort the years in ascending order
        Collections.sort(years);
    }

    // to find the population value in the year from January.txt file
    long getFirstMonthValue(int year) {
        // read December.txt file in the year folder
        File januaryFile = new File("data/" + year + "/January.txt");

        if (!januaryFile.exists()) {
            return -1;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(januaryFile))) {
            String line;

            // read all lines of the file
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("Number of people")) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(line);

                    if (matcher.find())
                        return Long.parseLong(matcher.group());
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading January.txt file: " + e.getMessage());
        }

        return -1;
    }

    // to find the population value in the year from December.txt file
    long getLastMonthValue(int year) {
        // read December.txt file in the year folder
        File decemberFile = new File("data/" + year + "/December.txt");

        if (!decemberFile.exists()) {
            return -1;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(decemberFile))) {
            String line;

            // read all lines of the file
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("Number of people")) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(line);

                    if (matcher.find())
                        return Long.parseLong(matcher.group());
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading December.txt file: " + e.getMessage());
        }

        return -1;
    }

    // to find the population value in the year from the given month file
    long getMonthValue(int year, String month) {
        // read month file in the year folder
        File monthFile = new File("data/" + year + "/" + month);

        if (!monthFile.exists()) {
            return -1;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(monthFile))) {
            String line;

            // read all lines of the file
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("Number of people")) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(line);

                    if (matcher.find())
                        return Long.parseLong(matcher.group());
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading " + month + " file: " + e.getMessage());
        }

        return -1;
    }

    int findYear(long targetValue) {
        // perform binary search on the years list
        int low = 0;
        int high = years.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int year = years.get(mid);

            long firstMonthPopulation = getFirstMonthValue(year);
            long lastMonthPopulation = getLastMonthValue(year);

            if (targetValue < firstMonthPopulation) {
                high = mid - 1;
            } else if (targetValue > lastMonthPopulation) {
                low = mid + 1;
            } else {
                return year;
            }
        }

        return -1;
    }

    int findYearForValue(long targetValue) {
        int year = findYear(targetValue);

        if (year == -1) {
            return -1;
        }

        for (String month : months) {
            long monthValue = getMonthValue(year, month);

            if (monthValue == targetValue) {
                return year;
            }
        }

        return -1;
    }

    static void main() {
        FindYear findYear = new FindYear();

        // load the list of all years present in the data folder
        findYear.getListOfAllYears();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the target value: ");
        long targetValue = scanner.nextLong();
        scanner.close();

        System.out.println("Year in which " + targetValue + " exists: " + findYear.findYearForValue(targetValue));
    }
}
