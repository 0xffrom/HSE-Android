package com.goga133.task5_7.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.goga133.task5_7.R
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.fragment_info.view.*


class InfoFragment : Fragment() {

    private lateinit var infoViewModel: InfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        infoViewModel =
                ViewModelProviders.of(this).get(InfoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_info, container, false)

        infoViewModel.text.observe(viewLifecycleOwner, Observer {
            root.text_home.text = it
        })

        root.button_1.setOnClickListener{
            root.text_home.startAnimation(AnimationUtils.loadAnimation(root.context, R.anim.rotate))
        }

        root.button_2.setOnClickListener{
            root.text_home.startAnimation(AnimationUtils.loadAnimation(root.context, R.anim.zoom_in))
        }


        return root
    }
}