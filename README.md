# Gym Management System

<img src="studio_img.png" width="600" alt="Login Screen"/>

## Overview
The Gym Management System is a Java-based project designed to simulate the operations of a gym. <br/>
It incorporates key software design patterns and robust error-handling mechanisms to ensure seamless management of gym activities.<br/>

## Key Features
1. **Singleton Pattern:**
    - Ensures only one instance of the gym exists throughout the application.
    - Maintains a single logger and centralized data for the gym.

2. **Proxy Pattern:**
    - Manages a single secretary responsible for gym operations.
    - Blocks permissions for the current secretary upon replacement.

3. **Factory Pattern:**
    - Simplifies the creation of new training sessions.

4. **Observer Pattern:**
    - Implements a notification system for clients, enabling efficient message distribution.

5. **Logger:**
    - Tracks and logs all actions performed by the secretary.

6. **Gym Data Management:**
    - Stores and maintains all gym-related data over time.

## Secretary Actions
The secretary can perform the following actions:
- **Register New Clients:** Add new members to the gym.
- **Unregister Clients:** Remove members from the gym.
- **Create New Session:** Schedule new training sessions using the Factory pattern.
- **Register Client to a Session:** Enroll members in specific sessions.
- **Hire Instructor:** Add new instructors to the gym.
- **Pay Salaries:** Process payments for gym staff.
- **Print Gym Logs:** Display the history of all actions performed.
- **Send Messages to Clients:** Notify clients based on:
    - All members.
    - Members of a specific session.
    - Members registered for a session on a specific date.

## Exceptions
The system handles various edge cases and errors using custom exceptions:
1. **InvalidAgeException:**
    - Thrown when attempting to register a client under 18 years old.

2. **DuplicateClientException:**
    - Thrown when trying to register a client who is already registered with the gym
    - Thrown when trying to register a client who is already registered to a session.

3. **InstructorNotQualifiedException:**
    - Thrown when an instructor is not qualified to lead a specific session type.

4. **ClientNotRegisteredException:**
    - Thrown when the secretary try to unregister an non-registered client
    - Thrown when a non-registered client attempts to join a session.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher.
- Integrated Development Environment (IDE), e.g., IntelliJ IDEA, Eclipse, or VS Code.
- Operating System: Linux, macOS (Silicon), or Windows.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/itaysegev1/Fitness-Studio/tree/main/src
   ```

2. Open the project in your preferred IDE.
3. Build and run the project.

### Usage
1. Initialize the gym using the Singleton pattern.
2. Appoint a secretary via the Proxy pattern.
3. Use the provided methods to perform actions such as client registration, session management, and more.
4. Check the logs for a record of all actions performed.

## Design Patterns
- **Singleton:**
    - Ensures a single instance of the gym and logger is maintained.

- **Proxy:**
    - Controls access to the secretary and manages permissions.

- **Factory:**
    - Simplifies the creation of new gym sessions.

- **Observer:**
    - Facilitates the notification system for clients.

## Error Handling
The system includes comprehensive error handling with descriptive exceptions to ensure smooth operation. Errors that are not explicitly handled by exceptions are logged in the gym logger for review.

## Contributors
- **Itay Segev**
- **Salome Timsit**

