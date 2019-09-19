from unittest import TestCase

from pysrc.leet.maxnumbaloons.solution import Solution


class TestSolution(TestCase):
    def test_maxNumberOfBalloons(self):
        s = Solution()
        assert 0 == s.maxNumberOfBalloons("balon")
        assert 1 == s.maxNumberOfBalloons("ballono")
        assert 2 == s.maxNumberOfBalloons("lbalonolbalono")
        assert 1 == s.maxNumberOfBalloons("lbalonolbalon")
        assert 10 == s.maxNumberOfBalloons("krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw")

