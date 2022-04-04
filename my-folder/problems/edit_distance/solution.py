class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        if word1 is None or len(word1) == 0:
            if word2 is None:
                return 0
            return len(word2)
        if word2 is None or len(word2) == 0:
            if word1 is None:
                return 0
            return len(word1)
        w1_len = len(word1)
        w2_len = len(word2)
        dp = [[0] * (w2_len + 1) for _ in range(w1_len + 1)]
        for i in range(1, w1_len+1):
            dp[i][0] = i
        for j in range(1, w2_len+1):
            dp[0][j] = j
            
        for i in range(1, w1_len + 1):
            for j in range(1, w2_len + 1):
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
        return dp[w1_len][w2_len]
            