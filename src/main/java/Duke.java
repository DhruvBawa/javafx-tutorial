/**
 * Generates responses for the Duke chatbot.
 */
public class Duke {
    private String commandType;

    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    /**
     * Generates a response for the user's chat message.
     *
     * @param input The user's input.
     * @return Duke's response.
     */
    public String getResponse(String input) {
        commandType = identifyCommandType(input);
        return "Duke heard: " + input;
    }

    /**
     * Returns the type of the most recently processed command.
     */
    public String getCommandType() {
        return commandType;
    }

    /**
     * Identifies the command type represented by the supplied input.
     *
     * @param input The user's input.
     * @return The command type, or an empty string for commands without a custom style.
     */
    private String identifyCommandType(String input) {
        String commandWord = input.strip().split("\\s+", 2)[0];
        return switch (commandWord) {
            case "todo", "deadline", "event" -> "AddCommand";
            case "mark" -> "MarkCommand";
            case "delete" -> "DeleteCommand";
            default -> "";
        };
    }
}
