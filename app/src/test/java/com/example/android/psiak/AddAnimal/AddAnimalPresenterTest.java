package com.example.android.psiak.AddAnimal;

import com.example.android.psiak.Repository.InMemoryRepository;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */
public class AddAnimalPresenterTest {

    @Test
    public void should_be_one_dog_after_save() {
        InMemoryRepository repository = InMemoryRepository.getInstance();
        AddAnimalPresenter presenter = new AddAnimalPresenter(repository);
        presenter.attach(new MockView());
        presenter.save("Burek", "10 lat");
        assertThat(repository.getAll().size(), is(1));
    }

    @Test
    public void should_show_success_method_after_add(){
        InMemoryRepository repository = InMemoryRepository.getInstance();
        AddAnimalPresenter presenter = new AddAnimalPresenter(repository);
        MockView view = new MockView();
        presenter.attach(view);
        presenter.save("Burek", "10 lat");
        assertThat(view.success,is(true));
    }

    @Test
    public void should_show_error_when_empty_dog_data(){
        InMemoryRepository repository = InMemoryRepository.getInstance();
        AddAnimalPresenter presenter = new AddAnimalPresenter(repository);
        MockView view = new MockView();
        presenter.attach(view);
        presenter.save("","");
        assertThat(view.error,is(true));

    }

    private class MockView implements AddAnimalContract.View {

        boolean success;
        boolean error;

        @Override
        public void showSuccessMessage() {
            success = true;
        }

        @Override
        public void showErrorMessage() {
            error = true;
        }
    }
}