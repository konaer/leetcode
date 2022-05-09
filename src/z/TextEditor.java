package z;

import java.util.*;
import java.util.Stack;

public class TextEditor {
	
	class State {
		int cursor;
		int selectedLength;
		String content;
		
		public State(int cursor, int selectedLength, String content) {
			this.cursor= cursor;
			this.selectedLength = selectedLength;
			this.content = content;
		}
	}
	
	private StringBuilder content;
	private int cursor;
	private int selectedLength;
//	private TextEditorManager textEditorManager;
	private static String clipBoard;
	private Stack<State> undoStack;
	private Stack<State> redoStack;
	private static Map<String>
	
	public TextEditor() {
		this.content = new StringBuilder();
		this.cursor = 0;
		this.selectedLength= 0;
//		this.textEditorManager = new TextEditorManager();
		this.undoStack = new Stack<>();
		this.redoStack = new Stack<>();
	}
	
	private void saveCurrentState() {
		undoStack.push(new State(cursor, selectedLength, content.toString()));
	}
	
	private void clearRedoStack() {
		redoStack.clear();
	}
	
	public String append(String s) {
		saveCurrentState();
		clearRedoStack();
		
		int start = cursor - selectedLength;
		content.replace(Math.max(start, 0), cursor, s);
		cursor = start + s.length();
		selectedLength = 0;
		
		return content.toString();	
	}
	
	public void move(int position) {
		selectedLength = 0;
		
		if (position <= 0) {
			cursor = 0;
			return;
		} 
		
		if (position >= content.length()) {
			cursor = content.length();
			return;
		}
		
		cursor = position;
	}
	
	public String backspace() {
		saveCurrentState();
		clearRedoStack();
		
		int start = cursor - selectedLength;
		if (start == cursor) {
			content.deleteCharAt(start);
		} else {
			content.delete(start, cursor);
		}
		
		cursor = start;
		selectedLength = 0;
		
		return content.toString();
	}
	
	
	public void select(int p1, int p2) {
		int left = Math.min(p1, p2);
		int right = Math.max(p1, p2);
		left = Math.max(0, left);
		right = Math.min(content.length(), right);
		
		selectedLength = right - left;
		cursor = right;
//		return content.substring(left, right);
		return;
	}
	
	public void copy() {
		clipBoard = content.substring(cursor - selectedLength, cursor);
	}
	
	public String paste() {
		return append(clipBoard);
	}
	
	public String undo() {
		redoStack.push(new State(cursor, selectedLength, content.toString()));
		
		if (!undoStack.isEmpty()) {
			State state = undoStack.pop();
			content = new StringBuilder(state.content);
			cursor = state.cursor;
			selectedLength = state.selectedLength;
		} else {
			content = new StringBuilder();
			cursor = 0;
			selectedLength = 0;
		}
		return content.toString();
	}
	
	public String redo() {
		if (!redoStack.isEmpty()) {
			undoStack.push(new State(cursor, selectedLength, content.toString()));
			State state = redoStack.pop();
			content = new StringBuilder(state.content);
			cursor = state.cursor;
			selectedLength = state.selectedLength;
		}
		return content.toString();
	}
}
