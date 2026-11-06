
class Solution:
    def answerQueries(self, nums: list[int], queries: list[int]) -> list[int]:
        nums.sort()
        prefix = list(accumulate(nums))
        return [bisect.bisect_right(prefix, q) for q in queries]