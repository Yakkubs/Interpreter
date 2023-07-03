package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class Pop implements ByteCode {
    private int numberOfPops;
    public Pop(String[] args) {
        this.numberOfPops = Integer.parseInt(args[1]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int popCount = this.numberOfPops;
        if(this.numberOfPops > vm.currentFrameSize()){
            popCount = vm.currentFrameSize();
        }
        while(popCount > 0){
            vm.pop();
        }
    }

    @Override
    public String toString() {
        return "POP " + this.numberOfPops;
    }
}
