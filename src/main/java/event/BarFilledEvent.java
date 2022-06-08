package event;

import javafx.event.Event;
import javafx.event.EventType;

/**
 * 07/06/2022.
 *
 * @author Laurent Lamiral
 */


public class BarFilledEvent extends Event {


    public BarFilledEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }
}
