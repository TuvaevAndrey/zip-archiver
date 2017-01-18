package com.command;

import com.ConsoleHelper;
import com.ZipFileManager;
import com.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Unpacking the archive.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Input path for unpacking:");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(destinationPath);

            ConsoleHelper.writeMessage("Archive has been unpacked.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Wrong path.");
        }
    }
}
