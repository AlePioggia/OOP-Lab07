package it.unibo.oop.lab.nesting2;

import java.util.ArrayList;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

	private List<T> list = new ArrayList<>();
	
	public OneListAcceptable(List<T> list) {
		this.setList(list);
	}

	public Acceptor<T> acceptor() {
		return new Acceptor<T>() {	
			
			public void accept(T newElement) throws ElementNotAcceptedException {
				if(list.iterator().hasNext()) {
					list.iterator().next();
				}
				else {
					throw new ElementNotAcceptedException(newElement);
				}
			}
			
			public void end() throws EndNotAcceptedException {
				if(!list.iterator().hasNext()) {
					return;
				}
				else {
					throw new EndNotAcceptedException();
				}
			}
			
		};
	}

	public List<T> getList() {
		return this.list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
