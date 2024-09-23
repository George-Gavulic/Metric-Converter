import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        String startingUnit;
        String endingUnit;
        double unit;
        double continuedUnit;
        double commonConversion = 0.;
        double meterToFeet = 3.2808398950131233;

        while (running = true) {
            System.out.println("\n\n" + "I am your personal conversion calculator!" +"\u001B[0m");
            System.out.println("Please format your input as follows:");
            System.out.println("\u001B[31m" + "starting unit " + "\u001B[32m" + " [,]" + "\u001B[31m" + " amount of starting unit" + "\u001B[32m" + " [,] " + "\u001B[31m" + "desired conversion value." + "\u001B[0m");
            System.out.println("PLEASE EXCLUDE newlines, " + "\u001B[32m" + "example: kilometers,10,miles" + "\u001B[0m");
            System.out.println("Available units: kilometers, miles, meters, centimeters, yards, feet, inches, kelvin, celsius, fahrenheit");
            System.out.println("Type 'exit' to exit.");

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                running = false;
                break;
            }
            String[] parts = input.split(",");
            if (parts.length!= 3) {
                System.out.println("Invalid input, please try again.\n");
                continue;
            }
            startingUnit = parts[0].trim().toLowerCase();
            //System.out.println(startingUnit);
            unit = Double.parseDouble(parts[1].trim());
            //System.out.println(unit);
            endingUnit = parts[2].trim().toLowerCase();
            //System.out.println(endingUnit);


            //1 meter = 3.2808398950131233 feet
            //convert everything to a common unit for easier conversion
            if ((startingUnit.equalsIgnoreCase("kilometers"))||(startingUnit.equalsIgnoreCase("miles"))||
                (startingUnit.equalsIgnoreCase("kilometer"))||(startingUnit.equalsIgnoreCase("mile"))){
                if (startingUnit.equalsIgnoreCase("kilometers")||startingUnit.equalsIgnoreCase("kilometer")){
                    commonConversion = (unit * 1000 ) / meterToFeet;
                } else if (startingUnit.equalsIgnoreCase("miles")||startingUnit.equalsIgnoreCase("mile")){
                    commonConversion = unit / 5280;
                }
            } else if ((startingUnit.equalsIgnoreCase("meters"))||(startingUnit.equalsIgnoreCase("centimeters"))||
            (startingUnit.equalsIgnoreCase("yards"))||(startingUnit.equalsIgnoreCase("feet"))||
            (startingUnit.equalsIgnoreCase("inches"))||
            (startingUnit.equalsIgnoreCase("meter"))||(startingUnit.equalsIgnoreCase("centimeter"))||
            (startingUnit.equalsIgnoreCase("yard"))||(startingUnit.equalsIgnoreCase("inch"))){
                if (startingUnit.equalsIgnoreCase("meters")||startingUnit.equalsIgnoreCase("meter")){
                    commonConversion = unit / meterToFeet;
                } else if (startingUnit.equalsIgnoreCase("centimeters")||startingUnit.equalsIgnoreCase("centimeter")){
                    commonConversion = (unit * 100) / meterToFeet;
                } else if (startingUnit.equalsIgnoreCase("yards")||startingUnit.equalsIgnoreCase("yard")){
                    commonConversion = unit / 3;
                } else if (startingUnit.equalsIgnoreCase("feet")){
                    commonConversion = unit;
                } else if (startingUnit.equalsIgnoreCase("inches")||startingUnit.equalsIgnoreCase("inch")){
                    commonConversion = unit * 12;
                }
            } else if ((startingUnit.equalsIgnoreCase("kelvin"))||(startingUnit.equalsIgnoreCase("celsius"))||
            (startingUnit.equalsIgnoreCase("fahrenheit"))){
                if (startingUnit.equalsIgnoreCase("kelvin")){
                    commonConversion = unit + 273.15;
                } else if (startingUnit.equalsIgnoreCase("celsius")){
                    commonConversion = unit;
                } else if (startingUnit.equalsIgnoreCase("fahrenheit")){
                    commonConversion = (unit * 9/5) + 32;
                }
            } else {
                System.out.println("Invalid starting input, please check if you need to include an s, please try again.\n");
                continue;
            }


            //Convert from common factor to desired ending unit
            if ((endingUnit.equalsIgnoreCase("kilometers"))||(endingUnit.equalsIgnoreCase("miles"))||
                (endingUnit.equalsIgnoreCase("kilometer"))||(endingUnit.equalsIgnoreCase("mile"))){
                if (endingUnit.equalsIgnoreCase("kilometers")||endingUnit.equalsIgnoreCase("kilometer")){
                    continuedUnit = (commonConversion / 1000) * meterToFeet;
                    System.out.println(continuedUnit + " kilometers");
                } else if (endingUnit.equalsIgnoreCase("miles")||endingUnit.equalsIgnoreCase("mile")){
                    continuedUnit = commonConversion * 5280;
                    System.out.println(continuedUnit + " miles");
                }
            } else if ((endingUnit.equalsIgnoreCase("meters"))||(endingUnit.equalsIgnoreCase("centimeters"))||
            (endingUnit.equalsIgnoreCase("yards"))||(endingUnit.equalsIgnoreCase("feet"))||
            (endingUnit.equalsIgnoreCase("inchs"))||
            (endingUnit.equalsIgnoreCase("meter"))||(endingUnit.equalsIgnoreCase("centimeter"))||
            (endingUnit.equalsIgnoreCase("yard"))||
            (endingUnit.equalsIgnoreCase("inch"))){
                if (endingUnit.equalsIgnoreCase("meters")||endingUnit.equalsIgnoreCase("meter")){
                    continuedUnit = commonConversion * meterToFeet;
                    System.out.println(continuedUnit + " meters");
                } else if (endingUnit.equalsIgnoreCase("centimeters")||endingUnit.equalsIgnoreCase("centimeter")){
                    continuedUnit = (commonConversion * meterToFeet) / 100;
                    System.out.println(continuedUnit + " centimeters");
                } else if (endingUnit.equalsIgnoreCase("yards")||endingUnit.equalsIgnoreCase("yard")){
                    continuedUnit = commonConversion * 3;
                    System.out.println(continuedUnit + " yards");
                } else if (endingUnit.equalsIgnoreCase("feet")){
                    continuedUnit = commonConversion;
                    System.out.println(continuedUnit + " feet");
                } else if (endingUnit.equalsIgnoreCase("inches")||endingUnit.equalsIgnoreCase("inch")){
                    continuedUnit = commonConversion / 12;
                    System.out.println(continuedUnit + " inches");
                }
            
            } else if ((endingUnit.equalsIgnoreCase("kelvin"))||(endingUnit.equalsIgnoreCase("celsius"))){
                if (endingUnit.equalsIgnoreCase("kelvin")){
                    continuedUnit = commonConversion - 273.15;
                    System.out.println(continuedUnit + " degrees Kelvin");
                } else if (endingUnit.equalsIgnoreCase("celsius")){
                    continuedUnit = commonConversion;
                    System.out.println(continuedUnit + " degrees Celsius");
                } else if (endingUnit.equalsIgnoreCase("fahrenheit")){
                    continuedUnit = (commonConversion * 9/5) + 32;
                    System.out.println(continuedUnit + " degrees Fahrenheit");
                }
            } else {
                System.out.println("Invalid ending input, please try again.\n");
                continue;
            }

        }
        System.out.println("done! Goodbye! :)");
        scanner.close();
    }
}