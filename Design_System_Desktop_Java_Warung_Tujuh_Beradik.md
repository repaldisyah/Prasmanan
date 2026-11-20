# DESIGN SYSTEM DESKTOP JAVA
## Sistem Informasi Penjualan dan Pengelolaan Warung Prasmanan Tujuh Beradik

> Dokumen ini mengadaptasi prinsip visual dari **FoodDash Design System** menjadi panduan antarmuka aplikasi desktop menggunakan **Java Swing**. Desain disesuaikan dengan karakter warung nasi Padang dan kebutuhan kerja kasir/admin, bukan tampilan aplikasi pemesanan atau delivery berbasis web/mobile.

---

## 1. Arah Desain

### 1.1 Konsep visual

**Nama konsep: Padang Modern — Clean, Warm, Efficient.**

Antarmuka memakai latar putih yang bersih, aksen merah cabai sebagai warna aksi utama, kuning keemasan sebagai penanda perhatian, hijau daun untuk status berhasil/tersedia, oranye untuk peringatan, dan cokelat untuk elemen identitas warung.

Karakter desain yang ingin dicapai:

- **Bersih dan mudah dibaca:** layar kasir harus mudah dipindai ketika transaksi berlangsung berulang kali.
- **Hangat dan berkarakter:** kombinasi merah, emas, hijau, dan cokelat memberi nuansa rumah makan Padang tanpa membuat tampilan terlalu ramai.
- **Fungsional:** tombol, tabel, total transaksi, dan status harus lebih menonjol daripada dekorasi.
- **Desktop-first:** ruang layar dimanfaatkan untuk menampilkan daftar lauk dan ringkasan transaksi secara berdampingan.
- **Sederhana dibangun:** utamakan komponen bawaan Java Swing dan hindari ketergantungan pada framework UI besar.

### 1.2 Prinsip desain

1. Tindakan terpenting pada halaman transaksi adalah **Tambah Item** dan **Simpan Transaksi**.
2. Harga, jumlah, subtotal, dan total harus terlihat jelas tanpa perlu membuka dialog tambahan.
3. Informasi disusun dengan hierarki yang konsisten: judul halaman → ringkasan → filter/form → tabel → aksi.
4. Gunakan warna untuk menyampaikan arti, bukan sebagai dekorasi semata.
5. Jangan membuat tampilan seperti aplikasi delivery. Tidak diperlukan peta, pelacakan pesanan, banner promosi, rating restoran, atau tombol keranjang mengambang.

---

## 2. Palet Warna Warung Nasi Padang

### 2.1 Warna utama dan sekunder

Warna yang ditentukan untuk identitas aplikasi:

| Peran | Nama warna | Kode | Penggunaan |
|---|---|---|---|
| Primer | Putih | `#FFFFFF` | Latar utama, panel konten, form, dan permukaan kartu. |
| Sekunder 1 | Kuning keemasan | `#E9B949` | Highlight, item terpilih, badge perhatian, dan aksen visual. |
| Sekunder 2 | Merah cabai | `#A83226` | Warna identitas, tombol aksi utama, indikator aktif, dan aksen penting. |
| Sekunder 3 | Hijau daun | `#527A3B` | Status tersedia, berhasil, transaksi selesai, dan konfirmasi positif. |
| Sekunder 4 | Oranye rempah | `#D98236` | Peringatan, status menunggu, dan tombol aksi sekunder tertentu. |
| Sekunder 5 | Cokelat kayu | `#79513A` | Sidebar, elemen identitas, teks penekanan, dan aksen pendukung. |

### 2.2 Warna netral pendukung

Warna netral berikut hanya berfungsi membantu keterbacaan dan pemisahan bidang. Warna ini bukan pengganti palet utama/sekunder.

| Peran | Kode | Penggunaan |
|---|---|---|
| Latar area kerja | `#F7F5F1` | Area di belakang kartu/panel agar permukaan putih tetap terlihat. |
| Teks utama | `#2F2925` | Judul, label, isi tabel, dan nominal. |
| Teks sekunder | `#756B64` | Keterangan tambahan, hint, dan informasi pendukung. |
| Garis/border | `#E5DED7` | Garis tabel, pemisah, dan batas input. |
| Disabled | `#BDB6AF` | Kontrol yang tidak dapat digunakan. |

### 2.3 Aturan kombinasi warna

