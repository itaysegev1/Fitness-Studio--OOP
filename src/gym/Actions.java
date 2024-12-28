package gym;

/**
 * A class that not visible to the main class and protected from creating new instances of
 * clients, instructors, sessions and reistering clients to sessions
 */
public enum Actions {
    create_client, create_instructor, create_session, register_client_to_session
}
