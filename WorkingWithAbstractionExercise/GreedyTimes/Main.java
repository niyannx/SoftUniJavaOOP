
package WorkingWithAbstractionExercise.GreedyTimes;

/*
Finally, you have unlocked the safe and reached the treasure! Inside there are all kinds of gems, cash in different
currencies, and gold. Next to you, there is a bag which unfortunately has limited space. You don’t have
much time, so you need to take as much wealth as possible! But to get a bigger amount of the most valuable items,
you need to keep the following rules:
 The gold amount in your bag should always be more than or equal to the gem amount at any time
 The gem amount should always be more than or equal to the cash amount at any time
If you read an item that breaks one of these rules you should not put it in the bag. You should always be careful
not to exceed the overall bag’s capacity because it will tear down, and you will lose everything! You will receive the
content of the safe on a single line in the format "{item} {quantity}" pairs, separated by whitespace. You
need to gather only three types of items:
 Cash - All three letter items
 Gem - All items which end on "Gem" (at least 4 symbols)
 Gold - this type has only one item with the name - "Gold"
Each item that does not fall in one of the above categories is useless, and you should skip it. Reading item’s
names should be CASE-INSENSITIVE, except when the item is Cash. You should aggregate items’ quantities that
have the same name.
If you’ve kept the rules you should escape successfully with a bag full of wealth. Now it’s time to review what
you have managed to get out of the safe. Print all the types ordered by the total amount in descending order.
Inside a type, order the items first alphabetically in descending order and then by their amount in ascending order.
Use the format described below for each type.
 */

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<String, LinkedHashMap<String, Long>> bag;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        bag = new LinkedHashMap<>();

        long entrance = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long count = Long.parseLong(safe[i + 1]);

            String item = getItem(name);

            if (item.equals("")) {
                continue;
            } else if (entrance < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count) {
                continue;
            }

            switch (item) {
                case "Gem":
                    if (!bag.containsKey(item)) {
                        if (bag.containsKey("Gold")) {
                            if (count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(item).values().stream().mapToLong(e -> e).sum() + count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(item)) {
                        if (bag.containsKey("Gem")) {
                            if (count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(item).values().stream().mapToLong(e -> e).sum() + count > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(item)) {
                bag.put((item), new LinkedHashMap<>());
            }

            if (!bag.get(item).containsKey(name)) {
                bag.get(item).put(name, 0L);
            }

            bag.get(item).put(name, bag.get(item).get(name) + count);

        }

        printOutput();
    }

    public static void printOutput() {
        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", x.getKey(), sumValues);

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        }
    }

    public static String getItem(String name) {

        String item = "";

        if (name.length() == 3) {
            item = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            item = "Gem";
        } else if (name.equalsIgnoreCase("gold")) {
            item = "Gold";
        }

        return item;
    }
}