class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Berikan komentar apa yang dilakukan pada blok ini?
                // Blok ini mengunci (lock) objek acc1 agar tidak bisa diubah oleh thread lain secara bersamaan.
                System.out.println("Thread-1: berhasil mengunci acc1");
                try { Thread.sleep(100); } catch (Exception e) {} 
                // Simulasi dengan memberikan jeda. Mengapa diperlukan Exception?
                // Karena Thread.sleep() berpotensi dilempar (throw) InterruptedException-
                // jika thread ini diinterupsi oleh thread lain saat sedang tertidur/jeda.

                synchronized (acc2) { // Berikan komentar apa yang dilakukan pada blok ini?
                    // Blok ini mencoba mengunci objek acc2 untuk menyelesaikan proses transfer.
                    System.out.println("Thread-1: berhasil mengunci acc2");
                    acc2.balance += acc1.balance;
                    System.err.println("Thread-1: Penjumlahan selesai, acc2:" + acc2.balance);
                }
            }
        });

        // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        //Menggunakan urutan kunci yang sama dengan thread 1 untuk mencegah deadlock
        Thread t2 = new Thread(() -> {
            synchronized (acc1) { // Berikan komentar apa yang dilakukan pada blok ini?
                // Blok ini mengunci (lock) objek acc1 agar tidak bisa diubah oleh thread lain secara bersamaan.
                System.out.println("Thread-2: berhasil mengunci acc1");
                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc2) { // Berikan komentar apa yang dilakukan pada blok ini?
                     // Blok ini mencoba mengunci objek acc2 untuk menyelesaikan proses transfer.
                    System.out.println("Thread-2: berhasil mengunci acc2");
                    acc1.balance += acc2.balance;
                    System.err.println("Thread-2: Penjumlahan selesai, acc1: " + acc1.balance );
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
		System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}
