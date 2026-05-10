package tugas2;
public class AhmadElifiaAshari_25161562070_Stack {

    // === BAGIAN 1: Deklarasi Stack ===
    static String[] stack = new String[10];
    static int top = -1;

    // === BAGIAN 2: Operasi Stack ===
    // TODO: Lengkapi Method push() untuk menambah data ke stack
    static void push(String tiket) {
        // Cek stack penuh
        if (top == stack.length - 1) {
            System.out.println("Stack penuh!");
        } else {
            top++;
            stack[top] = tiket;
            System.out.println("Push: " + tiket);
        }
    }

    // TODO: Lengkapi Method pop() untuk mengambil data paling atas dari stack
    static String pop() {
        // Cek stack kosong
        if (isEmpty()) {
            return "Stack kosong!";
        } else {
            String data = stack[top];
            top--;
            return data;
        }
    }

    // TODO: Lengkapi Method peek() 
    static String peek() {
        // Cek stack kosong
        if (isEmpty()) {
            return "Stack kosong";
        } else {
            return stack[top];
        }
    }

    // Method untuk mengecek apakah stack kosong
    static boolean isEmpty() {
        return top == -1;
    }

    // === BONUS: Hitung Total Transaksi ===
    // Method untuk menghitung total harga tiket dalam stack
    static void hitungTotal() {
        int total = 0;
        for (int i = 0; i <= top; i++) {

            // Ambil angka harga dari string 
            String tiket = stack[i];

            // Contoh format:
            // "Tiket-A01: Avengers Rp50.000"
            int indexRp = tiket.indexOf("Rp");
            String hargaString = tiket.substring(indexRp + 2);

            // Hilangkan titik pada harga dan konversi ke integer
            hargaString = hargaString.replace(".", "");
            int harga = Integer.parseInt(hargaString);
            total += harga;
        }
        // Format total dengan pemisah ribuan
        System.out.println("\nTotal transaksi: Rp" +
        String.format("%,d", total).replace(',', '.'));
    }

    // Method untuk menampilkan seluruh isi stack
    static void tampilkanStack() {
        System.out.println("\n=== Isi Stack (TOP -> BOTTOM) ===");
        for (int i = top; i >= 0; i--) {
                System.out.println("| " + stack[i] + " |");
        }
        System.out.println("=================================");
    }

    // === BAGIAN 3: Main Program ===
    public static void main(String[] args) {

        // TODO: Push 3 transaksi berikut ke dalam stack
        push("Tiket-A01: Avengers Rp50.000");
        push("Tiket-B02: Interstellar Rp45.000");
        push("Tiket-C03: Inception Rp45.000");

        // Tampilkan total transaksi
        hitungTotal();

        // Tampilkan seluruh isi stack
        tampilkanStack();

        // TODO: Tampilkan tiket paling atas (peek)
        System.out.println("\nTiket terakhir masuk: " + peek());

        // TODO: Batalkan transaksi teratas (pop) dan tampilkan tiket yang dibatalkan
        System.out.println("Tiket dibatalkan: " + pop());

        // Tampilkan total transaksi setelah pembatalan
        tampilkanStack();
    }
}