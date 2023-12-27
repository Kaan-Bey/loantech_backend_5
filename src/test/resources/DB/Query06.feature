Feature: Database üzerinden staff_leave_request tablosundan (ıstenen) staff leave bilgisini siliniz.

@query06
  Scenario: staff_leave_request tablosundan data silme testi.


    * Database baglantisi kurulur.
    * Delete Query`si hazirlanir ve staff_leave_request tablosuna execute edilir.
    * Database baglantisi kapatilir.