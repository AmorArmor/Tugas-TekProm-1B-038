public class EmployeeTest {
    public static void main(String[] args) {
        // Mendeklarasikan dan mengalokasikan array untuk 3 objek Employee
        Employee[] staff = new Employee[3];

        // Inisialisasi data karyawan
        staff[0] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[1] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);
        staff[2] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);

        // Menaikkan gaji setiap staf sebesar 5%
        for (int i = 0; i < 3; i++) {
            staff[i].raiseSalary(5);
        }

        // Mencetak data dari setiap staf
        System.out.println("--- Sebelum Sorting ---");
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }

        // --- Menambahkan pengujian metode compare() ---
        System.out.println("\n--- Test Metode compare ---");

        int hasil1 = staff[0].compare(staff[1]);
        System.out.println("Bandingkan staff[0] dengan staff[1] hasilnya: " + hasil1);

        int hasil2 = staff[1].compare(staff[2]);
        System.out.println("Bandingkan staff[2] dengan staff[1] hasilnya: " + hasil2);

        int hasil3 = staff[1].compare(staff[1]);
        System.out.println("Bandingkan staff[1] dengan staff[1] hasilnya: " + hasil3);


        // --- Mengurutkan Data Karyawan dengan Shell Sort ---
        // memasukkan array 'staff' sebagai parameternya
        Sortable.shell_sort(staff);

        // --- Mencetak Data Setelah Sorting ---
        System.out.println("\n--- Setelah Sorting ---");
        for (int i = 0; i < staff.length; i++) {
            staff[i].print();
        }
    }
}
