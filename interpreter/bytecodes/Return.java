package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class Return implements ByteCode {
    private String label;

    public Return(String[] args) {
        //in case of no arguments
        if(args.length == 2){
            this.label = args[1];
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.popFrame();
        vm.setProgramCounter(vm.popReturnAddress());
    }

    @Override
    public String toString() {
        String base = "RETURN";
        if(label != null){
            base += " " + label;
        }
        return base;
    }
}
