package SOLIDExercise.Logger.Appenders;

import SOLIDExercise.Logger.Layouts.Layout;
import SOLIDExercise.Logger.Loggers.MessageLogger;

public abstract class BaseAppender implements Appender {
    protected Layout layout;
    protected int counter;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
    }

    public Layout getLayout() {
        return layout;
    }

    public int getMessagesCount() {
        return counter;
    }
}
