# Gym Management System
## Overview
The Gym Management System is a Java-based project that simulates the operations of a gym.
The system is designed with key software design patterns and error handling mechanisms to ensure smooth management of the gym's activities.
<br />
### Key Features
1. **<u>Singleton Pattern</u>**: Ensures only one instance of the gym exists throughout the application, ensure there is a single logger and ensure there us single data for the gym
2. **<u>Proxy Pattern</u>**: Manages a single secretary who performs gym operations. Permissions of the current secretary are blocked upon replacement.
3. **<u>Factory Pattern</u>**: Used for creating new sessions.
4. **<u>Observer Pattern</u>**: Implements the notification system for clients, allowing the secretary to send messages effectively.
5. **<u>Logger</u>**: Tracks and logs all actions performed by the secretary.
<br />
### Secretary Actions
The secretary can perform the following actions:
- **<u>Register New Clients</u>**: Add new members to the gym.
- **<u>Unregister Clients</u>**: Remove members from the gym.
- **<u>Create New Session</u>**: Schedule new training sessions using a factory.
- **<u>Register Client to a Session</u>**: Enroll members in specific sessions.
- **<u>Hire Instructor</u>**: Add new instructors to the gym.
- **<u>Pay Salaries</u>**: Process payments for gym staff.
- **<u>Print Gym Logs</u>**: Display the history of all actions performed.
- **<u>Send Messages to Clients</u>**: Notify clients based on:
  - All members.
  - Members of a specific session.
  - Members registered for a session on a specific date.
<br />
### Exceptions
The system handles various edge cases and errors using custom exceptions:
1. **<u>InvalidAgeException</u>**: Thrown when attempting to register a client under 18 years old.
2. **<u>DuplicateClientException</u>**: Thrown when trying to register a client who is already registered to the gym or a session.
3. **<u>InstructorNotQualifiedException</u>**: Thrown when an instructor is not qualified to lead a specific session type.
4. **<u>ClientNotRegisteredException</u>**: Thrown when a non-registered client attempts to join a session.
<br />
## Getting Started
### Prerequisites
- Java Development Kit (JDK) 8 or higher.
- IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).
- Linux, Silicon, Windows operating system
<br />
### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/itaysegev1/Fitness-Studio/tree/main/src
2. Open the project in your preferred IDE.
3. Build and run the project.
<br />
### Usage
1. Initialize the gym using the Singleton pattern.
2. Appoint a secretary via the Proxy pattern.
3. Use the provided methods to perform actions such as client registration, session management, and more.
4. Check the logs for a record of all actions performed.
<br />
### Design Pattern
* **<u>Singleton:</u>** Ensures a single instance of the gym and logger is maintained.
* **<u>Proxy:</u>** Controls access to the secretary and manages permissions.
* **<u>Factory:</u>** Simplifies the creation of new gym sessions.
* **<u>Observer:</u>** Facilitates the notification system for clients.
<br />
### Error Handling
  The system includes comprehensive error handling with descriptive exceptions to ensure smooth operation 
  and some errors that can be made and not handled by exception, written to the gym logger
<br />
## Contributes
  ### - Itay Segev
  ### - Salome Timsit
