package com.p2p.domain;

public class Loan {
    private Borrower borrower;
    private double amount;
    private LoanStatus status; // Ubah dari String menjadi LoanStatus

    public Loan(Borrower borrower, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount pinjaman harus lebih dari 0");
        }
        this.borrower = borrower;
        this.amount = amount;
        this.status = LoanStatus.PROPOSED; // Menggunakan Enum
    }

    public double getAmount() {
        return amount;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public LoanStatus getStatus() { // Return type diubah ke Enum
        return status;
    }

    public void approve() {
        this.status = LoanStatus.APPROVED; // Menggunakan Enum
    }
}