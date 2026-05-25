import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Message {
    
    // Keep track of total message sent in this session
    private static int messageCount = 0;

    //Generate a unique message ID using current timestamp
    private static String generateMessageId() {
        return "MSG" + System.currentTimeMillis();
    }
// Creates a hash from message ID,count,and first/last words for quick identification
    private static String generateMessageHash(String messageId, int count, String message) {

        String[] words = message.trim().split("\\s+");

        String first = words.length > 0 ? words[0] : "";

        String last = words.length > 1 ? words[words.length - 1] : first;

        return messageId.substring(0, 2) + ":" + count + ":" +
                first.toUpperCase() + last.toUpperCase();
    }
//Display main menu and handles user input until user choose to quit
    public static void StartChat() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Welcome to Quick Chat");
            System.out.println("Select transaction:");
            System.out.println("Option 1 - Select Message");
            System.out.println("Option 2 - Send Message");
            System.out.println("Option 3 - Quit");
            System.out.print("Enter your choice (1,2,or 3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("You selected: Select Message");
                    System.out.println("This feature is coming soon, please stay tuned");

                    break;

                case 2:

                    System.out.println("You selected: Send Message");

                    String recipient;

                    //Validates South African number format:must start with +27 and be 12 characters
                    do {
                        System.out.println("Enter your number (must start with +27 and be exactly 12 characters):");
                        recipient = scanner.nextLine();

                    } while (!(recipient.startsWith("+27") && recipient.length() == 12));

                    System.out.print("Enter your Message (must be 250 characters or less): ");

                    String message = scanner.nextLine();

                    if (message.length() > 250) {

                        System.out.println("Please enter a Message of less than 250 characters.");
                        break;
                    }

                    String messageId = generateMessageId();

                    int currentMessageCount = ++messageCount;

                    String messageHash =
                            generateMessageHash(messageId, currentMessageCount, message);

                    System.out.println("Message Hash: " + messageHash);

                    System.out.println("Choose an option:");
                    System.out.println("Option 1 - Send Message");
                    System.out.println("Option 2 - Disregard Message");
                    System.out.println("Option 3 - Store Message to send later");

                    int subChoice = scanner.nextInt();

                    scanner.nextLine();

                    switch (subChoice) {

                        case 1:

                            System.out.println("Sending Message to " + recipient + "...");
                            System.out.println("Message sent successfully");

                            break;

                        case 2:

                            System.out.println("Message disregarded.");

                            break;

                        case 3:

                            System.out.println("Message stored to send later");

                            storeMessageToTextFile(
                                    messageId,
                                    recipient,
                                    message,
                                    messageHash
                            );

                            break;

                        default:

                            System.out.println("Invalid option. Message not processed");

                            break;
                    }

                    break;

                case 3:

                    System.out.println("Quitting Message. Goodbye!");

                    scanner.close();

                    return;

                default:

                    System.out.println("Invalid choice. Please enter 1,2,or 3");

                    break;
            }

            System.out.println();
        }
    }
//Saves message details to stored_message.txt file for later user
    private static void storeMessageToTextFile(
            String id,
            String recipient,
            String message,
            String hash
    ) {

        try (FileWriter file = new FileWriter("stored_message.txt", true)) {

            file.write("Message ID: " + id + "\n");
            file.write("Recipient: " + recipient + "\n");
            file.write("Message: " + message + "\n");
            file.write("Hash: " + hash + "\n");
            file.write("----\n");

            System.out.println("Message stored successfully in text file.");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}
