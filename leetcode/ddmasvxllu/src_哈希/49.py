class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        from typing import Counter
        str_dict = {}
        str_com_lst = []
        for str in strs:
            sorted_str = "".join(sorted(str))
            if not str_dict.get(sorted_str):
                str_dict[sorted_str] = [str]
            else:
                str_dict[sorted_str].append(str)
        return [str_dict[_] for _ in str_dict]


Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"])


# error usage: dict['haha'] 不存在
'''
dict = {'name':'lucy'}
print(dict['haha'])
'''
