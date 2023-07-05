package interpreter.virtualmachine;

import interpreter.bytecodes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Program {

    private List<ByteCode> program;
    private HashMap<String, Integer> addressLocations = new HashMap<>();

    /**
     * Instantiates a program object using an
     * ArrayList
     */
    public Program() {
        program = new ArrayList<>();

    }

    /**
     * Gets the size of the current program.
     * @return size of program
     */
    public int getSize() {
        return this.program.size();
    }

    /**
     * Grabs an instance of a bytecode at an index.
     * @param programCounter index of bytecode to get.
     * @return a bytecode.
     */
    public ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    /**
     * Adds a bytecode instance to the Program List.
     * @param c bytecode to be added
     */
    public void addByteCode(ByteCode c) {
        //checking id byteCode is a label, if so we put it into the hashMap
        if(c instanceof Label lc){
            addressLocations.put(lc.getLabel(),this.program.size());

        }
        this.program.add(c);
    }

    /**
     * Makes multiple passes through the program ArrayList resolving
     * addrss for Goto,Call and FalseBranch bytecodes. These bytecodes
     * can only jump to Label codes that have a matching label value.
     * HINT: make note of what type of data-structure ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CAHNGED *****
     */
    public void resolveAddress() {
        for(int i = 0; i < this.program.size(); i++){
            ByteCode bc = this.program.get(i);
            if(bc instanceof Goto gc){
                gc.setTarget(addressLocations.get(gc.getLabel()));
            }else if(bc instanceof Call cc){
                cc.setTarget(addressLocations.get(cc.getLabelName()));
            }else if(bc instanceof FalseBranch fbc){
                fbc.setTarget(addressLocations.get(fbc.getLabel()));
            }
        }
    }
}