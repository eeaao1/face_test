package NEW;

import java.util.Stack;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：NEW
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2022/3/12 12:48
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class ReverseStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        printStack(stack);
        // reverse(stack);
        System.out.println("===============");
        for (int j = 0; j < stack.size(); j++) {
            for (int i = 1; i < stack.size() - j; i++) {
                reverse(stack, i);
            }
        }
        printStack(stack);
    }


    public static String reverse(Stack<String> stack, int i) {
        if (stack.size() == i) {
            return stack.pop();
        } else {
            String cur = stack.pop();
            String target = reverse(stack, i);
            stack.push(cur);
            if (stack.size() == i) {
                stack.push(target);
            }
        }
        return null;
    }

    public static void printStack(Stack<String> stack) {
        if (stack.empty()) {
            return;
        } else {
            String cur = stack.pop();
            System.out.println(cur);
            printStack(stack);
            stack.push(cur);
        }
    }

}
