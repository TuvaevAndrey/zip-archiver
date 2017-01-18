package com.command;

import com.ConsoleHelper;
import com.ZipFileManager;
import com.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Creating archive.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Input full file name or package name for compressing:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.createZip(sourcePath);

            ConsoleHelper.writeMessage("Archive has been created.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Wrong file or package.");
        }
    }
}
