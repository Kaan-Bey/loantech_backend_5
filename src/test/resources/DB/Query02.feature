Feature: Database üzerinden students tablosundaki
  firstname= Brian ve
  lastname= Kohlar olan öğrencinin
  email bilgisinin brain@gmail.com olduğunu doğrulayınız.

  @query02
  Scenario: Students tablosundaki ogrencilerin email bilgisi dogrulama testi.

    * Database baglantisi kurulur.
    * Query hazirlanir ve students tablosuna execute edilir.
    * Students tablosundan donen resultSet`teki email bilgisi dogrulanir.
    * Database baglantisi kapatilir.

