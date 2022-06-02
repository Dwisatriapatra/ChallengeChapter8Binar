package com.example.challengechapter8binar.activity

class FilmRepository {

    fun getAllFilm() : List<Film>{
        return listOf(
            Film(1, "This is title", "Dwi Satria Patra", "This is desc"),
            Film(2, "This is title", "Dwi Satria Patra", "This is desc"),
            Film(3, "This is title", "Dwi Satria Patra", "This is desc"),
            Film(4, "This is title", "Dwi Satria Patra", "This is desc"),
            Film(5, "This is title", "Dwi Satria Patra", "This is desc"),
            Film(6, "This is title", "Dwi Satria Patra", "This is desc"),
            Film(7, "This is title", "Dwi Satria Patra", "This is desc"),
            Film(8, "This is title", "Dwi Satria Patra", "This is desc"),
            Film(9, "This is title", "Dwi Satria Patra", "This is desc"),
            Film(10, "This is title", "Dwi Satria Patra", "This is desc")
        )
    }

}