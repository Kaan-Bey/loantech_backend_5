Feature: Database üzerinden transport_feemaster tablosundaki
  month degeri 'October' olan kaydın
  fine_amount değerini '200.00' olarak güncellenebilmeli.

  @query04
  Scenario: Transport_feemaster tablosundan veri guncelleme testi.

    * Database baglantisi kurulur.
    * Query hazirlanir ve transport_feemaster tablosuna executeUpdate edilir.
    * Database baglantisi kapatilir.