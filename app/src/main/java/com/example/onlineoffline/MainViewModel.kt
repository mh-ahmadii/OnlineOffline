package com.example.onlineoffline

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: PhotoRepository) : ViewModel() {
    val errorLiveData = MutableLiveData<String>()

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            errorLiveData.value = throwable.message.toString()
        }
    init {
        viewModelScope.launch(coroutineExceptionHandler) {
            repository.refreshPhoto()
        }
    }

    val photoLiveData: LiveData<List<Photo>> = repository.getPhotos()
}






































/*  }
    init {
        liveData<LiveData<List<Photo>>> {
            val photos = repository.refreshPhoto()
        }
    }
    val photoLiveData: LiveData<List<Photo>> = liveData(coroutineExceptionHandler) {
        var photos = repository.refreshPhoto()
        emit(photos)
    }

    fun getPhotos(): LiveData<List<Photo>> {
        return repository.getPhotos()
    }*/




/*
init {
       liveData<LiveData<List<Photo>>>(coroutineExceptionHandler + Dispatchers.IO) {
           repository.getPhotos()
       }
   }
    val photoLiveData: LiveData<List<Photo>> = liveData(coroutineExceptionHandler + Dispatchers.IO) {
        repository.refreshPhoto()
        var photos = repository.getPhotos()
        emit(photos)
    }
*/
//------------------------------------------------------------------------------------------------//
/*
val xxx: LiveData<List<Photo>> = liveData(coroutineExceptionHandler) {
//        repository.refreshPhoto()
}
val photoLiveData: LiveData<List<Photo>> = repository.getPhotos()
}

 */




