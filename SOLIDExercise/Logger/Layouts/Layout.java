package SOLIDExercise.Logger.Layouts;

import SOLIDExercise.Logger.Loggers.MessageLogger;

public interface Layout {
    String format(String timeStamp, MessageLogger.LogLevel level, String message);
}
