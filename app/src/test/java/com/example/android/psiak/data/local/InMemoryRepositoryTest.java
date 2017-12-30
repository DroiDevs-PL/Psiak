package com.example.android.psiak.data.local;

import com.example.android.psiak.model.Dog;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */
public class InMemoryRepositoryTest {

    @Test
    public void should_have_one_element_after_add(){
        Repository repository = InMemoryDogRepository.getInstance();
        repository.add(new Dog());
        assertThat(repository.getAll().size(),is(1));
    }

    @Test
    public void should_be_empty_after_removeAll(){
        Repository repository = InMemoryDogRepository.getInstance();
        repository.removeAll();
        assertThat(repository.getAll().size(),is(0));
    }


}