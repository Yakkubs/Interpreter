package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class Goto implements ByteCode {
    private String label;
    private int target;
    public Goto(String[] args) {
        this.label = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(target);
    }

    public void setAddress(int target) {
        this.target = target;
    }
    public int getTarget() {
        return this.target;
    }
    public String getLabel() {
        return this.label;
    }
    @Override
    public String toString() {
        return "GOTO " + this.label;
    }
}