- Gunakan **putih** sebagai warna permukaan dominan.
- Gunakan **merah cabai `#A83226`** untuk tombol utama seperti `Simpan Transaksi`, `Login`, dan aksi utama lainnya. Teks tombol berwarna putih.
- Gunakan **cokelat `#79513A`** untuk sidebar dengan teks putih. Jangan gunakan cokelat untuk seluruh area konten.
- Gunakan **kuning `#E9B949`** sebagai highlight dengan teks gelap/cokelat agar tetap terbaca. Hindari teks putih kecil di atas kuning.
- Gunakan **hijau `#527A3B`** untuk status sukses/tersedia. Jangan menjadikannya warna tombol utama secara bersamaan dengan merah.
- Gunakan **oranye `#D98236`** untuk peringatan atau tindakan sekunder yang perlu perhatian.
- Warna merah untuk aksi berbahaya seperti hapus boleh tetap digunakan, tetapi tampilkan label yang jelas dan minta konfirmasi.

### 2.4 Status dan badge

| Status | Latar | Teks | Contoh label |
|---|---|---|---|
| Tersedia / berhasil | `#EAF1E5` | `#527A3B` | Tersedia, Berhasil, Selesai |
| Perhatian / menunggu | `#FFF3D6` | `#79513A` atau `#9A5A19` | Menunggu, Perlu dicek |
| Tidak tersedia / dibatalkan | `#F8E8E5` | `#A83226` | Tidak tersedia, Dibatalkan |
| Informasi / pilihan aktif | `#F8EFCF` | `#79513A` | Dipilih, Filter aktif |

Gunakan label teks bersama warna. Jangan mengandalkan warna saja untuk membedakan status.

---

## 3. Tipografi Desktop

Java Swing tidak memakai skala tipografi CSS. Atur ukuran font menggunakan `java.awt.Font` dan gunakan font sistem agar aplikasi mudah dijalankan di komputer lain.

### 3.1 Rekomendasi font

- **Font utama:** `Arial` atau `SansSerif`.
- **Judul/heading:** Arial Bold.
- **Isi/form/tabel:** Arial Plain.
- **Nomor transaksi/kode:** `Monospaced` atau `SansSerif` dengan angka yang mudah dibaca.

Jangan mewajibkan Poppins, DM Sans, atau Roboto Mono karena font tersebut belum tentu tersedia di komputer tempat aplikasi dijalankan.

### 3.2 Skala ukuran

| Elemen | Ukuran | Gaya |
|---|---:|---|
| Judul aplikasi/login | 24–28 pt | Bold |
| Judul halaman | 21–24 pt | Bold |
| Judul bagian/kartu | 15–17 pt | Bold |
| Isi umum | 13–14 pt | Plain |
| Label form | 12–13 pt | Bold atau Plain |
| Keterangan tambahan | 11–12 pt | Plain |
| Nominal total transaksi | 24–30 pt | Bold |
| Nomor transaksi | 12–13 pt | Monospaced/Plain |

**Catatan:** nominal total dan harga harus tetap terbaca jelas. Jangan mengecilkan angka hanya untuk memuat lebih banyak kolom.

---

## 4. Ukuran Layar dan Kerangka Aplikasi

### 4.1 Ukuran jendela

- Ukuran awal yang disarankan: **1366 × 768 px**.
- Ukuran minimum: sekitar **1100 × 700 px**.
- Saat dijalankan, aplikasi dapat dibuka dalam keadaan maximized.
- Hindari posisi komponen yang ditentukan dengan koordinat absolut.
- Gunakan Swing Layout Manager supaya tampilan tetap menyesuaikan ukuran jendela.

### 4.2 Kerangka halaman utama

Gunakan struktur utama berikut:

```text
+--------------------------------------------------------------------------------+
| SIDEBAR         | TOP BAR: Nama halaman       Nama pengguna / Peran  [Keluar]  |
|                 +--------------------------------------------------------------+
| Logo / Nama     |                                                              |
| Warung          |                     AREA KONTEN                              |
|                 |                                                              |
| Beranda         |   Judul halaman                                              |
| Transaksi       |   Keterangan / filter                                         |
| Menu            |                                                              |
| Riwayat         |   Kartu ringkasan / form / tabel                              |
| Laporan         |                                                              |
|                 |                                                              |
|                 |                                                              |
+--------------------------------------------------------------------------------+
```

Rekomendasi proporsi:

- Sidebar kiri: **210–230 px**.
- Top bar: **58–68 px**.
- Padding area konten: **20–28 px**.
- Jarak antar kartu: **14–20 px**.
- Tinggi tombol utama: **40–44 px**.
- Tinggi baris tabel: **36–42 px**.

### 4.3 Struktur Java Swing

Gunakan komponen berikut:

