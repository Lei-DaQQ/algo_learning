class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        from typing import Counter
        magazine_counter = Counter(magazine)
        for ch in ransomNote:
            if magazine_counter[ch] == 0:
                return False
            magazine_counter[ch] -= 1
        return True

from typing import Counter
c = Counter({'a':1, 'b':2, 'c':3})
d = Counter({'a':1, 'b':3, 'c':2, 'd':2})
res = c - d
print(res)