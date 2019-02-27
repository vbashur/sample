package com.vbashur.bits.reverse_bits;

/*


Reverse bits of an 32 bit unsigned integer

Example 1:

x = 0,

          00000000000000000000000000000000
=>        00000000000000000000000000000000

return 0

Example 2:

x = 3,

          00000000000000000000000000000011
=>        11000000000000000000000000000000

return 3221225472

Since java does not have unsigned int, use long
 */


/**
 * Created by vic on 27/02/19.
 * <p>
 * https://www.interviewbit.com/problems/reverse-bits/
 */
public class Solution {

    public long reverse( long a ) {

        String reversed = convertToBinary( a );
        String maxLongVal = convertToBinary( Double.valueOf( Math.pow( 2, 32 ) - 1 ).longValue() );
        StringBuilder reversedLongValue = new StringBuilder();
        for( int i = 0; i < maxLongVal.length(); ++i ) {
            if( i < reversed.length() ) {
                reversedLongValue.append( reversed.charAt( i ) );
            } else {
                reversedLongValue.append( '0' );
            }
        }
        long res = 0L;
        for( int iter = 0; iter < reversedLongValue.length(); ++iter ) {
            if( reversedLongValue.charAt( iter ) == '1' ) {
                res += Double.valueOf( Math.pow( 2, reversedLongValue.length() - iter - 1 ) ).longValue();
            }
        }
        return res;
    }

    private String convertToBinary( long num ) {

        StringBuilder numStr = new StringBuilder();
        while( num > 0 ) {
            numStr.append( num % 2 );
            num = num / 2;
        }
        return numStr.toString();
    }

    /* Editoral solution */
    public long reverseEditoral( long A ) {
        long rev = 0;

        for( int i = 0; i < 32; i++ ) {
            rev <<= 1;
            if( (A & (1 << i)) != 0 )
                rev |= 1;
        }

        return rev;

    }

}
