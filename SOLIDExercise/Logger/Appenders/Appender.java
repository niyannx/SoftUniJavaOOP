package SOLIDExercise.Logger.Appenders;

import SOLIDExercise.Logger.Layouts.Layout;
import SOLIDExercise.Logger.Loggers.MessageLogger;

public interface Appender {
    void append(String timeStamp, MessageLogger.LogLevel level, String message);
    Layout getLayout();
    int getMessagesCount();
}
