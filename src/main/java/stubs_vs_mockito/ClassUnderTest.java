package stubs_vs_mockito;

public class ClassUnderTest {
	private Collaborator talksTo;

	public ClassUnderTest(Collaborator talksTo) {
		this.talksTo = talksTo;
	}

	public String askTheCollaborator() {
		return talksTo.tellMeSomething();
	}

	public void tellTheCollaboratorToDoSomething() {
		talksTo.doSomething();
	}
}
