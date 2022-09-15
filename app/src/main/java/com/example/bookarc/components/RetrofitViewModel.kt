package com.example.bookarc.components

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookarc.bookarcmodel.Item
import com.example.bookarc.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RetrofitViewModel @Inject constructor(private val retrofitrepository: Retrofitrepository) :ViewModel() {

    val list:MutableState<Mainstate> = mutableStateOf(Mainstate())

    fun getsearchedimage(q:String)=viewModelScope.launch{
        list.value=Mainstate(isLoading = true)
        try{
            val result = retrofitrepository.getsearchedbooks(q)
            when(result){
                is Resource.Error->{
                    list.value= Mainstate(error = "Something went wrong")
                }
                is Resource.Success->{
                    result.data?.items?.let {
                        list.value=Mainstate(data = it)
                    }
                }
            }
        }catch (e:Exception){
            list.value= Mainstate(error = "WENT WRONG")
        }

    }

    fun gettrendingimage()=viewModelScope.launch{
        try{
            val result1 = retrofitrepository.gettrendingbooks()
            when (result1) {
                is Resource.Error -> {
                    list.value = Mainstate(error = "Something went wrong")
                }
                is Resource.Success -> {
                    result1.data?.items?.let {
                        list.value = Mainstate(data = it)
                    }
                }
            }
        }catch (e:Exception){
            list.value= Mainstate(error = "WENT WRONG")
        }
    }


}