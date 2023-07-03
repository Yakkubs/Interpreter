package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class Args implements ByteCode {
    private int numOfArgs;
    public Args(String[] args) {
        this.numOfArgs = Integer.parseInt(args[1]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(numOfArgs);
    }
    @Override
    public String toString(){
        return "ARGS " + numOfArgs;
    }
}
