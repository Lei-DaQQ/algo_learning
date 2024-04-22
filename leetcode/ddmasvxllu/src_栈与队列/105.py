class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        stack = []
        for token in tokens:
            if token in '+-*/':
                num2 = stack.pop()
                # 注意顺序
                num1 = stack.pop()
                if token == '+':
                    stack.append(num1+num2)
                elif token == '-':
                    stack.append(num1-num2)
                elif token == '*':
                    stack.append(num1*num2)
                elif token == '/':
                    stack.append(int(num1/num2))
            else:
                stack.append(int(token))
        return stack.pop()
tokens = ["4","13","5","/","+"]
tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Solution().evalRPN(tokens)

