# Latihan 0: Perkenalan Git

CSCM602023 - Pemrograman Lanjut, 
Fakultas Ilmu Komputer Universitas Indonesia
Semester Genap 2016/2017

* * *

Halo! Selamat datang di tutorial pertama dari Pemrograman Lanjut,
Kali ini anda akan belajar bagaimana cara penggunaan mendasar dari
perintah yang ada di Git

Tutorial ini dibagi menjadi dua bagian. Bagian pertama merupakan pengenalan
mengenai perintah dasar dari Git. Anda akan belajar bagaimana membuat Git repository
di komputer lokal anda, menyimpan pekerjaan anda di dalam repository, serta melakukan
push repository yang terdapat di komputer lokal anda ke dalam remote Git repository.

Bagian kedua di dalam tutorial ini akan memperkenalkan lebih lanjut mengenai branches/cabang
yang terdapat di dalam Git dan bagaimana bekerja dengan cabang tersebut.

## Bagian Pertama: Git 101 : Perintah Dasar

Selama menjadi mahasiswa Ilmu Komputer, anda mungkin pernah menggunakan salah satu jenis
dari sistem untuk version control. Salah satu yang mungkin terjadi adalah menggunakan fungsi undo
pada text editor. Seperti halnya fungsi undo, ketika kita membuat kesalahan maka bisa dikembalikan
ke dalam state sebelum kita mengedit dokumen tersebut. Contoh lainnya adalah ketika menggunakan salah
satu fitur di dalam Google Drive (Docs, Excel, Presentation) dimana kita mengedit secara kolaboratif
dengan teman sekelompok kita dan Google Drive mencatat aktivitas apa saja yang telah dilakukan di dalam
dokumen tersebut.

Dalam sebagian besar kuliah ini, anda akan menggunakan tools bernama Git. Git adalah suatu sistem untuk
melakukan version control yang populer digunakan untuk mencatat perubahan di dalam suatu pengembangan perangkat lunak.
Git bekerja dengan cara mencatat setiap state dari perubahan tersebut dalam bentuk rangkaian commit. Rangkaian commit
tersebut di urutkan berdasarkan dari yang terlama hingga yang terbaru dan memungkinkan juga untuk terdapat beberapa
cabang. Representasinya bisa dianalogikan sebagai suatu graph dimana setiap nodenya merepresentasikan commit dan setiap
garis yang menghubungkan node tersebut merepresentasikan hubungan setiap commit seperti yang sudah dijelaskan sebelumnya.

Sekian penjelasan singkat dari Git, mari kita langsung mencoba tutorial pengenalan Git ini!

1. Silahkan membuka command-prompt atau shell. Untuk platform Windows, silahkan `Git Bash`.
Untuk platform Linux atau Mac-OS, kalian bisa langsung menggunakan terminal atau shell favorite kalian.
2. Silahkan membuat folder dimana akan dipakai sepanjang perkuliahan Advanced Programming dan masuk ke dalam
folder tesebut.

    Hint: Jika memakai command-prompt, bisa memakai perintah `mkdir` <Nama_Folder> dan bisa menggunakan perintah
    `cd`
3. Buatlah folder yang akan digunakan untuk menyimpan file yang akan dibuat dalam tutorial ini. 
Tuliskan nama dari folder tersebut sebagai `git-exercises` dan dengan memakai perintah `cd` masuk ke dalam folder tersebut.
4. Di dalam folder tersebut, silahkan eksekusi perintah `git init`. Setelah melakukan eksekusi perintah tersebut, maka 
akan terdapat Git repository kosong akan dibuat di dalam folder ini
5. Silahkan mencoba perintah `git status`. Dia akan mencetak state dari Git repository tersebut sampai pada saat sebelum 
melakukan perintah `git status`

Selamat! Anda telah membuat Git repository secara lokal di dalam komputer anda. Sebelum kita melanjutkan tutorial ini,
ada beberapa pengaturan yang harus dilakukan di repository Git lokal di dalam komputer anda.

1. Silahkan membuat username serta email yang akan digunakan untuk menyimpan atau mengambil data pekerjaan kalian di dalam
repository Git ini. Gunakan perintah ini ketika berada di dalam repository Git:
`git config user.name "<NAMA_ANDA>"` dan
`git config user.email <EMAIL_ANDA>`

    Contoh: `git config user.name "Muhammad Ardhan Fadhlurrahman"`
    `git config user.email muhammad.ardhan@ui.ac.id`
2. Jika anda menggunakan PC di dalam Lab Fasilkom UI, anda harus melakukan pengaturan HTTP proxy dalam konfigurasi Git tersebut.
Silahkan mengatur proxy dengan perintah:
`git config http.proxy 152.118.24.10:8080`
3. Jika anda ingin mengatur konfigurasi git agar konfigurasinya menjadi state 'global', silahkan menambahkan '--global' di dalam
perintah `git config`, contoh:
`git config --global user.name "Muhammad Ardhan Fadhlurrahman"`
4. Jika ingin mengetahui konfigurasi yang terdapat pada repository Git lokal anda, anda bisa melakukan eksekusi perintah:
`git config --list --local`

