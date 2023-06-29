package com.aditya.hilt_mvp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.hilt_mvp.model.User
import com.aditya.hilt_mvp.repository.MainRepository
import com.aditya.hilt_mvp.utils.DataState
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    private val _dataState: MutableLiveData<DataState<List<User>>> = MutableLiveData()
    val dataState: LiveData<DataState<List<User>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent){
                is MainStateEvent.GetUserEvent -> {
                    repository.getUsers()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.None -> {
                    // Nothing
                }
            }
        }
    }
}

sealed class MainStateEvent {
    object GetUserEvent : MainStateEvent()
    object None : MainStateEvent()
}