package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class Label implements ByteCode {
    private String label;
    public Label(String[] args) {
        this.label = args[1];
    }
    public String getLabel(){
        return this.label;
    }
    @Override
    public void execute(VirtualMachine vm) {

    }
    @Override
    public String toString() {
        return "LABEL " + this.label;
    }
}
