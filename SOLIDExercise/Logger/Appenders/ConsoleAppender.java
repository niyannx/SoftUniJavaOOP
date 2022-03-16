package SOLIDExercise.Logger.Appenders;

import SOLIDExercise.Logger.Layouts.Layout;
import SOLIDExercise.Logger.Loggers.MessageLogger;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String timeStamp, MessageLogger.LogLevel level, String message) {
        System.out.println(layout.format(timeStamp, level, message));
        counter++;
    }
}
