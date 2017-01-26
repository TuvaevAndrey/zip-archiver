package com;

import com.exception.WrongZipFileException;

import java.io.IOException;


public class Archiver {
    public static void main(String[] args) throws IOException {
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("You haven't chosen archive file or file was wrong.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Error has occurred. Check the entered data.");
            }

        } while (operation != Operation.EXIT);

    }


    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("Сhoose operation:");
        ConsoleHelper.writeMessage(String.format("\t %d - pack files", Operation.CREATE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - add files to archive", Operation.ADD.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - delete file from archive", Operation.REMOVE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - unpack archive", Operation.EXTRACT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - view content", Operation.CONTENT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - exit", Operation.EXIT.ordinal()));

        return Operation.values()[ConsoleHelper.readInt()];
    }
}