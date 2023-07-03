package interpreter.loaders;

import interpreter.bytecodes.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class ByteCodeLoader {
    private String codSourceFileName;
    
    /**
     * Constructs ByteCodeLoader object given a COD source code
     * file name
     * @param fileName name of .cod File to load.
     */
    public ByteCodeLoader(String fileName){
        this.codSourceFileName = fileName;
    }
    
    /**
     * Loads a program from a .cod file.
     * @return a constructed Program Object.
     * @throws InvalidProgramException thrown when 
     * loadCodes fails.
     */
    public Program loadCodes() throws InvalidProgramException {
        Program program;
        try(BufferedReader reader = new BufferedReader(new FileReader(this.codSourceFileName))){
            String line;
            String[] items;
            String byteCodeName;
            ByteCode bc;
            program = new Program();
            for(line = reader.readLine(); reader.ready(); line= reader.readLine()){
                items = line.split("\\s+");
                byteCodeName = items[0];
                bc = ByteCode.getNewInstance(byteCodeName,items);
                program.addByteCode(bc);
            }
        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
       return program;
    }
}
