/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n1234567.comments;

import java.util.EventListener;


/**
 * A listener interface for receiving notification on events occurring in an
 * commentable cell.
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public interface CommentableCellListener extends EventListener {

	/**
	 * Invoked when a comment is added to or removed from a cell.
	 * @param cell the cell that was modified
	 */
	public void commentChanged(CommentableCell cell);
}
