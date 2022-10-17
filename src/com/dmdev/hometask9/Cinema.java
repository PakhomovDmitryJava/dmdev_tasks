package com.dmdev.hometask9;

import java.util.*;

/**
 * Даны 2 класса:
 * - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
 * - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив,
 * где ключом является год издания, а значением - все фильмы, выпустившиеся в этом году.
 * Добавить функционал в кинотеатр таким образом, чтобы можно было:
 * - добавлять в него новый фильм +
 * - получить все фильмы по переданному году +
 * - получить все фильмы по переданному году и месяцу +
 * - получить все фильмы по переданному жанру +
 * - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания +
 * Учесть следующее:
 * - в кинотеатре фильмы должны храниться в порядке их добавления в него (т.е. предусмотреть порядок значения ассоциативного массива)
 * - не должен добавляться фильм, если такой уже есть в кинотеатре
 * Продемонстрировать работу кинотеатра в отдельном классе.
 */
public class Cinema {
    private LinkedHashMap<Integer, ArrayList<Film>> filmsSortedByYear;

    public Cinema(LinkedHashMap<Integer, ArrayList<Film>> filmsSortedByYear) {
        this.filmsSortedByYear = filmsSortedByYear;
    }

    public ArrayList<Film> getAllFilms() {
        ArrayList<Film> allFilms = new ArrayList<>();
        Set<Integer> set = filmsSortedByYear.keySet();
        for (Integer integer : set) {
            allFilms.addAll(getFilmsByYear(integer));
        }
        return allFilms;
    }

    public void addNewFilm(Film film) {
        if (getAllFilms().contains(film)) {
            System.out.println("This film is already exist in the cinema!\n");
        } else {
            filmsSortedByYear.get(film.getYear()).add(film);
        }
    }

    public ArrayList<Film> getFilmsByYear(Integer year) {
        return filmsSortedByYear.get(year);
    }

    public ArrayList<Film> getFilmsByYearAndMonth(Integer year, int month) {
        ArrayList<Film> byYear = getFilmsByYear(year);
        ArrayList<Film> byYearAndMoth = new ArrayList<>();
        for (Film film : byYear) {
            if (film.getMonth() == month) {
                byYearAndMoth.add(film);
            }
        }
        return byYearAndMoth;
    }

    public ArrayList<Film> getFilmsByGenre(String genre) {
        ArrayList<Film> byGenre = new ArrayList<>();
        Set<Integer> set = filmsSortedByYear.keySet();
        for (Integer integer : set) {
            for (Film film : getFilmsByYear(integer)) {
                if (film.getGenre().equals(genre)) {
                    byGenre.add(film);
                }
            }
        }
        return byGenre;
    }

    public ArrayList<Film> getTop10FilmsByRating() {
        ArrayList<Film> allFilms = getAllFilms();
        allFilms.sort(Comparator.comparing(Film::getRating).reversed());
        int TOP_10 = 10;
        return new ArrayList<>(allFilms.subList(0, TOP_10));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return Objects.equals(filmsSortedByYear, cinema.filmsSortedByYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmsSortedByYear);
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "filmsForYear=" + filmsSortedByYear +
                '}';
    }

    public LinkedHashMap<Integer, ArrayList<Film>> getFilmsSortedByYear() {
        return filmsSortedByYear;
    }

    public void setFilmsSortedByYear(LinkedHashMap<Integer, ArrayList<Film>> filmsSortedByYear) {
        this.filmsSortedByYear = filmsSortedByYear;
    }
}
