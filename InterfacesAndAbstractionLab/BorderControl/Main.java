package InterfacesAndAbstractionLab.BorderControl;

/*
It’s the future, you’re the ruler of a totalitarian dystopian society inhabited by citizens and robots, since you’re
afraid of rebellions you decide to implement strict control of who enters your city. Your soldiers check the Ids of
everyone who enters and leaves.
You will receive from the console an unknown amount of lines until the command "End" is received, on each line,
there will be the information for either a citizen or a robot who tries to enter your city in the format
"{name} {age} {id}" for citizens and "{model} {id}" for robots.
After the end command on the next line, you will receive a single number representing the last digits of fake ids, all
citizens or robots whose ID ends with the specified digits must be detained.
The output of your program should consist of all detained Ids each on a separate line (the order of printing doesn't
matter).
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Identifiable> citizensAndRobots = new ArrayList<>();

        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split("\\s+");

            Identifiable identifiable;

            if (commands.length == 2) {
                String model = commands[0];
                String id = commands[1];

                identifiable = new Robot(model, id);
            } else {
                String name = commands[0];
                int age = Integer.parseInt(commands[1]);
                String id = commands[2];

                identifiable = new Citizen(name, age, id);
            }

            citizensAndRobots.add(identifiable);

            input = scan.nextLine();
        }

        String fakeIDDigits = scan.nextLine();

        System.out.println(citizensAndRobots.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeIDDigits))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
