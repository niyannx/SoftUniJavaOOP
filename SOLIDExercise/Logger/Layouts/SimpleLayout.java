package SOLIDExercise.Logger.Layouts;

import SOLIDExercise.Logger.Loggers.MessageLogger;

public class SimpleLayout implements Layout {
    @Override
    public String format(String timeStamp, MessageLogger.LogLevel level, String message) {
        return String.format("%s - %s - %s", timeStamp, level, message);
    }
}
