package validators;

import data.CommandsData;

public class DataValidator {

    public boolean isValidate(String commandStr, Enum[] commandsData) {
        for (Enum command : commandsData) {
            if (command.name().equals(commandStr)) {
                return true;
            }
        }
        return false;
    }
}
