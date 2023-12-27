Feature: Database üzerinden onlineexam tablosundaki sinavlarin
  passing_percentage değerlerinin ortalamasını alıp listeleyınız.

@query03
  Scenario: Onlineexam tablosundaki sinavlarin passing_percentage değerlerinin
  ortalamasını alıp listeleme testi.


    * Database baglantisi kurulur.
    * Query hazirlanir ve onlineexam tablosuna execute edilir.
    * Onlineexam tablosundan donen resultSet`teki bilgiler listelenir.
    * Database baglantisi kapatilir.



