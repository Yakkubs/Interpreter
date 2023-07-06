package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class Goto implements ByteCode,JumpCode {
    private String label;
    private int target;
    public Goto(String[] args) {
        this.label = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(target);
    }

    public void setTarget(int target) {
        this.target = target;
    }
    //made this just incase, dont think i need it for goto
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
