package stubs_vs_mockito;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UsingMockito {

	@InjectMocks
	ClassUnderTest underTest;

	@Mock
	private Collaborator collaborator;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldUseMockitoToGetAResponse() {

		when(collaborator.tellMeSomething()).thenReturn("canned response");
		// you may also see it like... (usually for spies on real object)
		doReturn("canned response").when(collaborator).tellMeSomething();

		String response = underTest.askTheCollaborator();

		assertThat(response, is("canned response"));
	}

	@Test
	public void shouldUseMockitoToVerifySomethingHappened() {

		underTest.tellTheCollaboratorToDoSomething();

		verify(collaborator).doSomething();
	}
}
