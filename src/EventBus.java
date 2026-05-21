import java.util.ArrayList;
import java.util.List;

public class EventBus {

    private List<GameEventListener> listeners = new ArrayList<>();

    // A class subscribes here to start receiving events
    public void subscribe(GameEventListener listener) {
        listeners.add(listener);
    }

    // When something happens, publish it — every subscriber is notified
    public void publish(String eventType) {
        for (GameEventListener listener : listeners) {
            listener.onEvent(eventType);
        }
    }
}
