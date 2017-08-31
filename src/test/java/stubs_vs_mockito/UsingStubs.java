package stubs_vs_mockito;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UsingStubs {

	private boolean stubDidSomething = false; // default value

	@Test
	public void shouldUseAStubToGetAResponse() {
		Collaborator stub = new CollaboratorStub();
		ClassUnderTest underTest = new ClassUnderTest(stub);

		String response = underTest.askTheCollaborator();

		assertThat(response, is("canned response"));
	}

	@Test
	public void shouldUseAStubToVerifySomethingHappened() {
		Collaborator stub = new CollaboratorStub();
		ClassUnderTest underTest = new ClassUnderTest(stub);

		underTest.tellTheCollaboratorToDoSomething();

		assertThat(stubDidSomething, is(true));
	}

	public class CollaboratorStub implements Collaborator {
		@Override
		public String tellMeSomething() {
			return "canned response";
		}

		@Override
		public void doSomething() {
			stubDidSomething = true;
		}
	}
}
