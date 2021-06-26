package com.atul.mangatain.networking;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.atul.mangatain.model.Chapter;
import com.atul.mangatain.model.Manga;
import com.atul.mangatain.readm.RClient;

import java.util.List;
import java.util.Set;

public class RMRepository extends ViewModel {
    MutableLiveData<List<Manga>> mangas = new MutableLiveData<>();
    MutableLiveData<List<Manga>> search = new MutableLiveData<>();
    MutableLiveData<List<String>> pages = new MutableLiveData<>();
    static int page  = 1;

    public RMRepository() {
    }

    public MutableLiveData<List<Manga>> browse(String genre){
        RClient.browse(mangas, page, genre);
        page++;

        return mangas;
    }

    public MutableLiveData<List<Manga>> search(String query){
        RClient.search(search, query);
        return search;
    }

    public MutableLiveData<List<String>> pages(Chapter chapter){
        RClient.pages(pages, chapter);
        return pages;
    }

    public Set<String> genres(){
        return RClient.genres();
    }
}
