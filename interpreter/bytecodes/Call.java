package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class Call implements ByteCode {
    private String label;
    private int target;
    public Call(String[] args) {
        this.label = args[1];
    }
    @Override
    public void execute(VirtualMachine vm) {
        vm.pushPC();
        vm.setProgramCounter(target);
    }
    public void setTarget (int target) {
        this.target = target;
    }
    public String getLabelName() {
        return this.label;
    }
    public int getTarget() {
        return this.target;
    }
    @Override
    public String toString() {
        return "CALL " + this.label + "<<" + this.target + ">>";
    }
}
