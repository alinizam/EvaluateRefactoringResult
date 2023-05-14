/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluaterefactoringresult;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//import com.google.common.io.Files;

/**
 *
 * @author ali.nizam
 */
public class CodeFileVisitor implements FileVisitor<Path> {
    
  
    ArrayList<String> dirInfo;
    StringBuilder fileInfos=new StringBuilder();
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        dirInfo=new ArrayList<>();
        dirInfo.add(dir.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file);
        if (Files.isRegularFile(file)) {
            String extention=com.google.common.io.Files.getFileExtension(file.toString());
            if (extention.equals("txt")){
                Scanner s=new Scanner(file);
                int changeCount=s.nextInt();
                dirInfo.add(changeCount+"");
            }
           if (extention.equals("java")){
                String fileName=com.google.common.io.Files.getNameWithoutExtension(file.toString());
                System.out.println("---"+fileName);
                if (fileName.endsWith("_PE")){
                    dirInfo.add(fileName);
                }
            }
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println(exc);
        return FileVisitResult.TERMINATE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if (dir.getName(dir.getNameCount()-1).toString().matches("\\d+")){
            fileInfos.append(dirInfo.toString()).append("\n");
        }
        return FileVisitResult.CONTINUE;
    }

}