| Bagian | Komponen Java Swing |
|---|---|
| Jendela aplikasi | `JFrame` |
| Kerangka utama | `JPanel` + `BorderLayout` |
| Sidebar | `JPanel` + `BoxLayout` atau `GridBagLayout` |
| Header/top bar | `JPanel` + `BorderLayout` |
| Perpindahan halaman | `CardLayout` |
| Area konten | `JPanel` |
| Tabel data | `JTable` di dalam `JScrollPane` |
| Form input | `JTextField`, `JPasswordField`, `JComboBox`, `JSpinner` |
| Pilihan pembayaran | `JRadioButton` + `ButtonGroup` |
| Dialog konfirmasi/detail | `JOptionPane` atau `JDialog` |
| Tanggal/filter | `JComboBox` atau input tanggal sederhana |
| Pemisah area | `JSeparator` / `BorderFactory` |

Gunakan `BorderLayout` untuk kerangka aplikasi, `GridBagLayout` untuk form yang butuh perataan, `GridLayout` untuk kartu ringkasan, dan `BoxLayout` untuk susunan vertikal sederhana.

---

## 5. Komponen Visual

### 5.1 Tombol

Jangan memakai tombol pill besar seperti aplikasi mobile. Untuk desktop gunakan tombol datar dengan sudut sederhana, tinggi konsisten, dan label yang jelas.

| Varian | Tampilan | Penggunaan |
|---|---|---|
| Primary | Latar `#A83226`, teks putih | Login, Simpan Transaksi, Simpan Menu |
| Secondary | Latar putih, border `#A83226`, teks `#A83226` | Batal, Reset, Kembali |
| Accent | Latar `#E9B949`, teks `#2F2925` | Tambah Item, Filter, atau aksi penunjang |
| Success | Latar `#527A3B`, teks putih | Konfirmasi selesai jika memang dibutuhkan |
| Warning | Latar `#D98236`, teks putih/gelap sesuai kontras | Aksi yang memerlukan perhatian |
| Destructive | Latar `#A83226`, teks putih | Hapus; wajib disertai dialog konfirmasi |
| Ghost | Latar transparan/putih, teks `#79513A` | Navigasi ringan atau aksi sekunder |

Aturan:

- Satu halaman sebaiknya hanya memiliki **satu tombol Primary** untuk aksi utama.
- Tombol `Hapus` tidak boleh terlihat sama dengan tombol `Simpan`.
- Tombol yang tidak relevan dengan peran pengguna harus disembunyikan atau dinonaktifkan.
- Berikan state hover/focus sederhana bila memungkinkan; jangan mengandalkan animasi.

### 5.2 Kartu ringkasan

Kartu digunakan pada Dashboard dan ringkasan transaksi.

- Latar: `#FFFFFF`.
- Border: 1 px `#E5DED7`.
- Padding: 16–20 px.
- Sudut: sederhana, sekitar 8–10 px bila dibuat custom.
- Hindari bayangan besar; border dan perbedaan latar sudah cukup untuk memisahkan area.
- Isi kartu: label kecil, nilai utama besar, keterangan periode bila diperlukan.

Contoh kartu Dashboard:

```text
+---------------------------+  +---------------------------+
| PENDAPATAN HARI INI       |  | JUMLAH TRANSAKSI          |
| Rp 1.250.000              |  | 42 transaksi              |
| Hari ini                  |  | Hari ini                  |
+---------------------------+  +---------------------------+
```

### 5.3 Input dan form

- Tinggi input: **36–40 px**.
- Latar input: putih.
- Border normal: `#E5DED7`.
- Border fokus: `#A83226`.
- Border error: `#A83226` dengan pesan kesalahan yang jelas.
- Label diletakkan di atas field, bukan hanya menggunakan placeholder.
- Format harga menggunakan Rupiah saat ditampilkan; validasi nilai tetap dilakukan pada service.

Komponen yang disarankan:

- Nama menu: `JTextField`.
- Harga: `JTextField` dengan validasi angka/`BigDecimal`.
- Jenis menu: `JComboBox` atau `JTextField` sesuai daftar kategori yang ditetapkan.
- Status: `JComboBox` dengan pilihan Tersedia/Tidak Tersedia.
- Jumlah lauk: `JSpinner` atau `JTextField` dengan validasi bilangan bulat.

### 5.4 Tabel

Gunakan `JTable` di dalam `JScrollPane`.

- Header tabel: latar `#79513A`, teks putih, font bold.
- Baris normal: putih.
- Baris alternatif: dapat menggunakan `#FAF8F5` jika ingin meningkatkan keterbacaan.
- Garis pemisah: `#E5DED7`.
- Tinggi baris: 36–42 px.
- Angka harga, jumlah, subtotal, dan total sebaiknya rata kanan.
- Kode dan nomor transaksi dapat rata kiri atau memakai font monospaced.
- Baris terpilih: gunakan highlight lembut bernuansa kuning, dengan teks gelap.
- Sediakan keadaan kosong seperti **Belum ada data**; jangan membiarkan tabel kosong tanpa penjelasan.

### 5.5 Badge/status

