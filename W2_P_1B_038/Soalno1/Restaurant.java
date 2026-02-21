class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    // GETTER & SETTER untuk stok
    public int getStok(int index){
        return this.stok[index];
    }

    public void setStok(int index, int  stokBaru){
        if (stokBaru >= 0 ) {
            this.stok[index] = stokBaru;
        } else{
            System.out.println("Error: stok baru tidak valid");
        }
    }

    // GETTER untuk nama dan harga
    public String getNamaMakanan(int index) {
        return this.nama_makanan[index];
    }

    public double getHargaMakanan(int index) {
        return this.harga_makanan[index];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
    this.nama_makanan[id] = nama;
    this.harga_makanan[id] = harga;
    this.stok[id] = stok;
    }

    public void tampilMenuMakanan() {
    System.out.println("\n==========================");
    for (int i = 0; i <= id; i++) {
        if (!isOutOfStock(i)) {
            System.out.println(
                nama_makanan[i] + "[" + stok[i] + "]" + "\tRp. " + harga_makanan[i]
            );
        } else{
            System.err.println(
                nama_makanan[i] + " [STOK HABIS]"
            );
        }
    }
    System.out.println("==========================\n");
    }

    public boolean isOutOfStock(int id) {
    if (stok[id] == 0) {
        return true;
    } else {
        return false;
    }
    }

    public static void nextId() {
    id++;
    }

    public void memesanMenu(int index, int jumlahPesanan){
        int stokSekarang = this.getStok(index);
        if(stokSekarang >= jumlahPesanan){
            this.setStok(index, stokSekarang - jumlahPesanan);
            System.out.println("Pesanan "+ getNamaMakanan(index) + " sebanyak " + jumlahPesanan + " pcs diproses");
        } else {
            System.out.println("Pesanan " + getNamaMakanan(index) + " ditolak karena stok tidak cukup!");
        }
    }

}
