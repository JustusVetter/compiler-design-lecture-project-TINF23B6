package com.auberer.compilerdesignlectureproject.lexer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerLiteralStateMachineTest {

    @Test
    @DisplayName("SingleZero")
    public void testSingleZero() {
        String input = "0";
        IntegerLiteralStateMachine stateMachine = new IntegerLiteralStateMachine();
        stateMachine.init();
        stateMachine.reset();
        for (char c : input.toCharArray()) {
            assertFalse(stateMachine.isInAcceptState());
            assertDoesNotThrow(() -> stateMachine.processInput(c));
        }
        assertTrue(stateMachine.isInAcceptState());
    }
}
