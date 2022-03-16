package SOLIDExercise.Logger.Utilities;

public class LogFile implements File {
    private StringBuilder memory;

    public LogFile() {
        memory = new StringBuilder();
    }

    @Override
    public void write(String line) {
        memory.append(line).append(System.lineSeparator());
    }

    @Override
    public int size() {
        return memory.chars().filter(Character::isAlphabetic).sum();
    }
}
