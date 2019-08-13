package com.learn_recyclerview

/**
 * @author: GY.LEE
 * @date: 2019-08-13
 * @Des:
 */
object ObtainData {
    fun initList(): List<Word> {
        val list = mutableListOf<Word>()
        for (index in 0..20) {
            list.add(Word("Title $index", "content $index",false))
        }
        return list
    }

    fun initSectionList(): List<Word> {
        val list = mutableListOf<Word>()
        for (index in 0..5) {
            val isHeader = index == 0
            list.add(Word("ATitle $index", "content $index", isHeader))
        }
        for (index in 0..10) {
            val isHeader = index == 0
            list.add(Word("BTitle $index", "content $index", isHeader))
        }
        for (index in 0..5) {
            val isHeader = index == 0
            list.add(Word("cTitle $index", "content $index", isHeader))
        }
        for (index in 0..10) {
            val isHeader = index == 0
            list.add(Word("dTitle $index", "content $index", isHeader))
        }
        for (index in 0..10) {
            val isHeader = index == 0
            list.add(Word("eTitle $index", "content $index", isHeader))
        }
        return list
    }
}