package SOLIDExercise.Logger;

/*
Write a logging library for logging messages. The interface for the end-user should be as follows:

SAMPLE SOURCE CODE 1:
    Layout simpleLayout = new SimpleLayout();
    Appender consoleAppender = new ConsoleAppender(simpleLayout);
    Logger logger = new MessageLogger(consoleAppender);
    logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
    logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

Logger logs data and time (String) and a message (String).

LIBRARY ARCHITECTURE
    The library should have the following components:
         Layouts - define the format in which messages should be appended (e.g. SimpleLayout displays logs in the
        format "{date-time} – {report level} – {message}")
         Appenders - responsible for appending the messages somewhere (e.g. Console, File, etc.)
         Loggers - hold methods for various kinds of logging (warnings, errors, info, etc.)

    Whenever a logger is told to log something, it calls all of its appenders and tells them to append the message. In
    turn, the appenders append the message (e.g. to the console or a file) according to the layout they have.

REQUIREMENTS
    Your library should correctly follow all SOLID principles:
         Single Responsibility Principle - no class or method should do more than one thing at once
         Open-Closed Principle - the library should be open for extension (i.e. its user should be able to create his
        own layouts/appenders/loggers)
         Liskov Substitution Principle - children classes should not break the behavior of their parent
         Interface Segregation Principle - the library should provide simple interfaces for the client to implement
         Dependency Inversion - no class/method should directly depend on concretions (only on abstractions)
    Avoid code repetition. Name everything accordingly.

IMPLEMENTATIONS
    The library should provide the following ready classes for the client:
         SimpleLayout - defines the format "{date-time} – {report level} – {message}";
         ConsoleAppender - appends a log to the console using the provided layout
         FileAppender - appends a log to a file (You need to implement a CustomFile class) using
        the provided layout
         LogFile - a custom file class that logs messages in a string builder using a method write(). It should have a
        getter for its size which is the sum of the ASCII codes of all alphabet characters it contains (e.g. a-z and A-Z).
         Logger - a logger class that is used to log messages. Calls each of its appenders when something needs to be
        logged.

SAMPLE SOURCE CODE 2:
    Layout simpleLayout = new SimpleLayout();
    Appender consoleAppender = new ConsoleAppender(simpleLayout);
    File file = new LogFile();
    Appender fileAppender = new FileAppender(simpleLayout, file);
    Logger logger = new MessageLogger(consoleAppender, fileAppender);
    logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
    logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

The above code should log the messages both on the console and in LogFile in the format SimpleLayout provides.

REPORT THRESHOLD
    Implement a report level threshold in all appenders. The appender should append-only messages with report level
    above or equal to its report level threshold (by default all messages are appended). The report level is in the order
    Info > Warning > Error > Critical > Fatal.

FILE
    A file should write all messages internally, and it should keep information about its size.
    The size of a file is calculated by summing ASCII codes of all alphabet characters (a-Z). For example, a file appender
    with a simple layout and a single message "3/31/2015 5:33:07 PM - ERROR - Error parsing request" has size 2606
    (including all characters in PM, ERROR, Error, parsing, request). In the case of XML layout, the file would have size
    6632, because of the extra characters within the tags.

CONTROLLER
    Implement a Controller which reads all appenders that a Logger will have and input messages from the console.
    Every message should be evaluated by all the appenders and logged if they meet the report level. Console
    appenders should write directly on the console. File appenders write (save) the messages but do not print them.

INPUT
    On the first line, you will get N - the number of appenders. On the next N lines, you will get information about the
    appenders in one of the formats below:
         "{appender type} {layout type} {REPORT LEVEL}"
         "{appender type} {layout type}"

    If no report level is provided, the appender should be set to record all messages.
    If there is no report level, the value is INFO.
    Next, until you get the "END" command you will receive messages containing report level, time, and message
    separated by pipe "|":
         "{REPORT LEVEL}|{time}|{message}"

OUTPUT
    Console appenders should print directly at the console in the layout they are provided:
         Simple layout example - "3/31/2015 5:33:07 PM - ERROR - Error parsing request"
         Xml layout example (date, level and message tags are indented by 1 tabulation):
            <log>
                <date>3/31/2015 5:33:07 PM</date>
                <level>ERROR</level>
                <message>Error parsing request</message>
            </log>

    After the "END" command you should print Logger info which includes statistics about every appender (its type,
    layout, report level, messages appended, and file size for file appenders):
    "Logger info
    Appender type: {appender type}, Layout type: {layout type}, Report level: {REPORT LEVEL}, Messages appended: {count},
    File size: {size}"

EXAMPLE INPUT
    2
    ConsoleAppender SimpleLayout CRITICAL
    FileAppender XmlLayout
    INFO|3/26/2015 2:08:11 PM|Everything seems fine
    WARNING|3/26/2015 2:22:13 PM|Warning: ping is too high - disconnect imminent
    ERROR|3/26/2015 2:32:44 PM|Error parsing request
    CRITICAL|3/26/2015 2:38:01 PM|No connection string found in App.config
    FATAL|3/26/2015 2:39:19 PM|mscorlib.dll does not respond
    END

OUTPUT TO EXAMPLE
    3/26/2015 2:38:01 PM - CRITICAL - No connection string found in App.config
    3/26/2015 2:39:19 PM - FATAL - mscorlib.dll does not respond
    Logger info
    Appender type: ConsoleAppender, Layout type: SimpleLayout, Report level: CRITICAL, Messages appended: 2
    Appender type: FileAppender, Layout type: XmlLayout, Report level: INFO, Messages appended: 5, File size: 37526
*/

