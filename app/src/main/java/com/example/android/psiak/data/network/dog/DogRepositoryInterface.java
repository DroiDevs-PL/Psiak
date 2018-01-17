package com.example.android.psiak.data.network.dog;

import com.example.android.psiak.model.DogFirebase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import java.util.List;

public interface DogRepositoryInterface {
  Observable<DogFirebase> getById(@NonNull String id);
  Observable<List<DogFirebase>> getAll();
}
