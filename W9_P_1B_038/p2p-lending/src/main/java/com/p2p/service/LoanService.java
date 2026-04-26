package com.p2p.service;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;

public class LoanService {

    public Loan applyLoan(Borrower borrower, double amount) {
        borrower.checkEligibility();
        
        // Refactor: Langsung buat dan kembalikan objeknya (Inline Variable)
        return new Loan(borrower, amount);
    }
}