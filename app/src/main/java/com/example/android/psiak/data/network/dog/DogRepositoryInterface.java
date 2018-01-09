package com.example.android.psiak.data.network.dog;

import com.example.android.psiak.model.DogFirebase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import java.util.List;

/**
 * Created by Sebastian Kaluzny on 09.01.18.
 */

public interface DogRepositoryInterface {
  Observable<DogFirebase> getById(@NonNull String id);
  Observable<List<DogFirebase>> getAll();
}
