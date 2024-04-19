class Solution:
    def isValid(self, s: str) -> bool:
        '''
        这个做法是遇到左括号，push
        遇到右括号，pop，看是否匹配
        '''
        stack = []
        for ch in s:
            if ch in ')]}':
                if len(stack) == 0:
                    return False
                top = stack.pop()
                if ch == ')':
                    if top != '(':
                        return False
                elif ch == ']':
                    if top != '[':
                        return False
                else:
                    if top != '{':
                        return False
            else:
                stack.append(ch)
        return len(stack) == 0


class Solution:
    def isValid(self, s: str) -> bool:
        '''
        原理是如果括号是匹配的，左括号和右括号是对称的：
        [[{{()}}]](([]))
        这个做法是遇到左括号，push 对应的右括号
        遇到右括号，pop，看是否相同
        '''
        stack = []
        for ch in s:
            if ch == '(':
                stack.append(')')
            elif ch == '[':
                stack.append(']')
            elif ch == '{':
                stack.append('}')
            else:
                # 遇到右括号，应该 pop 并匹配
                if not stack or stack.pop() != ch:
                    return False

        return len(stack) == 0
