package com.p2p.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;

public class LoanServiceTest {

    @Test
    public void shouldRejectLoanWhenBorrowerNotVerified() {
        // Arrange: Siapkan data (Peminjam yang belum diverifikasi)
        Borrower unverifiedBorrower = new Borrower("B01", "Budi Peminjam");
        unverifiedBorrower.setVerified(false);
        
        LoanService loanService = new LoanService();
        
        // Act & Assert: Eksekusi pengajuan pinjaman dan pastikan sistem menolak dengan melemparkan Error/Exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            loanService.applyLoan(unverifiedBorrower, 5000000.0); // Mengajukan 5 juta
        });
        
        // Pastikan pesan error-nya sesuai
        assertEquals("Borrower belum diverifikasi", exception.getMessage());
    }

    @Test
    public void shouldRejectLoanWhenAmountIsZeroOrLess() {
        // Arrange: Siapkan Peminjam yang SUDAH diverifikasi
        Borrower verifiedBorrower = new Borrower("B02", "Siti Peminjam");
        verifiedBorrower.setVerified(true);
        
        LoanService loanService = new LoanService();
        
        // Act & Assert: Uji dengan nominal 0
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            loanService.applyLoan(verifiedBorrower, 0); // Pengajuan 0 rupiah
        });
        
        // Pastikan pesan error-nya sesuai
        assertEquals("Amount pinjaman harus lebih dari 0", exception.getMessage());
    }

    @Test
    public void shouldApplyLoanSuccessfully() {
        // Arrange: Siapkan Peminjam yang valid dan nominal yang benar
        Borrower validBorrower = new Borrower("B03", "Andi Sukses");
        validBorrower.setVerified(true);
        double validAmount = 10000000.0; // 10 Juta
        
        LoanService loanService = new LoanService();
        
        // Act: Eksekusi pengajuan pinjaman
        // Perhatikan: Kita sekarang menuntut fungsi applyLoan untuk mengembalikan objek Loan!
        Loan appliedLoan = loanService.applyLoan(validBorrower, validAmount);
        
        // Assert: Pastikan objek Loan terbentuk dan datanya akurat
        assertNotNull(appliedLoan, "Objek Loan tidak boleh null/kosong");
        assertEquals(validAmount, appliedLoan.getAmount(), "Nominal pinjaman harus sesuai");
        assertEquals(validBorrower, appliedLoan.getBorrower(), "Data peminjam harus sesuai");
    }
}