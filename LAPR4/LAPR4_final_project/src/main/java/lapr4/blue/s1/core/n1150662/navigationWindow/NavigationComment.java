/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150662.navigationWindow;

import csheets.core.Value;
import csheets.core.formula.Formula;

/**
 *
 * @author bruno
 */
public class NavigationComment {
    private String cellName;
    private String cellComment;
    
  
    
    public NavigationComment(String cellName,String cellComment){
        setCellName(cellName);
        setCellComment(cellComment);
        ;
        
        
    }
    
    public String getText(){
        StringBuilder b = new StringBuilder(this.cellName);
        b.append(": ");
        b.append(this.cellComment);
        return b.toString();
    }
    
    
    
 
    
    private void setCellName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Cell's name cannot be null.");
		}
		if (name.trim().isEmpty()) {
			throw new IllegalArgumentException("Cell's name cannot be empty or blank spaces.");
		}
		this.cellName = name;
	}
    
    private void setCellComment(String comment){
        if(comment == null){
            throw new IllegalArgumentException("Comment's cant be null");
        }
        
        this.cellComment = comment;
    }
    
   
  
    @Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj instanceof NavigationComment) {
			NavigationComment comment = (NavigationComment) obj;
			return this.cellName.equalsIgnoreCase(comment.cellName) && this.cellComment.
				equals(comment.cellComment);
		}
		return false;
	}
        
        @Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + (this.cellName != null ? this.cellName.hashCode() : 0);
		hash = 97 * hash + (this.cellComment != null ? this.cellComment.hashCode() : 0);
		return hash;
	}
    
}
