package com.gmail.stella1198.a4thseminarr

import com.gmail.stella1198.a4thseminarr.get.GetBoardResponse
import com.gmail.stella1198.a4thseminarr.post.PostBoardResponse
import com.gmail.stella1198.a4thseminarr.post.PostTemp
import okhttp3.Call
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface NetworkService {
    @Multipart
    @POST("board")
    fun postBoard(
            @Part boardImg : MultipartBody.Part?,
            @Part("user_id") id : RequestBody,
            @Part("board_title") title : RequestBody,
            @Part("board_content") content : RequestBody
            ) : Call<PostBoardResponse>

    @GET("board")
    fun getContent() : Call<GetBoardResponse>
    @POST("board")
    fun postPart(
            @Body temp : PostTemp
    ) : Call<Unit>
}