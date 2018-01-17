package com.example.android.psiak.data.network.dog;

import com.example.android.psiak.model.DogFirebase;
import com.google.firebase.FirebaseException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import java.util.List;

public class DogFirebaseRepository implements DogRepositoryInterface {
  /**
   * Reference to Firebase database
   */
  private FirebaseDatabase database = FirebaseDatabase.getInstance();

  /**
   * Reference to "dogs" endpoint in database
   */
  private DatabaseReference ref = database.getReference("dogs");

  @Override
  public Observable<DogFirebase> getById(@NonNull final String id) {
    return Observable.create(new ObservableOnSubscribe<DogFirebase>() {
      @Override
      public void subscribe(final ObservableEmitter<DogFirebase> e) throws Exception {
        ref.child(id).addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
            DogFirebase dog = dataSnapshot.getValue(DogFirebase.class);
            dog.setId(dataSnapshot.getKey());
            e.onNext(dog);
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {
            e.onError(new FirebaseException(databaseError.getMessage()));
          }
        });
      }
    });
  }

  @Override
  public Observable<List<DogFirebase>> getAll() {
    return null;
  }
}
