package com.example.myfirstapp.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfirstapp.data.AData
import com.example.myfirstapp.util.MyItemDecoration
import com.example.myfirstapp.R
import kotlinx.android.synthetic.main.fragment_one.*


class FragmentOne : Fragment() {

    lateinit var adapter: MainRecyclerAdapter
    val datas = mutableListOf<AData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        main_recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        main_recyclerview.addItemDecoration(
            MyItemDecoration(
                30
            )
        )

        adapter = MainRecyclerAdapter()
        main_recyclerview.adapter  = adapter
        load()
    }

    private fun load(){
        Toast.makeText(context,"hh",Toast.LENGTH_SHORT).show()
        datas.apply { add(
            AData(
                "구글",
                "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png",
                "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"
            )
        )
          add(
              AData(
                  "야후",
                  "https://s.yimg.com/rz/p/yahoo_frontpage_en-US_s_f_p_205x58_frontpage_2x.png",
                  "https://s.yimg.com/rz/p/yahoo_frontpage_en-US_s_f_p_205x58_frontpage_2x.png"
              )
          )
            add(
                AData(
                    "네이버",
                    "https://lh3.googleusercontent.com/proxy/4HiMOTKJzo2Fu2oj8giG_UFNm7kPsFpKpJQvuizq71OEO9wC-EnxDK0uuUNRGBPlU2rPOdUNiH1ytbxcxGP12rXZRsY7U714n8asXqJm1cwhsdiIXRzs0vMzSdVPyKj8vC2I4hJbMCKBCttRbDVTP4bfmc8oZzmK1kLxF2vICYc74Gw6cMpV7EMdFCQnCTkHdf03vGQYB-4uj7oD3PEwg7F_",
                    "https://lh3.googleusercontent.com/proxy/4HiMOTKJzo2Fu2oj8giG_UFNm7kPsFpKpJQvuizq71OEO9wC-EnxDK0uuUNRGBPlU2rPOdUNiH1ytbxcxGP12rXZRsY7U714n8asXqJm1cwhsdiIXRzs0vMzSdVPyKj8vC2I4hJbMCKBCttRbDVTP4bfmc8oZzmK1kLxF2vICYc74Gw6cMpV7EMdFCQnCTkHdf03vGQYB-4uj7oD3PEwg7F_"
                )
            )
        }
        adapter.datas = datas
        adapter.notifyDataSetChanged()
    }
}