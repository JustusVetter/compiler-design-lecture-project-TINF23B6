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

        State stateZero = new State("zero");
        stateZero.setAcceptState(true);
        addState(stateZero);

        State stateNoZero = new State("noZero");
        stateNoZero.setAcceptState(true);
        addState(stateNoZero);

        State stateAllNumbers = new State("allNumbers");
        stateAllNumbers.setAcceptState(true);
        addState(stateAllNumbers);

        addCharTransition(stateStart,stateZero, '0');
        addRangeTransition(stateStart, stateNoZero, new Range('1','9'));
        addRangeTransition(stateNoZero, stateAllNumbers, new Range('0','9'));
        addRangeTransition(stateAllNumbers, stateAllNumbers, new Range('0','9'));
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.TOK_INT_LIT;
    }
}
