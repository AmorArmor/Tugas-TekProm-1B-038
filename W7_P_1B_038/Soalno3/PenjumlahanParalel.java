import java.util.Scanner;

// Kelas untuk menyimpan hasil akhir secara aman (Thread-Safe)
class SumResult {
    long totalSum = 0; // menggunakan long agar dapat mencakup total angka yang besar

    // Metode synchronized memastikan hanya satu thread yang dapat 
    // menambahkan hasil parsial pada satu waktu (mencegah Race Condition)
    synchronized public void addSum(long partialResult) {
        totalSum += partialResult;
    }
}

public class PenjumlahanParalel {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // 1. Menerima Input dari pengguna
        System.out.print("Masukkan Jumlah Thread: ");
        int numThreads = scanner.nextInt();
        System.out.print("Masukkan Angka Akhir: ");
        long targetNumber = scanner.nextLong();

        SumResult result = new SumResult(); // Objek penampung hasil akhir yang akan di-share ke semua thread
        Thread[] threads = new Thread[numThreads]; // Array untuk menyimpan referensi setiap thread

        // 2. Pembagian Tugas (Divide and Conquer)
        long chunkSize = targetNumber / numThreads;
        long startNumber = 1;

        for (int i = 0; i < numThreads; i++) {
            // Menentukan batas akhir perhitungan untuk thread saat ini.
            // Jika ini adalah thread terakhir, dia akan mengambil semua sisa angka.
            long endNumber = (i == numThreads - 1) ? targetNumber : startNumber + chunkSize - 1;
            
            // Variabel final/efektif final diperlukan agar bisa diakses di dalam lambda expression
            final long currentStart = startNumber;
            final long currentEnd = endNumber;
            final int threadId = i + 1;

            threads[i] = new Thread(() -> {
                long partialSum = 0;
                
                // Menjumlahkan angka pada rentang yang sudah dibagi
                for (long j = currentStart; j <= currentEnd; j++) {
                    partialSum += j;
                }
                
                // Menampilkan tugas dan hasil parsial dari masing-masing thread
                System.out.println("Thread-" + threadId + ": Menjumlahkan " + currentStart + " - " + currentEnd + " | Hasil parsial: " + partialSum);
                
                // 3. Menambahkan hasil parsial ke total akhir secara aman (Synchronized)
                result.addSum(partialSum);
            });

            // Menyiapkan startNumber untuk iterasi thread selanjutnya
            startNumber = endNumber + 1;
            System.err.println("Thread[" + i + "] selesai menjumlahkan.");
        }

        // 4. Memulai (Start) semua thread
        for (int i = 0; i < numThreads; i++) {
            threads[i].start();
        }

        // 5. Menunggu semua thread selesai (Join)
        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }

        // 6. Menampilkan Hasil Akhir
        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Total Penjumlahan dari 1 sampai " + targetNumber + " adalah: " + result.totalSum);
        
        scanner.close();
    }
}
