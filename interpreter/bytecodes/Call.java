package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class Call implements ByteCode,JumpCode {
    private String label;
    private int target;
    private String returnVal;
    public Call(String[] args) {
        this.label = args[1];
    }
    @Override
    public void execute(VirtualMachine vm) {
        vm.pushToAddressStack();
        vm.setProgramCounter(target);
        this.returnVal = vm.stringCurrentFrame();
    }
    public void setTarget (int target) {
        this.target = target;
    }
    public String getLabel() {
        return this.label;
    }
    public int getTarget() {
        return this.target;
    }
    @Override
    public String toString() {
        String base = "CALL " + this.label;
        String[] split = label.split("<");
        base += "\t"+split[0] + "(" + returnVal +")";
        return base;
    }
}