Status sebaiknya berupa teks pendek dalam `JLabel` atau panel kecil yang diberi warna latar. Contoh: `TERSEDIA`, `TIDAK TERSEDIA`, `SELESAI`, dan `DIBATALKAN`.

### 5.6 Dialog dan notifikasi

Untuk desktop gunakan `JOptionPane` atau `JDialog`, bukan bottom sheet.

- Berhasil: pesan singkat dengan ikon informasi/sukses.
- Gagal validasi: tampilkan apa yang salah dan cara memperbaikinya.
- Hapus data: konfirmasi sebelum penghapusan.
- Detail transaksi: dialog terpisah yang menampilkan isi struk atau rincian transaksi.
- Hindari dialog beruntun yang tidak diperlukan.

---

## 6. Rancangan Halaman Aplikasi

### 6.1 UI-01 — Login

**Pengguna:** Kasir/Pegawai dan Pemilik/Admin.

Tampilan login dibuat terpusat, sederhana, dan tidak memakai navigasi sidebar.

```text
+--------------------------------------------------------------------------------+
|                                                                                |
|                          WARUNG TUJUH BERADIK                                  |
|                   Sistem Informasi Penjualan dan Pengelolaan                  |
|                                                                                |
|                 +------------------------------------------+                   |
|                 |              MASUK KE AKUN               |                   |
|                 |                                          |                   |
|                 | Username                                 |                   |
|                 | [____________________________________]   |                   |
|                 | Password                                 |                   |
|                 | [____________________________________]   |                   |
|                 |                                          |                   |
|                 |             [ MASUK / LOGIN ]             |                   |
|                 +------------------------------------------+                   |
|                                                                                |
+--------------------------------------------------------------------------------+
```

Komponen:

- `JFrame` login dengan panel utama putih.
- Label nama aplikasi dan deskripsi singkat.
- `JTextField` untuk username.
- `JPasswordField` untuk password.
- `JButton` Masuk/Login.
- Pesan error apabila akun tidak cocok.

Aturan interaksi:

- Validasi field kosong sebelum autentikasi.
- Enter pada field password dapat memicu proses login.
- Kasir berhasil login → langsung masuk ke halaman Transaksi.
- Admin berhasil login → masuk ke Dashboard.

### 6.2 UI-02 — Dashboard Admin

**Pengguna:** Pemilik/Admin.

```text
+--------------------------------------------------------------------------------+
| SIDEBAR         | BERANDA                              Admin: Nama [Keluar]    |
|                 +--------------------------------------------------------------+
| WARUNG          | RINGKASAN PENJUALAN HARI INI                               |
| TUJUH BERADIK   |                                                              |
|                 | +----------------------+ +----------------------+             |
| > Beranda       | | Pendapatan Hari Ini  | | Jumlah Transaksi     |             |
|   Transaksi     | | Rp xxx.xxx           | | xxx transaksi        |             |
|   Menu          | +----------------------+ +----------------------+             |
|   Riwayat       |                                                              |
|   Laporan       | JUMLAH LAUK TERJUAL / LAUK TERLARIS                         |
|                 | +----------------------------------------------------------+ |
|                 | | Nama Lauk                  | Jumlah Terjual              | |
|                 | | Ayam                       | xx                          | |
|                 | | Rendang                    | xx                          | |
|                 | | Ikan                       | xx                          | |
|                 | +----------------------------------------------------------+ |
+--------------------------------------------------------------------------------+
```

Elemen:

- Kartu pendapatan hari ini.
- Kartu jumlah transaksi hari ini.
- Tabel lauk terlaris atau ringkasan jumlah lauk terjual.
- Navigasi ke Transaksi, Menu, Riwayat, dan Laporan.

Dashboard hanya menampilkan angka dari transaksi yang telah tersimpan. Jangan menampilkan data contoh sebagai data nyata setelah aplikasi mulai digunakan.

### 6.3 UI-03 — Pengelolaan Menu

**Pengguna:** Admin dapat mengelola; Kasir hanya dapat melihat daftar menu.

```text
+--------------------------------------------------------------------------------+
| SIDEBAR         | PENGELOLAAN MENU                     Admin: Nama [Keluar]    |
|                 +--------------------------------------------------------------+
|                 | [ + Tambah Menu ]       Cari menu: [____________] [Cari]     |
|                 |                                                              |
|                 | +----------------------------------------------------------+ |
|                 | | Kode | Nama Menu | Jenis | Harga | Status | Aksi         | |
|                 | | M001 | Rendang   | Lauk  | 18.000| Tersedia| Ubah Hapus  | |
|                 | | M002 | Ayam Bakar| Lauk  | 15.000| Tersedia| Ubah Hapus  | |
|                 | | M003 | Nasi      | Nasi  |  5.000| Tersedia| Ubah Hapus  | |
|                 | +----------------------------------------------------------+ |
+--------------------------------------------------------------------------------+
```

