Feature: Database üzerinden chat_users tablosundaki create_staff_id=1 olan
  kullanıcı sayısının 11 olduğunu dogrulayiniz

@query1
  Scenario: Chat_users tablosundaki kullanicilari create_staff_id`lerine gore siralama testi

    * Database baglantisi kurulur.
    * Query hazirlanir ve chat_users tablosuna execute edilir.
    * Chat_users tablosundan donen resultSet dogrulanir.
    * Database baglantisi kapatilir.