Setelah melakukan konfigurasi email serta username, silahkan melakukan langkah selanjutnya dalam tutorial ini:

1. Buatlah sebuah file baru bernamakan `README.md` dimana didalamnya terdapat beberapa komponen seperti nama pada baris pertama,
NPM pada baris kedua, serta kelas pada baris ketiga
2. Jalankan `git status` kembali. Bisa terlihat terdapat untracked file, yang berarti terdapat file yang belum di track oleh Git
3. Tambahkan file tersebut ke dalam Git dengan menggunakan perintah `git add README.md`
4. Jalankan `git status` kembali. Terdapat pesan yang berbeda dengan sebelumnya dimana `README.md` telah masuk ke dalam
`Changes to be commited`. Pesan tersebut memiliki arti bahwa `README.md` akan di track oleh Git pada commit berikutnya.
5. Pada saat ini, `README.md` belum di track oleh Git walaupun anda telah mengeksekusi perintah `git add README.md`. perintah
`git add` hanya memberitahukan Git untuk melakukan perubahan pada state setelah di commit
6. Untuk melakukan penggantian secara permanen, silahkan melakukan commit dengan mengeksekusi perintah `git commit`. Teks editor
akan muncul dimana anda harus menuliskan pesan yang mendeskripsikan perubahan yang terjadi sampai dengan anda melakukan commit.

    Cara menggunakan Vim: `h j k l` untuk memindahkan cursor. `i` untuk masuk ke dalam INSERT MODE, atau state dimana anda 
    bisa melakukan penambahan, pengurangan, atau modifikasi terhadap file tersebut. `escape` untuk kembali ke COMMAND MODE, atau state
    dimana anda bisa memasukan perintah dasar vim. `:w` di dalam COMMND MODE untuk menyimpan/write file yang tulis pada content buffer
    ke dalam output stream, `:q` dalam COMMAND MODE untuk keluar dari Vim

    Hint: Anda bisa langsung mengetik `:wq` untuk write and quit pada satu komentar bersamaan.
7. Setelah memasukan pesan dalam commit tersebut, perubahan akan terjadi dan tersimpan di dalam Git
8. Anda telah selesai melakukan commit

Anda telah membuat suatu repository Git dan sudah melakukan tracking terhadap perubahan yang terjadi pada file di dalam repository.
Repository yang telah dibuat pada langkah sebelumnya, hanya tersimpan pada komputer atau perangkat yang sekarang anda gunakan. Jika
anda ingin membagikan serta mengintegrasikan pekerjaan anda dengan teman kerja anda, anda harus mempunyai repository yang bisa diakses
melalui Web. Untuk melakukan hal tersebut, anda harus menduplikasikan repository yang terdapat pada komputer anda ke dalam Git hosting
online service bernama Gitlab.

1. Silahkan mengakses Gitlab.com dengan menggunakan browser sesuai dengan yang anda sukai.
2. Jika sudah mendaftar, gunakan akun Gitlab yang anda punya. Jika belum mempunyai akun tersebut, silahkan membuat akun baru.
3. Silahkan membuat repository baru bernama **my-first-git-repo** di dalam Gitlab dan silahkan masuk ke dalam halaman repository tersebut.
Pastikan anda melakukan pengaturan terlebih dahulu agar visibilitynya menjadi public.
4. Temukan bagian bernama `clone URL` di dalam halaman tersebut. Perhatikan terdapat dua jenis URL: HTTPS dan SSH, kita akan menggunakan
HTTPS URL. Silahka catat HTTPS URL tersebut ke dalam catatan anda.
5. Anda akan melakukan update terhadap repository Git yang terdapat pada komputer anda maka commit yang anda lakukan sebelumnya dapat 
disimpan dalam Gitlab. Silahkan melakukan eksekusi perintah `git remote add origin <URL>` dimana `<URL>` tersebut merupakan HTTPS URL
di dalam Gitlab repository anda. Contoh:
`git remote add origin https://gitlab.com/JohnDoe/my-first-git-repo.git`

    `git remote` akan menambahkan PATH pada repository lokal yang ada di komputer anda saat ini kepada repository online yang terdapat di GitLab.
    PATH tersebut akan diidentifikasi dengan nama `origin`. Dengan mempunyai PATH ini, anda dapat menyimpan commit yang anda lakukan ke dalam
    repository online anda.
