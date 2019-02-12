package com.vbashur.stack_queue.evaluate_expression;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by vic on 12/02/19.
 * <p>
 * https://www.interviewbit.com/problems/evaluate-expression/
 */

public class Solution {

    private enum Operation {
        ADD( "+" ),
        SUBSTRACT( "-" ),
        MULTIPLY( "*" ),
        DIVIDE( "/" );

        Operation( String symbol ) {
            this.symbol = symbol;
        }

        private String symbol;

        public String getValue() {
            return this.symbol;
        }


        public static Operation getOperation( String symbol ) {
            for( Operation oper : Operation.values() ) {
                if( oper.getValue().equals( symbol ) ) {
                    return oper;
                }
            }
            return null;
        }
    }

    public int evalRPN( ArrayList<String> A ) {
        LinkedList<String> stack = new LinkedList<>();
        for( String exprItem : A ) {
            Operation operation = Operation.getOperation( exprItem );
            if( operation != null ) {
                Integer operand2 = Integer.valueOf( stack.pollLast() );
                Integer operand1 = Integer.valueOf( stack.pollLast() );

                Integer result = new Integer( 0 );
                switch( operation ) {
                    case MULTIPLY:
                        result = operand1 * operand2;
                        break;
                    case ADD:
                        result = operand1 + operand2;
                        break;
                    case DIVIDE:
                        result = operand1 / operand2;
                        break;
                    case SUBSTRACT:
                        result = operand1 - operand2;
                        break;
                }
                stack.addLast( String.valueOf( result ) );

            } else {
                stack.addLast( exprItem );
            }
        }
        return Integer.parseInt( stack.pollLast() );
    }
}
