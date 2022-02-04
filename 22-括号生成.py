class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        if n == 1:
            return list({'()'})#借助set的去重功能，解决了重复问题，取巧了属于是
        res = set()
        for s in self.generateParenthesis(n-1):
            for j in range(0,len(s)+2):
                res.add(s[0:j]+'()'+s[j:])
        return list(res)