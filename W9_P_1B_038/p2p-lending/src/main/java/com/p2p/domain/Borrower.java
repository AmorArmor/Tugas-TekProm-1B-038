package com.p2p.domain;

public class Borrower {
    private String id;
    private String name;
    private boolean isVerified;

    // Constructor
    public Borrower(String id, String name) {
        this.id = id;
        this.name = name;
        this.isVerified = false; // Default belum diverifikasi
    }

    // Setter untuk test
    public void setVerified(boolean verified) {
        this.isVerified = verified;
    }

    // Getter untuk mengecek status
    public boolean isVerified() {
        return isVerified;
    }

    // Fungsi baru untuk memindahkan logika dari Service ke Domain
    public void checkEligibility() {
        if (!this.isVerified) {
            throw new IllegalArgumentException("Borrower belum diverifikasi");
        }
    }
}