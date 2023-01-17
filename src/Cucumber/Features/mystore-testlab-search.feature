Feature: Adres uzytkownika

  Scenario Outline: Wypelnienie formularza new address
    Given uzytkownik wchodzi na strone "https://mystore-testlab.coderslab.pl"
    And uzytkownik loguje sie uzywajac danych do logowania
    When uzytkownik klika w kafelek ADDRESSES, a nastepnie CREATE NEW ADDRESS
    When uzytkownik uzupełni folmularz NEW ADDRESS danymi "<alias>", "<address>", "<city>", "<postalCode>", "<country>", "<phone>" uzytkownik klika przycisk save
    Then sprawdzenie poprawnosci danych "<alias>", "<address>", "<city>", "<postalCode>", "<country>", "<phone>"
    And zamykamy przegladarke

Examples:
    |alias|address|city|postalCode|country|phone|
    |j.pio@o2.com|Mieszczanska 1|Wroclaw|50-500|United Kingdom|777666555|