package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class Dump implements ByteCode,notDumping {
    private String state;
    public Dump(String[] args) {
        this.state = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.dumpState(this.state);
    }
}
