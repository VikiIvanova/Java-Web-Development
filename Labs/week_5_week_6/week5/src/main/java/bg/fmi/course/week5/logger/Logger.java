package bg.fmi.course.week5.logger;

public interface Logger {
    void info(Object toLog);

    void debug(Object toLog);

    void trace(Object toLog);

    void error(Object toLog);
}
