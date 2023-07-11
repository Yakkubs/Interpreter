package interpreter.virtualmachine;

import interpreter.bytecodes.ByteCode;
import interpreter.bytecodes.notDumping;

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
            ByteCode code = this.program.getCode(programCounter);
            code.execute(this);
            if(this.dumpStatus && !(code instanceof notDumping)){
                System.out.println(code);
                System.out.println(this.runTimeStack.dump());
            }
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

    public void pushToAddressStack() {
        this.returnAddress.push(programCounter);
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

    public int peek() {
        return this.runTimeStack.peek();
    }

    public String stringCurrentFrame() {
        return this.runTimeStack.stringCurrentFrame();
    }
}