import SOLIDExercise.Logger.Appenders.Appender;
import SOLIDExercise.Logger.Appenders.ConsoleAppender;
import SOLIDExercise.Logger.Appenders.FileAppender;
import SOLIDExercise.Logger.Layouts.Layout;
import SOLIDExercise.Logger.Layouts.SimpleLayout;
import SOLIDExercise.Logger.Layouts.XMLLayout;
import SOLIDExercise.Logger.Loggers.Logger;
import SOLIDExercise.Logger.Loggers.MessageLogger;
import SOLIDExercise.Logger.Utilities.File;
import SOLIDExercise.Logger.Utilities.LogFile;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int appendersCount = Integer.parseInt(scan.nextLine());

        Map<Appender, MessageLogger.LogLevel> appenderLogLevelMap = new LinkedHashMap<>();

        while (appendersCount-- > 0) {
            String[] input = scan.nextLine().split("\\s+");

            // read data for appenders, layouts and log levels
            String appenderType = input[0];
            String layoutType = input[1];
            MessageLogger.LogLevel logLevel = input.length == 3 ? MessageLogger.LogLevel.valueOf(input[2]) : MessageLogger.LogLevel.INFO;

            // create layout and appender -> with readInformation
            Layout layout = createLayout(layoutType);
            Appender appender = createAppender(appenderType, layout);

            appenderLogLevelMap.put(appender, logLevel);
        }

        Logger logger = new MessageLogger(appenderLogLevelMap);

        String line = scan.nextLine();

        while (!line.equalsIgnoreCase("END")) {
            String[] input = line.split("\\|");

            MessageLogger.LogLevel logLevel = MessageLogger.LogLevel.valueOf(input[0]);

            String timeStamp = input[1];
            String message = input[2];

            switch (logLevel) {
                case INFO -> logger.logInfo(timeStamp, message);
                case ERROR -> logger.logError(timeStamp, message);
                case WARNING -> logger.logWarning(timeStamp, message);
                case CRITICAL -> logger.logCritical(timeStamp, message);
                case FATAL -> logger.logFatal(timeStamp, message);
            }

            line = scan.nextLine();
        }

        System.out.println(logger);
    }

    private static Appender createAppender(String appenderType, Layout layout) {
        return appenderType.equals("ConsoleAppender")
                ? new ConsoleAppender(layout) : new FileAppender(layout, new LogFile());
    }

    private static Layout createLayout(String layoutType) {
        return layoutType.equals("SimpleLayout")
                ? new SimpleLayout() : new XMLLayout();
    }
}
