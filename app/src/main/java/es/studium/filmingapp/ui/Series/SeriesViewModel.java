package es.studium.filmingapp.ui.Series;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SeriesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SeriesViewModel() {
        mText = new MutableLiveData<>();
       //mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

