package com.example.botnavc.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.botnavc.databinding.FragmentHomeBinding
import com.example.botnavc.domain.model.Config
import com.example.botnavc.repository.ConfigEvent
import com.example.botnavc.repository.MyDataState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: ConfigViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setConfigEvent(ConfigEvent.GetConfigEvent)
        viewModel.config.observe(this, Observer { data ->
            when (data) {
                is MyDataState.Success<Config> -> {
                    data.data
                    Log.d("observing data", "success yay")
                }
                is MyDataState.Error -> {
                    Log.d("observing data", "oh no error");
                }
                is MyDataState.Loading -> {
                    Log.d("observing data", "is loading...")
                }
            }
        })
        Log.d("VIEWMODEL:", " ${viewModel}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val observed = viewModel.config.value;
        return ComposeView(requireContext()).apply {
            setContent {
                ConfigView()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}