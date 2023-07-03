package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RunTimeStack{

    private List<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial frame pointer value, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    public String dump() {
        String dumpVal = "";
        if (!framePointer.isEmpty()) {
            for (int i = 0; i < framePointer.size() - 1; i++) {
                int start = framePointer.get(i);
                int end = framePointer.get(i + 1);

                dumpVal += "[";
                for (int j = start; j < end; j++) {
                    dumpVal += runTimeStack.get(j);
                    if (j != end - 1) {
                        dumpVal += ",";
                    }
                }
                dumpVal += "] ";
            }
            int lastIndex = framePointer.size() - 1;
            int lastStart = framePointer.get(lastIndex);
            dumpVal += "[";
            for (int j = lastStart; j < runTimeStack.size(); j++) {
                dumpVal += runTimeStack.get(j);
                if (j != runTimeStack.size() - 1) {
                    dumpVal += ",";
                }
            }
            dumpVal += "] ";
        }
        return dumpVal;
    }
    public int peek(){
        return this.runTimeStack.get(this.runTimeStack.size()-1);
    }
    public int push(int value){
        this.runTimeStack.add(value);
        return value;
    }
    public int pop(){
        return this.runTimeStack.remove(this.runTimeStack.size()-1);
    }
    public int store ( int offsetFromFramePointer ) {
        int val = pop();
        runTimeStack.set(offsetFromFramePointer + framePointer.peek(), val);
        return val;
    }
    public int load( int offsetFromFramePointer ){
        int loadValue = runTimeStack.get(offsetFromFramePointer+ framePointer.peek());
        runTimeStack.add(loadValue);
        return loadValue;
    }
    public void newFrameAt(int offsetFromTopOfRunStack){
        framePointer.push(runTimeStack.size()-offsetFromTopOfRunStack);
    }
    public void popFrame(){
        int val = pop();
        while(runTimeStack.size() > framePointer.peek()){
            pop();
        }
        framePointer.pop();
        runTimeStack.add(val);
    }
    public static void main(String[] args) {
        RunTimeStack rs = new RunTimeStack();
        rs.push(1);
        rs.push(2);
        rs.push(3);
        rs.newFrameAt(0);
        rs.push(4);
        rs.push(5);
        rs.push(6);
        rs.newFrameAt(0);
        rs.push(7);
        rs.push(8);
        System.out.println(rs.dump());
    }

    public int currentFrameSize() {
        return runTimeStack.size() - framePointer.peek();
    }
}
