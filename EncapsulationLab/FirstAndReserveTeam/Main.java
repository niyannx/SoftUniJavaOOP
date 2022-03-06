package EncapsulationLab.FirstAndReserveTeam;

/*
Create a Team class. Add to this team all people you read. All people younger than 40 go on the first team, others go
on the reverse team. At the end print first and reserve team sizes.
The class should have private fields for:
 name: String
 firstTeam: List&lt;Person&gt;
 reserveTeam: List&lt;Person&gt;
The class should have constructors:
 Team(String name)
The class should also have private method for setName and public methods for:

getName(): String
 addPlayer(Person person): void
 getFirstTeam(): List&lt;Person&gt; (Collections.unmodifiableList)
 getReserveTeam(): List&lt;Person&gt; (Collections.unmodifiableList)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Team team = new Team("Black Eagles");

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] input = reader.readLine().split("\\s+");

            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            Person person = new Person(firstName, lastName, age, salary);
            team.addPlayer(person);
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}