6. Untuk menyimpan commit yang anda lakukan ke dalam repository online GitLab anda, silahkan mengeksekusi perintah `git push -u origin master`.
`git push -u` memberitahukan kepada Git untuk mengintegrasikan atau dalam terminologi Git adalah push, melakukan push dari commit yang anda
lakukan sebelumnya pada repository lokal anda. `origin` telah dijelaskan sebelumnya, dan `master` dimaksudkan untuk disimpan pada 
cabang `master`.
7. Silahkan melihat repository GitLab anda. Anda akan melihat file yang ada buat sudah bisa di akses melalui GitLab.

Anda juga dapat melakukan duplikasi terhadap repository online yang terdapat pada GitLab ke dalam komputer anda. Mari mencoba untuk
melakukan duplikasi terhadap repository GitLab online anda ke dalam folder lain di dalam komputer anda, dengan langkah berikut:
1. Silahkan masuk ke dalam halaman repository yang terdapat pada GitLab
2. Silahkan mencatat HTTPS clone URL yang terdapat pada repository tersebut.
3. Kembali ke command-prompt atau shell anda. silahkan membuat direktori seperti langkah awal tutorial ini
4. Silahkan eksekusi perintah berikut: `git clone <URL>` dimana `<URL>` nya adalah clone URL.
5. Silahkan mengecek dan melakukan validasi folder yang telah anda clone.

Ini merupakan akhir dari bagian pertama dari tutorial hari ini. Jangan lupa untuk menginformasikan GitLab username kepada tim pengajar
sehingga mereka dapat memantau pekerjaan anda dalam satu semester ini.

## Bagian Kedua: Git Branches

Ketika anda ingin melakukan modifikasi tetapi tidak ingin mengubah file yang anda bagikan kepada kolega anda di cabang 'master', anda
dapat membuat branch dengan cara seperti berikut:

1. Pastikan anda berada di dalam direktori/folder Git dengan cabang `master`
2. Silahkan eksekusi perintah `git branch <NAMA_CABANG>`, contohnya:
`git branch cool-feature`
3. Silahkan mengakses cabang tersebut dengan perintah:
`git checkout <NAMA_CABANG>`

    Langkah ke 2 dan 3 bisa dipersingkat menjadi satu perintah seperti `git checkout -b <NAMA_CABANG>`

Selamat! anda telah masuk ke dalam cabang yang anda buat. Sekarang kita akan melakukan simulasi merge conflict pada dua branch:

1. Silahkan membuka file `README.md` pada branch yang telah anda buat
2. Tambahkan baris keempat dengan hobi anda
3. Simpan `README.md` 
4. Silahkan melakukan perintah `git add`
5. Silahkan melakukan perintah `git commit`
6. Silahkan pindah ke branch `master` dengan perintah `git checkout master`
7. Silahkan membuka file `README.md` pada branch `master`
8. Tambahkan di baris keempat dengan hobi anda yang lain (tidak boleh sama)
9. Simpan `README.md`
10. Silahkan melakukan eksekusi perintah `git merge <NAMA_CABANG>`

Akan terdapat masalah pada git merge tersebut, Git secara otomatis akan memberikan solusi secara default yang bisa kalian
lihat pada file README.md. Di dalam file 'README.md' akan terdapat dua buah garis yang mendefinisikan konflik yang terjadi
pada file yang sama di baris yang sama. Silahkan memilih hobi mana yang menurut anda paling cocok dengan diri anda sendiri.

Sebagai contoh, misalkan anda memanggil perintah `git merge` di dalam cabang/branch `master`. Git akan memberitahu bahwa akan
terdapat merge conflict di dalam file README.md. Maka dari itu secara otomatis, Git akan melakukan perubahan pada masing masing
file README.md di semua cabang dan meminta programmer untuk melakukan penyelesaian konflik tersebut. Contoh konflik pada bagian
README.md adalah sebagai berikut:

```
Nama  : Muhammad Ardhan Fadhlurrahman
NPM   : 1206278246
Kelas : Pemrograman Lanjut A
<<<<< HEAD
Hobby : Tidur
=========
Hobby : Main Guitar Hero
>>>>> cool-feature
```

### Mandatory Tasks Checklist

- [ ] Melakukan Commit pada Repositori Git lokal
- [ ] Melakukan Sinkronisasi dari Repositori Git lokal dengan GitLab
- [ ] Terdapat satu cabang/branch pada Repositori Git lokal

## Additional Tasks Checklist

- [ ] Menemukan sebuah repositori public di dalam GitLab atau GitHub
dan mencoba melakukan eksekusi perintah clone ke dalam repositori Git
lokal
- [ ] Dapat menunjukan cara untuk melakukan handling merge conflict

## Additional Resources

- [Git Tutorials & Training by Atlassian](https://www.atlassian.com/git/tutorials)
- [Try Git in your Web browser](https://try.github.io/)
- [Pro Git e-book by Scott Chacon & Ben Straub](https://git-scm.com/book/en/v2)
- [Graph theory](http://think-like-a-git.net/sections/graph-theory.html)
- [Graph and Application in Git](http://think-like-a-git.net/sections/graphs-and-git.html)
