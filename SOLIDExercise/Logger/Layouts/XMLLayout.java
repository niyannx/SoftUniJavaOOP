package SOLIDExercise.Logger.Layouts;

import SOLIDExercise.Logger.Loggers.MessageLogger;

public class XMLLayout implements Layout {

    @Override
    public String format(String timeStamp, MessageLogger.LogLevel level, String message) {

        return "<log>\n" +
                    "<date>" + timeStamp + "</date>\n" +
                    "<level>" + level + "</level>\n" +
                    "<message>" + message + "</message>\n" +
                "</log>\n";
    }
}
