package org.example;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import org.slf4j.MDC;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogbackLayout extends LayoutBase<ILoggingEvent> {

    public String doLayout(ILoggingEvent event) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now()) + " // " +  MDC.get("id") +
                " - <" + MDC.get("tag") + ">" + event.getFormattedMessage() + "</" + MDC.get("tag") + ">" +
                CoreConstants.LINE_SEPARATOR;
    }
}