Form Tambah/Ubah Menu:

- ID menu dibuat otomatis atau ditetapkan oleh sistem.
- Nama menu.
- Jenis menu.
- Harga.
- Status ketersediaan.
- Tombol Simpan dan Batal.

Aturan:

- Kasir tidak melihat tombol Tambah, Ubah, dan Hapus.
- Admin harus mengonfirmasi sebelum menghapus menu.
- Jika menu sudah digunakan dalam transaksi, lebih aman menandainya sebagai Tidak Tersedia agar transaksi lama tetap dapat dibaca.
- Pencarian menu dapat dilakukan berdasarkan nama atau kode.

### 6.4 UI-04 — Transaksi Penjualan

**Pengguna:** Kasir/Pegawai dan Admin bila diperlukan.

Gunakan ruang desktop untuk memisahkan area pemilihan lauk/tabel dari panel ringkasan pembayaran.

```text
+--------------------------------------------------------------------------------+
| SIDEBAR         | TRANSAKSI PENJUALAN                   Kasir: Nama [Keluar]   |
|                 +--------------------------------------------------------------+
|                 | No. Transaksi: TRX-XXXXXXXX   Tanggal: dd-mm-yyyy  hh:mm     |
|                 |                                                              |
|                 | Pilih lauk: [Pilih menu v]  Jumlah: [__] [Tambah Item]       |
|                 |                                                              |
|                 | +--------------------------------------+ +----------------+ |
|                 | | DAFTAR ITEM                           | | PEMBAYARAN     | |
|                 | | Nama | Harga | Qty | Subtotal | Aksi  | |                | |
|                 | | ...                                      | | Total          | |
|                 | | ...                                      | | Rp xxx.xxx     | |
|                 | |                                          | |                | |
|                 | |                                          | | Metode         | |
|                 | |                                          | | (o) Tunai      | |
|                 | |                                          | | ( ) QRIS       | |
|                 | |                                          | | Jumlah Bayar   | |
|                 | |                                          | | [___________]  | |
|                 | |                                          | | Kembalian      | |
|                 | |                                          | | Rp xxx.xxx     | |
|                 | +--------------------------------------+ | [SIMPAN]       | |
|                 |                                           | [BATAL]        | |
+--------------------------------------------------------------------------------+
```

Elemen dan perilaku:

- Nomor transaksi, tanggal, waktu, dan nama kasir tampil di bagian atas.
- Pilihan menu hanya menampilkan menu yang berstatus tersedia.
- Kasir memasukkan jumlah lauk/porsi lalu menekan Tambah Item.
- Tabel menampilkan nama menu, harga satuan, jumlah, subtotal, dan aksi ubah/hapus.
- Total dihitung ulang setiap item ditambah, diubah, atau dihapus.
- Panel pembayaran menampilkan total, metode Tunai atau QRIS/e-wallet, jumlah bayar, dan kembalian bila relevan.
- Tombol Simpan Transaksi dibuat paling menonjol.

Aturan validasi:

- Minimal ada satu item.
- Jumlah harus bilangan bulat lebih dari nol.
- Menu harus masih tersedia.
- Metode pembayaran wajib dipilih.
- Jumlah bayar tidak boleh kurang dari total.
- Setelah transaksi berhasil disimpan, cegah penyimpanan ganda dan tampilkan struk.
- QRIS/e-wallet hanya dicatat sebagai metode pembayaran yang dikonfirmasi kasir; aplikasi tidak mengintegrasikan payment gateway.

### 6.5 UI-05 — Riwayat Transaksi

**Pengguna:** Kasir dan Admin.

```text
+--------------------------------------------------------------------------------+
| SIDEBAR         | RIWAYAT TRANSAKSI                     Nama Pengguna [Keluar] |
|                 +--------------------------------------------------------------+
|                 | Cari No. Transaksi: [____________]  Tanggal: [________] [Cari]|
|                 |                                                              |
|                 | +----------------------------------------------------------+ |
|                 | | No. Transaksi | Tanggal | Kasir | Total | Detail         | |
|                 | | TRX-000001    | ...     | ...   | ...   | [Lihat]        | |
|                 | | TRX-000002    | ...     | ...   | ...   | [Lihat]        | |
|                 | +----------------------------------------------------------+ |
+--------------------------------------------------------------------------------+
```

Detail transaksi dibuka melalui `JDialog` atau panel detail, berisi item, jumlah, harga saat transaksi, subtotal, total, metode pembayaran, kasir, dan waktu.

### 6.6 UI-06 — Laporan Penjualan

**Pengguna:** Pemilik/Admin.

