package com.example.android.psiak.Repository;

import com.example.android.psiak.Model.Dog;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */
public class InMemoryRepositoryTest {

    @Test
    public void should_have_one_element_after_add(){
        Repository repository = InMemoryRepository.getInstance();
        repository.add(new Dog());
        assertThat(repository.getAll().size(),is(1));
    }

    @Test
    public void should_be_empty_after_removeAll(){
        Repository repository = InMemoryRepository.getInstance();
        repository.removeAll();
        assertThat(repository.getAll().size(),is(0));
    }


}