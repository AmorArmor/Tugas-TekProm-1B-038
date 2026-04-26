package com.p2p.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LoanTest {

    @Test
    public void shouldChangeStatusToApprovedWhenApproved() {
        Borrower validBorrower = new Borrower("B04", "Dina Setuju");
        validBorrower.setVerified(true);
        Loan loan = new Loan(validBorrower, 5000000.0);

        // Assert menggunakan Enum LoanStatus.PROPOSED
        assertEquals(LoanStatus.PROPOSED, loan.getStatus(), "Status awal harus PROPOSED");

        loan.approve();

        // Assert menggunakan Enum LoanStatus.APPROVED
        assertEquals(LoanStatus.APPROVED, loan.getStatus(), "Status harus berubah menjadi APPROVED");
    }
}