```text
+--------------------------------------------------------------------------------+
| SIDEBAR         | LAPORAN PENJUALAN                     Admin: Nama [Keluar]   |
|                 +--------------------------------------------------------------+
|                 | Jenis: (o) Harian ( ) Bulanan   Periode: [________] [Tampilkan]|
|                 |                                                              |
|                 | +----------------------+ +----------------------+             |
|                 | | Total Pendapatan     | | Jumlah Transaksi     |             |
|                 | | Rp xxx.xxx           | | xxx transaksi        |             |
|                 | +----------------------+ +----------------------+             |
|                 |                                                              |
|                 | JUMLAH MENU/LAUK TERJUAL                                   |
|                 | +----------------------------------------------------------+ |
|                 | | Nama Menu                 | Jumlah Terjual              | |
|                 | | Rendang                   | xx                          | |
|                 | | Ayam Bakar                | xx                          | |
|                 | +----------------------------------------------------------+ |
|                 | Lauk Terlaris: [Nama Menu]                                  |
+--------------------------------------------------------------------------------+
```

Laporan harian dan bulanan dihitung dari transaksi dan detail transaksi yang tersimpan. Pengelolaan biaya/laba-rugi tidak dimasukkan ke versi awal karena mekanisme biaya belum ditentukan pada kebutuhan sistem.

---

## 7. Navigasi dan Hak Akses

| Menu navigasi | Kasir | Admin |
|---|:---:|:---:|
| Beranda/Dashboard | Tidak | Ya |
| Transaksi | Ya | Ya, bila diperlukan |
| Menu | Lihat saja | Kelola penuh |
| Riwayat | Ya | Ya |
| Laporan | Tidak | Ya |
| Logout | Ya | Ya |

Aturan navigasi:

- Setelah login, halaman awal berbeda sesuai peran.
- Kasir diarahkan langsung ke Transaksi.
- Admin diarahkan ke Dashboard.
- Menu yang tidak diizinkan tidak ditampilkan di sidebar.
- Hak akses tetap diperiksa oleh service, bukan hanya dengan menyembunyikan tombol di UI.

---

## 8. Adaptasi dari FoodDash (Web/Mobile) ke Java Desktop

| Prinsip/komponen FoodDash | Adaptasi untuk aplikasi desktop Java |
|---|---|
| Mobile-first layout | Desktop-first layout dengan sidebar, top bar, dan area konten lebar. |
| Tombol pill besar | Tombol desktop dengan tinggi konsisten dan bentuk sederhana. |
| One-thumb reachability | Aksi utama diletakkan dekat area kerja dan dapat diakses dengan mouse/keyboard. |
| Bottom sheet | `JDialog` atau `JOptionPane`. |
| Floating cart button | Panel ringkasan pembayaran yang selalu terlihat di sisi kanan halaman transaksi. |
| Haptic feedback | Fokus keyboard, hover, dan perubahan state tombol yang jelas. |
| Kartu dengan shadow besar | Panel putih dengan border halus dan jarak antarkomponen. |
| Search pill | `JTextField` dengan label pencarian dan tombol Cari. |
| List item 64 px dengan thumbnail | Baris `JTable` 36–42 px; gambar menu bersifat opsional. |
| Delivery/order tracking status | Badge status transaksi/menu seperti Tersedia, Selesai, atau Dibatalkan. |
| Promosi/banner restoran | Tidak digunakan, kecuali suatu saat menjadi kebutuhan sistem. |
| Food photography sebagai elemen utama | Tidak diwajibkan; fokus aplikasi adalah input, perhitungan, dan laporan. |

Prinsip FoodDash yang tetap dipertahankan adalah kejelasan CTA, keterbacaan harga, label status yang konsisten, serta alur transaksi yang cepat. Prinsip yang khusus untuk layar sentuh/mobile tidak diterapkan secara langsung.

---

## 9. Pengaturan Warna dalam Java Swing

Buat satu class terpusat agar warna seluruh halaman konsisten.

```java
package warungtujuhberadik.config;

import java.awt.Color;

public final class PaletWarna {
    private PaletWarna() {
        // Class berisi konstanta; tidak perlu dibuat menjadi object.
    }

    // Warna utama
    public static final Color PUTIH = Color.decode("#FFFFFF");

    // Warna sekunder identitas Warung Nasi Padang
    public static final Color EMAS = Color.decode("#E9B949");
    public static final Color MERAH_CABAI = Color.decode("#A83226");
    public static final Color HIJAU_DAUN = Color.decode("#527A3B");
    public static final Color ORANYE_REMPAH = Color.decode("#D98236");
    public static final Color COKELAT_KAYU = Color.decode("#79513A");

    // Warna netral pendukung
    public static final Color LATAR_AREA = Color.decode("#F7F5F1");
    public static final Color TEKS_UTAMA = Color.decode("#2F2925");
    public static final Color TEKS_SEKUNDER = Color.decode("#756B64");
    public static final Color BORDER = Color.decode("#E5DED7");
}
```

