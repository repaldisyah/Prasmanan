# Warung Tujuh Beradik

Fondasi aplikasi kasir desktop Java untuk Warung Prasmanan Tujuh Beradik.
Tahap 1 hanya menyiapkan project, model, database SQLite, utilitas, jendela kosong,
dan pengujian awal. Fitur login, menu, transaksi, dan laporan dikerjakan pada tahap berikutnya.

## Prasyarat

- JDK 17 atau lebih baru
- Maven 3.9 atau lebih baru

## Menjalankan di Linux

1. Instal JDK dan Maven. Contoh Ubuntu/Debian:

```bash
sudo apt update
sudo apt install openjdk-17-jdk maven
```

2. Buka terminal di root project:

```bash
cd /path/ke/Prasmana
mvn clean package
mvn exec:java
```

Pada Linux Arch, gunakan `sudo pacman -S jdk17-openjdk maven`.

## Menjalankan di Windows

1. Instal JDK 17 atau lebih baru dan Maven 3.9 atau lebih baru.
2. Pastikan perintah `java` dan `mvn` sudah masuk ke `PATH`.
3. Buka PowerShell di root project, lalu jalankan:

```powershell
cd C:\path\ke\Prasmana
mvn clean package
mvn exec:java
```

Jika Maven belum dikenali, tutup dan buka kembali PowerShell setelah mengatur `PATH`.

## Build, test, dan menjalankan

```text
mvn clean package  # build project dan menjalankan test
mvn test           # menjalankan test saja
mvn exec:java      # menjalankan aplikasi Swing
```

Perintah `mvn exec:java` membuat `warung.db` di root project pada pemakaian pertama dan
menampilkan jendela kosong **Warung Tujuh Beradik**. Docker tidak diperlukan karena aplikasi
ini adalah aplikasi desktop Swing; jalankan langsung pada Windows atau Linux.

Jika VS Code menampilkan error package atau dependency, buka folder root yang berisi `pom.xml`,
bukan folder `src`. Setelah itu jalankan `mvn clean package` agar dependency Maven terunduh.
Jika error masih muncul, gunakan perintah **Java: Clean Java Language Server Workspace** dari
Command Palette lalu buka ulang project.

## Menjalankan tanpa Maven (hanya untuk source tanpa dependency)

Tahap ini membutuhkan SQLite dan FlatLaf, jadi cara utama tetap Maven. Perintah `javac` biasa
belum cukup karena dependency berada di classpath Maven.

## Struktur folder yang benar

```text
Prasmana/
├── pom.xml
└── src/
    ├── main/java/warung/
    └── test/java/warung/
```

Jangan membuka `src/main/java` sebagai root project. Maven otomatis menjadikan folder tersebut
sebagai source root, sehingga deklarasi package tetap `package warung;`.

## Akun demo awal

| Username | Password | Peran |
|---|---|---|
| `admin` | `admin123` | ADMIN |
| `kasir` | `kasir123` | KASIR |

Password pada database disimpan sebagai hash SHA-256 dengan salt, bukan teks biasa.
Akun dan menu tersebut hanya data demo.

## Pembagian tahap untuk tiga orang

1. Anggota 1: fondasi project, model, utilitas, dan database.
2. Anggota 2: DAO/service, login, pengelolaan menu, dan transaksi.
3. Anggota 3: tampilan Swing, riwayat, laporan, pengujian integrasi, dan perapian.

## Asumsi dan batasan tahap ini

- Tahap ini mengikuti `AGENT_GUIDE_Warung_Tujuh_Beradik.md` dan memakai SQLite.
- Nilai uang disimpan sebagai integer rupiah.
- Tabel `biaya` dibuat sesuai skema guide, tetapi fitur biaya belum dikerjakan.
- JFrame masih kosong; belum ada login, CRUD menu, transaksi, laporan, atau export.
- SQLite digunakan sebagai file lokal satu komputer sesuai rancangan tahap awal.
