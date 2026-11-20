# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working in this repository.

## Requirements source

The repository is currently an empty Java project: no source tree, build tool, tests, README, or editor-agent rules exist yet. The authoritative requirements are in:

`/home/tenkai/Obsidian Vault/3-Projects/Pramana/Prompt_Desain_Sistem_Warung_Tujuh_Beradik_FIX.md`
`/home/tenkai/Obsidian Vault/3-Projects/Pramana/AGENT_GUIDE_Warung_Tujuh_Beradik.md`

Read that document before implementing or changing the application. Parts 1–13 are the requirements; Part 14 defines the staged delivery process. Do not use the older non-`_FIX` note as the source of truth.

## Commands

No project-specific build, lint, or test commands exist yet. The planned project is compiled and run from the repository root with Java 17+:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out warungtujuhberadik.Main
```

Use `src` as the source root in an IDE, run `warungtujuhberadik.Main`, and keep the working directory at the project root. There is no test framework yet; run any plain Java self-check class with `java -cp out <package.ClassName>`. Leave at least one runnable check for non-trivial money, transaction, persistence, or report logic.

The application stores local data at `data/warung.dat` relative to the working directory. `data/warung.dat` is generated at first run and must be ignored by version control.

## Architecture

Use plain Java Swing and JDK classes only: no Spring, Hibernate, JavaFX, Lombok, or external dependencies. Keep one class per file and dependencies flowing `ui -> service -> repository -> local data`.

- `config`: `Konfigurasi` (application constants, colors, dimensions) and `DataAwal` (seed data).
- `model`: Serializable domain models and enums: abstract `Pengguna`, `Kasir`, `Admin`, `Menu`, `Transaksi`, `DetailTransaksi`, `Pembayaran`, `DatabaseData`, `Keranjang`, `ItemKeranjang`, `RingkasanLaporan`, `BarisLaporanMenu`, `Peran`, `StatusMenu`, `MetodePembayaran`, `StatusTransaksi`, and `StatusPembayaran`.
- `repository`: `DataRepository` and `FileDataRepository`. Repository loads once into a shared in-memory cache; services mutate that data and persist it through the interface.
- `service`: `AuthService`, `MenuService`, `TransaksiService`, `LaporanService`, `StrukService`, and `AksesDitolakException`. Services own validation and authorization; UI checks are only early feedback.
- `ui`: `LoginFrame`, `MainFrame`, `DashboardPanel`, `MenuPanel`, `TransaksiPanel`, `RiwayatPanel`, and `LaporanPanel`. Handlers read controls, call services, and refresh views; do not put business rules or file I/O in handlers.
- `util`: `FormatRupiah`, `GeneratorId`, and `PasswordUtil`.
- `Main.java`: constructs the repository/services and starts Swing with `SwingUtilities.invokeLater`.

Pass dependencies through constructors; do not use global variables. Logout closes the main frame and creates a fresh login frame.

## Fixed contracts and data rules

Keep the public names/signatures in Part 9 of the requirements stable. Important contracts include:

- `AksesDitolakException` is thrown for unauthorized service operations. Sensitive service methods receive `Pengguna pelaku`.
- `MenuService` supports role-filtered listing, search, CRUD, and rejects duplicate names (case-insensitive after trim). IDs are automatic `M001`, `M002`, … and are never reused. A menu already referenced by a transaction cannot be deleted; mark it unavailable instead.
- `TransaksiService.simpanTransaksi(Pengguna, Keranjang, MetodePembayaran, BigDecimal)` validates again, writes transaction/detail/payment together, rejects a saved cart, and preserves in-memory/file consistency if persistence fails.
- `LaporanService` supports admin-only daily and monthly reports and counts only `SELESAI` transactions. Reports aggregate quantities, revenue, transactions, and all tied best-selling menus; an empty period returns zero and no winner.
- `StrukService` creates a fixed-width 40-character monospaced receipt and supports printing with `JTextArea.print()`.

Use `BigDecimal` with scale 0 for rupiah and compare values with `compareTo`, not `equals`. Use `java.time`. All serialized classes (`Pengguna`, `Kasir`, `Admin`, `Menu`, `Transaksi`, `DetailTransaksi`, `Pembayaran`, `DatabaseData`) implement `Serializable` with `serialVersionUID`.

Transaction details are immutable snapshots containing `idMenu`, `namaMenu`, `jumlah`, `hargaSatuan`, and `subtotal`; never store a `Menu` object reference in a detail. IDs follow these formats:

- Transaction: `TRX-yyyyMMdd-NNN`, sequence highest existing number for that date plus one.
- Detail: `<idTransaksi>-D1`, `<idTransaksi>-D2`, …
- Payment: `PAY-yyyyMMdd-NNN`, sharing the transaction sequence.

The cart is temporary and not serialized. Adding the same menu merges quantities. A transaction requires at least one item, positive integer quantities, available menus at save time, a payment method, and payment at least the total for cash or exactly the total for QRIS/e-wallet. Cash change is display-only. QRIS/e-wallet payment is recorded only after a confirmation dialog; there is no provider integration. Disable Save while processing and use the cart's `sudahDisimpan` guard.

## Persistence safety

Use one file `data/warung.dat`. Create the directory/file automatically only when no data file exists. Write to `warung.dat.tmp`, then move to the target using `REPLACE_EXISTING` and try `ATOMIC_MOVE`. If an existing file cannot be read, show a clear error and exit without writing or replacing it. Never silently treat corrupt data as empty.

Seed data is demo-only and created by `DataAwal.buat()` only when the file is absent:

- Admin: `admin` / `admin123`, name `Pemilik`.
- Cashier: `kasir` / `kasir123`, name `Kasir 1`.
- `M001` Ayam Rp10.000 (Lauk), `M002` Ikan Rp8.000 (Lauk), `M003` Nasi Rp5.000 (Nasi), `M004` Es Teh Rp3.000 (Minuman).

Passwords use `PBKDF2WithHmacSHA256`: `iterasi:saltBase64:hashBase64`, 120000 iterations, 16-byte random salt, 256-bit key, and constant-time comparison. Login accepts `char[]`, clears it with `Arrays.fill`, and reports the generic message `Username atau password salah.`

## Roles and UI behavior

- Admin: Beranda, Transaksi, Riwayat, Menu, Laporan; sees all menus and transactions and can manage menus/reports.
- Cashier: Transaksi, Riwayat, Daftar Menu read-only; sees available menus and only transactions they recorded.
- Enforce both UI visibility and service authorization.
- Admin login opens Dashboard; cashier login opens Transaksi.
- Use Swing layout managers, `CardLayout`, non-editable `JTable`s, and action buttons below tables rather than buttons inside cells.
- Main window is about `1100x700`, minimum `960x600`; use the specified navy/slate/green/amber/red/light-gray palette from the source document. UI text and comments are Indonesian.

Do not add customer self-ordering, payment-gateway integration, expense/profit-and-loss features, a separate catering workflow, mobile/web support, account/password-management features, transaction deletion/cancellation, or a relational database unless requirements are explicitly changed. No expense entity exists.

## Implementation order

Follow the source document's five stages and normally do one stage per response:

1. Foundation: enums, models/support models, `Konfigurasi`, and utilities.
2. Persistence and services.
3. `Main`, login, main frame, role sidebar, and dashboard.
4. Menu and transaction pages, receipt dialog/printing.
5. History, reports, run instructions, demo-account notice, and checklist.

Keep public signatures from the source document unchanged. If a conflict requires a deviation, document it explicitly rather than changing it silently. Before declaring completion, compile from the project root and check the minimum scenarios in Part 13, especially role filtering, duplicate-save prevention, snapshot history, atomic persistence, corrupt-file handling, and tied best-seller reporting.
