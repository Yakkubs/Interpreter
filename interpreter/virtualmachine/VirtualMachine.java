package interpreter.virtualmachine;

import interpreter.bytecodes.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean        dumpStatus;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
    }

    public void executeProgram() {
        isRunning = true;
        while(isRunning){
            ByteCode code = Program.getCode(programCounter);
            code.execute(this);
            programCounter++;
        }
    }

    public void push(int valueToPush) {
        this.runTimeStack.push(valueToPush);
    }

    public void vmSwitch(){
        this.isRunning = !this.isRunning;
    }

    public int pop() {
        return this.runTimeStack.pop();
    }

    public int currentFrameSize() {
        return this.runTimeStack.currentFrameSize();
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public int store(int offset) {
        return this.runTimeStack.store(offset);
    }

    public void load(int offset) {
        this.runTimeStack.load(offset);
    }

    public void newFrameAt(int numOfArgs) {
        this.runTimeStack.newFrameAt(numOfArgs);
    }

    public void pushPC() {
        this.runTimeStack.push(programCounter);
    }

    public void popFrame() {
        this.runTimeStack.popFrame();
    }

    public int popReturnAddress() {
        return this.returnAddress.pop();
    }

    public void dumpState(String state) {
        if(state.equals("ON")){
            this.dumpStatus = true;
        }else if(state.equals("OFF")){
            this.dumpStatus = false;
        }
    }
}
