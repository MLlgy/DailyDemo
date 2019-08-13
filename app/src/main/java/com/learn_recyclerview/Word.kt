package com.learn_recyclerview

import android.support.annotation.Nullable

/**
 * @author: GY.LEE
 * @date: 2019-08-13
 * @Des:
 */
data class Word(
        val title: String,
        val content: String,
        @Nullable val isHeader: Boolean
)