package com.example.botnavc.ui.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.botnavc.domain.model.Config
import com.example.botnavc.repository.ConfigEvent
import com.example.botnavc.repository.ConfigRepository
import com.example.botnavc.repository.MyDataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class ConfigViewModel
@ViewModelInject
constructor(
    private val repository: ConfigRepository,
    @Assisted private val state: SavedStateHandle,
) : ViewModel() {

    private val _config: MutableLiveData<MyDataState<Config>> = MutableLiveData()
    val config: LiveData<MyDataState<Config>>
        = _config

    fun setConfigEvent(configEvent: ConfigEvent) {
        viewModelScope.launch(Dispatchers.IO) {
            when (configEvent) {
                is ConfigEvent.GetConfigEvent -> {
                    repository.get()
                        .onEach { dataState ->
                            _config.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is ConfigEvent.None -> {
                    // who cares
                }
            }
        }
    }


}