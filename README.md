# myFridge - README

## Opis projektu

**myFridge** to aplikacja webowa, typu REST, napisana w języku Java. Umożliwia zapisywanie nazw produktów w wirtualnych lodówkach. Dzięki dostępowi do bazy danych, użytkownik może wybrać istniejącą lodówkę lub stworzyć nową i modyfikować jej zawartość.

## Funkcjonalności

- Dodawanie produktów do niezależnych lodówek
- Usuwanie lodówek po usunięciu wszystkich produktów i zamknięciu strony

## Użytkowanie

1. Wejdź na stronę [myFridge](https://myfridges.onrender.com/).
2. Wpisz nazwę swojej lodówki w okienko i wybierz język (domyślnie angielski).
3. Kliknij "Submit" i wyświetli się lista produktów zapisanych w lodówce o tej nazwie (jeśli lodówka nie istnieje, wyświetli się pusta lista).
4. Możesz dodawać produkty do lodówki, wpisując nazwę produktu w okienko i klikając plusik.
5. Możesz usuwać produkty z lodówki, zaznaczając pole obok produktu i klikając minusik.

Dane są zapisywane w bazie danych na serwerze.

## Architektura

Aplikacja korzysta z:

Spring do zarządzania zależnościami i tworzenia aplikacji webowej.
Hibernate do mapowania obiektowo-relacyjnego i zarządzania bazą danych.
PostgreSQL jako bazy danych do przechowywania informacji o produktach i lodówkach.
Jackson do przetwarzania JSON.
JavaScript do interakcji po stronie klienta.
Docker do konteneryzacji aplikacji.
Flyway do zarządzania migracjami bazy danych.

![moja_lodowka](https://github.com/Szackie/myFridgeS/assets/104226817/885ea486-4a4b-48bb-987f-ba0d181fac7b)

## Autor

[Szackie](https://github.com/Szackie)
