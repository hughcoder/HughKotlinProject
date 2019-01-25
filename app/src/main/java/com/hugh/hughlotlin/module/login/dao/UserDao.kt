package com.hugh.hughlotlin.module.login.dao

import com.hugh.hughlotlin.HughApplication
import com.hugh.hughlotlin.common.db.FlatMapRealmSaveResult
import com.hugh.hughlotlin.common.db.FlatTransactionInterface
import com.hugh.hughlotlin.common.db.ReceivedEvent
import com.hugh.hughlotlin.model.bean.Event
import com.hugh.hughlotlin.model.net.GsonUtils
import io.realm.RealmQuery
import io.realm.RealmResults
import retrofit2.Response
import java.net.CacheResponse
import javax.inject.Inject

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/24}
 */

class UserDao @Inject constructor(private val application: HughApplication) {

    /**
     *  保存当前用户接收到的事件
     */

    fun saveReceivedRcentDao(response: Response<ArrayList<Event>>, needSave: Boolean) {
        FlatMapRealmSaveResult(response, ReceivedEvent::class.java, object : FlatTransactionInterface<ReceivedEvent> {
            override fun query(q: RealmQuery<ReceivedEvent>): RealmResults<ReceivedEvent> {
                return q.findAll()
            }

            override fun onTransaction(targetObject: ReceivedEvent?) {
                val data = GsonUtils.toJsonString(response.body())
                targetObject?.data = data
            }

        }, needSave)
    }
}