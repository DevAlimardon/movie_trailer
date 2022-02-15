package uz.infinityandro.moviestream.presenter.pages

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.infinityandro.moviestream.R
import uz.infinityandro.moviestream.databinding.PageTvSeriaBinding

class PageTvSeria:Fragment(R.layout.page_tv_seria) {
    private val binding by viewBinding(PageTvSeriaBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