### 9.1 Pengaturan dasar Look and Feel

Gunakan Look and Feel bawaan Java agar tidak membutuhkan library eksternal. Warna komponen dapat diatur melalui `UIManager`.

```java
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import warungtujuhberadik.config.PaletWarna;
import warungtujuhberadik.ui.LoginFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UIManager.put("Panel.background", PaletWarna.LATAR_AREA);
            UIManager.put("OptionPane.background", PaletWarna.PUTIH);
            UIManager.put("TextField.background", PaletWarna.PUTIH);
            UIManager.put("TextField.foreground", PaletWarna.TEKS_UTAMA);
            UIManager.put("Table.background", PaletWarna.PUTIH);
            UIManager.put("Table.foreground", PaletWarna.TEKS_UTAMA);
            UIManager.put("Table.selectionBackground", PaletWarna.EMAS);
            UIManager.put("Table.selectionForeground", PaletWarna.TEKS_UTAMA);

            new LoginFrame().setVisible(true);
        });
    }
}
```

Atur warna khusus pada komponen utama secara langsung apabila nilai `UIManager` tidak diterapkan oleh Look and Feel yang digunakan.

### 9.2 Contoh styling tombol

```java
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import warungtujuhberadik.config.PaletWarna;

public class TombolFactory {
    public static JButton tombolUtama(String teks) {
        JButton tombol = new JButton(teks);
        tombol.setFont(new Font("Arial", Font.BOLD, 14));
        tombol.setBackground(PaletWarna.MERAH_CABAI);
        tombol.setForeground(PaletWarna.PUTIH);
        tombol.setFocusPainted(false);
        tombol.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
        tombol.setOpaque(true);
        return tombol;
    }
}
```

### 9.3 Contoh styling tabel

```java
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import warungtujuhberadik.config.PaletWarna;

public class TabelFactory {
    public static void aturTampilan(JTable tabel) {
        tabel.setFont(new Font("Arial", Font.PLAIN, 13));
        tabel.setRowHeight(40);
        tabel.setFillsViewportHeight(true);
        tabel.setShowVerticalLines(false);
        tabel.setGridColor(PaletWarna.BORDER);
        tabel.setSelectionBackground(PaletWarna.EMAS);
        tabel.setSelectionForeground(PaletWarna.TEKS_UTAMA);

        JTableHeader header = tabel.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 13));
        header.setBackground(PaletWarna.COKELAT_KAYU);
        header.setForeground(PaletWarna.PUTIH);
        header.setReorderingAllowed(false);
    }
}
```

---

## 10. Pola Navigasi Halaman dengan CardLayout

Gunakan satu `MainFrame` sebagai kerangka aplikasi, kemudian ganti panel konten menggunakan `CardLayout`. Sidebar dan top bar tetap terlihat ketika pengguna berpindah halaman.

Contoh kerangka sederhana:

```java
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel panelKonten = new JPanel(cardLayout);

    public MainFrame() {
        setTitle("Sistem Informasi Warung Tujuh Beradik");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 768);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.add(new SidebarPanel(this), BorderLayout.WEST);
        root.add(new HeaderPanel(), BorderLayout.NORTH);

        panelKonten.add(new DashboardPanel(), "DASHBOARD");
        panelKonten.add(new TransaksiPanel(), "TRANSAKSI");
        panelKonten.add(new MenuPanel(), "MENU");
        panelKonten.add(new RiwayatPanel(), "RIWAYAT");
        panelKonten.add(new LaporanPanel(), "LAPORAN");

        root.add(panelKonten, BorderLayout.CENTER);
        setContentPane(root);
    }

    public void tampilkanHalaman(String namaHalaman) {
        cardLayout.show(panelKonten, namaHalaman);
    }
}
```

Kode ini merupakan pola kerangka. Sesuaikan constructor panel, komponen sidebar, dan header dengan implementasi class di project.

---

## 11. Aturan Implementasi UI

