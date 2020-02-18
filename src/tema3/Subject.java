package tema3;

/**
 * The interface Subject for the Observer design pattern.
 */
public interface Subject {
    /**
     * Register observer.
     *
     * @param observer the observer
     */
    void registerObserver(ITeam observer);

    /**
     * Notify observers.
     */
    void notifyObservers();
}
