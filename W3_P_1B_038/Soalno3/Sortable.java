public abstract class Sortable {
    public abstract int compare(Sortable b);

    public static void shell_sort(Sortable[] a) {
        int n = a.length;

        // 1. Tentukan ukuran gap awal (biasanya setengah dari panjang array), 
        // lalu terus dibagi dua sampai gap bernilai 1
        for (int gap = n / 2; gap > 0; gap /= 2) {
            
            // 2. Lakukan perulangan mulai dari elemen pada indeks 'gap' hingga akhir array
            for (int i = gap; i < n; i++) {
                
                // Simpan elemen saat ini ke variabel sementara (temp)
                Sortable temp = a[i];
                
                int j;
                // 3. Bandingkan dan geser elemen.
                // Kita memanggil a[j - gap].compare(temp) > 0.
                // Jika elemen di kiri lebih besar dari 'temp', method compare() dari Employee 
                // akan mengembalikan nilai 1 (yang berarti > 0), sehingga elemen tersebut digeser ke kanan.
                for (j = i; j >= gap && a[j - gap].compare(temp) > 0; j -= gap) {
                    a[j] = a[j - gap];
                }
                
                // Tempatkan 'temp' pada posisi yang sudah tepat
                a[j] = temp;
            }
        }
    }
}
