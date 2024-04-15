class Solution:
    def commonChars(self, words: list[str]) -> list[str]:
        from typing import Counter
        insert_cnt = Counter(words[0])
        for str in words[1:]:
            str_cnt = Counter(str)
            insert_cnt = insert_cnt & str_cnt
        lst = [(item) for item, counter in insert_cnt.items() for _ in range(counter)]
        # lst = [(item * counter) for item, counter in insert_cnt.items()]
        return lst
           
res = Solution().commonChars(["bella","label","roller"])            
print(res)     
            
            
            
            
            
            
            