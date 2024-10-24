-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 21, 2024 at 05:10 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `drstone`
--

-- --------------------------------------------------------

--
-- Table structure for table `batu`
--

CREATE TABLE `batu` (
  `idBatu` varchar(10) NOT NULL,
  `namaBatu` varchar(50) NOT NULL,
  `deskripsi` text NOT NULL,
  `karakteristik` text NOT NULL,
  `gambar` text NOT NULL,
  `sumberYoutube` text DEFAULT NULL,
  `sumberWebsite` text DEFAULT NULL,
  `sumberGoogleScholar` text DEFAULT NULL,
  `idSubKategoriBatu` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `batu`
--

INSERT INTO `batu` (`idBatu`, `namaBatu`, `deskripsi`, `karakteristik`, `gambar`, `sumberYoutube`, `sumberWebsite`, `sumberGoogleScholar`, `idSubKategoriBatu`) VALUES
('1', 'Batu Granit', 'Granit adalah batuan beku yang terbentuk dari pendinginan magma jauh di bawah permukaan bumi. Proses pendinginan ini sangat lambat, sehingga memungkinkan mineral-mineral di dalamnya membentuk kristal yang besar. Granit termasuk dalam kategori batuan beku intrusif dan bisa ditemukan di kerak benua. Batu Granit digunakan di berbagai tempat seperti countertop dapur, lantai rumah, paving jalan, hingga batu nisan dan monumen. Daya tahan dan estetika granit membuatnya menjadi pilihan yang selalu populer, baik di zaman kuno maupun modern.', '• Granit berwarna terang, dengan variasi seperti merah muda, putih, abu-abu, merah, dan hijau.\n• Teksturnya kasar dan kuat, dengan permukaan yang biasanya agak berkilau.\n• Nilai kekerasan sekitar 6 hingga 7 pada skala Mohs.', 'https://drive.google.com/file/d/1RXDIjl3OTsaEBBqiFAPrFZPp0mpfnGRz/view?usp=drive_link', 'https://youtu.be/_SkZTIrR0-U?si=1gQI0N7xyic_IsVb', 'https://ilmugeografi.com/geologi/batuan-granit', 'https://jgsm.geologi.esdm.go.id/index.php/JGSM/article/view/718', '3'),
('10', 'Batu Pasir', 'Batu pasir adalah jenis batuan sedimen klastik yang terbentuk dari butiran-butiran pasir (berukuran 0,0625 hingga 2 mm), yang terkompaksi dan tersemen. Batu ini terbentuk dari material pasir yang terangkut oleh air, angin, atau es, kemudian diendapkan di lingkungan seperti sungai, pantai, gurun, atau dasar laut.', '• Warna: Bervariasi, tergantung pada komposisi mineral butiran pasir. Warna umum termasuk cokelat, kuning, merah, putih, dan abu-abu.\n• Tekstur: Sedang hingga kasar, karena ukuran butirannya seragam dan dapat dirasakan saat disentuh. Tekstur batu pasir cenderung halus atau sedikit kasar, bergantung pada ukuran butiran pasir.\n• Kekerasan (Skala Mohs): Biasanya antara 6 hingga 7 pada skala Mohs, tergantung pada jenis mineral yang mendominasi.', 'https://drive.google.com/file/d/1tqiv06mXZsHxir_bLBYvVvVGPQL6UyDd/view?usp=drive_link', 'https://youtu.be/NJdhDBfnMr8?si=VVnJnYOHI5f61bTO', 'https://geology.com/rocks/sandstone.shtml', 'https://link.springer.com/chapter/10.1007/978-3-642-34132-8_4', '2'),
('11', 'Batu Serpih (Shale)', 'Batu serpih (shale) adalah jenis batuan sedimen klastik yang terbentuk dari partikel-partikel halus seperti lempung dan mineral-mineral lainnya dengan ukuran butiran kurang dari 0,004 mm. Batu serpih terbentuk dari endapan lumpur yang terkompresi dan tersemen selama jutaan tahun, sering kali di lingkungan yang tenang seperti dasar danau atau laut.', '• Warna: Umumnya berwarna abu-abu gelap hingga hitam, tetapi bisa juga berwarna hijau, cokelat, merah, atau kuning tergantung pada komposisi mineral dan bahan organik yang terkandung di dalamnya.\n• Tekstur: Halus dan berlapis-lapis (laminasi), dengan butiran sangat kecil yang sulit dilihat tanpa mikroskop. Batu serpih memiliki kemampuan untuk membelah menjadi lembaran tipis mengikuti lapisan-lapisannya.\n• Kekerasan (Skala Mohs): Biasanya antara 3 hingga 4 pada skala Mohs.', 'https://drive.google.com/file/d/1zf7qSfrm4pIAXS-JCjWW2x1tNAQHYdif/view?usp=drive_link', 'https://youtu.be/crSfFg3ZoF4?si=18TnYFo2MQT3OgU8', 'https://geologyscience.com/rocks/sedimentary-rocks/shale/', NULL, '2'),
('12', 'Porfiri Granit', 'Batu porfiri granit adalah jenis batuan beku yang terdiri dari mineral yang terbentuk dalam dua fase pendinginan berbeda. Batuan ini disebut \"porfiri\" karena mengandung kristal-kristal besar (fenokris) yang tertanam dalam matriks atau latar belakang berbutir lebih halus. Pada porfiri granit, kristal-kristal besar ini biasanya terdiri dari kuarsa, feldspar, dan mika, yang sama dengan granit biasa, tetapi dengan tekstur porfiritik yang khas. Batu porfiri granit memiliki berbagai kegunaan berkat kekuatan, daya tahan, dan teksturnya yang unik. Salah satu penggunaan utamanya adalah dalam konstruksi, di mana batu ini sering digunakan sebagai bahan bangunan untuk dinding, jembatan, dan infrastruktur lainnya, karena ketahanan terhadap tekanan dan aus. Selain itu, porfiri granit banyak dimanfaatkan sebagai batu paving untuk trotoar, jalan setapak, dan permukaan luar lainnya.', '• Porfiri granit memiliki warna yang bervariasi, tergantung pada komposisi mineralnya. Biasanya berwarna abu-abu, merah muda, atau putih.\n• Porfiritik: Tekstur ini adalah ciri khas dari batuan porfiri, di mana terdapat campuran kristal besar (fenokris) dan butiran halus. Dan Granitik: Sama seperti granit, porfiri granit memiliki komposisi yang mirip dengan batuan granit standar, tetapi dengan tambahan tekstur porfiritik.\n• Porfiri granit memiliki kekerasan sekitar 6 hingga 7 pada skala Mohs.', 'https://drive.google.com/file/d/19WmtiVBJ7xDsP14B40PouEqAzB0Iygx9/view?usp=drive_link', 'https://youtu.be/lnOv9gQ1DoY?si=b1uUiPWWnD-ykwnD', 'https://geologybase.com/granite-porphyry/', NULL, '9'),
('13', 'Porfiri Gabbro', 'Batu porfiri gabbro adalah jenis batuan beku yang memiliki komposisi mineral yang sama dengan gabbro, tetapi dengan tekstur porfiritik. Batuan ini terbentuk dari magma yang mendingin secara bertahap dalam dua fase, menghasilkan kristal besar (disebut fenokris) yang tertanam dalam matriks yang lebih halus. Batu porfiri gabbro terdiri dari mineral-mafiksi seperti plagioklas (biasanya labradorit), pyroksen (augit), olivin, dan kadang-kadang hornblenda. Batu porfiri gabbro memiliki berbagai kegunaan yang signifikan dalam konstruksi dan dekorasi, berkat kekuatan dan daya tahannya yang tinggi. Dalam bidang konstruksi, batu ini sering digunakan sebagai bahan untuk fondasi bangunan, jembatan, dan jalan raya, di mana kemampuan menahan beban berat dan ketahanannya terhadap pelapukan sangat dibutuhkan. Selain itu, porfiri gabbro juga digunakan sebagai batu paving untuk trotoar dan jalan setapak, ideal untuk area dengan lalu lintas tinggi.', '• Warna porfiri gabbro umumnya gelap, dengan nuansa hitam hingga hijau tua atau abu-abu karena dominasi mineral-mineral mafik seperti pyroksen dan olivin.\n• Batu porfiri gabbro memiliki tekstur porfiritik, yang artinya terdapat kristal besar (fenokris) yang terlihat jelas dan tertanam dalam matriks yang lebih halus.\n• Batu porfiri gabbro memiliki kekerasan sekitar 5 hingga 6 pada skala Mohs.', 'https://drive.google.com/file/d/1Xl9rLCxnG01DtPl_J5PwcGXBEiDhwh_f/view?usp=drive_link', 'https://youtu.be/lnOv9gQ1DoY?si=b1uUiPWWnD-ykwnD', NULL, NULL, '9'),
('14', 'Batu Sekis', 'Batu sekis adalah jenis batuan metamorf berfoliasi yang terbentuk melalui proses metamorfisme tingkat menengah hingga tinggi. Batuan ini mengalami tekanan dan suhu yang tinggi, biasanya dalam skala regional, yang menyebabkan mineral-mineral di dalamnya tersusun dalam lapisan-lapisan atau pita yang sejajar, memberikan tampilan yang berlapis dan mudah terbelah. Batu sekis biasa digunakan untuk bahan bangunan seperti untuk dinding, paving, dan digunakan untuk ornamen dan dekorasi.', '• Batu sekis umumnya berwarna abu-abu, hijau, perak, dan coklat.\n• Batu sekis memiliki tekstur kasar dan terlihat bercahaya. Dan struktur berlapis yang membuatnya rapuh dan mudah terbelah.\n• Kekerasan batu sekis biasanya berada pada kisaran 3 hingga 4 pada skala Mohs.', 'https://drive.google.com/file/d/1NT98A93LxR1dH39P4fQf6hLgwhSEHshs/view?usp=drive_link', 'https://youtu.be/hPISq97S2mQ?si=iYYK6KzOpebW4lA2', 'https://geologyscience.com/rocks/metamorphic-rocks/schist/', NULL, '7'),
('15', 'Batu Gneis', 'Batu Gneis terbentuk melalui proses metamorfisme regional, di mana batuan asalnya seperti granit atau batuan sedimen seperti batu pasir mengalami tekanan dan suhu tinggi selama periode waktu yang sangat lama. Proses ini sering terjadi akibat pergerakan lempeng tektonik, yang membuat gneis umumnya ditemukan di daerah pegunungan. Kegunaannya biasa digunakan di kontruksi sebagai bahan bangunan, untuk dekorasi, dan monumen.', '• Batu Gneis biasanya berwarna abu-abu, coklat, merah muda, atau putih dengan pita-pita mineral berwarna gelap.\n• Batu Gneis memiliki tektur kasar dan berpola.\n• Batu Gneis memiliki tingkat kekerasan yang relatif tinggi, berkisar antara 6 hingga 7 pada skala Mohs.', 'https://drive.google.com/file/d/1ufAgcpWr-znYMl-Qe1_yD1bu_DPKrzO8/view?usp=drive_link', 'https://youtu.be/H-qTJs1ywIo?si=jfygskDqHC0b6w1J', 'https://www.britannica.com/science/gneiss', NULL, '7'),
('16', 'Batu Kuarsit', 'Batu Kuarsit terbentuk dari batu pasir kuarsa yang mengalami metamorfisme, baik melalui metamorfisme kontak maupun regional. Proses metamorfosis ini mengubah butiran kuarsa menjadi kristal yang lebih padat dan terkonsolidasi, menciptakan batu yang sangat kuat dan keras. Kegunaannya untuk konstruksi sebagai pelapis dinding dan lantai serta industri sebagai produksi beton.', '• Kuarsit biasanya berwarna putih hingga abu-abu terang.\n• Kuarsit memiliki tekstur non-foliasi atau masif, tanpa lapisan. Permukaannya lebih halus dan seragam.\n• Kuarsit memiliki tingkat kekerasan yang sangat tinggi, biasanya berkisar pada 7 pada skala Mohs.', 'https://drive.google.com/file/d/16TLTys2TkwJnXhtOIFyemXzFHhhNFLBx/view?usp=drive_link', 'https://youtu.be/PrXa-SkFheU?si=LBcpdRGCqYUinr0y', 'https://geology.com/rocks/quartzite.shtml', NULL, '7'),
('17', 'Batu Sabak', 'Batu Sabak, atau slate, adalah batuan metamorf berfoliasi yang terbentuk melalui metamorfisme tingkat rendah dari batuan sedimen seperti shale atau batu lanau. Proses metamorfisme ini menghasilkan tekstur halus, di mana mineral-mineral dalam sabak, terutama mika, tersusun sejajar dalam lapisan-lapisan tipis yang memungkinkan sabak dibelah menjadi lembaran yang rata. Kegunaannya biasanya untuk atap, ubin, meja tulis, dan eksterior.', '• Umumnya berwarna abu-abu gelap, hitam, hijau, atau merah, tergantung pada kandungan mineralnya.\n• Berfoliasi halus, yang berarti mineral tersusun dalam lapisan-lapisan sejajar yang tipis, mudah dibelah menjadi lembaran.\n• Cukup keras dengan skala Mohs sekitar 3 hingga 5.', 'https://drive.google.com/file/d/1cu3pDVAc3UrFLN1Gp8XKVjgwjs0AB58O/view?usp=drive_link', 'https://youtu.be/suQPIY5x_qI?si=zOHNovp8J1JCkwK7', 'https://geology.com/rocks/slate.shtml', NULL, '1'),
('18', 'Batu Milonit', 'Milonit adalah batuan metamorf yang terbentuk akibat deformasi intensif dalam zona geser tektonik. Milonit terbentuk melalui tekanan dan geseran yang sangat kuat, sering kali di sepanjang patahan atau zona geser aktif, di mana batuan mengalami rekristalisasi akibat deformasi plastis. Milonit umumnya menunjukkan foliasi karena deformasi dan rekristalisasi yang berlangsung secara intens di bawah tekanan tinggi. Kegunaannya hanya untuk studi geologi.', '• Warna bervariasi, tetapi seringkali berwarna abu-abu, hitam, atau coklat tergantung pada komposisi mineralnya.\n• Tekstur halus hingga sangat halus, dengan foliasi.\n• Kekerasan umumnya memiliki kekerasan yang tinggi, antara 5 hingga 7 pada skala Mohs.', 'https://drive.google.com/file/d/1jz8LOVDZk09439p-4dtGYXiK-NBJtC3l/view?usp=drive_link', 'https://youtu.be/2cfDfXp4YLA?si=zC1VGQiIqGTcvu1S', 'https://www.sandatlas.org/mylonite/', NULL, '1'),
('19', 'Batu Filonit', 'Filonit, atau phyllonite, adalah batuan metamorf yang terbentuk melalui deformasi dinamis dalam zona geser, mirip dengan milonit, tetapi pada tekanan yang lebih rendah dan dengan kondisi metamorfisme yang lebih ringan. Batu ini menunjukkan tekstur berfoliasi yang lebih halus dibandingkan milonit dan sering mengandung mineral yang mengalami deformasi tetapi tidak hancur sepenuhnya, memungkinkan beberapa struktur asli batuan asal tetap terlihat. Kegunaannya untuk penelitian geologi.', '• Warna abu-abu, kehijauan, atau coklat, bergantung pada kandungan mineralnya.\n• Tekstur berfoliasi halus, tetapi tidak sehalus sabak.\n• Kekerasannya umumnya berkisar antara 4 hingga 6 pada skala Mohs.', 'https://drive.google.com/file/d/1er1GZkigNlA_XGuHIv4Ve7gi5MQ-Sbt9/view?usp=drive_link', 'https://youtu.be/_POm5mOcbD8?si=BFpN5uAFKj1-W2cm', 'https://geologyscience.com/rocks/phyllite/', NULL, '1'),
('2', 'Batu Gabbro', 'Gabbro adalah batuan beku intrusif yang terbentuk dari pendinginan magma di bawah permukaan bumi. Batuan ini termasuk dalam kategori batuan beku mafik, yang berarti mengandung jumlah mineral mafik yang tinggi, seperti piroksen dan plagioklas feldspar. Batuan Gabbro memiliki berbagai penggunaan yang bermanfaat, mulai dari konstruksi hingga dekorasi. Dalam dunia konstruksi, gabbro digunakan sebagai bahan bangunan untuk pembuatan dinding, fondasi, dan struktur bangunan lainnya, berkat kekuatan dan daya tahannya. Batu ini juga sering dipakai untuk paving jalan, trotoar, dan area luar ruangan lainnya.', '• Gabbro umumnya berwarna gelap, sering kali hitam atau hijau tua.\n• Gabbro memiliki tekstur faneritik, artinya butir-butir mineralnya cukup besar.\n• Gabbro memiliki kekerasan sekitar 6 hingga 7 pada skala Mohs.', 'https://drive.google.com/file/d/1Cwzrf_7PFXdxpAm4q7VAEWLpaTgmzne6/view?usp=drive_link', 'https://youtu.be/SoPG4r-tHus?si=CyDHxshWVwgWTE7x', 'https://ilmugeografi.com/geologi/batu-gabro', NULL, '3'),
('20', 'Batu Apung', 'Batu apung adalah batuan beku vulkanik yang terbentuk dari letusan gunung berapi. Batu apung terbentuk ketika lava yang mengandung banyak gas mengalami pengurangan tekanan yang drastis, sehingga gas-gas tersebut keluar dan menciptakan pori-pori yang membuat batu ini sangat berongga. Batu apung memiliki beragam penggunaan di berbagai industri karena sifatnya yang ringan dan abrasif. Dalam industri konstruksi, batu apung digunakan sebagai agregat ringan dalam pembuatan beton dan blok beton, menjadikannya ideal untuk bangunan bertingkat atau jembatan karena memberikan kekuatan tanpa menambah berat. Selain itu, batu apung sering digunakan sebagai bahan abrasif ringan untuk pengelupasan kulit mati, seperti pada produk perawatan kulit atau batu apung untuk kaki, dan juga untuk membersihkan permukaan material tanpa merusaknya.', '• Batu apung biasanya berwarna terang, seperti abu-abu, putih, atau kuning pucat.\n• Memiliki tekstur kasar dan berpori, sering kali terasa seperti kertas amplas. Ukuran pori-pori bisa bervariasi, mulai dari sangat kecil hingga cukup besar.\n• Batu apung memiliki kekerasan yang relatif rendah, yaitu sekitar 5 hingga 6 pada skala Mohs.', 'https://drive.google.com/file/d/1C0FlbVVFJqv2IGM4649CF1YoEw77neOW/view?usp=drive_link', 'https://youtu.be/q1ag3WhDctQ?si=vZEC0g2efcrxRevG', 'https://geologyscience.com/rocks/igneous-rocks/extrusive-igneous-rocks/pumice/', 'https://iptek.its.ac.id/index.php/jfa/article/download/1403/1178', '6'),
('21', 'Batu Liparit', 'Batu liparit, yang juga dikenal sebagai riolit, adalah batuan beku vulkanik yang terbentuk dari pendinginan lava dengan kandungan silika yang sangat tinggi. Ini adalah batuan yang kaya akan mineral felsik, seperti kuarsa, feldspar, dan biotit, sehingga membuatnya memiliki komposisi yang mirip dengan granit, tetapi terbentuk di permukaan bumi atau dekat permukaan akibat aktivitas vulkanik. Batu liparit biasa digunakan di berbagai bidang seperti untuk bahan bangunan di daerah vulkanik karena daya tahannya yang baik terhadap peapukan. Kemudian bisa untuk batu ornamen sebagai hiasan ataupun juga sebagai agregat untuk campuran beton.', '• Liparit umumnya berwarna terang, seperti putih, abu-abu muda, merah muda, atau krem.\n• Liparit memiliki tekstur yang bervariasi, mulai dari afanitik (butir halus dan tidak terlihat dengan mata telanjang) hingga porfiritik (mengandung kristal besar yang dikelilingi oleh matriks halus).\n• Liparit memiliki kekerasan sekitar 6 hingga 7 pada skala Mohs.', 'https://drive.google.com/file/d/1x-cOUw-7n17Q9VWLMGBAmpH1xi1k2Lb-/view?usp=drive_link', 'https://youtu.be/bmu1WfgZbf4?si=WxXNBwrXmEyElg2L', 'https://geologybase.com/rhyolite/', NULL, '6'),
('22', 'Batu Gamping (Limestone)', 'Batu gamping (limestone) adalah jenis batuan sedimen yang terutama terdiri dari mineral kalsium karbonat (CaCO₃), biasanya dalam bentuk kalsit. Batu ini sering terbentuk di lingkungan laut dangkal dari pengendapan sisa-sisa organisme laut seperti koral, foraminifera, dan alga. Batu gamping juga dapat terbentuk melalui proses kimiawi ketika kalsium karbonat mengendap dari air yang jenuh mineral.', '• Warna: Umumnya berwarna putih hingga abu-abu terang, tetapi bisa juga berwarna kuning, cokelat, atau hitam tergantung pada kandungan mineral lain dan bahan organik yang ada di dalamnya. Batu gamping yang mengandung banyak bahan organik cenderung lebih gelap.\n• Tekstur: Bervariasi dari halus hingga agak kasar, tergantung pada ukuran butirannya. Batu gamping organik sering memiliki tekstur kasar karena mengandung fragmen cangkang atau koral, sementara yang terbentuk secara kimiawi cenderung memiliki tekstur lebih halus.\n• Kekerasan (Skala Mohs): Biasanya antara 3 hingga 4 pada skala Mohs. Kekerasan batu gamping relatif rendah karena terbuat dari kalsit, yang mudah tergores oleh mineral yang lebih keras.', 'https://drive.google.com/file/d/1jhe7fUaUDrZy1hef_ornuEUzNhggbXuD/view?usp=drive_link', 'https://youtu.be/UhgvUr-oXuI?si=ya7xWyLV51Q0GmXE', 'https://www.britannica.com/science/limestone', 'https://link.springer.com/content/pdf/10.1007/978-3-642-75829-4_2?pdf=chapter%20toc', '5'),
('23', 'Halite (Garam Batu)', 'Halite adalah jenis batuan sedimen yang terdiri dari mineral natrium klorida (NaCl), yang dikenal sebagai garam batu. Halite terbentuk terutama melalui proses penguapan air laut atau air danau yang kaya garam, di mana air yang menguap meninggalkan kristal garam sebagai endapan. Halite sering ditemukan di daerah dengan iklim kering atau di dasar danau garam.', '• Warna: Umumnya berwarna putih atau transparan, tetapi bisa juga berwarna merah, kuning, atau cokelat tergantung pada kontaminan atau mineral lain yang ada dalam larutan saat pengendapan.\n• Tekstur: Memiliki tekstur kristal, dengan struktur yang umumnya berbentuk kubus. Halite dapat ditemukan dalam bentuk butiran kecil atau sebagai blok besar. Permukaannya dapat licin dan bersinar, terutama pada potongan yang halus.\n• Kekerasan (Skala Mohs): Sekitar 2 hingga 2,5 pada skala Mohs. Halite cukup lunak dan dapat dengan mudah tergores dengan kuku atau alat yang lebih keras.', 'https://drive.google.com/file/d/1yctV5UAfZAL0DpzKiHKzM7E01ta2usII/view?usp=drive_link', 'https://youtu.be/PAcgL1olrhI?si=xtVAN5FQZYblqYRu', 'https://geologyscience.com/minerals/halite/', NULL, '5'),
('3', 'Batu Diorit', 'Diorit adalah batuan beku intrusif yang terbentuk dari pendinginan magma yang terjadi di bawah permukaan bumi. Diorit sering dianggap sebagai batuan transisi antara granit (yang kaya akan kuarsa) dan gabbro (yang kaya akan mineral mafik). Diorit memiliki beragam penggunaan yang bermanfaat dalam berbagai bidang. Dalam dunia konstruksi, diorit digunakan sebagai bahan bangunan yang kuat, termasuk dalam pembuatan dinding, fondasi, dan paving. Selain itu, diorit juga digunakan sebagai agregat dalam campuran beton dan aspal, di mana kekuatan dan kepadatan batuan ini memberikan daya tahan tambahan pada struktur bangunan.', '• Diorit biasanya berwarna abu-abu, hijau tua, atau hitam.\n• Diorit memiliki tekstur faneritik, artinya butir-butir mineralnya cukup besar.\n• Diorit memiliki kekerasan sekitar 6 hingga 7 pada skala Mohs.', 'https://drive.google.com/file/d/1isMvOl9QhObRPezZuWQASMzfXGFQ7ekf/view?usp=drive_link', 'https://youtu.be/CJ7mpHtrw4g?si=tanDvj65x7vXurCi', 'https://ilmugeografi.com/geologi/batu-diorit', 'https://jgsm.geologi.esdm.go.id/index.php/JGSM/article/view/718', '3'),
('4', 'Batu Syenit', 'Syenit adalah batuan beku intrusif yang kaya akan feldspar, terutama feldspar alkali, dengan kandungan kuarsa yang relatif rendah. Syenit terbentuk dari pendinginan magma yang terjadi di bawah permukaan bumi dan sering dianggap sebagai batuan transisi antara granit dan basalt. Batu Syenit memiliki berbagai penggunaan yang bermanfaat di berbagai bidang. Dalam konstruksi, syenit digunakan sebagai bahan dasar untuk pembuatan dinding, fondasi, dan struktur bangunan lainnya, berkat kekuatan dan daya tahannya yang menjadikannya pilihan yang baik untuk proyek-proyek konstruksi. Selain itu, syenit sering digunakan sebagai agregat dalam campuran beton dan aspal, di mana ukuran batuan yang bervariasi memberikan daya tahan tambahan pada struktur.', '• Syenit biasanya berwarna terang hingga sedang, seperti abu-abu, merah muda, atau kuning, tergantung pada komposisi mineral yang ada.\n• Syenit memiliki tekstur faneritik, artinya butir-butir mineralnya cukup besar.\n• Syenit memiliki kekerasan sekitar 6 hingga 7 pada skala Mohs.', 'https://drive.google.com/file/d/1rHiiLBo8HUv0dRLQe1U1Q3unhu7qm3hb/view?usp=drive_link', 'https://youtu.be/_4vcW_SQzUg?si=qBg5RF3jW8TYi4bO', 'https://geologyscience.com/rocks/igneous-rocks/syenite/', NULL, '3'),
('5', 'Kapur (Chalk)', 'Kapur (chalk) adalah jenis batuan sedimen yang terutama terdiri dari mineral kalsium karbonat (CaCO₃) dalam bentuk mikroskopis cangkang organisme laut, seperti foraminifera dan coccolithophores. Kapur terbentuk di dasar laut dangkal, di mana sisa-sisa organisme ini mengendap selama jutaan tahun. Proses pengendapan dan kompaksi sisa-sisa ini membentuk kapur yang lembut dan berpori.', '• Warna: Umumnya berwarna putih hingga krem, tetapi dapat juga memiliki nuansa abu-abu atau kuning, tergantung pada kontaminan atau kondisi pembentukan.\n• Tekstur: Halus dan berbutir, dengan struktur yang biasanya berlapis. Kapur cenderung mudah dipecah dan memiliki kemampuan untuk membentuk debu halus ketika dihancurkan.\n• Kekerasan (Skala Mohs): Sekitar 1 hingga 2 pada skala Mohs. Kapur sangat lunak dan dapat dengan mudah tergores oleh kuku atau alat yang lebih keras.', 'https://drive.google.com/file/d/19M0kEuvLO0nU_nbrFNDyh8-kwd98_xBd/view?usp=drive_link', 'https://youtu.be/wI0hW2SQsYg?si=sWJecCMqQLWMtU4E', 'https://geologyscience.com/rocks/sedimentary-rocks/chalk/', 'https://www.sciencedirect.com/science/article/pii/S0016787810000817', '8'),
('6', 'Batu Gamping (Limestone Biogenik)', 'Batu gamping biogenik (biogenic limestone) adalah jenis batuan sedimen yang terutama terdiri dari mineral kalsium karbonat (CaCO₃) yang berasal dari sisa-sisa organisme hidup, seperti cangkang moluska, koral, dan foraminifera. Batu gamping biogenik terbentuk di lingkungan laut dangkal, di mana organisme-organisme ini mengumpulkan dan mengendapkan kalsium karbonat saat mereka hidup. Setelah organisme mati, sisa-sisa mereka akan terakumulasi dan mengalami proses kompaksi dan sementasi menjadi batuan.', '• Warna: Umumnya berwarna putih hingga krem, tetapi bisa juga berwarna kuning, abu-abu, atau bahkan hijau tergantung pada kandungan mineral lain dan bahan organik yang ada di dalamnya.\n• Tekstur: Teksturnya bervariasi dari halus hingga agak kasar, tergantung pada ukuran dan jenis fragmen yang ada. Batu gamping biogenik sering kali memiliki tekstur kasar karena mengandung fragmen cangkang yang lebih besar dan dapat terlihat jelas.\n• Kekerasan (Skala Mohs): Sekitar 3 hingga 4 pada skala Mohs. Batu gamping biogenik tergolong lunak dibandingkan dengan banyak batuan lainnya, tetapi cukup keras untuk digunakan dalam konstruksi.', 'https://drive.google.com/file/d/1Ik1gDFJPDctMTjcAHfLXpkFsRq022cWE/view?usp=drive_link', NULL, 'https://www.geologyin.com/2024/02/how-limestone-is-formed-and-where.html', NULL, '8'),
('7', 'Batu Marmer', 'Batu marmer adalah jenis batuan metamorf yang terbentuk dari batu kapur yang mengalami proses metamorfosis akibat tekanan dan suhu tinggi di dalam kerak bumi. Proses ini mengubah struktur mineral batu kapur menjadi kristal-kristal kalsit, memberikan marmer tekstur yang lebih padat dan kuat. Batu marmer biasa digunakan untuk keperluan interior bangunan seperti untuk lantai dan dinding dan di bidang kesenian digunakan untuk patung.', '• Batu marmer memiliki warna putih, abu-abu, hitam, merah, hijau, dan cokelat, tergantung pada jenis mineral yang terkandung di dalamnya.\n• Marmer memiliki tekstur kristalin yang halus dan kilap, dengan permukaan yang bisa dipoles hingga sangat mengilap.\n• Marmer memiliki kekerasan sekitar 3 hingga 4 pada skala Mohs.', 'https://drive.google.com/file/d/1sEvsk2NCTfjzZJIB-nB2AgIM7nBFMM76/view?usp=drive_link', 'https://youtu.be/LHgifUKUqWw?si=OjU-NdMRKIRDou0u', 'https://geology.com/rocks/marble.shtml', 'https://jurnal.ugm.ac.id/jpkm/article/download/35963/25066', '4'),
('8', 'Batu Antrasit', 'Batu antrasit adalah jenis batu bara dengan tingkat karbon tertinggi, yang merupakan bentuk paling murni dan keras dari batu bara. Antrasit terbentuk dari proses metamorfisme yang melibatkan suhu dan tekanan tinggi yang mengubah batu bara bituminus menjadi antrasit. Batu ini memiliki ciri khas dengan kilau metalik atau semi-logam, serta warna hitam yang sangat pekat. Batu antrasit banyak digunakan di berbagai bidang seperti untuk bahan bakar pembangkit listrik, untuk industri baja, dan untuk filtrasi air.', '• Batu antrasit berwarna hitam pekat dan memiliki kilau metallic atau semi-logam.\n• Permukaannya halus dan keras.\n• Kekerasan batu antrasit berada pada kisaran 2,75 hingga 3 pada skala Mohs.', 'https://drive.google.com/file/d/1bZ4J4xyqw390wx-n9AiNofYwGReT0T82/view?usp=drive_link', 'https://youtu.be/8p0DVYIhC2w?si=XP7PBcaFdz3cK2in', 'https://www.britannica.com/science/anthracite', NULL, '4'),
('9', 'Batu Konglomerat', 'Batu konglomerat adalah jenis batuan sedimen klastik yang terdiri dari fragmen-fragmen batuan atau mineral berukuran besar, biasanya berbentuk bulat, yang disemen bersama oleh matriks halus seperti pasir, lumpur, atau kalsium karbonat. Fragmen-fragmen besar ini dikenal sebagai klast, dan ukurannya lebih dari 2 milimeter (kerikil, batu, atau kerakal).', '• Warna: Bervariasi tergantung pada klast (fragmen) dan matriks yang mengikatnya, dengan warna umum seperti abu-abu, cokelat, merah, atau hijau. Pengaruh oksidasi pada fragmen bisa menghasilkan rona kemerahan.\n• Tekstur: Kasar, dengan klast-klast besar (lebih dari 2 mm) yang berbentuk bulat, menunjukkan proses abrasi selama transportasi. Di antara klast-klast besar terdapat matriks halus yang mengisi celah-celah.\n• Kekerasan (Skala Mohs): Bervariasi antara 2 hingga 7 pada skala Mohs, tergantung pada komposisi klast dan jenis semen.', 'https://drive.google.com/file/d/16c5iu02aOdLyh_TkIDGQAPjqM1J0g0a0/view?usp=drive_link', 'https://youtu.be/JLxcHxOVUxI?si=ucaVHtFfkZc4jsTm', 'https://geologyscience.com/rocks/sedimentary-rocks/conglomerate/#google_vignette', 'https://link.springer.com/article/10.1007/s11440-024-02317-9', '2');

-- --------------------------------------------------------

--
-- Table structure for table `bookmark`
--

CREATE TABLE `bookmark` (
  `idBookmark` varchar(10) NOT NULL,
  `namaBookmark` varchar(20) NOT NULL,
  `idUser` varchar(10) NOT NULL,
  `idBatu` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `data_mini_game`
--

CREATE TABLE `data_mini_game` (
  `idDataMiniGame` varchar(10) NOT NULL,
  `totalLevelSelesai` int(11) NOT NULL,
  `totalPermainan` int(11) NOT NULL,
  `highestScore` int(11) NOT NULL,
  `idUser` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `idKategoriBatu` varchar(10) NOT NULL,
  `namaKategori` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`idKategoriBatu`, `namaKategori`) VALUES
('1', 'Batuan Sedimen'),
('2', 'Batuan Beku'),
('3', 'Batuan Metamorf');

-- --------------------------------------------------------

--
-- Table structure for table `sesi_mini_game`
--

CREATE TABLE `sesi_mini_game` (
  `idSesiMiniGame` varchar(10) NOT NULL,
  `score` int(11) NOT NULL,
  `levelSelesai` int(11) NOT NULL,
  `tanggalMain` date NOT NULL,
  `idUser` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sub_kategori`
--

CREATE TABLE `sub_kategori` (
  `idSubKategoriBatu` varchar(10) NOT NULL,
  `namaSubKategori` varchar(100) DEFAULT NULL,
  `idKategoriBatu` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sub_kategori`
--

INSERT INTO `sub_kategori` (`idSubKategoriBatu`, `namaSubKategori`, `idKategoriBatu`) VALUES
('1', 'Batuan Metamorf Tindihan', '3'),
('2', 'Batuan Sedimen Klastika', '1'),
('3', 'Batuan Tubir', '2'),
('4', 'Batuan Metamorf Kontak', '3'),
('5', 'Batuan Sedimen Kimiawi', '1'),
('6', 'Batuan Leleran', '2'),
('7', 'Batuan Metamorf Regional', '3'),
('8', 'Batuan Sedimen Biokimia', '1'),
('9', 'Batuan Korok', '2');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `idUser` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `pass` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`idUser`, `username`, `pass`) VALUES
('7d331cd8-ed95-4c96-82ac-03e5eea6f0cb', 'hikam', 'baidawih'),
('b9594036-857c-422b-b717-6665b9fc54fe', 'faqih', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `batu`
--
ALTER TABLE `batu`
  ADD PRIMARY KEY (`idBatu`),
  ADD KEY `idSubKategoriBatu` (`idSubKategoriBatu`);

--
-- Indexes for table `bookmark`
--
ALTER TABLE `bookmark`
  ADD PRIMARY KEY (`idBookmark`),
  ADD KEY `idUser` (`idUser`),
  ADD KEY `idBatu` (`idBatu`);

--
-- Indexes for table `data_mini_game`
--
ALTER TABLE `data_mini_game`
  ADD PRIMARY KEY (`idDataMiniGame`),
  ADD KEY `idUser` (`idUser`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`idKategoriBatu`);

--
-- Indexes for table `sesi_mini_game`
--
ALTER TABLE `sesi_mini_game`
  ADD PRIMARY KEY (`idSesiMiniGame`),
  ADD KEY `idUser` (`idUser`);

--
-- Indexes for table `sub_kategori`
--
ALTER TABLE `sub_kategori`
  ADD PRIMARY KEY (`idSubKategoriBatu`),
  ADD KEY `idKategoriBatu` (`idKategoriBatu`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`idUser`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `batu`
--
ALTER TABLE `batu`
  ADD CONSTRAINT `batu_ibfk_1` FOREIGN KEY (`idSubKategoriBatu`) REFERENCES `sub_kategori` (`idSubKategoriBatu`);

--
-- Constraints for table `bookmark`
--
ALTER TABLE `bookmark`
  ADD CONSTRAINT `bookmark_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `users` (`idUser`),
  ADD CONSTRAINT `bookmark_ibfk_2` FOREIGN KEY (`idBatu`) REFERENCES `batu` (`idBatu`);

--
-- Constraints for table `data_mini_game`
--
ALTER TABLE `data_mini_game`
  ADD CONSTRAINT `data_mini_game_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `users` (`idUser`);

--
-- Constraints for table `sesi_mini_game`
--
ALTER TABLE `sesi_mini_game`
  ADD CONSTRAINT `sesi_mini_game_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `users` (`idUser`);

--
-- Constraints for table `sub_kategori`
--
ALTER TABLE `sub_kategori`
  ADD CONSTRAINT `sub_kategori_ibfk_1` FOREIGN KEY (`idKategoriBatu`) REFERENCES `kategori` (`idKategoriBatu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
