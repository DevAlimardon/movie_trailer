package uz.infinityandro.moviestream.presenter.viewmodel

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.util.BottomPage

interface MainModel {
    val openSelectPosPageFlow: Flow<BottomPage>
    val returnPage: Flow<Int>
    fun selectPagePos(page : BottomPage)
    fun openPage()
}