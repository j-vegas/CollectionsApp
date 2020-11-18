package com.jvegas.translate.data

data class Text(
    val autoCorrected: Boolean,
    val didYouMean: Boolean,
    val value: String
)