/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.evaluaterefactoringresult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ali.nizam
 */
public class EvaluateRefactoringResult {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        CodeFileVisitor fileVisitor = new CodeFileVisitor();
        String filePath = "D:\\dataSetWRefactoring";
        CodeFileVisitor v=new CodeFileVisitor();
        Files.walkFileTree(Paths.get(filePath),v);
        
           try(FileWriter outputFile=new FileWriter("d:\\filename.txt")) { 
            
            outputFile.write(v.fileInfos.toString());
            
        } catch (IOException ex) {
            Logger.getLogger(CodeFileVisitor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    //not well supported
    void deleteWithRandomAccess() {
        /*RandomAccessFile raf = new RandomAccessFile(filePath, "r");
        while((s=raf.readLine())!=null){
            if (s.startsWith("package ")){
                long current_position = raf.getFilePointer();
            }
        }*/
    }
}
