from collections import Counter
class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        intersect_dict = Counter(nums1) & Counter(nums2)
        lst = [item for item, counter in intersect_dict.items()
               for _ in range(counter)]
        return lst
