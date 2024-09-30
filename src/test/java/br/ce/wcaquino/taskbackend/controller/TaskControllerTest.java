package br.ce.wcaquino.taskbackend.controller;

import java.time.LocalDate;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Assert;
import org.junit.Before;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;

public class TaskControllerTest {

	@Mock
	private TaskRepo todoRepoMock;
	@InjectMocks
	TaskController controllerMock;

	@Before
	public void setup() {
		//MockitoAnnotations.initMocks(this);

	}

	@Test
	public void nãoDeveSalvarTarefaSemDescricao() {
		Task todo = new Task();
		todo.setDueDate(LocalDate.now());
		try {
			new TaskController().save(todo);
		} catch (ValidationException e) {
			Assert.assertEquals("Fill the task description", e.getMessage());
		}
	}

	@Test
	public void nãoDeveSalvarTarefaSemData() {
		Task todo = new Task();

		todo.setTask("descricao");

		try {
			new TaskController().save(todo);
		} catch (ValidationException e) {
			Assert.assertEquals("Fill the due date", e.getMessage());
		}

	}

	@Test
	public void nãoDeveSalvarTarefaComDataPassada() {
		Task todo = new Task();
		todo.setDueDate(LocalDate.of(2010, 01, 01));
		todo.setTask("descricao");

		try {
			new TaskController().save(todo);
		} catch (ValidationException e) {
			Assert.assertEquals("Due date must not be in past", e.getMessage());
		}
	}

	@Test
	public void deveSalvarTarefaComSucesso() throws ValidationException {
		Task todo = new Task();
		todo.setDueDate(LocalDate.now());
		todo.setTask("descricao");

		//new TaskController().save(todo);

	}
}
