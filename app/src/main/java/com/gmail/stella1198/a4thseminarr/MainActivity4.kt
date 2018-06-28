package com.gmail.stella1198.a4thseminarr

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.gmail.stella1198.a4thseminarr.get.GetBoardResponse
import com.gmail.stella1198.a4thseminarr.get.GetBoardResponseData
import kotlinx.android.synthetic.main.activity_main4.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity4 : AppCompatActivity() {
    lateinit var networkService: NetworkService
    lateinit var boardAdapter: BoardAdapter
    lateinit var boardItems : ArrayList<GetBoardResponseData>
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        networkService = ApplicationController.instance.networkSerVice
        requestManager = Glide.with(this)
        main_board_list.layoutManager = LinearLayoutManager(this)
        main_write_btn.setOnClickListener {
            startActivity(Intent(applicationContext, BoardActivity::class.java))
        }
        val getBoardResponse = networkService.getContent()
        getBoardResponse.enqueue(object : Callback<GetBoardResponse>{
            override fun onFailure(call: Call<GetBoardResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<GetBoardResponse>?, response: Response<GetBoardResponse>?) {
                if (response!!.isSuccessful){
                    boardItems = response.body().data
                    boardAdapter = BoardAdapter(boardItems, requestManager)
                    main_board_list.adapter = boardAdapter
                }
            }
        })
    }
}
