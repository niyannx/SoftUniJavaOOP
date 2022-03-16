package SOLIDExercise.Logger.Appenders;

import SOLIDExercise.Logger.Layouts.Layout;
import SOLIDExercise.Logger.Loggers.MessageLogger;
import SOLIDExercise.Logger.Utilities.File;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout, File file) {
        super(layout);
        this.file = file;
    }

    @Override
    public void append(String timeStamp, MessageLogger.LogLevel level, String message) {
        file.write(layout.format(timeStamp, level, message));
        counter++;
    }

    public File getFile() {
        return file;
    }
}
