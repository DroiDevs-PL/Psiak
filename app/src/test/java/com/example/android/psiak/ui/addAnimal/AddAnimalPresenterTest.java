package com.example.android.psiak.ui.addAnimal;

import com.example.android.psiak.data.repository.InMemoryDogRepository;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */
public class AddAnimalPresenterTest {

    private static AddAnimalContract.View mockView;

    @Before
    public void init() {
        mockView = mock(AddAnimalActivity.class);
    }

    @Test
    public void should_be_one_dog_after_save() {
        InMemoryDogRepository repository = InMemoryDogRepository.getInstance();
        AddAnimalPresenter presenter = new AddAnimalPresenter(repository);
        presenter.attach(mockView);
        presenter.save("Burek", "10 lat");
        assertThat(repository.getAll().size(), is(1));
    }

    @Test
    public void should_show_success_method_after_add() {
        InMemoryDogRepository repository = InMemoryDogRepository.getInstance();
        AddAnimalPresenter presenter = new AddAnimalPresenter(repository);
        presenter.attach(mockView);
        presenter.save("Burek", "10 lat");
        verify(mockView).showSuccessMessage();
    }

    @Test
    public void should_show_error_when_empty_dog_data() {
        InMemoryDogRepository repository = InMemoryDogRepository.getInstance();
        AddAnimalPresenter presenter = new AddAnimalPresenter(repository);
        presenter.attach(mockView);
        presenter.save("", "");
        verify(mockView).showErrorMessage();
    }

}