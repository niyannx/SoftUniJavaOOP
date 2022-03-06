package WorkingWithAbstractionExercise.TrafficLights;

public enum Colors {
    RED("GREEN"),
    GREEN("YELLOW"),
    YELLOW("RED");

    private String name;

    Colors(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
