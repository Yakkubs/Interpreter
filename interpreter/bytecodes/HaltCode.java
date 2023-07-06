package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class HaltCode implements ByteCode, notDumping {
    public HaltCode(String[] args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.vmSwitch();
    }
}
