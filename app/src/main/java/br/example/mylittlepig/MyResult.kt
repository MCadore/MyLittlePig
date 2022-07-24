package br.example.mylittlepig


sealed class Result<T>

data class Success<T>(val data: T) : Result<T>()

data class Error<T>(val msg: String = "erro") : Result<T>()