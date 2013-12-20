package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.model.operations.Note;
import com.vectorsf.jvoice.model.operations.State;

public class NoteValidator {
	private OperationsValidator operationsValidator;

	public NoteValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_Note_oneOutcomingNotesState(Note note) {
		for (State state : note.getReferencedStates()) {
			int count = 0;
			for (State sta : note.getReferencedStates()) {
				if (sta.equals(state)) {
					count++;
				}
			}
			if (count > 1) {
				operationsValidator.error(note, "Note containing \"" + note.getDescription()
						+ "\" has more than one outgoing transition to the same state");
			}
		}
		return true;
	}

	public boolean validate_Note_lenghtNotesState(Note note) {
		if (note.getDescription().length() > 1000) {
			operationsValidator.error(note, "Note containing \"" + note.getDescription()
					+ "\" has more than of 1000 characters");
		}

		return true;
	}
}
