package com.wanttobuy.garagekit.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.text.TextUtils
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wanttobuy.garagekit.GaragekitApplication
import java.lang.Exception
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class SharedPreferenceUtils{


    companion object {
         var mSharedPreference:SharedPreferences = PreferenceManager.getDefaultSharedPreferences(GaragekitApplication.instance?.applicationContext)
         var gson:Gson = Gson()

        fun getIntance(context: Context):SharedPreferences{
            return mSharedPreference
        }

        fun putString(key:String,value:String,context: Context){
            getIntance(context).edit(){
                putString(key, value)
            }
        }


        fun getString(key:String,context: Context):String?{
            return getIntance(context).getString(key,"")
        }

        fun puBoolean(key: String,value: Boolean,context: Context){
            getIntance(context).edit(){
                putBoolean(key,value)
            }
        }

        fun getBoolean(key: String,context: Context):Boolean{
            return getIntance(context).getBoolean(key,false)
        }

//        fun putAccessToken(key: String,value: String,context: Context){
//            getIntance(context).edit(){
//                value.expires_timestamp = System.currentTimeMillis()/1000 + value.expires_timestamp!!
//                val data = gson.toJson(value)
//                putString(key,data)
//            }
//        }

//        fun getAccessToken(key: String,context: Context):AccessToken{
//            val data = getIntance(context).getString(key,"")
//            val accessToken = gson.fromJson(data,AccessToken::class.java)
//            return accessToken
//        }

//        fun putUser(key: String, user: Profile, context: Context){
//            getIntance(context).edit(){
//                val value = gson.toJson(user)
//                putString(key, value)
//            }
//        }
//
//        fun getUser(key: String,context: Context):Profile{
//            var data = getIntance(context).getString(key,"")
//            val user = gson.fromJson(data,Profile::class.java)
//            return user
//        }
//
//        fun getSearchHistory(context: Context,key: String) : MutableList<String>{
//            var data = getIntance(context).getString(key,"")
//            val type = object :TypeToken<List<String>>(){}.type
//            var newList = Gson().fromJson<List<String>>(data,type)
//            if(newList == null){
//                newList = ArrayList()
//            }
//            return newList.toMutableList()
//        }
//
//        fun addSearchHistory(context: Context,content:String){
//            getIntance(context).edit(){
//                val list = getSearchHistory(context, SEARCH_HISTORY)
//                list.add(0,content)
//                val data = gson.toJson(list)
//                putString(SEARCH_HISTORY, data)
//            }
//
//        }
//
//        fun clearSearchHistory(context: Context){
//            getIntance(context).edit(){
//                putString(SEARCH_HISTORY, "")
//            }
//

//        }


    }



}