package com.auberer.compilerdesignlectureproject.lexer;

import com.auberer.compilerdesignlectureproject.lexer.statemachine.Range;
import com.auberer.compilerdesignlectureproject.lexer.statemachine.State;
import com.auberer.compilerdesignlectureproject.lexer.statemachine.StateMachine;

public class IntegerLiteralStateMachine extends StateMachine {

    @Override
    public void init() {
        // Start state
        State stateStart = new State("start");
        stateStart.setStartState(true);
        addState(stateStart);

        State firstNumber = new State("firstNumber");
        firstNumber.setAcceptState(true);
        addState(firstNumber);

        State followingNumber = new State("followingNumber");
        followingNumber.setAcceptState(true);
        addState(followingNumber);


        addRangeTransition(stateStart,firstNumber,new Range('1','9'));
        addRangeTransition(firstNumber,followingNumber,new Range('0','9'));
        addRangeTransition(followingNumber,followingNumber,new Range('0','9'));
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.TOK_INT_LIT;
    }
}
