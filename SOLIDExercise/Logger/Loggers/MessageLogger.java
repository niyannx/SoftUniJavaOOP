package SOLIDExercise.Logger.Loggers;

import SOLIDExercise.Logger.Appenders.Appender;
import SOLIDExercise.Logger.Appenders.FileAppender;

import java.util.*;

public class MessageLogger implements Logger {
    public enum LogLevel {
        INFO,
        ERROR,
        WARNING,
        CRITICAL,
        FATAL
    }

    private Map<Appender, LogLevel> appendersWithLevels;

    public MessageLogger(Map<Appender, LogLevel> appendersWithLevels) {
        this.appendersWithLevels = appendersWithLevels;
    }

    @Override
    public void logError(String time, String message) {
        log(time, LogLevel.ERROR, message);
    }

    @Override
    public void logInfo(String time, String message) {
        log(time, LogLevel.INFO, message);
    }

    @Override
    public void logWarning(String time, String message) {
        log(time, LogLevel.WARNING, message);
    }

    @Override
    public void logCritical(String time, String message) {
        log(time, LogLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String time, String message) {
        log(time, LogLevel.FATAL, message);
    }

    private void log(String time, MessageLogger.LogLevel level, String message) {
        for (Map.Entry<Appender, LogLevel> entry : appendersWithLevels.entrySet()) {
            Appender appender = entry.getKey();
            LogLevel logLevel = entry.getValue();

            if (logLevel.ordinal() <= level.ordinal()) {
                appender.append(time, level, message);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("--- Logger info: ---").append(System.lineSeparator());

        for (Map.Entry<Appender, LogLevel> entry : appendersWithLevels.entrySet()) {
            Appender appender = entry.getKey();
            LogLevel level = entry.getValue();

            sb.append("Appender type: ").append(entry.getKey().getClass().getSimpleName()).append(", ")
                    .append("Layout type: ").append(appender.getLayout().getClass().getSimpleName()).append(", ")
                    .append("Report level: ").append(level.toString()).append(", ")
                    .append("Messages appended: ").append(appender.getMessagesCount()).append(", ");

            if (appender instanceof FileAppender) {
                sb.append("File size: ").append(((FileAppender) appender).getFile().size());
            }

            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
