package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class FalseBranch implements ByteCode,JumpCode {
    private String label;
    private int target;

    public FalseBranch(String[] args) {
        this.label = args[1];
    }
    @Override
    public void execute(VirtualMachine vm) {
        if(vm.pop() == 0){
            vm.setProgramCounter(target);
        }
    }
    public void setTarget(int target) {
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
        return "FALSEBRANCH " + this.label;
    }
}