1. Gunakan `SwingUtilities.invokeLater()` untuk memulai UI pada Event Dispatch Thread.
2. Gunakan `ActionListener` atau lambda untuk tombol dan kontrol yang membutuhkan aksi.
3. Event handler cukup membaca input, memanggil service, lalu memperbarui tampilan.
4. Jangan menempatkan perhitungan transaksi atau akses file langsung di dalam class tampilan.
5. Hindari `null layout` dan `setBounds()` untuk menyusun seluruh halaman.
6. Jangan menaruh semua komponen dalam satu class besar. Pisahkan `LoginFrame`, `MainFrame`, `SidebarPanel`, `HeaderPanel`, dan panel halaman.
7. Untuk tabel gunakan `DefaultTableModel` atau model tabel khusus; hindari mengedit data transaksi langsung tanpa melewati service.
8. Format mata uang dengan formatter Rupiah, tetapi simpan angka sebagai `BigDecimal`.
9. Gunakan `JOptionPane` untuk konfirmasi sederhana dan `JDialog` untuk detail yang lebih panjang.
10. Jangan memuat gambar besar atau animasi pada halaman transaksi karena kecepatan dan keterbacaan lebih penting.
11. Pastikan ukuran tombol dan jarak cukup untuk penggunaan mouse.
12. Berikan fokus awal ke field yang paling sering digunakan, misalnya username pada Login atau pilihan menu pada Transaksi.

---

## 12. Hal yang Tidak Digunakan dari Desain Web/Mobile

Karena aplikasi ini ditujukan untuk komputer desktop kasir/admin, elemen berikut tidak perlu dipindahkan secara langsung:

- Bottom navigation dan navigasi satu jempol.
- Floating cart button.
- Bottom sheet mobile.
- Haptic feedback.
- Layout kartu yang dirancang untuk layar ponsel.
- Banner promosi dan rating restoran.
- Pelacakan kurir/pengiriman.
- Foto makanan sebagai bagian wajib setiap baris menu.
- Efek animasi atau bayangan yang berat.

Desain desktop harus memprioritaskan daftar menu, jumlah item, total pembayaran, dan riwayat/laporan.

---

## 13. Checklist Konsistensi Desain

### Visual

- [ ] Putih `#FFFFFF` menjadi warna permukaan utama.
- [ ] Merah `#A83226` digunakan konsisten untuk aksi utama.
- [ ] Emas `#E9B949` digunakan sebagai highlight dengan teks yang kontras.
- [ ] Hijau `#527A3B` hanya digunakan untuk status berhasil/tersedia atau aksi positif.
- [ ] Oranye `#D98236` digunakan untuk peringatan.
- [ ] Cokelat `#79513A` digunakan untuk sidebar/header tabel/aksen identitas.
- [ ] Ukuran font dan tinggi tombol konsisten di seluruh halaman.

### Desktop dan interaksi

- [ ] Jendela dapat diperbesar dan tidak menggunakan absolute positioning.
- [ ] Sidebar dan top bar konsisten pada seluruh halaman utama.
- [ ] Kasir langsung diarahkan ke Transaksi setelah login.
- [ ] Admin langsung diarahkan ke Dashboard setelah login.
- [ ] Total transaksi mudah terlihat pada halaman Transaksi.
- [ ] Ringkasan pembayaran tidak tertutup ketika tabel item bertambah.
- [ ] Tabel mempunyai header, tinggi baris, dan status kosong yang jelas.
- [ ] Dialog konfirmasi muncul sebelum penghapusan data.
- [ ] Semua tombol penting memiliki ActionListener yang berfungsi.

### Batasan kebutuhan

- [ ] Tidak ada fitur pemesanan mandiri pelanggan.
- [ ] Tidak ada integrasi payment gateway QRIS/e-wallet.
- [ ] Tidak ada perhitungan laba/rugi sebelum mekanisme pencatatan biaya dikonfirmasi.
- [ ] Riwayat transaksi lama tetap menampilkan harga saat transaksi dibuat.

---

## 14. Arahan Akhir untuk Pengembang / AI Coding Assistant

Buat antarmuka desktop Java Swing untuk **Sistem Informasi Penjualan dan Pengelolaan Warung Prasmanan Tujuh Beradik** dengan mengikuti design system ini.

Prioritaskan:

1. Desain desktop-first dengan sidebar kiri, top bar, dan area konten utama.
2. Palet warna nasi Padang: putih `#FFFFFF`, emas `#E9B949`, merah cabai `#A83226`, hijau daun `#527A3B`, oranye rempah `#D98236`, dan cokelat kayu `#79513A`.
3. Halaman Login, Dashboard Admin, Pengelolaan Menu, Transaksi Penjualan, Riwayat Transaksi, dan Laporan Penjualan.
4. Tampilan transaksi yang cepat dipakai kasir, dengan tabel item di bagian utama dan ringkasan pembayaran di sisi kanan.
5. Komponen bawaan Java Swing, layout manager yang tepat, dan kode yang mudah dipahami mahasiswa.
6. Konsistensi dengan kebutuhan sistem pada SRS dan rancangan teknis aplikasi Warung Tujuh Beradik.

Jangan mengubah aplikasi menjadi web, jangan menambahkan fitur delivery, dan jangan membuat tampilan seperti aplikasi pemesanan pelanggan. Hasil akhirnya harus terasa seperti **aplikasi kasir desktop modern untuk warung nasi Padang**.
