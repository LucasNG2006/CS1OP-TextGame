public interface GameEventListener {

    // Any class that listens for events must implement this method
    void onEvent(String eventType);
}
