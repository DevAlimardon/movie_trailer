package uz.infinityandro.moviestream.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import uz.infinityandro.moviestream.presenter.viewmodel.MainModel
import uz.infinityandro.moviestream.util.BottomPage

class MainModelImpl:ViewModel(),MainModel {
    override val openSelectPosPageFlow= MutableSharedFlow<BottomPage>()
    override val returnPage= MutableSharedFlow<Int>()
    private var selectPos = 0


    override fun selectPagePos(page: BottomPage) {
        if (selectPos != page.pos) {
            selectPos = page.pos
            viewModelScope.launch {
                openSelectPosPageFlow.emit(page)
            }
        }
    }

    override fun openPage() {

    }
}