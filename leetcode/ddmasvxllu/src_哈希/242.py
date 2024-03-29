

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        hash_map = {}
        for ch in s:
            hash_map[ch] = hash_map.get(ch, 0) + 1
        for ch in t:
            if ch not in hash_map:
                return False
            hash_map[ch] -= 1
            if hash_map[ch] == 0:
                del hash_map[ch]
        return not hash_map

 
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        from typing import Counter
        s_count = Counter(s)
        t_count = Counter(t)
        return s_count == t_count

 