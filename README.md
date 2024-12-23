# Gym Management System

## Overview
The Gym Management System is a Java-based project that simulates the operations of a gym. The system is designed with key software design patterns and robust error handling mechanisms to ensure smooth management of the gym's activities.

### Key Features
1. **Singleton Pattern**: Ensures only one instance of the gym exists throughout the application.
2. **Proxy Pattern**: Manages a single secretary who performs gym operations. Permissions of the current secretary are blocked upon replacement.
3. **Factory Pattern**: Used for creating new sessions.
4. **Observer Pattern**: Implements the notification system for clients, allowing the secretary to send messages effectively.
5. **Logger**: Tracks and logs all actions performed by the secretary.

### Secretary Actions
The secretary can perform the following actions:
- **Register New Clients**: Add new members to the gym.
- **Unregister Clients**: Remove members from the gym.
- **Create New Session**: Schedule new training sessions using a factory.
- **Register Client to a Session**: Enroll members in specific sessions.
- **Hire Instructor**: Add new instructors to the gym.
- **Pay Salaries**: Process payments for gym staff.
- **Print Gym Logs**: Display the history of all actions performed.
- **Send Messages to Clients**: Notify clients based on:
  - All members.
  - Members of a specific session.
  - Members registered for a session on a specific date.

### Exceptions
The system handles various edge cases and errors using custom exceptions:
1. **InvalidAgeException**: Thrown when attempting to register a client under 18 years old.
2. **DuplicateClientException**: Thrown when trying to register a client who is already registered to the gym or a session.
3. **InstructorNotQualifiedException**: Thrown when an instructor is not qualified to lead a specific session type.
4. **ClientNotRegisteredException**: Thrown when a non-registered client attempts to join a session.

## Getting Started
### Prerequisites
- Java Development Kit (JDK) 8 or higher.
- IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).

### Installation
1. Clone the repository:
   ```bash
   git clone <(https://github.com/itaysegev1/Fitness-Studio/tree/main/src)>
2. Open the project in your preferred IDE.
    ```bash
3. Build and run the project.
    ```bash

### Usage
1. Initialize the gym using the Singleton pattern.
2. Appoint a secretary via the Proxy pattern.
3. Use the provided methods to perform actions such as client registration, session management, and more.
4. Check the logs for a record of all actions performed.

### Design Pattern
* Singleton : Ensures a single instance of the gym is maintained.
* Proxy : Controls access to the secretary and manages permissions.
* Factory : Simplifies the creation of new gym sessions.
* Observer : Facilitates the notification system for clients.
* Logger : Controls of written the gym logger

### Error Handling
    The system includes comprehensive error handling with descriptive exceptions to ensure smooth operation 
    and some errors that can be made and not handled by exception, written to the gym logger

### Contributes
    - Itay Segev
    - Salome Timsit
